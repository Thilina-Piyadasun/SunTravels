package com.cgn.reservation.service;

import com.cgn.reservation.dao.SearchRoomMvEntity;
import com.cgn.reservation.util.SingletonSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thilinap on 4/18/2017.
 */
public class SearchHotel
{
	private SessionFactory sessionFactory= SingletonSessionFactory.getSessionFactory();

	public List search(){

		List list=new ArrayList( 10 );
		try
		{
			Session session=sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("from SearchRoomMvEntity ");
			list = query.list();
			SearchRoomMvEntity se= ( SearchRoomMvEntity ) list.get( 0 );
			if(list.size()==0){
				System.out.println("5657hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhg");
			}
			System.out.println( se.getCityName() + " " + se.getHotelName());
			t.commit();
			session.close();

		}catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{

		}
		return list;
	}

}
