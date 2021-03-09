package com.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.util.TESTutility;

import RESTAPI.RESTAPI.TESTBase;
import co.qa.client.RESTclient;

public class GetAPITest extends TESTBase {
	
	TESTBase testbase;
	String serviceUrl;
	String ApiUrl;
	String url;
	RESTclient restclinet;
	CloseableHttpResponse closeableresponse;
	
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
		closeableresponse =restclinet.get(url);
		
		
		int Status =closeableresponse.getStatusLine().getStatusCode();
		System.out.println("Status  Code ---->" + Status);
		
		Assert.assertEquals(Status,RESPONSE_STATUS_CODE_200, "status code is not 200");
		
		
		
		String responseString =EntityUtils.toString(closeableresponse.getEntity(),"UTF-8");
		
		JSONObject  responsejson = new JSONObject(responseString);
		System.out.println("RESONSE JSON ---->" + responsejson);
		
		String s= TESTutility.getValueByJPath(responsejson,"/per_page");
		System.out.println("value of per_page-->" + s);
		
		Assert.assertEquals(Integer.parseInt(s),6);
		
		// get the value of JSON array 
		
		String id =TESTutility.getValueByJPath(responsejson, "/data[0]/id");
		String  first_name=	TESTutility.getValueByJPath(responsejson, "/data[0]/first_name");
		String last_name=TESTutility.getValueByJPath(responsejson, "/data[0]/last_name");
		String avatar= TESTutility.getValueByJPath(responsejson, "/data[0]/avatar");
		
		System.out.println(id);
		System.out.println(first_name);

		System.out.println(last_name);

		System.out.println(avatar);

		
		
		
		
		 	
		Header [] headerArray= closeableresponse.getAllHeaders();
		
		
		HashMap<String, String> allheaders = new HashMap<String, String>();
		
		for(Header header:headerArray) {
			
			allheaders.put(header.getName(), header.getValue());
		}
		System.out.println("ALl HEADERS--->"+allheaders);
		
	}

	
	
} 
