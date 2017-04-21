package com.cgn.reservation.dao;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by thilinap on 4/19/2017.
 */
@Entity
@Table(name = "SEARCH_ROOM_MV", schema = "THILINAP", catalog = "")
public class SearchRoomMvEntity
{
	private int roomContractId;
	private Timestamp validFrom;
	private Timestamp validTo;
	private long price;
	private Integer hotelId;
	private String hotelName;
	private Integer rating;
	private Byte countryId;
	private String countryName;
	private Integer cityId;
	private String cityName;
	private Integer roomId;
	private String type;
	private Integer maxAdults;
	private String description;

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
	@Column(name = "VALID_FROM")
	public Timestamp getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom( Timestamp validFrom )
	{
		this.validFrom = validFrom;
	}

	@Basic
	@Column(name = "VALID_TO")
	public Timestamp getValidTo()
	{
		return validTo;
	}

	public void setValidTo( Timestamp validTo )
	{
		this.validTo = validTo;
	}

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

	@Basic
	@Column(name = "HOTEL_ID")
	public Integer getHotelId()
	{
		return hotelId;
	}

	public void setHotelId( Integer hotelId )
	{
		this.hotelId = hotelId;
	}

	@Basic
	@Column(name = "HOTEL_NAME")
	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName( String hotelName )
	{
		this.hotelName = hotelName;
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

	@Basic
	@Column(name = "COUNTRY_ID")
	public Byte getCountryId()
	{
		return countryId;
	}

	public void setCountryId( Byte countryId )
	{
		this.countryId = countryId;
	}

	@Basic
	@Column(name = "COUNTRY_NAME")
	public String getCountryName()
	{
		return countryName;
	}

	public void setCountryName( String countryName )
	{
		this.countryName = countryName;
	}

	@Basic
	@Column(name = "CITY_ID")
	public Integer getCityId()
	{
		return cityId;
	}

	public void setCityId( Integer cityId )
	{
		this.cityId = cityId;
	}

	@Basic
	@Column(name = "CITY_NAME")
	public String getCityName()
	{
		return cityName;
	}

	public void setCityName( String cityName )
	{
		this.cityName = cityName;
	}

	@Basic
	@Column(name = "ROOM_ID")
	public Integer getRoomId()
	{
		return roomId;
	}

	public void setRoomId( Integer roomId )
	{
		this.roomId = roomId;
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
	public Integer getMaxAdults()
	{
		return maxAdults;
	}

	public void setMaxAdults( Integer maxAdults )
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

		SearchRoomMvEntity that = ( SearchRoomMvEntity ) o;

		if ( roomContractId != that.roomContractId )
			return false;
		if ( price != that.price )
			return false;
		if ( validFrom != null ? !validFrom.equals( that.validFrom ) : that.validFrom != null )
			return false;
		if ( validTo != null ? !validTo.equals( that.validTo ) : that.validTo != null )
			return false;
		if ( hotelId != null ? !hotelId.equals( that.hotelId ) : that.hotelId != null )
			return false;
		if ( hotelName != null ? !hotelName.equals( that.hotelName ) : that.hotelName != null )
			return false;
		if ( rating != null ? !rating.equals( that.rating ) : that.rating != null )
			return false;
		if ( countryId != null ? !countryId.equals( that.countryId ) : that.countryId != null )
			return false;
		if ( countryName != null ? !countryName.equals( that.countryName ) : that.countryName != null )
			return false;
		if ( cityId != null ? !cityId.equals( that.cityId ) : that.cityId != null )
			return false;
		if ( cityName != null ? !cityName.equals( that.cityName ) : that.cityName != null )
			return false;
		if ( roomId != null ? !roomId.equals( that.roomId ) : that.roomId != null )
			return false;
		if ( type != null ? !type.equals( that.type ) : that.type != null )
			return false;
		if ( maxAdults != null ? !maxAdults.equals( that.maxAdults ) : that.maxAdults != null )
			return false;
		if ( description != null ? !description.equals( that.description ) : that.description != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = roomContractId;
		result = 31 * result + ( validFrom != null ? validFrom.hashCode() : 0 );
		result = 31 * result + ( validTo != null ? validTo.hashCode() : 0 );
		result = 31 * result + ( int ) ( price ^ ( price >>> 32 ) );
		result = 31 * result + ( hotelId != null ? hotelId.hashCode() : 0 );
		result = 31 * result + ( hotelName != null ? hotelName.hashCode() : 0 );
		result = 31 * result + ( rating != null ? rating.hashCode() : 0 );
		result = 31 * result + ( countryId != null ? countryId.hashCode() : 0 );
		result = 31 * result + ( countryName != null ? countryName.hashCode() : 0 );
		result = 31 * result + ( cityId != null ? cityId.hashCode() : 0 );
		result = 31 * result + ( cityName != null ? cityName.hashCode() : 0 );
		result = 31 * result + ( roomId != null ? roomId.hashCode() : 0 );
		result = 31 * result + ( type != null ? type.hashCode() : 0 );
		result = 31 * result + ( maxAdults != null ? maxAdults.hashCode() : 0 );
		result = 31 * result + ( description != null ? description.hashCode() : 0 );
		return result;
	}
}
