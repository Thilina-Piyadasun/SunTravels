package it.codegen.suntravel.dao;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by thilinap on 4/21/2017.
 */
@Entity
@Table(name = "CONTRACT", schema = "THILINAP", catalog = "")
public class ContractEntity
{
	private int id;
	private Long validFrom;
	private Long validTo;

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
	public Long getValidFrom()
	{
		return validFrom;
	}

	public void setValidFrom( Long validFrom )
	{
		this.validFrom = validFrom;
	}

	@Basic
	@Column(name = "VALID_TO")
	public Long getValidTo()
	{
		return validTo;
	}

	public void setValidTo( Long validTo )
	{
		this.validTo = validTo;
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

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + ( validFrom != null ? validFrom.hashCode() : 0 );
		result = 31 * result + ( validTo != null ? validTo.hashCode() : 0 );
		return result;
	}

	public Timestamp ValidFromAsDate(){
		return new Timestamp(this.getValidFrom());
	}

	public Timestamp ValidToAsDate(){
		return new Timestamp(this.getValidTo());
	}
}
