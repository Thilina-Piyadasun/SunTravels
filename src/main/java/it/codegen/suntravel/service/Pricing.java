package it.codegen.suntravel.service;

/**
 * Created by thilinap on 4/18/2017.
 */
public class Pricing
{


	public long calculateMarkedUpPrice(long initValue,int adults,int dates,long mark){

		return initValue*mark*adults*dates/100;
	}


}
