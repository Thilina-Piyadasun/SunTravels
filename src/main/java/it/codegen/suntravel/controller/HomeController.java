package it.codegen.suntravel.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.codegen.suntravel.beans.SearchRequestBean;
import it.codegen.suntravel.service.DataRequest;
import it.codegen.suntravel.service.SearchHotel;
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
			List list ;
			int i=2;
			if(i==1)
				 list = searchHotel.searchByHotel(requestBean);
			else
				 list = searchHotel.searchByCity(requestBean);
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
		srb.setId( 1 );
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

	@ResponseBody
	@RequestMapping(value = "/getCountry", method = RequestMethod.GET)
	public String getCountries(){


		return gson.toJson( dataRequest.getCountries( ) );
	}

	@ResponseBody
	@RequestMapping(value = "/getCity", method = RequestMethod.GET)
	public String getCities(@RequestParam byte id){
		System.out.println(id);
		return gson.toJson( dataRequest.getCityByCountry( id ) );
	}

	@ResponseBody
	@RequestMapping(value = "/getHotel", method = RequestMethod.GET)
	public String getCities(@RequestParam int id){
		System.out.println(id);
		return gson.toJson( dataRequest.getHotelsByCity( id ) );
	}
}
