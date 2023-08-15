package com.PostMessageValidationSD;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostMessageValidationTest {
	Response response;
	
	@Given("post the data to create user")
	public void post_the_data_to_create_user() {
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": \"user1112\",\r\n"
						+ "    \"job\": \"QA leader\",\r\n"
						+ "    \"mob\": \"122\",\r\n"
						+ "    \"dept\": \"QA-Automation\",\r\n"
						+ "    \"location\": \"Pune\"\r\n"
						+ "}\r\n"
						+ "")
				.post("https://reqres.in/api/users");
	  
	}

	@Given("post the data to create from file")
	public void post_the_data_to_create_from_file() {
		File file = new File("src/test/java/com/PostMessageValidationSD/CreateUser.json");
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body(file)
				.post("https://reqres.in/api/users");
	  
	}
	
	@Given("post the data to create user from file with updated name")
	public void post_the_data_to_create_user_from_file_with_updated_name() throws IOException {
		String dataString = new String(Files.readAllBytes(Paths.get("src/test/java/com/PostMessageValidationSD/CreateUser.json")));
		JSONObject jsonObject = new JSONObject(dataString);
		double randomNum = Math.random();
		jsonObject.put("name", "userNewName"+randomNum);
		
		String finalDataString = jsonObject.toString();
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body(finalDataString)
				.post("https://reqres.in/api/users");
		response.then().log().all();
	}
	
	@Then("validate status code is {string}")
	public void validate_status_code_is(String statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode()+"");
		
	}
	
	@Then("validate id created for user with non null value")
	public void validate_id_created_for_user_with_non_null_value() {
		String id = response.body().jsonPath().getString("id");
	    Assert.assertTrue(!id.equals(null) );
	}
	
	@Then("validate id created for user with non zero value")
	public void validate_id_created_for_user_with_non_zero_value() {
		int id = response.body().jsonPath().getInt("id");
	    Assert.assertTrue(id > 0 );
	}
	
	
	
}
