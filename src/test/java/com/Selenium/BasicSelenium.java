package com.Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasicSelenium {
	WebDriver driver = new ChromeDriver();
	@Given("hit the application")
	public void hit_the_application() {
	
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div/input[@placeholder = 'Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//div/input[@placeholder = 'Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//div/button[@type='submit']")).click();
		System.out.println("Login with admin user");
	}

	@Then("validate login working for application")
	public void validate_login_working_for_application() {
	   System.out.println("validate login working for application");
	   driver.quit();
	   
	}
	

}
