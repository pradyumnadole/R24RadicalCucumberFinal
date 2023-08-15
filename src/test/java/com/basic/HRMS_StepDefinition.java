package com.basic;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRMS_StepDefinition {
	
	@Given("Login with admin user")
	public void login_with_admin_user() {
	    System.out.println("Login with admin user");
	}

	@When("Go to PIM Tab")
	public void go_to_pim_Tab() {
		System.out.println("Go to PIM Tab");
	}

	@Then("validate user gettting searched")
	public void validate_user_gettting_searched() {
	   System.out.println("validate user gettting searched");
	   
	}






}
