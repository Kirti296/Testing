package RESTAPI.RESTAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TESTBase {
	
	public Properties prop;
	
	public TESTBase()
	{
		
		try {
		prop=new Properties();
		
		FileInputStream ip =new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\RESTAPI\\src\\main\\java\\com\\qa\\configuration\\config.properties");
				prop.load(ip);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
}
