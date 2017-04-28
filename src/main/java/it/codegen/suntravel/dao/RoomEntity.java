package it.codegen.suntravel.dao;

import javax.persistence.*;

/**
 * Created by thilinap on 4/21/2017.
 */
@Entity
@Table(name = "ROOM", schema = "THILINAP", catalog = "")
public class RoomEntity
{
	private int id;
	private String type;
	private int maxAdults;
	private String description;
	private HotelEntity hotelByHotelId;

	@Id
	@Column(name = "ID")
	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	@Basic
	@Column(name = "TYPE")
	public String getType()
	{
		return type;
	}

	public void setType( String type )
	{
		this.type = type;
	}

	@Basic
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
	@Column(name = "DESCRIPTION")
	public String getDescription()
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		RoomEntity that = ( RoomEntity ) o;

		if ( id != that.id )
			return false;
		if ( maxAdults != that.maxAdults )
			return false;
		if ( type != null ? !type.equals( that.type ) : that.type != null )
			return false;
		if ( description != null ? !description.equals( that.description ) : that.description != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + ( type != null ? type.hashCode() : 0 );
		result = 31 * result + maxAdults;
		result = 31 * result + ( description != null ? description.hashCode() : 0 );
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "HOTEL_ID", referencedColumnName = "ID", nullable = false)
	public HotelEntity getHotelByHotelId()
	{
		return hotelByHotelId;
	}

	public void setHotelByHotelId( HotelEntity hotelByHotelId )
	{
		this.hotelByHotelId = hotelByHotelId;
	}
}
