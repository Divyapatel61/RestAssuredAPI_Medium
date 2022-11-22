package tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestsExample
{
	@Test
	public void test_01()
	{
		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println("Response :- " +response.asString()); 
		System.out.println("Body :- " +response.getBody().asString());
		System.out.println("Status Code :- " +response.getStatusCode());
		System.out.println("Status Line :- " +response.getStatusLine());
		System.out.println("Content Type:- " +response.getHeader("content-type"));
		System.out.println("Get Time :- " +response.getTime());

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_02()
	{
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]", equalTo(7));
	}
	
	

}
