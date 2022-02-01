import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class RestPostRequest 
{
	@Test
   public void Postrequest() 
   {
	   RestAssured.baseURI="https://reqres.in/";
	String response=   given().log().all().header("Content-Type","application/json").body("{\r\n"
	   		+ "    \"name\": \"morpheus\",\r\n"
	   		+ "    \"job\": \"leader\"\r\n"
	   		+ "}").when().post("/api/users").then().log().all().assertThat().statusCode(201).extract().response().asString();
	System.out.println(response);
	
	  JsonPath js=new JsonPath(response);
	 System.out.println(js);
	System.out.println( js.getString("name"));
	
	
	
	
	
   }
}
