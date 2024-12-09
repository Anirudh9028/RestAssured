package day2;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;




public class PostRequest_POJOClass {

	
	
@Test (priority = 1)
public void creatUser () {
		 
	Pojo data = new Pojo ();
	
	data.setName("Anirudh");
	data.setJob("teacher");
	String gh [] = {"java","python"};
	data.setCources(gh);
	
		 
		 given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			            
		.then()
			.statusCode(201)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("name", equalTo("Anirudh"))
			.body("job", equalTo("teacher"))
			.body("cources[1]", equalTo("python"))
			.body("cources[0]", equalTo("java"))
			.log().all();
		 
		 
	 }
	
	
	
}
