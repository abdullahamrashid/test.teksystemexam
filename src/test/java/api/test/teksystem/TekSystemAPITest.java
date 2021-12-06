package api.test.teksystem;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import io.restassured.response.Response;


public class TekSystemAPITest {

	@Test
	public void positiveAPI() {
		Response response= RestAssured.get("https://restcountries.com/v3.1/capital/rome");

		System.out.println(response.getBody().asString());

		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("contant-type"));
		System.out.println(response.getTime());
		System.out.println(response.getContentType());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);


	}
	@Test
	public void negativeAPI() {
		Response response= RestAssured.get("https://restcountries.com/v3.1/capital/paris");

		System.out.println(response.getBody().asString());
		System.out.println(response.getContentType());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);


	}
	@Test
	public void bddAPITest() {

		given().
		when().
		get("https://restcountries.com/v3.1/all").
		then().
		assertThat().statusCode(200).
		log().all();

	}
}


