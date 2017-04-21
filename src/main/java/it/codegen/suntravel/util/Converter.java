package com.cgn.reservation.util;

import com.cgn.reservation.beans.SearchResponseBean;
import com.cgn.reservation.dao.SearchRoomMvEntity;
import oracle.sql.DATE;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * Created by thilinap on 4/18/2017.
 */
public class Converter
{
	@Autowired
	private SearchResponseBean searchResponseBean;

	public SearchResponseBean convertSearchRoomEntity_to_SearchResponseBean( SearchRoomMvEntity entity )
			throws Exception
	{
		searchResponseBean.setHotelID( entity.getHotelId() );
		searchResponseBean.setHotelName( entity.getHotelName() );
		searchResponseBean.setCity( entity.getCityName() );
		searchResponseBean.setPrice( entity.getPrice() );
		searchResponseBean.setRating( entity.getRating() );
		searchResponseBean.setAvaliability_status( true );
		return searchResponseBean;
	}

	/*
	* Method calculate the no of days between given two dates
	* */
	public int get_date_difference( Timestamp out, Timestamp in )
	{
		int diff = (int)((out.getTime() - in.getTime())/ (1000 * 60 * 60 * 24));
		System.out.println( diff );
		return diff;
	}


}