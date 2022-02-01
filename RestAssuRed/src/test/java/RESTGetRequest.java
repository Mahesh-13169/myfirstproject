import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class RESTGetRequest {

//	public static void main(String[] args) 
	@Test
	public void m1()
	{
		String name="Michael";
		RestAssured.baseURI="https://reqres.in/";
		String response=	given().log().all().queryParam("page", "2").contentType("ContentType.JSON").when().get("/api/users").then()
		.assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		System.out.println(js);
		System.out.println("page is:"+js.getString("page"));
		System.out.println("list of emails"+js.getList("data.email"));
		int count=js.getList("data.id").size();
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			System.out.println("id is:"+js.get("data.id["+i+"]"));
			System.out.println("first name is:"+js.get("data.first_name["+i+"]")+"\t"+"last_name is:"+js.get("data.last_name["+i+"]"));
			System.out.println("emai id is:"+js.get("data.email["+i+"]"));
		}
		
			
		

	}

}
