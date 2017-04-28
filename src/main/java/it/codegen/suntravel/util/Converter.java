package it.codegen.suntravel.util;

import it.codegen.suntravel.beans.RoomContractBean;
import it.codegen.suntravel.beans.SearchResponseBean;
import it.codegen.suntravel.dao.SearchRoomMvEntity;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thilinap on 4/18/2017.
 */
public class Converter
{
	//@Autowired
	//private SearchResponseBean searchResponseBean;

	public SearchResponseBean convertSearchRoomEntity_to_SearchResponseBean( SearchRoomMvEntity entity )
			throws Exception
	{
		//TODO inject beans without creating it
		SearchResponseBean searchResponseBean=new SearchResponseBean();

		searchResponseBean.setHotelID( entity.getHotelId() );
		searchResponseBean.setHotelName( entity.getHotelName() );
		searchResponseBean.setRoomID( entity.getRoomId() );
		searchResponseBean.setCity( entity.getCityName() );
		searchResponseBean.setPrice( entity.getPrice() );
		searchResponseBean.setRating( entity.getRating() );
		searchResponseBean.setRoomType( entity.getType() );
		searchResponseBean.setAvaliability_status( true );
		return searchResponseBean;
	}

	/*
	* Method calculate the no of days between given two dates
	* */
	public int get_date_difference( long out, long in )
	{
		Timestamp t1=new Timestamp(in);
		Timestamp t2=new Timestamp(out);
		int diff = (int)((t2.getTime() - t1.getTime())/ (1000 * 60 * 60 * 24));
		System.out.println( diff );
		return diff;
	}

	public Timestamp toTimeStamp(long time){
		DateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );

		return new Timestamp( time );
	}

	public List<RoomContractBean> convertToRoomContractBeanList(List<SearchRoomMvEntity> entityList)throws Exception{

		List<RoomContractBean> list=new ArrayList<>( 50 );
		for(SearchRoomMvEntity entity:entityList){
			RoomContractBean rcb=new RoomContractBean(  );
			rcb.setRoomNo( entity.getRoomId() );
			rcb.setType( entity.getType() );
			rcb.setAdults( entity.getMaxAdults() );
			rcb.setPrice( entity.getPrice() );
			list.add( rcb );
		}

		return list;

	}

//	convertToSearchRoomBean()
}
