
Feature: This file contains test scenarios of add employee

Scenario: 1.Validate New employee getting created and searched in HRMS System
	Given Login with admin user
	When Go to PIM Tab
	When hit Add Employee section
	When enter user details
	When hit save button
	When search the user 
	Then validate user gettting searched


Scenario: 2. Validate employee not getting created if mandatory fields missing
	Then Login with admin user
	When Go to PIM Tab
	When hit Add Employee section
	When don’t enter all mandatory user details
	When hit save button
	When search the user 
	Given validate user gettting searched