package day3;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class headerDemo {

	@Test(priority =1)
	public void getCookies() {
		
		given()
		.when()
			.get("https://www.google.co.in/")
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1") // Content-Type: text/html; charset=ISO-8859-1
			.header("Content-Encoding", "gzip")
			.header("Server", "gws")
			.log().headers();
		
	}
	
	@Test(priority =2 , enabled = true)
	public void getHeaderValue() {
		
		
		Response res = given()
		.when()
			.get("https://www.google.co.in/");
		
		
		String headerValue = res.getHeader("Content-Type");
		System.out.println("content type header Value  = "+ headerValue);

			
		}
			
				
		
	
	
}
