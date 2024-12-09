package day3;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class queryAndPathParameter {

	@Test
	public void queryAndPathParam() {
		
		given()
			.pathParam("TestEnv", "users")
			.queryParam("page", 2)
			.queryParam("id", 8)
		.when()
			.get("https://reqres.in/api/{TestEnv}") //https://reqres.in/api/{TestEnv}?page=2&id=8
		
		.then()
			.statusCode(200)
			.log().all()
		;
		
		
		
	}
	
	
	
	
	
}
