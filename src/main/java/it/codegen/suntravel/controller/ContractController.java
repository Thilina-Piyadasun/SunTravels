package it.codegen.suntravel.controller;

import com.google.gson.Gson;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import it.codegen.suntravel.beans.ContractBean;
import it.codegen.suntravel.service.AddContractData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by thilinap on 4/21/2017.
 */
@Controller
@RequestMapping("/contract")
public class ContractController
{

	@Autowired
	private AddContractData addContractData;

	@Autowired
	private Gson gson;


	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean  addContract(@RequestBody ContractBean contractBean){

		System.out.println(gson.toJson( contractBean ));
		addContractData.addContractDetails(contractBean);
		return true;
	}

	@ResponseBody
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String getContract(){
		return gson.toJson( addContractData.viewContracts() );
	}

	@ResponseBody
	@RequestMapping(value = "/viewRoomContract", method = RequestMethod.GET)
	public String getRoomContract(@RequestParam int id){

		try{
			return gson.toJson( addContractData.viewRoomContracts(id) );
		}
		catch ( Exception e ){}
		finally
		{

		}
		return "";
	}
}
