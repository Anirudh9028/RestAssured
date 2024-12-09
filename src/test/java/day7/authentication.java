package day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class authentication {

	
	@Test (priority =1)
	public void auth() {
		
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		;
		
		
	}
	
	@Test (priority =2)
	public void bearerToken() {
		
		
		String bearerToken = "abc123";
		
		
		given()
			.headers("Authorization","Bearer " + bearerToken) // dont forget to add space after bearer word
			
		.when()
			.get("https://api.csvgetter.com/yj4iuhzWUJnVSE9U44A1")
		
		.then()
			.log().all();
		;
		
		
	}
	
	
	
	
	
}
