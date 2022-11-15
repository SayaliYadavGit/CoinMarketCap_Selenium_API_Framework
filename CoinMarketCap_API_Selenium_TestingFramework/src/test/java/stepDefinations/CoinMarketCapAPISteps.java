package stepDefinations;

import org.json.simple.parser.ParseException;

import pages.CoinMarketCapRestAPIFunctions;

import io.cucumber.java.en.*;



public class CoinMarketCapAPISteps {

CoinMarketCapRestAPIFunctions restAPI = new CoinMarketCapRestAPIFunctions();
	
	
@Given("I am able to access the cryptocurrency map API")
public void i_am_able_to_access_the_cryptocurrency_map_api() {
	restAPI.getRequest();
}

@When("I Retrieve the IDS of {string},{string},{string}")
public void i_retrieve_the_ids_of(String string, String string2, String string3) throws ParseException {
	restAPI.retrieveIDS(string,string2,string3);
}

@Then("I should be able to convert IDS to {string} format")
public void ids_should_be_converted_to_format(String string) {
	restAPI.convertIDSToBolivian(string);
}

@Given("I am able to retrieve the cryptocurrency info API for {string}")
public void i_am_able_to_retrieve_the_cryptocurrency_info_api_for(String string) {
	restAPI.getCryptoCurrencyInfoForGivenId(string);
}

@Then("Response should have {string} , {string}, {string}, {string} and tag {string}")
public void response_should_have_and_tag(String logo, String technical_doc, String symbol, String date_added, String tag) {
	restAPI.valiateJsonResponseID(logo,technical_doc,symbol,date_added,tag);
}

@Given("I Retreive the first {int} currencies from the cryptocurrency info API call")
public void i_retreive_the_first_currencies_from_the_cryptocurrency(Integer int1) throws ParseException {
	restAPI.getCryptoCurrencies();
}

@Then("Validate that the currencies have the mineable tag associated with them")
public void check_tags_have_the_mineable_tag_associated_with_them() {
	CoinMarketCapRestAPIFunctions.cryptocurrencyValidation();
}


}
