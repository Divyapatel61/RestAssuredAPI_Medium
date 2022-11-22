package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalAPI 
{
	//@Test
	public void test_get()
	{

	baseURI = "http://localhost:3000/";

	given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
	when().
		get("/users").
		then().
		statusCode(200).
		log().all();

	}
	
	//@Test
	public void test_get_2()
	{

		baseURI = "http://localhost:3000/";

		given().
		param("name", "Automation").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		when().
		get("/subjects").
		then().
		statusCode(200).
		log().all();

	}
	
	//@Test
	void test_post()
	{
		JSONObject request = new JSONObject();

		request.put("firstName", "Gary");
		request.put("lastName", "Thomson");
		request.put("subjectId", 2);

		baseURI = "http://localhost:3000/";

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
			then().
			statusCode(201)
			.log().all();

	}
	
	//@Test
	public void test_patch() 
	{

		JSONObject request = new JSONObject();

		request.put("lastName", "Shephered");

		baseURI = "http://localhost:3000/";

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/4").
			then().
			statusCode(200)
			.log().all();

	}


	//@Test
	public void test_put() 
	{

		JSONObject request = new JSONObject();

		request.put("firstName", "Ray");
		request.put("lastName", "Murphy");
		request.put("subjectId", 1);


		baseURI = "http://localhost:3000/";

		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/4").
			then().
			statusCode(200)
			.log().all();

	}
	
	@Test
	public void test_delete() 
	{
		baseURI = "http://localhost:3000/";

		
		when().
			delete("/users/4").
		then().
			statusCode(200)
			.log().all();

	}


}
