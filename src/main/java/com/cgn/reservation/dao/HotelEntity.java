package com.cgn.reservation.dao;

import javax.persistence.*;

/**
 * Created by thilinap on 4/17/2017.
 */
@Entity
@Table(name = "HOTEL", schema = "THILINAP", catalog = "")
public class HotelEntity
{
	private long id;
	private String name;
	private String state;
	private Boolean rating;

	@Id
	@Column(name = "ID")
	public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	@Basic
	@Column(name = "NAME")
	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	@Basic
	@Column(name = "STATE")
	public String getState()
	{
		return state;
	}

	public void setState( String state )
	{
		this.state = state;
	}

	@Basic
	@Column(name = "RATING")
	public Boolean getRating()
	{
		return rating;
	}

	public void setRating( Boolean rating )
	{
		this.rating = rating;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		HotelEntity that = ( HotelEntity ) o;

		if ( id != that.id )
			return false;
		if ( name != null ? !name.equals( that.name ) : that.name != null )
			return false;
		if ( state != null ? !state.equals( that.state ) : that.state != null )
			return false;
		if ( rating != null ? !rating.equals( that.rating ) : that.rating != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( id ^ ( id >>> 32 ) );
		result = 31 * result + ( name != null ? name.hashCode() : 0 );
		result = 31 * result + ( state != null ? state.hashCode() : 0 );
		result = 31 * result + ( rating != null ? rating.hashCode() : 0 );
		return result;
	}
}
