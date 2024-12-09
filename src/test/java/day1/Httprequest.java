package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
/*
 given() 
 
	set cookies ,add auth, set parm ,set headers
 when()
 	get , put, delete, post
 then()
 	validated the ,status code, response body 

 
 */

/*
 
 @Test (priority =)
	public void () {}
 
  */

import java.util.HashMap;

public class Httprequest {

	
	int id ;
	
	@Test (priority =1, enabled =true)
	public void getUser(){
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
			
		.then()
			.statusCode(200)
			.body("page", equalTo(2));
			//.log().all();
		
	}
	
	@Test (priority =2)
	public void creatUser () {
		
		HashMap <String ,String >data = new HashMap <String ,String >();
			
			data.put("name" ,"morpheus");
			data.put("job", "leader");
		
		
		id = given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");                    // it will get response data 
		
		//.then()
			//.statusCode(201);
			//.log().all();
		
		
		
	}
	
	 @Test (priority = 3 ,dependsOnMethods = {"creatUser"})
		public void updateUser() {
		 
		 HashMap <String ,String >data = new HashMap <String ,String >();
			
			data.put("name" ,"Anirudh");
			data.put("job", "Boss");
		
		
		 given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.put("https://reqres.in/api/users/" + id)
			                
		
		.then()
			.statusCode(200);
			//.log().all();
		 	 
		 
	 }
	
	 @Test (priority = 4 ,dependsOnMethods = {"updateUser"})
	public void deleteUser(){
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/" + id)
		
		.then()
			.statusCode(204)
			//.log().all()
		;
	}
	
	
	
	
}
