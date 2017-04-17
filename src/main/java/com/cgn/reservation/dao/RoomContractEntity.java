package com.cgn.reservation.dao;

import javax.persistence.*;

/**
 * Created by thilinap on 4/17/2017.
 */
@Entity
@Table(name = "ROOM_CONTRACT", schema = "THILINAP", catalog = "")
public class RoomContractEntity
{
	private long price;
	private long roomContractId;



	@Basic
	@Column(name = "PRICE")
	public long getPrice()
	{
		return price;
	}

	public void setPrice( long price )
	{
		this.price = price;
	}

	@Id
	@Column(name = "ROOM_CONTRACT_ID")
	public long getRoomContractId()
	{
		return roomContractId;
	}

	public void setRoomContractId( long roomContractId )
	{
		this.roomContractId = roomContractId;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		RoomContractEntity that = ( RoomContractEntity ) o;

		if ( price != that.price )
			return false;
		if ( roomContractId != that.roomContractId )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( price ^ ( price >>> 32 ) );
		result = 31 * result + ( int ) ( roomContractId ^ ( roomContractId >>> 32 ) );
		return result;
	}
}
