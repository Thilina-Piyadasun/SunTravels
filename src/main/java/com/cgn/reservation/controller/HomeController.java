package com.cgn.reservation.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cgn.reservation.beans.SearchRequestBean;
import com.cgn.reservation.service.DataRequest;
import com.cgn.reservation.service.SearchHotel;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController
{
	private static final Logger logger = Logger.getLogger( HomeController.class );

	@Autowired
	private DataRequest dataRequest;

	@Autowired
	private SearchHotel searchHotel;

	@Autowired
	private Gson gson;

	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String getData( @RequestBody SearchRequestBean requestBean )
	{
		try
		{
			long millis1 = System.currentTimeMillis();
			List list = searchHotel.search(requestBean);
			long millis2 = System.currentTimeMillis();
			System.out.println( millis2 - millis1 );
			return gson.toJson( list );
		}
		catch ( Exception e){
			new Exception( "Exception occured in Home controller line : 41" );
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/search/country", method = RequestMethod.POST)
	public String getDatabyCountry(@RequestBody byte id) throws IOException
	{

		long millis1 = System.currentTimeMillis();
		List list = dataRequest.getCityByCountry( id );

		long millis2 = System.currentTimeMillis();
		System.out.println( millis2 - millis1 );
		return gson.toJson( list );
	}

	@ResponseBody
	@RequestMapping(value = "/search/city", method = RequestMethod.POST)
	public String getHotelNames( @RequestBody int city )
	{
		return gson.toJson( dataRequest.getHotelsByCity( city ) );
	}

	@ResponseBody
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2( ){
		byte b=1;
		return gson.toJson( dataRequest.getCityByCountry(b));
	}



	/*delete this method after*/
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test( )
	{
		SearchRequestBean srb=new SearchRequestBean();
		srb.setAdults( 3 );
		srb.setHotelID( 1 );
		int[][] arr={{1,2},{2,3}};
		srb.setRoomRequestDetails( arr );
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = null;
		Date date2 = null;
		try
		{
			date1 = dateFormat.parse("23/09/2016");
			date2 = dateFormat.parse("23/09/2017");
		}
		catch ( ParseException e )
		{
			e.printStackTrace();
		}

		long time = date1.getTime();
		long time2 = date2.getTime();


		srb.setCheckIN( time );
		srb.setCheckOut( time2 );
		return gson.toJson( srb );
	}


}
