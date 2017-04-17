package com.cgn.reservation.dao;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by thilinap on 4/17/2017.
 */
@Entity
@Table(name = "CONTRACT", schema = "THILINAP", catalog = "")
public class ContractEntity
{
	private long id;
	private Time validFrom;
	private Time validTo;
	private Byte validDates;



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
	@Column(name = "VALID_FROM")
	public Time getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom( Time validFrom )
	{
		this.validFrom = validFrom;
	}

	@Basic
	@Column(name = "VALID_TO")
	public Time getValidTo()
	{
		return validTo;
	}

	public void setValidTo( Time validTo )
	{
		this.validTo = validTo;
	}

	@Basic
	@Column(name = "VALID_DATES")
	public Byte getValidDates()
	{
		return validDates;
	}

	public void setValidDates( Byte validDates )
	{
		this.validDates = validDates;
	}

	@Override
	public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass() != o.getClass() )
			return false;

		ContractEntity that = ( ContractEntity ) o;

		if ( id != that.id )
			return false;
		if ( validFrom != null ? !validFrom.equals( that.validFrom ) : that.validFrom != null )
			return false;
		if ( validTo != null ? !validTo.equals( that.validTo ) : that.validTo != null )
			return false;
		if ( validDates != null ? !validDates.equals( that.validDates ) : that.validDates != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) ( id ^ ( id >>> 32 ) );
		result = 31 * result + ( validFrom != null ? validFrom.hashCode() : 0 );
		result = 31 * result + ( validTo != null ? validTo.hashCode() : 0 );
		result = 31 * result + ( validDates != null ? validDates.hashCode() : 0 );
		return result;
	}
}
