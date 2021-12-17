package Restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class apivalidation {
	
	@Test
	public static void main(String[] args)
	{
		RestAssured.baseURI="http://demo.guru99.com";
		given().log().all().when().get("/V4/sinkministatement.php").
		then().log().all().assertThat().statusCode(200);
		
	}

}
