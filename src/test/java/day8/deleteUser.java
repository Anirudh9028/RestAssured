package day8;


import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class deleteUser {
@Test
public void removeUser(ITestContext context) {
		
		int id = (Integer)context.getAttribute("user_id");
		String token = "da865475d9ba87e62bdfeb533f594757b6d5c26f38c134f595aa89a47db39ba3";
		
		  given()
				.headers("Authorization","Bearer " + token)
				.pathParam("id", id)
			

		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
			
			
		.then()
			.statusCode(204)
			.log().all();
		
		
		
	}
	
	
	
	
}
