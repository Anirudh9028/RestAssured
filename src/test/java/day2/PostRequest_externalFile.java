package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;





public class PostRequest_externalFile {

	
	
@Test (priority = 1)
public void creatUser () throws FileNotFoundException {
		 
	File ip =new File(".//data.json"); //open the file
	FileReader fr = new FileReader (ip); // read the file 
	JSONTokener jt = new JSONTokener(fr);
	JSONObject data  = new JSONObject(jt);
		 
		 given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://reqres.in/api/users")
			            
		.then()
			.statusCode(201)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("name", equalTo("Anirudh"))
			.body("courses [0]", equalTo("java"))
			.log().all();
		 
		 
	 }
	
	
	
}
