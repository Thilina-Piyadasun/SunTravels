package com.cgn.reservation.dao;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by thilinap on 4/19/2017.
 */
@Entity
@Table(name = "CONTRACT", schema = "THILINAP", catalog = "")
public class ContractEntity
{
	private int id;
	private Timestamp validFrom;
	private Timestamp validTo;
	private Integer validDates;

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
	@Column(name = "VALID_DATES")
	public Integer getValidDates()
	{
		return validDates;
	}

	public void setValidDates( Integer validDates )
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
		int result = id;
		result = 31 * result + ( validFrom != null ? validFrom.hashCode() : 0 );
		result = 31 * result + ( validTo != null ? validTo.hashCode() : 0 );
		result = 31 * result + ( validDates != null ? validDates.hashCode() : 0 );
		return result;
	}
}
