package it.codegen.suntravel.beans;

/**
 * Created by thilinap on 4/17/2017.
 */
public class SearchRequestBean
{

	private int id;
	private int adults;
	private long  checkIN;
	private long  checkOut;
	private int[][] roomRequestDetails;

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public int[][] getRoomRequestDetails()
	{
		return roomRequestDetails;
	}

	public void setRoomRequestDetails( int[][] roomRequestDetails )
	{
		this.roomRequestDetails = roomRequestDetails;
	}

	public int getAdults()
	{
		return adults;
	}

	public void setAdults( int adults )
	{
		this.adults = adults;
	}

	/*public Timestamp getCheckIN()
	{
		return new Timestamp( checkIN);
	}*/

	public long getCheckIN()
	{
		return  checkIN;
	}
	public void setCheckIN( long checkIN )
	{

		this.checkIN = checkIN;
	}

	/*public Timestamp getCheckOut()
	{
		return new Timestamp(checkOut);
	}*/
	public long getCheckOut()
	{
		return checkOut;
	}


	public void setCheckOut( long checkOut )
	{
		this.checkOut = checkOut;
	}
}
