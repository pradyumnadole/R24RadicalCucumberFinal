package com.ApplicationUp;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApplicationUpStepDef {
	Response response;
	
	@Given("hit the URI11")
	public void hit_the_uri11() {
		
		// response = RestAssured.get("https://www.google.com");
		 response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		 
		
		 System.out.println("get the response");
	  
	}

	@Then("validate the response {string} of application")
	public void validate_the_response_of_application(String expectedcode) {   
		response.then().log().all();
		String actualcode = ""+response.getStatusCode()+"";
		Assert.assertEquals(expectedcode, actualcode);
	}
	
	/*
	 * @Then("validate the response {string} of application") public void
	 * validate_the_response_of_application(String expectedcode) { String actualcode
	 * = ""+response.getStatusCode()+""; Assert.assertEquals(expectedcode,
	 * actualcode); }
	 */
}
