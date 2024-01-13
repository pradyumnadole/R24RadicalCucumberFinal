Feature: validate Update request

Scenario: 1.Validate you are able to create data in system
  Given update the data to create user3
	Then validate status code3 is "201"
	Then validate id created for user with non null value3 
	Then validate id created for user with non zero value3
	
	
Scenario: 2.Validate you are able to create data from File
  Given update the data to create from file3 
	Then validate status code3 is "201"
	Then validate id created for user with non null value3
	Then validate id created for user with non zero value3
	
Scenario: 3.Validate you are able to create user from update File with name field
  Given update the data to create user from file with updated name3
	Then validate status code3 is "201"
	Then validate id created for user with non null value3 
	Then validate id created for user with non zero value3
	
Scenario: 4.Validate you are able to create user from update File with name field
  Given update the data to create user from file with updated fields3
  |name|
	Then validate status code3 is "201"
	Then validate id created for user with non null value3 
	Then validate id created for user with non zero value3
	
Scenario: 5.Validate you are able to create user from update File with name field
 Given update the data to create user from file with updated fields3
  |name|
  |job|
  |mob|
	Then validate status code3 is "201"
	Then validate id created for user with non null value3 
	Then validate id created for user with non zero value3
	