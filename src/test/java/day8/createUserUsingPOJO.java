package day8;


import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;




public class createUserUsingPOJO
{
	
	Faker faker ;
	int uid;
	pojoClass userPayload;
	String token = "da865475d9ba87e62bdfeb533f594757b6d5c26f38c134f595aa89a47db39ba3";
	String payload = "";
	ObjectMapper objmap;
	
@BeforeClass
public void setUp() throws JsonProcessingException {

	faker = new Faker();
	userPayload = new pojoClass ();
	userPayload.setName(faker.name().fullName());
	userPayload.setEmail(faker.internet().emailAddress());
	userPayload.setGender("male");
	userPayload.setStatus("inactive");
	
	
	// covert class obj into json obj (joson payload as string) (serilaition)
	
	ObjectMapper objmap =new ObjectMapper();
	
	 payload = objmap.writeValueAsString(userPayload);
	
	
		
}

@Test(priority =1)
public void serialiazation() {
		
		System.out.println("serialiazation data (class obj-->json obj (as string))= " + payload);
		
		
	}
	
@Test(priority =2)
public void deserialiazation() throws JsonMappingException, JsonProcessingException {
		
	pojoClass userPayload2 =  objmap.readValue(payload, pojoClass.class);
	
	
	System.out.println("de-serialiazation  (json obj(string data)-->class obj ) obje id = " + userPayload2.getName());
		
		
	}
			
	
@Test(priority =3)
public void creatUser(ITestContext context) {
		
		
		
		 int id  =given()
				.headers("Authorization","Bearer " + token)
				.contentType("application/json")
				.body(payload)

		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
			
		
		System.out.println("user Id is = " + id);
		context.setAttribute("user_id", id);
			/*
			 * .then()
			.log().all();
			 * */
		
	}
	

}
