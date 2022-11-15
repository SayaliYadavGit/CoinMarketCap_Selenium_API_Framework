package base;

import org.openqa.selenium.By;

public class LocatorsUtility {

	public static By ClosePopUp = By.cssSelector("body > div.sc-27634647-0.eqvUQC > div.sc-27634647-2.brXFBk > div.gv-close > svg > path");
	public static By CountRowsDropdown = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[3]/div[1]/div");
	public static By FilterButton = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[4]/div[2]/div[3]/div[2]/button[1]");
	public static By AddFilter = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/ul/li[5]/button");
	public static By MarketCapRangeFilter = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[6]/div/div/div[2]/div[1]/div[2]/button");
	public static By SelectMarketCapRangeFilter = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[6]/div/div/div[2]/div/div[3]/div[1]/div[2]/button[2]");
	public static By PriceRangeFilter = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[6]/div/div/div[2]/div[1]/div[3]/button");									
	public static By SelectpriceRangeFilter = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[6]/div/div/div[2]/div/div[4]/div[1]/div[2]/button[3]");
	public static By ShowResults = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[6]/div/div/div[2]/div[2]/button[1]");
	public static By MayBeLater = By.cssSelector("#__next > div > div.sc-c5c9d167-2.dwWUUU > div.sc-c7b56da4-0.BcsEj.popped > div.buttons > button.sc-612ec9ca-0.blLayT");
	public static By TableBody = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/table/tbody");
	public static By Table = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/table");
	public static By TableRow = By.tagName("tr");
	public static By row100 = By.xpath("//button[text()=\"100\"]");
	public static By ApplyFilter = By.cssSelector("#__next > div > div.main-content > div.sc-1a736df3-0.PimrZ.cmc-body-wrapper > div > div:nth-child(1) > div.popup-overlay > div > div > div.sc-aef7b723-0.jKbKdp > div > div.sc-67bdc129-0.dcixLX > div.sc-aef7b723-0.dDQUel > div > button.sc-612ec9ca-0.jgfEME.cmc-filter-button");
}


