package RESTAPI.RESTAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TESTBase {
	
	
	public int RESPONSE_STATUS_CODE_200=200;
	public int RESPONSE_STATUS_CODE_201=201;
	public int RESPONSE_STATUS_CODE_400=400;
	public int RESPONSE_STATUS_CODE_500=500;
	public int RESPONSE_STATUS_CODE_401=401;


	
	public Properties prop;
	
	public TESTBase()
	{
		
		try {
		prop=new Properties();
		
		FileInputStream ip =new FileInputStream("C:\\Users\\Shree\\Desktop\\KKK\\PROJECT_KK\\Testing\\RESTAPI\\src\\main\\java\\com\\qa\\configuration\\config.properties");
				prop.load(ip);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
}
