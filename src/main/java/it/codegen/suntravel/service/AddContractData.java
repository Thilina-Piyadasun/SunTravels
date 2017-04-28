package it.codegen.suntravel.service;

import com.google.gson.Gson;
import it.codegen.suntravel.beans.ContractBean;
import it.codegen.suntravel.beans.RoomContractBean;
import it.codegen.suntravel.beans.ViewContractBean;
import it.codegen.suntravel.dao.*;
import it.codegen.suntravel.util.Converter;
import it.codegen.suntravel.util.SingletonSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by thilinap on 4/17/2017.
 */
public class AddContractData
{
	private SessionFactory sessionFactory = SingletonSessionFactory.getSessionFactory();


	private Converter converter=new Converter();
	//@Autowired
	private Availability availability=new Availability();

	public static void main( String[] args )
	{
		AddContractData ContractData = new AddContractData();
//	ContractData.addContractDetails( ContractData.mock());
		//ContractData.addContrctData();
		System.out.println(new Gson().toJson( ContractData.mock() ));
	}

	public void addContractDetails( ContractBean contractBean )
	{

		//there is a open conection on check avlilbility
		//consider it

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try
		{
			ContractEntity contractEntity = new ContractEntity();
			//contractEntity.setId( contractBean.getContractID() );
			contractEntity.setValidFrom( contractBean.getValidFrom() );
			contractEntity.setValidTo( contractBean.getValidTo() );
			session.save( contractEntity );
			System.out.println("Contract Entity Saved with key : "+ contractEntity.getId());
			CountryEntity country = getCountry( session, contractBean );
			CityEntity city=getCity(session, contractBean,country);

			HotelEntity hotel=getHotel(session, contractBean,city);
			List<RoomEntity> roomEntities=getRooms(session, contractBean,hotel);
			List<RoomContractEntity> roomContract=getRoomContracts(session,contractBean, contractEntity,roomEntities);
			session.getTransaction().commit();

		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

	}

	public List<RoomContractEntity> getRoomContracts(Session session, ContractBean contractBean, ContractEntity contractEntity ,List<RoomEntity> roomEntities){

		List<RoomContractEntity> roomContracts=new ArrayList<>( 10 );

		int i=0;
		int j=getnext();
		for(RoomContractBean roomContractBean:contractBean.getRoomContracts())
		{
			RoomEntity room=roomEntities.get( i );
			/*if ( !availability.isRoomContractExists( room.getId(),contractEntity.getId(),contractBean.getValidFrom(),contractBean.getValidTo() ))
			{
				System.out.println(" Room Contract Exists in DB ");

			}
			else*/
			{
				RoomContractEntity roomContractEntity = new RoomContractEntity();
				roomContractEntity.setRoomContractId( j );
				roomContractEntity.setContractByContractId( contractEntity);
				roomContractEntity.setRoomByRoomId( room);
				roomContractEntity.setAvlFrom( contractBean.getValidFrom() );
				roomContractEntity.setAvlTo(contractBean.getValidTo());
				roomContractEntity.setPrice(roomContractBean.getPrice());
				roomContractEntity.setMarkUp(contractBean.getMarkup());
				roomContracts.add(  roomContractEntity);
				session.save( roomContractEntity );
				j++;
				System.out.println("Room Contract Entity Saved with key : "+ roomContractEntity.getRoomContractId());
			}
			i++;
		}

		return roomContracts;
	}

	public List<RoomEntity> getRooms( Session session, ContractBean contractBean ,HotelEntity hotel ) throws Exception
	{
		List<RoomEntity> rooms=new ArrayList<RoomEntity>( 10 );


		for(RoomContractBean roomContractBean:contractBean.getRoomContracts())
		{
			if ( availability.isRoomExists( contractBean.getHotelID(), roomContractBean.getRoomNo() ) )
			{
				session.getTransaction();
				List<RoomEntity> list = session.createQuery( "from RoomEntity where id=:c_id" )
						.setParameter( "c_id", roomContractBean.getRoomNo() ).list();
				if ( list.size() > 1 )
					throw new Exception( "list size must be 1" );

				rooms.add(  list.get( 0 ));
				System.out.println(" Room Exists in DB wirth key :"+ roomContractBean.getRoomNo());
			}
			else
			{
				RoomEntity room = new RoomEntity();
				room.setId( roomContractBean.getRoomNo());
				room.setType( roomContractBean.getType() );
				room.setMaxAdults( roomContractBean.getAdults() );
				room.setHotelByHotelId( hotel );
				rooms.add( room );
				session.save( room );
				System.out.println("Room Entity Saved with key : "+ room.getId());
			}
		}

		return rooms;
	}

	public HotelEntity getHotel( Session session, ContractBean contractBean,CityEntity city ) throws Exception
	{
		HotelEntity hotel;

		if ( availability.isHotelExists( contractBean.getHotelID() ) )
		{
			session.getTransaction();
			List<HotelEntity> list = session.createQuery( "from HotelEntity where id=:c_id" )
					.setParameter( "c_id", contractBean.getHotelID() ).list();
			if ( list.size() > 1 )
				throw new Exception( "list size must be 1" );

			hotel = list.get( 0 );
			System.out.println(" Hotel Exists in DB "+ hotel.getId());
		}
		else
		{
			hotel = new HotelEntity();
			hotel.setId( contractBean.getHotelID() );
			hotel.setName( contractBean.getHotelName() );
			hotel.setRating( contractBean.getHotelrating() );
			hotel.setCityByCityCId( city );
			session.save( hotel );
			System.out.println("Hotel Entity Saved with key : "+ hotel.getId());
		}

		return hotel;
	}
	public CityEntity getCity( Session session, ContractBean contractBean ,CountryEntity countryEntity) throws Exception
	{
		CityEntity city;

		if ( availability.isCityExists( contractBean.getCityID() ) )
		{
			session.getTransaction();
			List<CityEntity> list = session.createQuery( "from CityEntity where cId=:c_id" )
					.setParameter( "c_id", contractBean.getCityID() ).list();
			if ( list.size() > 1 )
				throw new Exception( "list size must be 1" );

			city = list.get( 0 );
			System.out.println(" City Exists in DB "+ city.getcId());
		}
		else
		{
			city = new CityEntity();
			city.setcId( contractBean.getCityID() );
			city.setName( contractBean.getCityName( ));
			city.setCountryByCountryId( countryEntity );
			session.save( city );
			System.out.println("City Entity Saved with key : "+ city.getcId());
		}

		return city;
	}

	public CountryEntity getCountry( Session session, ContractBean contractBean ) throws Exception
	{
		CountryEntity country;

		if ( availability.isCountryExists( contractBean.getCountryID() ) )
		{
			session.getTransaction();
			List<CountryEntity> list = session.createQuery( "from CountryEntity where id=:c_id" )
					.setParameter( "c_id", contractBean.getCountryID() ).list();
			if ( list.size() > 1 )
				throw new Exception( "list size must be 1" );

			country = list.get( 0 );
			System.out.println(" Country Exists in DB "+ country.getId());
		}
		else
		{
			country = new CountryEntity();
			country.setId( contractBean.getCountryID() );
			country.setName( contractBean.getCountry() );
			session.save( country );
			System.out.println("Country Entity Saved with key : "+ country.getId());
		}

		return country;
	}

	public List<ViewContractBean> viewContracts(){
		Session session = sessionFactory.openSession();

		List<RoomContractEntity> list=new ArrayList( 10 );
		try
		{
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("  from RoomContractEntity  order by roomContractId DESC "  );
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

		// add elements to al, including duplicates


		List<ViewContractBean> viewList=new ArrayList<>( 10 );
		for(RoomContractEntity s : list){
			if(s.getAvlFrom()!=null && s.getAvlTo()!=null)
			{
				ViewContractBean v = new ViewContractBean();
				v.setHotelName( s.getRoomByRoomId().getHotelByHotelId().getName() );
				v.setContractID( s.getContractByContractId().getId() );
				v.setValidFrom( new Timestamp( s.getAvlFrom() ) );
				v.setValidTo( new Timestamp( s.getAvlTo() ) );
				v.setMarkup( s.getMarkUp() );
				v.setHotelrating( s.getRoomByRoomId().getHotelByHotelId().getRating() );
				viewList.add( v );
			}
		}

		Set<ViewContractBean> hs = new HashSet<>();
		hs.addAll(viewList);
		viewList.clear();
		viewList.addAll(hs);

		return viewList;
	}

	/*
	* Return the room contracts of particular contract
	* */
	public List<RoomContractBean> viewRoomContracts(int id)throws Exception{
		Session session = sessionFactory.openSession();

		List<Integer> list=new ArrayList( 10 );
		List<SearchRoomMvEntity> entityList=new ArrayList<>( 50 );
		try
		{
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("select roomContractId from RoomContractEntity  where contractByContractId.id=:contractID"  )
					.setParameter( "contractID",id );
			list = query.list();

			Query query2 = session.createQuery("from SearchRoomMvEntity  where roomContractId IN (:li)")
					.setParameterList( "li",list );
			entityList = query2.list();
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

		return converter.convertToRoomContractBeanList(entityList);
	}
	public ContractBean mock(){
		ContractBean contractBean=new ContractBean(  );
		try
		{
			DateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
			Date date1 = dateFormat.parse( "13/03/2017" );
			Date date2 = dateFormat.parse( "03/09/2017" );
			long time = date1.getTime();
			long time2 = date2.getTime();

			//contractBean.setContractID( 17 );
			contractBean.setMarkup( 15l );
			byte id=4;
			contractBean.setCountryID( id );
			contractBean.setCountry( "Austria" );
			contractBean.setCityID( 142 );
			contractBean.setCityName( "Graz" );
			contractBean.setHotelID( 1425 );
			contractBean.setHotelName( "Mercure" );
			contractBean.setHotelrating( 4 );
			contractBean.setValidFrom( time );
			contractBean.setValidTo( time2 );
			contractBean.setRooms( 2 );

			RoomContractBean roomContractBean=new RoomContractBean( 14251,"Standerd",45690,3 );
			RoomContractBean roomContractBean2=new RoomContractBean( 14252,"Standerd",35690,1 );

			RoomContractBean[] arr=new RoomContractBean[2];
			arr[0]=roomContractBean;
			arr[1]=roomContractBean2;
			contractBean.setRoomContracts( arr );

		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		return contractBean;
	}

	public void addContrctData()
	{

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Timestamp t1 = new Timestamp( System.currentTimeMillis() );
		Timestamp t2 = new Timestamp( System.currentTimeMillis() );

		DateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
		ContractEntity contractEntity = new ContractEntity();

		try
		{
			Date date1 = dateFormat.parse( "13/12/2017" );
			Date date2 = dateFormat.parse( "03/03/2018" );
			long time = date1.getTime();
			long time2 = date2.getTime();
			t1 = new Timestamp( time );
			t2 = new Timestamp( time2 );
			contractEntity.setId( 9 );
			contractEntity.setValidFrom( time );
			contractEntity.setValidTo( time2 );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}

		CountryEntity c = new CountryEntity();
		c.setName( "England" );
		byte id = 5;
		c.setId( id );

		CityEntity city = new CityEntity();
		city.setName( "edinburgh" );
		city.setcId( 151 );
		city.setCountryByCountryId( c );

		HotelEntity h = new HotelEntity();
		h.setName( "Raddison" );
		h.setId( 1512 );
		h.setRating( 4 );
		h.setCityByCityCId( city );

		RoomEntity rm = new RoomEntity();
		rm.setId( 151292 );
		rm.setType( "Standard" );
		rm.setMaxAdults( 3 );
		rm.setHotelByHotelId( h );
		rm.setDescription( "description about hotel in Vienna" );

		RoomEntity rm2 = new RoomEntity();
		rm2.setId( 151291 );
		rm2.setType( "Standard" );
		rm2.setMaxAdults( 2 );
		rm2.setHotelByHotelId( h );
		rm2.setDescription( "description about hotel in Vienna" );

		int i = getnext();

		RoomContractEntity rc = new RoomContractEntity();
		rc.setRoomContractId( i );
		rc.setPrice( 90666 );
		rc.setRoomByRoomId( rm );
		rc.setContractByContractId( contractEntity );
		rc.setMarkUp( 15l );
		rc.setAvlFrom( contractEntity.getValidFrom() );
		rc.setAvlTo( contractEntity.getValidTo() );

		RoomContractEntity rc2 = new RoomContractEntity();
		rc2.setRoomContractId( i + 1 );
		rc2.setPrice( 69900 );
		rc2.setRoomByRoomId( rm2 );
		rc2.setContractByContractId( contractEntity );
		rc2.setMarkUp( 15l );
		rc2.setAvlFrom( contractEntity.getValidFrom() );
		rc2.setAvlTo( contractEntity.getValidTo() );

		//session.save( contractEntity );
		//session.save( c );
		//session.save( city );
		//session.save( h );
		//session.save( rm );
		//session.save( rm2 );
		session.save( rc );
		session.save( rc2 );

		session.getTransaction().commit();
		session.close();

	}

	public int getnext()
	{
		Session session = sessionFactory.openSession();
		int i = 0;
		try
		{
			session.beginTransaction();
			List<Integer> list = session.createQuery( "select max(roomContractId) from RoomContractEntity " ).list();
			session.getTransaction().commit();
			i = list.get( 0 );
			System.out.println( i );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return i + 1;
	}
}
