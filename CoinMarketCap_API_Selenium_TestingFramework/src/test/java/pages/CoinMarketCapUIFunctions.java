package pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.ConfigFileReader;
import mainFunctions.validatePriceMarketData;

import static base.LocatorsUtility.*;

public class CoinMarketCapUIFunctions {

	 public static void closePopUp(WebDriver driver) {
			ConfigFileReader.getInstance().getImplicitlyWait();
			driver.findElement(ClosePopUp).click();
	}
	 
public static void selectShowDropdownValue(String rows, WebDriver driver){
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(CountRowsDropdown));
		driver.findElement(CountRowsDropdown).click();
		if(Integer.parseInt(rows)==100)
		{driver.findElement(row100).click();}
}



public static void confirmRows(WebDriver driver,String rows1) {
		List<WebElement> rows = driver.findElements(TableRow);
		int size = rows.size()-1;
		Assert.assertEquals(Integer.parseInt(rows1),size);
}
	
public static void clickFilterButton(WebDriver driver){
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(FilterButton));
		driver.findElement(FilterButton).click();
}
	
public static void clickAddFilter(WebDriver driver){
		driver.findElement(AddFilter).click(); 
}
	
	
public static void AddFilters(WebDriver driver,String Filter,String Range){
		if(Filter.equals("Market Cap"))
		{
			driver.findElement(MarketCapRangeFilter).click();
			ConfigFileReader.getInstance().getImplicitlyWait();
			driver.findElement(SelectMarketCapRangeFilter).click(); //selectmarketcaprange
		}
		else
		{
			driver.findElement(PriceRangeFilter).click(); //clickonpricefilter
			ConfigFileReader.getInstance().getImplicitlyWait();
			driver.findElement(SelectpriceRangeFilter).click(); //pricefilter
			ConfigFileReader.getInstance().getImplicitlyWait();
		}
		
		clickApplyFilter(driver);
}
	
public static void clickApplyFilter(WebDriver driver){

		ConfigFileReader.getInstance().getImplicitlyWait();
		driver.findElement(ApplyFilter).click(); //applyfilter
		
	}
	
	
public static void clickShowResults(WebDriver driver){
		ConfigFileReader.getInstance().getImplicitlyWait();
		driver.findElement(ShowResults).click(); //showresult
		
}
	
public static void clickOnMayBeLater(WebDriver driver){
		
		ConfigFileReader.getInstance().getImplicitlyWait();
		ConfigFileReader.getInstance().getImplicitlyWait();
		ConfigFileReader.getInstance().getImplicitlyWait();
		if(isElementDisplayed(MayBeLater,driver))
            driver.findElement(MayBeLater).click();
        else
            System.out.println("No action needed");
}
	
private static boolean isElementDisplayed(By mayBeLater, WebDriver driver) {
	// TODO Auto-generated method stub
	return false;
}

public static List<WebElement> tableDataLoad(WebDriver driver)
	{

		ConfigFileReader.getInstance().getImplicitlyWait();
		driver.findElement(Table);

		ConfigFileReader.getInstance().getImplicitlyWait();
		
		WebElement tableBody=driver.findElement(TableBody);
		List<WebElement> rows=tableBody.findElements(TableRow);
		return rows;
		
	}
	
public static ArrayList<String> loadTablePriceData(WebDriver driver,List<WebElement> rows){
		ArrayList<String> PriceList = new ArrayList<String>(); 
		 
		for(int rnum=0;rnum<rows.size();rnum++)
		{
		List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
		PriceList.add(columns.get(3).getText());
		
		}
		return PriceList;
}
		
public static ArrayList<String> loadTableMarketCapData(WebDriver driver,List<WebElement> rows){
			 
			ArrayList<String> MarketCap = new ArrayList<String>(); 
			for(int rnum=0;rnum<rows.size();rnum++)
			{
			List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
			MarketCap.add(columns.get(7).getText());
			
			}
		return MarketCap;
}
		
public static void validateFilterData(WebDriver driver){
			List<WebElement> TableRows = CoinMarketCapUIFunctions.tableDataLoad(driver);
			ArrayList<String> Price = CoinMarketCapUIFunctions.loadTablePriceData(driver,TableRows); 
			ArrayList<String> MarketCap = CoinMarketCapUIFunctions.loadTableMarketCapData(driver,TableRows); 
			Assert.assertEquals(validatePriceMarketData.validatePriceData(Price), true);
			Assert.assertEquals(validatePriceMarketData.validateMarketData(MarketCap), true);
}	

public static void closeDriver(WebDriver driver) {
	driver.close();

	}

}
