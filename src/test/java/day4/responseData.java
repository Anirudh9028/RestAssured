package day4;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class responseData 
{
	
	@Test(priority = 1 )
	public void getData() {
		
		
	Response res = given()
		
	.when()
		.get("https://reqres.in/api/unknown");
	
	 /*.then()
	 	.log().all();
	 	
	 */

	JSONObject js = new JSONObject(res.asString());
	
	int lenOfArr = js.getJSONArray("data").length();
	System.out.println("Array length = "+ lenOfArr);
	
	String nameValue = js.getJSONArray("data").getJSONObject(0).get("name").toString();
	System.out.println("Name Value = " + nameValue);
	
	String firstObj = js.getJSONArray("data").getJSONObject(0).toString();
	System.out.println("Name Value = " + firstObj +"\n");
	
	System.out.println("All obj = " + "\n");
	
	
	
	 for(int i=0;i<lenOfArr;i++) {
		
		String obj = js.getJSONArray("data").getJSONObject(i).toString();
		System.out.println(obj);
	}
	 
	// calculation of id 
	 
	 double ids = 0; 
	 for(int i=0;i<lenOfArr;i++) {
			
			String obj = js.getJSONArray("data").getJSONObject(i).get("id").toString();
			ids = ids + Double.parseDouble(obj);
			
		}
	 System.out.println("\n"+"total cal of id = " +ids);
	
	}
}
