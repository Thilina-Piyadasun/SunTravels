package com.cgn.reservation.service;

import com.cgn.reservation.dao.ContractEntity;
import com.cgn.reservation.dao.CountryEntity;
import com.cgn.reservation.dao.HotelEntity;
import com.cgn.reservation.dao.RoomContractEntity;
import com.cgn.reservation.util.SingletonSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thilinap on 4/11/2017.
 */
public class SearchDataRequest
{

    private SessionFactory sessionFactory=SingletonSessionFactory.getSessionFactory();


    public List getData(){

        List list=new ArrayList( 10 );
        try
        {
            Session session=sessionFactory.openSession();
            Transaction t = session.beginTransaction();
			int city=1;
            Query query = session.createQuery("from CountryEntity join CityEntity as c where c.cId= :citys").setParameter( "citys",city );
            list = query.list();
            System.out.println(list.get( 0 ).toString());
            t.commit();
            session.close();

        }catch ( Exception e )
        {

        }
        finally
        {

        }
        return list;
    }

    public List getHotelsByCity(long city_id)
	{
		List list=new ArrayList( 10 );
		try
		{
			Session session=sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			Query query = session.createQuery("from HotelEntity");
			list = query.list();
			System.out.println(list.get( 0 ).toString());
			t.commit();
			session.close();

		}catch ( Exception e )
		{

		}
		finally
		{

		}
		return list;

	}

    public void insertData(){

        try
        {
            Session session=sessionFactory.openSession();
            session.beginTransaction();

            CountryEntity countryEntity=new CountryEntity();
            byte no=1;
            countryEntity.setId(no);
            countryEntity.setName(" USA ");
            session.save(countryEntity);
            session.getTransaction().commit();
            session.close();
        }catch ( Exception e )
        {

        }
        finally
        {

        }
    }

	/*public Map<Long,String> getHotelNames(long city)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<HotelEntity> list=session.createQuery( "from HotelEntity join CityEntity where CityEntity .cId=: c  " )
				.setParameter( "c" , city )
				.list();
		Map<Long,String> map=new HashMap<Long, String>( 100 );

		for(HotelEntity hotelEntity:list)
			//map.put( hotelEntity.getId(), hotelEntity.getName() );

		return map;

	}*/


}
