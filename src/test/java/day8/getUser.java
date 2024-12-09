package day8;


import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class getUser {

	
@Test
public void getUser(ITestContext context) {
		
	int  id  =  (Integer)context.getAttribute("user_id");
		
	String token = "da865475d9ba87e62bdfeb533f594757b6d5c26f38c134f595aa89a47db39ba3";
		
		
		given()
			.headers("Authorization","Bearer " + token)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all()
		
		;
		
		
		
	}
	
}
