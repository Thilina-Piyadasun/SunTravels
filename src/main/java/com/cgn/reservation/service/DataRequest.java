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
public class DataRequest
{

	private SessionFactory sessionFactory = SingletonSessionFactory.getSessionFactory();

	/*
	* Return cityies of a given country
	* */
	public List getCityByCountry( byte countryID )
	{

		List list = new ArrayList( 10 );
		try
		{
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			Query query = session.createQuery(
					"select c.name,ci.name from CityEntity ci join ci.countryByCountryId c where c.id=:c_ID" )
					.setParameter( "c_ID", countryID );
			list = query.list();
			t.commit();
			session.close();

		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{

		}
		return list;
	}

	/*return hotels of given city*/
	public List getHotelsByCity( int city_id )
	{
		List list = new ArrayList( 10 );
		try
		{
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			Query query = session.createQuery( "from HotelEntity h join h.cityByCityCId ci where ci.cId=:ci_id" )
					.setParameter( "ci_id", city_id );
			list = query.list();
			System.out.println( list.get( 0 ).toString() );
			t.commit();
			session.close();

		}
		catch ( Exception e )
		{

		}
		finally
		{

		}
		return list;
	}

}
