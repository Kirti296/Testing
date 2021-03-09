package co.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
 	
public class RESTclient {
	
	//1. GET method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpget= new HttpGet(url);  //http get request 
		CloseableHttpResponse closeableresponse=  httpClient.execute(httpget);  // hit the GET url

		 
		return closeableresponse;
}

	
}
	
	 