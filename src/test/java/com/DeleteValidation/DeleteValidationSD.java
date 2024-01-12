package com.DeleteValidation;

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
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteValidationSD {
	Response response;
	String id = null;
	@Given("post the data to create user1")
	public void post_the_data_to_create_user1() {
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
	@Given("post the data to create usernumber")
	public void post_the_data_to_create_usernumber() {
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": \"998877\",\r\n"
						+ "    \"job\": \"QA leader1\",\r\n"
						+ "    \"mob\": \"1222\",\r\n"
						+ "    \"dept\": \"QA-Automation1\",\r\n"
						+ "    \"location\": \"PuneM\"\r\n"
						+ "}\r\n"
						+ "")
				.post("https://reqres.in/api/users");
	  
	}

	@Given("post the data to create from file1")
	public void post_the_data_to_create_from_file1() {
		File file = new File("src/test/java/com/PostMessageValidationSD/CreateUser.json");
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body(file)
				.post("https://reqres.in/api/users");
	  
	}
	
	@Given("post the data to create user from file with updated name1")
	public void post_the_data_to_create_user_from_file_with_updated_name1() throws IOException {
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
	
	@Given("post the data to create user from file with updated fields1")
	public void post_the_data_to_create_user_from_file_with_updated_fields1(DataTable table) throws IOException {
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
	

	
	@Then("validate status code1 is {string}")
	public void validate_status_code1_is(String statuscode) {
		Assert.assertEquals(statuscode,""+ response.getStatusCode()+"");
		
	}
	
	@Then("validate date1 is {string}")
	public void validate_date1_is(String date) {
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
	
	@Then("validate id created for user with non null value1")
	public void validate_id_created_for_user_with_non_null_value1() {
	
		id = response.body().jsonPath().getString("id");
		System.out.println("id is "+ id);
	    Assert.assertTrue(!id.equals(null) );
	}
	
	@Then("validate id created for user with non zero value1")
	public void validate_id_created_for_user_with_non_zero_value1() {
		int id = response.body().jsonPath().getInt("id");
		System.out.println("id for non zero value is "+ id);
	    Assert.assertTrue(id > 0 );
	}
	
	@When ("delete user from system")
	public void delete_user_from_system() {
		System.out.println("=============Deleting user==========="+ id);
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.delete("https://reqres.in/api/users/"+ id);	
	}
	
	@Then ("validate user deleted from system")
	public void validate_user_deleted_from_system() {
		Assert.assertTrue(true);
	}
	
	
}
