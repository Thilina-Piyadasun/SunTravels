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
@Table(name = "ROOM_CONTRACT", schema = "THILINAP", catalog = "")
public class RoomContractEntity
{
	private long price;
	private int roomContractId;
	private Long avlFrom;
	private Long avlTo;
	private Long markUp;
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

	@Basic
	@Column(name = "AVL_FROM")
	public Long getAvlFrom()
	{
		return avlFrom;
	}

	public void setAvlFrom( Long avlFrom )
	{
		this.avlFrom = avlFrom;
	}

	@Basic
	@Column(name = "AVL_TO")
	public Long getAvlTo()
	{
		return avlTo;
	}

	public void setAvlTo( Long avlTo )
	{
		this.avlTo = avlTo;
	}

	@Basic
	@Column(name = "MARK_UP")
	public Long getMarkUp()
	{
		return markUp;
	}

	public void setMarkUp( Long markUp )
	{
		this.markUp = markUp;
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
		if ( avlFrom != null ? !avlFrom.equals( that.avlFrom ) : that.avlFrom != null )
			return false;
		if ( avlTo != null ? !avlTo.equals( that.avlTo ) : that.avlTo != null )
			return false;
		if ( markUp != null ? !markUp.equals( that.markUp ) : that.markUp != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( price ^ ( price >>> 32 ) );
		result = 31 * result + roomContractId;
		result = 31 * result + ( avlFrom != null ? avlFrom.hashCode() : 0 );
		result = 31 * result + ( avlTo != null ? avlTo.hashCode() : 0 );
		result = 31 * result + ( markUp != null ? markUp.hashCode() : 0 );
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
