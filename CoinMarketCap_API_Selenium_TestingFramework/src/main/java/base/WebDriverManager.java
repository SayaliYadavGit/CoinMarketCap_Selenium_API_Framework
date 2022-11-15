package base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverManager {
	private static WebDriver driver;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public static WebDriver getDriver() {
        return driver;
    }

	
	public static WebDriver getDriver(String browser) {
		System.out.println("Browser :"+browser);
		if(driver == null) {
			if (browser.equals("chrome"))
			{
				driver = createDriver();
				}
			
		}
		return driver;
	}

	private static WebDriver createDriver() {
		System.setProperty(CHROME_DRIVER_PROPERTY, ConfigFileReader.getInstance().DriverPath());
    	driver = new ChromeDriver();
    	if(ConfigFileReader.getInstance().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getInstance().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	

}