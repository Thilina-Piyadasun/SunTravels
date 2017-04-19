package com.cgn.reservation.service;

import com.cgn.reservation.dao.*;
import com.cgn.reservation.util.SingletonSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		Timestamp t1=new Timestamp( System.currentTimeMillis() );
		Timestamp t2=new Timestamp( System.currentTimeMillis() );

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try
		{
			Date date1 = dateFormat.parse("03/04/2017");
			Date date2 = dateFormat.parse("03/04/2018");
			long time = date1.getTime();
			long time2 = date2.getTime();
			t1=new Timestamp(time);
			t2=new Timestamp(time2);

		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		ContractEntity contractEntity = new ContractEntity();


		contractEntity.setId( 4 );
		contractEntity.setValidFrom( t1 );
		contractEntity.setValidTo( t2 );
		contractEntity.setValidDates( 365 );


		CountryEntity c=new CountryEntity();
		c.setName( "Austria" );
		byte id=4;
		c.setId( id );

		CityEntity city=new CityEntity();
		city.setName( "Vienna" );
		city.setcId( 141 );
		city.setCountryByCountryId(c);

		HotelEntity h=new HotelEntity();
		h.setName( "Wilhelmshof" );
		h.setId(1411);
		h.setRating( 5 );
		h.setCityByCityCId(city);

		RoomEntity rm=new RoomEntity();
		rm.setId(14111);
		rm.setType( "Standard" );
		rm.setMaxAdults( 3 );
		rm.setHotelByHotelId( h );
		rm.setDescription( "description about hotel in Vienna" );

		RoomContractEntity rc=new RoomContractEntity();
		rc.setRoomContractId( 3);
		rc.setPrice( 48200 );
		rc.setRoomByRoomId( rm );
		rc.setContractByContractId( contractEntity );

		session.save( contractEntity );
		session.save( c );
		session.save( city );
		session.save( h );
		session.save( rm );
		session.save( rc );
		session.getTransaction().commit();
		session.close();



	}
}
