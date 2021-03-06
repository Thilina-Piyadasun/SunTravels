package it.codegen.suntravel.dao;

import javax.persistence.*;

/**
 * Created by thilinap on 4/21/2017.
 */
@Entity
@Table(name = "COUNTRY", schema = "THILINAP", catalog = "")
public class CountryEntity
{
	private byte id;
	private String name;

	@Id
	@Column(name = "ID")
	public byte getId()
	{
		return id;
	}

	public void setId( byte id )
	{
		this.id = id;
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

		CountryEntity that = ( CountryEntity ) o;

		if ( id != that.id )
			return false;
		if ( name != null ? !name.equals( that.name ) : that.name != null )
			return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = ( int ) id;
		result = 31 * result + ( name != null ? name.hashCode() : 0 );
		return result;
	}
}
