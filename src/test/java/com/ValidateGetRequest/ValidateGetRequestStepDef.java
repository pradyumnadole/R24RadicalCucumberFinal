package com.ValidateGetRequest;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateGetRequestStepDef {
	Response response;
	String bookname = "Speaking JavaScript";
	String author = null;

	
	@Given("hit the URI111")
	public void hit_the_URI111() {
		
		 response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		 System.out.println("get the response");
	  
	}

	
	@Then("validate title {string} and pages {string} of application1")
	public void validate_title_and_pages_of_application1(String title, String int1) {
		String dataString = response.getBody().asString();
		System.out.println("All Data ==== "+dataString);
		String actualTitleString = response.getBody().jsonPath().getString("books[0].title");
		Assert.assertTrue(actualTitleString.equals(title));
		int pagesInt = response.getBody().jsonPath().getInt("books[0].pages");
		String pagesString = ""+pagesInt+"";
		Assert.assertEquals(pagesString, int1);
		
	}
	
	@Then("validate value for1 {string} is {string}")
	public void validate_value_for1(String str1, String str2) {
		String dataString = response.getBody().asString();
		String actualTitleString = response.getBody().jsonPath().getString(str1);
		Assert.assertTrue(actualTitleString.equals(str2));
	}
	

	@Then("validate value for attribute {string} is {string} present in response11")
	public void validate_value_for_attribute_is_present_in_response11(String str1, String expValue) {
		
		List<Object> allItem = response.getBody().jsonPath().getList("books."+str1);
		System.out.println("==="+allItem.toString());
		Assert.assertTrue(allItem.contains(expValue));
		
	}
	
	@Given("Title of book is {string}")
	public void Title_of_book_is_(String bookname){
		response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		 System.out.println("get the response");
		// bookname = "Speaking JavaScript";
	}
	
	@Then("validate author is {string}")
	public void validate_author_is_(String author){
		String dataString = response.getBody().asString();
		System.out.println("All Data ==== "+dataString);	
		
		List<String>alltitle=  response.getBody().jsonPath().getList("books.title");
		System.out.println("==="+alltitle.toString());
		int size = alltitle.size();
		
		for(int i =0 ;i<size;i++) {
			String actTitleString = response.getBody().jsonPath().param("i",i).getString("books[i].title");
			System.out.println("Title of book is " +actTitleString);
			if (actTitleString.equals(bookname)) {
				String author1 = response.getBody().jsonPath().param("i",i).getString("books[i].author");
				System.out.println("author is " +author1);
					if(author1.equals(author)) {
					System.out.println("**--***");
					Assert.assertEquals(author1, author);
					}
				break;
			}
			else {
				continue;
			}
	
		}
		
		
		
		
		
		
	
	}
	
	
}
