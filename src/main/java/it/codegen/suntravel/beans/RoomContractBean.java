package it.codegen.suntravel.beans;

/**
 * Created by thilinap on 4/24/2017.
 */
public class RoomContractBean
{
	private int roomNo;
	private String type;
	private int adults;
	private long r_price;

	public RoomContractBean(){}

	public RoomContractBean( int roomNo, String type, int adults, long r_price )
	{
		this.roomNo = roomNo;
		this.type = type;
		this.adults = adults;
		this.r_price = r_price;
	}

	public int getRoomNo()
	{
		return roomNo;
	}

	public void setRoomNo( int roomNo )
	{
		this.roomNo = roomNo;
	}

	public String getType()
	{
		return type;
	}

	public void setType( String type )
	{
		this.type = type;
	}

	public long getPrice()
	{
		return r_price;
	}

	public void setPrice( long price )
	{
		this.r_price = price;
	}

	public int getAdults()
	{
		return adults;
	}

	public void setAdults( int adults )
	{
		this.adults = adults;
	}
}
