package com.TagsValidationSD;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TagsValidationTest {
	Response response;
	
	@Given("post the data to create user2")
	public void post_the_data_to_create_user2() {
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

	@Given("post the data to create from file2")
	public void post_the_data_to_create_from_file2() {
		File file = new File("src/test/java/com/PostMessageValidationSD/CreateUser.json");
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body(file)
				.post("https://reqres.in/api/users");
	  
	}
	
	@Given("post the data to create user from file with updated name2")
	public void post_the_data_to_create_user_from_file_with_updated_name2() throws IOException {
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
	
	@Given("post the data to create user from file with updated fields2")
	public void post_the_data_to_create_user_from_file_with_updated_fields2(DataTable table) throws IOException {
		String dataString = new String(Files.readAllBytes(Paths.get("src/test/java/com/PostMessageValidationSD/CreateUser.json")));
		JSONObject jsonObject = new JSONObject(dataString);
		double randomNum = Math.random();
		List<List<String>> allDataList= table.asLists();
		
		
		for(int i =0;i<allDataList.size();i++) {
			String field = allDataList.get(i).get(0);
			
			if(field.equals("name")) {
				jsonObject.put("name", "userNewName"+randomNum);
			}else if(field.equals("job")) {
				jsonObject.put("job", "job"+randomNum);
			}else if(field.equals("mob")) {
				jsonObject.put("mob", "mobile"+randomNum);
			}
	
		}
		String finalDataString = jsonObject.toString();
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body(finalDataString)
				.post("https://reqres.in/api/users");
		response.then().log().all();
	}
	

	
	@Then("validate status code2 is {string}")
	public void validate_status_code2_is(String statuscode) {
		Assert.assertEquals(statuscode, response.getStatusCode()+"");
		
	}
	
	@Then("validate date2 is {string}")
	public void validate_date2_is(String date) {
		System.out.println("***"+response.body().jsonPath().getString("createdAt"));
		String date1 = response.body().jsonPath().getString("createdAt");
		String newstr = null;
		String arr [] = date1.split("T");
		for (int i =0;i< arr.length;i++) {
			System.out.println("Date is "+ arr[i]);
			 newstr = arr[i];
			break;
		}
		Assert.assertTrue(date.equals(newstr));
	}
	
	@Then("validate id created for user with non null value2")
	public void validate_id_created_for_user_with_non_null_value2() {
		String id = response.body().jsonPath().getString("id");
	    Assert.assertTrue(!id.equals(null) );
	}
	
	@Then("validate id created for user with non zero value2")
	public void validate_id_created_for_user_with_non_zero_value2() {
		int id = response.body().jsonPath().getInt("id");
	    Assert.assertTrue(id > 0 );
	}
	
	
	
}
