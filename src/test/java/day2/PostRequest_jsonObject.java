package day2;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;




public class PostRequest_jsonObject {

	
	
@Test (priority = 1)
public void creatUser () {
		 
	JSONObject data = new JSONObject();
	
	data.put("name" ,"gabber");
	data.put("job", "thief");
	data.put("location", "world");
	String [] io = {"gold","silver"};
	data.put("robery", io);
	
		 
		 given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://reqres.in/api/users")
			            
		.then()
			.statusCode(201)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("name", equalTo("gabber"))
			.body("location", equalTo("world"))
			.body("robery[1]", equalTo("silver"))
			.log().all();
		 
		 
	 }
	
	
	
}
