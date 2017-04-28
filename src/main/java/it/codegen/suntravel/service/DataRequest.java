package it.codegen.suntravel.service;

import it.codegen.suntravel.beans.IdBean;
import it.codegen.suntravel.dao.CityEntity;
import it.codegen.suntravel.dao.CountryEntity;
import it.codegen.suntravel.dao.HotelEntity;
import it.codegen.suntravel.util.SingletonSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thilinap on 4/11/2017.
 */
public class DataRequest
{

	private SessionFactory sessionFactory = SingletonSessionFactory.getSessionFactory();
	/*
		* Return cityies of a given country
		* */
	public List getCountries( )
	{
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		List<CountryEntity> list = new ArrayList( 10 );
		try
		{

			Query query = session.createQuery(
					" from CountryEntity ci " );
			list = query.list();
			t.commit();


		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

		List<IdBean> idBeen=new ArrayList<>( 50 );
		int size=list.size();
		for (CountryEntity result : list) {


			idBeen.add( new IdBean( result.getId(),result.getName() ) );
		}
		return idBeen;

	}
	/*
	* Return cityies of a given country
	* */
	public List getCityByCountry( byte countryID )
	{

		List list = new ArrayList( 10 );
		try
		{
			/*Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			Query query = session.createQuery(
					"select ci.id,ci.name from CityEntity ci join ci.countryByCountryId c where c.id=:c_ID" )
					.setParameter( "c_ID", countryID );
			list = query.list();
			t.commit();
			session.close();
*/

			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			Query query = session.createQuery( "from CityEntity ci join ci.countryByCountryId c where c.id=:c_ID" )
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

		List<IdBean> idBeen=new ArrayList<>( 50 );
		int size=list.size();
		for (Object result : list) {
			Object[] o = (Object[]) result;
			CityEntity city= ( CityEntity ) o[0];
			idBeen.add( new IdBean( city.getcId(),city.getName() ) );
		}
		return idBeen;
	}

	/*return hotels of given city*/
	public List getHotelsByCity( int city_id )
	{
		Session session = sessionFactory.openSession();
		List list = new ArrayList( 50 );
		try
		{

			Transaction t = session.beginTransaction();

			Query query = session.createQuery( "from HotelEntity h join h.cityByCityCId ci where ci.cId=:ci_id" )
					.setParameter( "ci_id", city_id );
			list = query.list();
			t.commit();

		}
		catch ( Exception e )
		{

		}
		finally
		{
			session.close();
		}
		List<IdBean> idBeen=new ArrayList<>( 50 );
		for (Object result : list) {
			Object[] o = (Object[]) result;
			HotelEntity hotel= ( HotelEntity ) o[0];
			idBeen.add( new IdBean( hotel.getId(),hotel.getName() ) );
		}

		return idBeen;
	}

}
