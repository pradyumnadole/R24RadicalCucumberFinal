package com.ApplicationUp;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApplicationUpStepDef {
	Response response;
	
	@Given("hit the URI")
	public void hit_the_uri() {
		
		 response = RestAssured.get("https://www.google.com");
		 //https://www.demoqa.com/BookStore/v1/Books
		 System.out.println("get the response");
	  
	}

	
	@Then("validate the response {string} of application")
	public void validate_the_response_of_application(String expectedcode) {   
		String actualcode = ""+response.getStatusCode()+"";
		Assert.assertEquals(expectedcode, actualcode);
	}
}
