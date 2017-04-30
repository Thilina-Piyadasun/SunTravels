package it.codegen.suntravel.dao;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by thilinap on 4/21/2017.
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "ROOM_DET_MV", schema = "THILINAP", catalog = "")
@IdClass(RoomDetMvEntityPK.class)
public class RoomDetMvEntity
{
	private int hotelId;
	private int maxAdults;
	private int noOfRooms;

	@Id
	@Column(name = "HOTEL_ID")
	public int getHotelId()
	{
		return hotelId;
	}

	public void setHotelId( int hotelId )
	{
		this.hotelId = hotelId;
	}

	@Id
	@Column(name = "MAX_ADULTS")
	public int getMaxAdults()
	{
		return maxAdults;
	}

	public void setMaxAdults( int maxAdults )
	{
		this.maxAdults = maxAdults;
	}

	@Basic
	@Column(name = "NO_OF_ROOMS")
	public int getNoOfRooms()
	{
		return noOfRooms;
	}

	public void setNoOfRooms( int noOfRooms )
	{
		this.noOfRooms = noOfRooms;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		RoomDetMvEntity that = ( RoomDetMvEntity ) o;

		if ( hotelId != that.hotelId )
			return false;
		if ( maxAdults != that.maxAdults )
			return false;
	/*	if ( noOfRooms != null ? !noOfRooms.equals( that.noOfRooms ) : that.noOfRooms != null )
			return false;
*/
		return true;
	}

	@Override
	public int hashCode()
	{
		int result = hotelId;
		result = 31 * result + maxAdults;
	//	result = 31 * result + ( noOfRooms != null ? noOfRooms.hashCode() : 0 );
		return result;
	}
}
