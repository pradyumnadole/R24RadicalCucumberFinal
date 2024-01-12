package com.ValidateGetRequestParam;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateGetRequestParamStepDef {
	Response response;
	
	@Given("hit the URI")
	public void hit_the_URI() {
		
		 response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		 System.out.println("get the response");
	  
	}

	
	@Then("validate title {string} and pages {string} of application1111")
	public void validate_title_and_pages_of_application1111(String title, String int1) {
		String dataString = response.getBody().asString();
		System.out.println("All Data ==== "+dataString);
		String actualTitleString = response.getBody().jsonPath().getString("books[0].title");
		Assert.assertTrue(actualTitleString.equals(title));
		int pagesInt = response.getBody().jsonPath().getInt("books[0].pages");
		String pagesString = ""+pagesInt+"";
		Assert.assertEquals(pagesString, int1);
		
	}
	
	@Then("validate value1 for {string} is {string}")
	public void validate_value1_for(String str1, String str2) {
		String dataString = response.getBody().asString();
		String actualTitleString = response.getBody().jsonPath().getString(str1);
		Assert.assertTrue(actualTitleString.equals(str2));
	}
	

//	@Then("validate value for attribute {string} is {string} present in response")
//	public void validate_value_for_attribute_is_present_in_response(String str1, String expValue) {
//		
//		List<Object> allItem = response.getBody().jsonPath().getList("books."+str1);
//		System.out.println("==="+allItem.toString());
//		Assert.assertTrue(allItem.contains(expValue));
//		
//	}
	@Then("validate value1 for attribute {string} is {string} present in response")
	public void validate_value1_for_attribute_is_present_in_response(String str1, String expValue) {
		List<Object> allItem = response.getBody().jsonPath().getList("books."+str1);
		System.out.println("==="+allItem.toString());
		Assert.assertTrue(allItem.contains(expValue));
		
	}
	
	
	
}
