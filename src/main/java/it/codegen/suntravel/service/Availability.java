package it.codegen.suntravel.service;

import it.codegen.suntravel.util.SingletonSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thilinap on 4/21/2017.
 */
public class Availability
{
	private SessionFactory sessionFactory= SingletonSessionFactory.getSessionFactory();

	public boolean isCityExists(int id){

		String query="from CityEntity where cId=:pram";
		return isExists( query,id );
	}

	public boolean isCountryExists(byte id){
		List list=new ArrayList( 1 );
		Session session=sessionFactory.openSession();
		try{
			Transaction t = session.beginTransaction();
			list=session.createQuery( "from CountryEntity where id=:pram" )
					.setParameter( "pram",id )
					.list();
			t.commit();
		}
		catch ( Exception e ){
			e.printStackTrace();
		}
		finally
		{
			//session.close();
		}

		if(list.size()==0)
			return false;

		return true;

	}

	public boolean isHotelExists(int id){

		String query="from HotelEntity where id=:pram";
		return isExists( query,id );
	}

	public boolean isRoomContractExists(int roomid,int conid,long avalFrom,long avalto){
		List list=new ArrayList( 1 );
		Session session=sessionFactory.openSession();
		try{
			Transaction t = session.beginTransaction();
			list=session.createQuery( "from RoomContractEntity where roomByRoomId.id=:roomid and contractByContractId.id =:conid and avlFrom=:avlFrom and avlTo=:avalto" )
					.setParameter( "roomid",roomid )
					.setParameter( "conid" ,conid)
					.setParameter( "avlFrom" ,avalFrom)
					.setParameter( "avalto",avalto )
					.list();
			t.commit();
		}
		catch ( Exception e ){
			e.printStackTrace();
		}
		finally
		{
			//session.close();
		}

		if(list.size()==0)
			return false;

		return true;
	}

	public boolean isRoomExists(int hid,int id){

		List list=new ArrayList( 0 );
		Session session=sessionFactory.openSession();
		try{
			Transaction t = session.beginTransaction();
			list=session.createQuery( "from RoomEntity where id=:pram and hotelByHotelId.id=:hid" )
					.setParameter( "pram",id )
					.setParameter( "hid" ,hid)
					.list();
			t.commit();
		}
		catch ( Exception e ){
			e.printStackTrace();
		}
		finally
		{
			//session.close();
		}

		if(list.size()==0)
			return false;

		return true;
	}

	public boolean isExists(String query,int parm){
		List list=new ArrayList( 1 );
		Session session=sessionFactory.openSession();
		try{
			Transaction t = session.beginTransaction();
			list=session.createQuery( query ).setParameter( "pram",parm ).list();
			t.commit();
		}
		catch ( Exception e ){
			e.printStackTrace();
		}
		finally
		{
			//session.close();
		}

		if(list.size()==0)
			return false;

		return true;
	}
}
