package pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import base.ConfigFileReader;
import java.util.*;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;

public class CoinMarketCapRestAPIFunctions
{
   public static HashSet<Boolean> flagList=new HashSet<>();
    public Response response;
    public ArrayList<String> bolivianList;
    public JSONObject json;
    List<HashMap<Object, Object>> jsonResponse;
    static Map<Object,HashMap<Object,Object>> jsonResponseObj;
   
    ArrayList<Integer> listids = new ArrayList<Integer>();
    
    public void getRequest() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = ConfigFileReader.getInstance().getBaseUrl();
        response = given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", ConfigFileReader.getInstance().getHeader())
                .when()
                .get("v1/cryptocurrency/map")
                .then()
                .extract().response();
    }

    public void retrieveIDS(String cur1,String cur2,String cur3) throws ParseException {
        Assert.assertEquals(200, response.statusCode());
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> allBooks = jsonPathEvaluator.getList("data");
        JSONArray jsonArray= new JSONArray(allBooks);
        
        for (int i = 0; i < jsonArray.length(); i++) {
    	    JSONObject jsonobject = jsonArray.getJSONObject(i);
    	    
    	   if(jsonobject.getString("name").toString().equals(cur1)||jsonobject.getString("name").toString().equals(cur2)||jsonobject.getString("name").toString().equals(cur3))
    		   listids.add(jsonobject.getInt("id"));
    	}
       System.out.println("List of Retrieved Ids: "+listids);
        
        }

    public void convertIDSToBolivian(String convert) {
    	bolivianList = new ArrayList<String>();
    	for(Integer s:listids)
    	{
    		bolivianList.add(given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", ConfigFileReader.getInstance().getHeader())
                .param("amount", "1")
                .param("convert", convert)
                .param("id", s)
                .when()
                .get("v1/tools/price-conversion")
                .then()
                .extract().response().jsonPath().get("data.quote.BOLI.price").toString());
    	}
    	
    	for(String x:bolivianList)
    	{
    		System.out.println("Converted Bolivain prices are: "+x);
    	}
    	
    	Assert.assertEquals(200, response.statusCode());

    }


    public void getCryptoCurrencyInfoForGivenId(String ID) {

        response = given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", ConfigFileReader.getInstance().getHeader())
                .param("id", ID)
                .when()
                .get("v1/cryptocurrency/info")
                .then()
                .extract().response();
        List<Object> list1 = response.jsonPath().get("data.1027.urls.website");
        Assert.assertTrue(list1.size()>0);
    }


    public void valiateJsonResponseID(String logo,String technical_doc,String symbol,String date_added,String tag) {
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(logo, response.jsonPath().get("data.1027.logo").toString());
        Assert.assertEquals(technical_doc, response.jsonPath().getList("data.1027.urls.technical_doc").get(0).toString());
        Assert.assertEquals(symbol, response.jsonPath().get("data.1027.symbol").toString());
        Assert.assertEquals(date_added, response.jsonPath().get("data.1027.date_added").toString());
        try{
            Assert.assertTrue(response.jsonPath().getList("data.1027.tags").contains(tag));

        }catch (Exception e) {
            System.out.println("tags: [ mineable ] is not associated here and so the test failed!");
            e.printStackTrace();
        }

    }



    public void getCryptoCurrencies(){
        
    	response = given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", ConfigFileReader.getInstance().getHeader())
                .param("id", "1,2,3,4,5,6,7,8,9,10")
                .when()
                .get("v1/cryptocurrency/info")
                .then()
                .extract().response();
        Assert.assertEquals(200, response.statusCode());
        jsonResponseObj = response.jsonPath().getMap("data");
   
    }

    
    public static void cryptocurrencyValidation(){
    	
    	
    	 for (Map.Entry<Object,HashMap<Object,Object>> entry : jsonResponseObj.entrySet()) {
             System.out.println(entry.getKey() + ":" + entry.getValue().get("tags")+ ":" + entry.getValue().get("name"));
             if(entry.getValue().get("tags").toString().contains("mineable")){
                 flagList.add(true);
                 System.out.println("true");
             }else{
                 flagList.add(false);
                 System.out.println("false");
             }
         }
         Boolean flag = true;
         if(flagList.contains(false)){
             flag=false;
         }
        
         Assert.assertTrue(flag);

    	
    }
}
        