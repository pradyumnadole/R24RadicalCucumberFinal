package com.ApplicationUp;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AppUp {
	Response response;
	
	@Given("URL is available")
	public void url_is_available() {
		response = RestAssured.get("https://www.google.com/");
		 System.out.println("get the response");
	}

	@Then("validate URL is running")
	public void validate_url_is_running() {
		//response.then().log().all(); 
		int code = response.getStatusCode();
		int expcode = 200;
		Assert.assertEquals(expcode, code);
	}
	
}
