package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class cookiesDemo {

	@Test(priority =1)
	public void getCookies() {
		
		given()
		.when()
			.get("https://www.google.co.in/")
		.then()
		.log().cookies()
		//.log().headers()
		;
		
	}
	
	@Test(priority =2)
	public void getCookiesValue() {
		
		
		Response res = 
		given()
		.when()
			.get("https://www.google.co.in/");
		
		
		String singleCookie = res.getCookie("AEC");
		
		System.out.println("value of AEC cookies =   " +  singleCookie);
		
		Map<String ,String> AllCookies = res.getCookies();
		
		for(String k : AllCookies.keySet()) {
			
			System.out.println(k +"    =    "+ AllCookies.get(k));
		}
		
		
		
	}
	
}
