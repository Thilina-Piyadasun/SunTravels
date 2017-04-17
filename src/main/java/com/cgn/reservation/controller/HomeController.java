package com.cgn.reservation.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cgn.reservation.service.SearchDataRequest;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController
{
	private static final Logger logger = Logger.getLogger( HomeController.class );

	@Autowired
	private SearchDataRequest searchDataRequest;

	@Autowired
	private Gson gson;

	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getData( HttpServletRequest request, HttpServletResponse resp ) throws IOException
	{

		long millis1 = System.currentTimeMillis();
		List list = searchDataRequest.getData();
		long millis2 = System.currentTimeMillis();
		System.out.println( millis2 - millis1 );
		return gson.toJson( list );
	}

	@ResponseBody
	@RequestMapping(value = "/search/country", method = RequestMethod.GET)
	public String getDatabyCountry() throws IOException
	{

		long millis1 = System.currentTimeMillis();
		long id = 3;
		List list = searchDataRequest.getHotelsByCountry( id );
		long millis2 = System.currentTimeMillis();
		System.out.println( millis2 - millis1 );
		return gson.toJson( list );
	}

	@ResponseBody
	@RequestMapping
	public String getHotelNames( @RequestParam("city") int city )
	{
		return gson.toJson( searchDataRequest.getHotelNames( city ) );
	}

}
