import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import files.payload;
public class BasicRest 
{
  public static void main(String[] args) 
  {
	//validate if add place api is working as expected
	  
	  RestAssured.baseURI="https://rahulshettyacademy.com";
	String response=  given().log().all().queryParam(" key ", " qaclick123").header("Content-Type","application/json;charset=UTF-8")
	  .body(payload.addplace()).when().post("maps/api/place/add/json")
	  .then().statusCode(200).body("scope", equalTo("APP")).extract().asString();
	  
	  System.out.println(response);
	  JsonPath js=new JsonPath(response);
	String placeid=  js.getString("place_id");
	System.out.println(placeid);
	
	  
	  
}
}
