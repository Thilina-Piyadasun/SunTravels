package com.cgn.reservation.service;

import com.cgn.reservation.beans.SearchRequestBean;
import com.cgn.reservation.beans.SearchResponseBean;
import com.cgn.reservation.dao.SearchRoomMvEntity;
import com.cgn.reservation.util.Converter;
import com.cgn.reservation.util.SingletonSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
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

	public List<SearchResponseBean> search(SearchRequestBean requestBean)
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
						.setParameter( "hotel",requestBean.getHotelID() )
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
				entity.setPrice( pricing.calculateMarkedUpPrice(entity.getPrice(),adults,no_of_dates) );
				responseBeanList.add(converter.convertSearchRoomEntity_to_SearchResponseBean( entity ));
			}
		}
		catch ( Exception e){
			e.printStackTrace();
		}
		return responseBeanList;
	}



}
