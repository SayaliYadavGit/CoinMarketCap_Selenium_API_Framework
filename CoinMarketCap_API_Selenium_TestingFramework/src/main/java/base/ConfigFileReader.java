package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class ConfigFileReader {
	private Properties properties;
	private static ConfigFileReader configReader;

    public ConfigFileReader() {
		BufferedReader reader;
	    	String propertyFilePath = "configs//Configuration.properties";
	        try {
	            reader = new BufferedReader(new FileReader(propertyFilePath));
	            properties = new Properties();
	            try {
	                properties.load(reader);
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	        }		
	}

    public static ConfigFileReader getInstance( ) {
    	if(configReader == null) {
    		configReader = new ConfigFileReader();
    	}
        return configReader;
    }

    public String getBaseUrl() {
        String BaseUrl = properties.getProperty("BaseUrl");
        if(BaseUrl != null) return BaseUrl;
        else throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
    }

    public String getHeader() {
        String userId = properties.getProperty("X-CMC_PRO_API_KEY");
        if(userId != null) return userId;
        else throw new RuntimeException("user_Id not specified in the Configuration.properties file.");
    }
    
    public String WebURL() {
        String WebURL = properties.getProperty("WebURL");
        if(WebURL != null) return WebURL;
        else throw new RuntimeException("WebURL not specified in the Configuration.properties file.");
    }

    public String DriverPath() {
    	String path = System.getProperty("user.dir");

        String DriverPath = properties.getProperty("DriverPath");
        if(DriverPath != null) return path+DriverPath;
        else throw new RuntimeException("DriverPath not specified in the Configuration.properties file.");
    }
    
    public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;		
	}
    
   
    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("WebURL not specified in the Configuration.properties file.");
    }
   
    
    public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}




}