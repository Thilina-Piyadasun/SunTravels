package it.codegen.suntravel.beans;

/**
 * Created by thilinap on 4/17/2017.
 */
public class SearchResponseBean
{
	private long hotelID;
	private String hotelName;
	private int roomID;
	private String city;
	private double price;
	private int rating;
	private String roomType;
	private boolean avaliability_status;

	public long getHotelID()
	{
		return hotelID;
	}

	public void setHotelID( long hotelID )
	{
		this.hotelID = hotelID;
	}

	public int getRating()
	{
		return rating;
	}

	public void setRating( int rating )
	{
		this.rating = rating;
	}

	public String getHotelName()
	{
		return hotelName;
	}

	public void setHotelName( String hotelName )
	{
		this.hotelName = hotelName;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity( String city )
	{
		this.city = city;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice( double price )
	{
		this.price = price;
	}

	public boolean isAvaliability_status()
	{
		return avaliability_status;
	}

	public void setAvaliability_status( boolean avaliability_status )
	{
		this.avaliability_status = avaliability_status;
	}

	public String getRoomType()
	{
		return roomType;
	}

	public void setRoomType( String roomType )
	{
		this.roomType = roomType;
	}

	public int getRoomID()
	{
		return roomID;
	}

	public void setRoomID( int roomID )
	{
		this.roomID = roomID;
	}
}
