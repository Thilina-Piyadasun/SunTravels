package it.codegen.suntravel.beans;

/**
 * Created by thilinap on 4/17/2017.
 */
public class ContractBean
{
	//private int contractID;
	private byte countryID;
	private String country;
	private int cityID;
	private String cityName;
	private int hotelID;
	private String hotelName;
	private int hotelrating;
	private long validFrom;
	private long validTo;
	private int rooms;
	private long markup;
	private RoomContractBean[] roomContracts;


	public ContractBean(){}

	public long getMarkup()
	{
		return markup;
	}

	public void setMarkup( long markup )
	{
		this.markup = markup;
	}

	public int getHotelrating()
	{
		return hotelrating;
	}

	public void setHotelrating( int hotelrating )
	{
		this.hotelrating = hotelrating;
	}


	public byte getCountryID()
	{
		return countryID;
	}

	public void setCountryID( byte countryID )
	{
		this.countryID = countryID;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry( String country )
	{
		this.country = country;
	}

	public int getCityID()
	{
		return cityID;
	}

	public void setCityID( int cityID )
	{
		this.cityID = cityID;
	}

	public String getCityName()
	{
		return cityName;
	}

	public void setCityName( String cityName )
	{
		this.cityName = cityName;
	}

	public int getHotelID()
	{
		return hotelID;
	}

	public void setHotelID( int hotelID )
	{
		this.hotelID = hotelID;
	}

	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName( String hotelName )
	{
		this.hotelName = hotelName;
	}

	public long getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom( long validFrom )
	{
		this.validFrom = validFrom;
	}

	public long getValidTo()
	{
		return validTo;
	}

	public void setValidTo( long validTo )
	{
		this.validTo = validTo;
	}

	public int getRooms()
	{
		return rooms;
	}

	public void setRooms( int rooms )
	{
		this.rooms = rooms;
	}

	public RoomContractBean[] getRoomContracts()
	{
		return roomContracts;
	}

	public void setRoomContracts( RoomContractBean[] roomContracts )
	{
		this.roomContracts = roomContracts;
	}
}
