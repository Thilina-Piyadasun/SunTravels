package com.cgn.reservation.service;

import com.cgn.reservation.dao.ContractEntity;
import com.cgn.reservation.dao.RoomContractEntity;
import com.cgn.reservation.util.SingletonSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Lifecycle;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by thilinap on 4/17/2017.
 */
public class AddContractData
{
	private SessionFactory sessionFactory= SingletonSessionFactory.getSessionFactory();

	public static void main( String[] args )
	{
		AddContractData ContractData=new AddContractData();
		ContractData.addContrctData();
	}
	public void addContrctData()
	{

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Time t1 = null;
		Time t2 = null;
		/*try
		{
			String s = "2017/05/03 21:02:44";
			String s2 = "2013/12/03 21:02:44";
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy/mm/dd hh24:mi:ss" );
			long ms = sdf.parse( s ).getTime();
			long ms2 = sdf.parse( s2 ).getTime();
			t1 = new Time( ms );
			t2 = new Time( ms2 );

		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
*/
		ContractEntity contractEntity = new ContractEntity();

		/*contractEntity.setId( 9 );
		contractEntity.setValidFrom( t1 );
		contractEntity.setValidTo( t2 );
		contractEntity.setValidDates( 150 );
		session.save( contractEntity );
		session.getTransaction().commit();
		session.close();*/

		try
		{
			 session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			Query query = session.createQuery( "from ContractEntity where id=:ids" ).setParameter( "ids",5 );
			List list = query.list();

				ContractEntity c = ( ContractEntity ) list.get( 0 );
				System.out.println( c.getValidFrom() );

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
	}
}
