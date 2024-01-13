Feature: Validate Get RequestDataTable

Scenario: 1.Validate Demo QA up and running
	Given hit the URI1
	Then validate title "Git Pocket Guide" and pages "234" of application
	
Scenario: 2.Validate Demo QA up and running
   Given hit the URI1
   Then validate value for "books[0].title" is "Git Pocket Guide"
   Then validate value for "books[0].pages" is "234" 
   Then validate value for "books[0].author" is "Richard E. Silverman" 
   Then validate value for "books[0].publisher" is "O'Reilly Media" 
   Then validate value for "books[1].title" is "Learning JavaScript Design Patterns"
   
   Scenario: 2.Validate Demo QA up and running
   Given hit the URI1
   Then validate value for below data
		|books[0].title    |Git Pocket Guide                   |
		|books[0].pages    |234                                |
		|books[0].author   |Richard E. Silverman               |
		|books[0].publisher|O'Reilly Media 			               |
		|books[1].title    |111Learning JavaScript Design Patterns|