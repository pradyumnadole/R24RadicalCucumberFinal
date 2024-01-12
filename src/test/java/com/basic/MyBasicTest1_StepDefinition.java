package com.basic;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyBasicTest1_StepDefinition {
	
	@Given("Login with admin user1")
	public void login_with_admin_user1() {
	    System.out.println("Login with admin user");
	}

	@When("Go to PIM Tab1")
	public void go_to_pim_Tab1() {
		System.out.println("Go to PIM Tab");
	}

	@Then("validate user getting searched1")
	public void validate_user_getting_searched1() {
	   System.out.println("validate user not getting searched");
	   
	}
	
	@Then("validate user not getting searched1")
	public void validate_user_not_getting_searched1() {
	   System.out.println("validate user not getting searched");
	   
	}

}
