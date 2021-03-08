package com.test;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import RESTAPI.RESTAPI.TESTBase;
import co.qa.client.RESTclient;
import io.restassured.response.Response;

public class GetAPITest extends TESTBase {
	
	TESTBase testbase;
	String serviceUrl;
	String ApiUrl;
	String url;
	RESTclient restclinet;
	Response re;
	
	@BeforeMethod
	
	public void setUp() throws ClientProtocolException, IOException
	{
		testbase= new TESTBase();
		 serviceUrl= prop.getProperty("URL");
		 ApiUrl = prop.getProperty("serviceURL");
		 
		 url= serviceUrl + ApiUrl;
		  
	}
	

	@Test
	
	public void getAPITest() throws ClientProtocolException, IOException {
		restclinet = new RESTclient();
		restclinet.get(url); 	
		
	}

} 
