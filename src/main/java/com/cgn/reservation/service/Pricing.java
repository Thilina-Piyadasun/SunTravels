package com.cgn.reservation.service;

/**
 * Created by thilinap on 4/18/2017.
 */
public class Pricing
{

	private final double MARK_UP=0.15;

	public long calculateMarkedUpPrice(double initValue,int adults,int dates){
		return ( long ) (initValue*MARK_UP*adults*dates);
	}


}
