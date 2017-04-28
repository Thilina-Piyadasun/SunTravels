package it.codegen.suntravel.beans;

import java.sql.Timestamp;

/**
 * Created by thilinap on 4/26/2017.
 */
public class ViewContractBean
{

	private int contractID;
	private String HotelName;
	private int hotelrating;
	private Timestamp validFrom;
	private Timestamp validTo;
	private long markup;

	public int getContractID()
	{
		return contractID;
	}

	public void setContractID( int contractID )
	{
		this.contractID = contractID;
	}

	public String getHotelName()
	{
		return HotelName;
	}

	public void setHotelName( String hotelName )
	{
		HotelName = hotelName;
	}

	public int getHotelrating()
	{
		return hotelrating;
	}

	public void setHotelrating( int hotelrating )
	{
		this.hotelrating = hotelrating;
	}

	public Timestamp getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom( Timestamp validFrom )
	{
		this.validFrom = validFrom;
	}

	public Timestamp getValidTo()
	{
		return validTo;
	}

	public void setValidTo( Timestamp validTo )
	{
		this.validTo = validTo;
	}

	public long getMarkup()
	{
		return markup;
	}

	public void setMarkup( long markup )
	{
		this.markup = markup;
	}
}
