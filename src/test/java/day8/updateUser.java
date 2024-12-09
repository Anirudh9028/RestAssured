package day8;


import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class updateUser {

@Test
public void updateUser(ITestContext context) {
		
		
	int id = (Integer) context.getAttribute("user_id");
	
	Faker fg =new Faker();
	JSONObject data = new JSONObject();
	
	data.put("name",fg.name().fullName());
	data.put("gender","female");
	data.put("email",fg.internet().emailAddress());
	data.put("status","active");
	
	String token = "da865475d9ba87e62bdfeb533f594757b6d5c26f38c134f595aa89a47db39ba3";
	
	
	  given()
			.headers("Authorization","Bearer " + token)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())

	.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
		
	.then()
		.statusCode(200)
		.log().all();
	


}
	
	
	
}
