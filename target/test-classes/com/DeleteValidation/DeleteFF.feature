Feature: validate post request

#Scenario: 1.Validate you are able to create data in system1
  #Given post the data to create user1
#	Then validate status code1 is "201"
#	Then validate id created for user with non null value1 
#	Then validate id created for user with non zero value1
#	
#	
#Scenario: 2.Validate you are able to create data from File1
  #Given post the data to create from file1 
#	Then validate status code1 is "201"
#	Then validate id created for user with non null value1 
#	Then validate id created for user with non zero value1
#	
#Scenario: 3.Validate you are able to create user from update File with name field1
  #Given post the data to create user from file with updated name1
#	Then validate status code1 is "201"
#	Then validate id created for user with non null value1 
#	Then validate id created for user with non zero value1
#	
#Scenario: 4.Validate you are able to create user from update File with name field1
  #Given post the data to create user from file with updated fields1
  #|name|
#	Then validate status code1 is "201"
#	Then validate id created for user with non null value1 
#	Then validate id created for user with non zero value1
#	
#Scenario: 5.Validate you are able to create user from update File with name field1
 #Given post the data to create user from file with updated fields1
  #|name|
  #|job|
  #|mob|
#	Then validate status code1 is "201"
#	Then validate id created for user with non null value1 
#	Then validate id created for user with non zero value1
	
Scenario: 6.Validate you are able to delete user
 Given post the data to create user from file with updated fields1
  |name|
  |job|
  |mob|
	Then validate status code1 is "201"
	Then validate id created for user with non null value1 
	Then validate id created for user with non zero value1
	When delete user from system
	Then validate user deleted from system
	