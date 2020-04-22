package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties prop;
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("Excpetion is"+ e.getMessage());
					 
		}
		
	}
	
public String getApplicationURL()
{
	String URL= prop.getProperty("baseURL");
	return URL;
}


public String getchromepath()
{
	String chromepath= prop.getProperty("chromepath");
	return chromepath;
}

public String getReportConfigPath(){
 String reportConfigPath = prop.getProperty("reportConfigPath");
 if(reportConfigPath!= null) return reportConfigPath;
 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
}
}