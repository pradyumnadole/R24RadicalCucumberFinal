Feature: Validate Demo QA application Data

Scenario: 1.Validate Demo QA up and running
	Given hit the URI11
	Then validate the response "200" of application
	
Scenario: 2.Validate Demo QA up and running
	Given hit the URI11
	Then validate the response "400" of application
	
Scenario: 3.Validate Demo QA up and running
	Given hit the URI11
	Then validate the response "500" of application