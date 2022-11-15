package base;

import static base.LocatorsUtility.*;

import org.openqa.selenium.WebDriver;

public class Utilities {

	 public static void navigateToBaseUrl(WebDriver driver){
	        driver.get(ConfigFileReader.getInstance().WebURL());
	        driver.manage().window().maximize();
	       }
	 
	
}
