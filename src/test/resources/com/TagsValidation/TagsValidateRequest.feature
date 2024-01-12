
Feature: validate post request with tags

@smoke
Scenario: 1.Validate you are able to create data in system
  Given post the data to create user2 
	Then validate status code2 is "201"
	Then validate id created for user with non null value2 
	Then validate id created for user with non zero value2
	
@smoke
Scenario: 2.Validate you are able to create data from File
  Given post the data to create from file2 
	Then validate status code2 is "201"
	Then validate id created for user with non null value2 
	Then validate id created for user with non zero value2
	
Scenario: 3.Validate you are able to create user from update File with name field
  Given post the data to create user from file with updated name2
	Then validate status code2 is "201"
	Then validate id created for user with non null value2
	Then validate id created for user with non zero value2
	
Scenario: 4.Validate you are able to create user from update File with name field
  Given post the data to create user from file with updated fields2
  |name|
	Then validate status code2 is "201"
	Then validate id created for user with non null value2 
	Then validate id created for user with non zero value2
	
Scenario: 5.Validate you are able to create user from update File with name field
 Given post the data to create user from file with updated fields2
  |name|
  |job|
  |mob|
	Then validate status code2 is "201"
	Then validate id created for user with non null value2
	Then validate id created for user with non zero value2
	
Scenario: 6.Validate you are able to create user from update File with name field
 Given post the data to create user from file with updated fields2
  |date|
	Then validate date2 is "2023-08-18"
	Then validate id created for user with non null value2
	Then validate id created for user with non zero value2
	