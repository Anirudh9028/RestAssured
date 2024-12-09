package day8;


import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class createUser
{
	@Test
	public void creatUser(ITestContext context) {
		
		
		
		Faker fg =new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name",fg.name().fullName());
		data.put("gender","male");
		data.put("email",fg.internet().emailAddress());
		data.put("status","inactive");
		
		String token = "da865475d9ba87e62bdfeb533f594757b6d5c26f38c134f595aa89a47db39ba3";
		
		 int id = given()
				.headers("Authorization","Bearer " + token)
				.contentType("application/json")
				.body(data.toString())

		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");

		System.out.println("user Id is = " + id);
		context.setAttribute("user_id", id);
		
	}
	

}
