package it.codegen.suntravel.service;

import it.codegen.suntravel.beans.SearchRequestBean;
import it.codegen.suntravel.beans.SearchResponseBean;
import it.codegen.suntravel.dao.SearchRoomMvEntity;
import it.codegen.suntravel.util.Converter;
import it.codegen.suntravel.util.SingletonSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thilinap on 4/18/2017.
 */
public class SearchHotel
{
	@Autowired
	private Converter converter;

	@Autowired
	private Pricing pricing;

	private SessionFactory sessionFactory = SingletonSessionFactory.getSessionFactory();

	public List<SearchResponseBean> searchByHotel(SearchRequestBean requestBean)
	{

		List list = new ArrayList( 10 );
		Session session = sessionFactory.openSession();
		try
		{
			if(requestBean!=null)
			{

				/*Timestamp in=requestBean.getCheckIN();
				Timestamp out=requestBean.getCheckOut();*/

				Transaction t = session.beginTransaction();

				list = session.createQuery( "from SearchRoomMvEntity where hotelId=:hotel and  (maxAdults>:adults or maxAdults=:adults )")
						.setParameter( "hotel",requestBean.getId() )
						.setParameter(  "adults",requestBean.getAdults())
						.list();

				t.commit();
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return generateSearchResponseBeanList(list,requestBean);
	}

	public List<SearchResponseBean> searchByCity(SearchRequestBean requestBean)
	{

		List list = new ArrayList( 10 );
		Session session = sessionFactory.openSession();
		try
		{
			if(requestBean!=null)
			{
				Transaction t = session.beginTransaction();

				int[][] roomdet=requestBean.getRoomRequestDetails();
				int size=roomdet.length;


				/*list = session.createQuery( "from SearchRoomMvEntity where validFrom <:lessthan and cityId=:city and  (maxAdults>:adults or maxAdults=:adults )")
						.setParameter( "city",requestBean.getId() )
						.setParameter(  "adults",requestBean.getAdults())
						.setParameter( "lessthan", "TO_DATE( requestBean.getCheckIN() )" )
						.list();*/

				list = session.createQuery( "select distinct(hotelId) from RoomDetMvEntity where noOfRooms >=:rooms and maxAdults >=:adults")
						.setParameter( "rooms",roomdet[0][0])
						.setParameter(  "adults",roomdet[0][1])
						.list();

				for(int i=1;i<size;i++){

					Query query= session.createQuery( "select distinct(hotelId) from RoomDetMvEntity where noOfRooms >=:rooms and maxAdults >=:adults and hotelId IN (:li)")
							.setParameterList( "li",list)
							.setParameter( "rooms",roomdet[i][0])
							.setParameter(  "adults",roomdet[i][1]);
					query.setCacheable(true);
							List list2=query.list();
					list=list2;
				}
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("No of hotels found : "+list.size());
				list = session.createQuery( "from SearchRoomMvEntity where validFrom<=:from_date and validTo>=:to_date and cityId=:city and hotelId IN (:li)")
						.setParameterList( "li",list)
						.setParameter( "from_date",requestBean.getCheckIN() )
						.setParameter( "to_date",requestBean.getCheckOut() )
						.setParameter( "city",requestBean.getId())
						.list();
				t.commit();
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return generateSearchResponseBeanList(list,requestBean);
	}
	/*
	* Convert result set to Response beans list
	 * Response beanslist send to controller
	* */
	public List<SearchResponseBean> generateSearchResponseBeanList( List<SearchRoomMvEntity> entityList ,SearchRequestBean requestBean )
	{
		int adults=requestBean.getAdults();
		int no_of_dates=converter.get_date_difference(requestBean.getCheckOut(),requestBean.getCheckIN());
		List<SearchResponseBean> responseBeanList=new ArrayList<SearchResponseBean>( 10 );

		try
		{
			for(SearchRoomMvEntity entity:entityList){
				//calculate price show to customer and update the price in each entity object

				entity.setPrice( pricing.calculateMarkedUpPrice(entity.getPrice(),adults,no_of_dates,entity.getMarkUp()) );
				responseBeanList.add(converter.convertSearchRoomEntity_to_SearchResponseBean( entity ));
			}
		}
		catch ( Exception e){
			e.printStackTrace();
		}
		return responseBeanList;
	}



}
