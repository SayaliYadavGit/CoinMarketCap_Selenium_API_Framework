@CoinMarketCapAPI
Feature: Test features of CoinMarketCap APIs task
  

	@MapAPICall
  Scenario Outline: Retrieve the ids from Map API and convert the currency 
    Given I am able to access the cryptocurrency map API
    When I Retrieve the IDS of "<cryptocurrency1>","<cryptocurrency2>","<cryptocurrency3>"
    Then I should be able to convert IDS to "<conversionformat>" format
  Examples:
    |cryptocurrency1|	|cryptocurrency2|	|cryptocurrency3|		|conversionformat|
    |Bitcoin|					|Tether|						|Ethereum|				|BOLI|
    
   
  @InfoAPICall
  Scenario Outline: Verify the Ethereum technical documentation for logo, URL, currency, date and tags
    Given I am able to retrieve the cryptocurrency info API for "<ID>"
    Then Response should have "<Logo>" , "<technical_doc_url>", "<Symbol>", "<date_added>" and tag "<mineable>"
  Examples:
    |ID|		|Logo|																												 |technical_doc_url|																 |Symbol| |date_added|							|tag|
    |1027|	|https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png| |https://github.com/ethereum/wiki/wiki/White-Paper| |ETH|		|2015-08-07T00:00:00.000Z||mineable|
  
    
  @InfoAPICall
  Scenario: To retreive first 10 currencies, check mineable tag and verify cryptocurrencies
   Given I Retreive the first 10 currencies from the cryptocurrency info API call
   Then Validate that the currencies have the mineable tag associated with them
    