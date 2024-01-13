package com.TagsValidationSD;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/com/TagsValidation/TagsValidateRequest.feature"},
		//if we want to run all feature files keep only path till folder
		glue={"com.TagsValidationSD"},
		//dryRun=false,
		//monochrome=true,
		tags= "@smoke",
		plugin={"pretty",
				"html:target/cucumber-htmlreport.html",
				"json:target/cucumber-report8.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/ExtentReport1.html"
		}
		)


public class RunnerTagsValidation {

}
