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
	public void get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpget= new HttpGet(url);  //http get request 
		CloseableHttpResponse closeableresponse=  httpClient.execute(httpget);  // hit the GET url

		 
		int Status =closeableresponse.getStatusLine().getStatusCode();
		System.out.println("Status  Code ---->" + Status);
		
		
		
		String responseString =EntityUtils.toString(closeableresponse.getEntity(),"UTF-8");
		
		JSONObject  responsejson = new JSONObject(responseString);
		System.out.println("RESONSE JSON ---->" + responsejson);
		
		
		Header [] headerArray= closeableresponse.getAllHeaders();
		
		
		HashMap<String, String> allheaders = new HashMap<String, String>();
		
		for(Header header:headerArray) {
			
			allheaders.put(header.getName(), header.getValue());
		}
		System.out.println("ALl HEADERS--->"+allheaders);
}

	
}
	
	