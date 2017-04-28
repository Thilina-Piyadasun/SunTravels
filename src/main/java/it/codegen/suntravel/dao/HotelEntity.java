package it.codegen.suntravel.dao;

import javax.persistence.*;

/**
 * Created by thilinap on 4/21/2017.
 */
@Entity
@Table(name = "HOTEL", schema = "THILINAP", catalog = "")
public class HotelEntity
{
	private int id;
	private String name;
	private String state;
	private Integer rating;
	private CityEntity cityByCityCId;

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
	public Integer getRating()
	{
		return rating;
	}

	public void setRating( Integer rating )
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
		int result = id;
		result = 31 * result + ( name != null ? name.hashCode() : 0 );
		result = 31 * result + ( state != null ? state.hashCode() : 0 );
		result = 31 * result + ( rating != null ? rating.hashCode() : 0 );
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "CITY_C_ID", referencedColumnName = "C_ID", nullable = false)
	public CityEntity getCityByCityCId()
	{
		return cityByCityCId;
	}

	public void setCityByCityCId( CityEntity cityByCityCId )
	{
		this.cityByCityCId = cityByCityCId;
	}
}
