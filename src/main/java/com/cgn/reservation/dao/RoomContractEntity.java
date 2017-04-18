package com.cgn.reservation.dao;

import javax.persistence.*;

/**
 * Created by thilinap on 4/18/2017.
 */
@Entity
@Table(name = "ROOM_CONTRACT", schema = "THILINAP", catalog = "")
public class RoomContractEntity
{
	private long price;
	private int roomContractId;
	private ContractEntity contractByContractId;
	private RoomEntity roomByRoomId;

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
	public int getRoomContractId()
	{
		return roomContractId;
	}

	public void setRoomContractId( int roomContractId )
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
		result = 31 * result + roomContractId;
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "CONTRACT_ID", referencedColumnName = "ID", nullable = false)
	public ContractEntity getContractByContractId()
	{
		return contractByContractId;
	}

	public void setContractByContractId( ContractEntity contractByContractId )
	{
		this.contractByContractId = contractByContractId;
	}

	@ManyToOne
	@JoinColumn(name = "ROOM_ID", referencedColumnName = "ID", nullable = false)
	public RoomEntity getRoomByRoomId()
	{
		return roomByRoomId;
	}

	public void setRoomByRoomId( RoomEntity roomByRoomId )
	{
		this.roomByRoomId = roomByRoomId;
	}
}
