package stepDefinations;

import static base.Utilities.navigateToBaseUrl;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.ConfigFileReader;
import base.WebDriverManager;
import io.cucumber.java.en.*;
import mainFunctions.validatePriceMarketData;
import pages.CoinMarketCapUIFunctions;

public class CoinMarketCapUISteps {

	public static WebDriverManager webDriverManager;
	
	ConfigFileReader prop=new ConfigFileReader();
    WebDriver driver=WebDriverManager.getDriver(prop.getBrowser());
    
@Given("Launch CoinMarketCap Website")
public void i_open_coinmarket_website() throws InterruptedException {
		navigateToBaseUrl(driver);
		}

@When("I select Show rows dropdown value to {string}")
public void i_select_show_rows_dropdown_value(String rows) {
		CoinMarketCapUIFunctions.closePopUp(driver);	
		CoinMarketCapUIFunctions.selectShowDropdownValue(rows,driver);   
}
	
@Then("Validate that correct number of rows should be displayed as {string}")
public void selected_value_should_match_number_of_rows_displayed(String rows1) {
		CoinMarketCapUIFunctions.confirmRows(driver,rows1);
			
}

@When("User clicks on filters button")
public void user_clicks_on_filters_button() {
	CoinMarketCapUIFunctions.clickFilterButton(driver);
	CoinMarketCapUIFunctions.clickAddFilter(driver);   
}

@When("Filters records by {string} in range {string}")
public void filters_records_by_range_from_to(String string, String string2) {
    CoinMarketCapUIFunctions.AddFilters(driver, string,string2);
}

@Then("Records should be displayed on page as per the filter applied")
public void records_should_be_displayed_on_page_as_per_the_filter_applied() {
	CoinMarketCapUIFunctions.clickShowResults(driver);
	//CoinMarketCapUIFunctions.clickOnMayBeLater(driver);    	
	CoinMarketCapUIFunctions.validateFilterData(driver);
	CoinMarketCapUIFunctions.closeDriver(driver);  
}

}

