package com.cgn.reservation.beans;

import java.util.ArrayList;

/**
 * Created by thilinap on 4/17/2017.
 */
public class SearchRequestBean
{
	private long hotelID;

	private int[][] roomRequestDetails;

	public long getHotelID()
	{
		return hotelID;
	}

	public void setHotelID( long hotelID )
	{
		this.hotelID = hotelID;
	}

	public int[][] getRoomRequestDetails()
	{
		return roomRequestDetails;
	}

	public void setRoomRequestDetails( int[][] roomRequestDetails )
	{
		this.roomRequestDetails = roomRequestDetails;
	}
}
