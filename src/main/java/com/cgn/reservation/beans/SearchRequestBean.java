package com.cgn.reservation.beans;

import oracle.sql.DATE;

import java.util.ArrayList;

/**
 * Created by thilinap on 4/17/2017.
 */
public class SearchRequestBean
{
	private int hotelID;
	private int adults;
	private DATE checkIN;
	private DATE checkOut;
//add dates
	private int[][] roomRequestDetails;

	public int getHotelID()
	{
		return hotelID;
	}

	public void setHotelID( int hotelID )
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

	public int getAdults()
	{
		return adults;
	}

	public void setAdults( int adults )
	{
		this.adults = adults;
	}

	public DATE getCheckIN()
	{
		return checkIN;
	}

	public void setCheckIN( DATE checkIN )
	{
		this.checkIN = checkIN;
	}

	public DATE getCheckOut()
	{
		return checkOut;
	}

	public void setCheckOut( DATE checkOut )
	{
		this.checkOut = checkOut;
	}
}
