package com.cgn.reservation.dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by thilinap on 4/18/2017.
 */
@Entity
@Table(name = "CITY", schema = "THILINAP", catalog = "")
public class CityEntity
{
	private int cId;
	private String name;
	private CountryEntity countryByCountryId;
	private Collection<HotelEntity> hotelsByCId;

	@Id
	@Column(name = "C_ID")
	public int getcId()
	{
		return cId;
	}

	public void setcId( int cId )
	{
		this.cId = cId;
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

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		CityEntity that = ( CityEntity ) o;

		if ( cId != that.cId )
			return false;
		if ( name != null ? !name.equals( that.name ) : that.name != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = cId;
		result = 31 * result + ( name != null ? name.hashCode() : 0 );
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID", nullable = false)
	public CountryEntity getCountryByCountryId()
	{
		return countryByCountryId;
	}

	public void setCountryByCountryId( CountryEntity countryByCountryId )
	{
		this.countryByCountryId = countryByCountryId;
	}

	@OneToMany(mappedBy = "cityByCityCId")
	public Collection<HotelEntity> getHotelsByCId()
	{
		return hotelsByCId;
	}

	public void setHotelsByCId( Collection<HotelEntity> hotelsByCId )
	{
		this.hotelsByCId = hotelsByCId;
	}
}
