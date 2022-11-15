@CoinMarketCapWebUI
Feature: To test the coinmarketcap Home page

Background: Open coinmarket website 
    Given Launch CoinMarketCap Website

  
  Scenario: Verify that Show rows dropdown value shows the correct number of Rows
    When I select Show rows dropdown value to "<Rows>"
    Then Validate that correct number of rows should be displayed as "<Rows>"
    Examples:
    |Rows|
    |100|
    


	Scenario Outline: Verify the records based on applied filters
      When User clicks on filters button
      And Filters records by "<MarketCapFilter>" in range "<MarketCapFilterRange>"
      And Filters records by "<Pricefilter>" in range "<PriceFilterRange>"
      Then Records should be displayed on page as per the filter applied
     Examples:
      | MarketCapFilter | MarketCapFilterRange |  Pricefilter | PriceFilterRange | 
      | Market Cap      | $1B - $10B      		 |  Price       | $101 - $1000| 