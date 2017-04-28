package it.codegen.suntravel.dao;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by thilinap on 4/21/2017.
 */
public class RoomDetMvEntityPK implements Serializable
{
	private int hotelId;
	private int maxAdults;

	@Column(name = "HOTEL_ID")
	@Id
	public int getHotelId()
	{
		return hotelId;
	}

	public void setHotelId( int hotelId )
	{
		this.hotelId = hotelId;
	}

	@Column(name = "MAX_ADULTS")
	@Id
	public int getMaxAdults()
	{
		return maxAdults;
	}

	public void setMaxAdults( int maxAdults )
	{
		this.maxAdults = maxAdults;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		RoomDetMvEntityPK that = ( RoomDetMvEntityPK ) o;

		if ( hotelId != that.hotelId )
			return false;
		if ( maxAdults != that.maxAdults )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = hotelId;
		result = 31 * result + maxAdults;
		return result;
	}
}
