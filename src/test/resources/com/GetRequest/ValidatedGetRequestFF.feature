Feature: Validate Get Request

Scenario: 1.Validate Demo QA up and running
	Given hit the URI111
	Then validate title "Git Pocket Guide" and pages "234" of application1
	
#Scenario: 2.Validate Demo QA up and running
  #  Given hit the URI1
   # Then validate value for "books[0].title" is "Git Pocket Guide"
    #Then validate value for "books[0].pages" is "234" 
    #Then validate value for "books[0].author" is "Richard E. Silverman" 
    #Then validate value for "books[0].publisher" is "O'Reilly Media" 
    #Then validate value for "books[1].title" is "Learning JavaScript Design Patterns"

Scenario: 3.Validate Demo QA up and running3
    Given hit the URI111
    Then validate value for attribute "title" is "Git Pocket Guide" present in response11
    Then validate value for attribute "author" is "Axel Rauschmayer" present in response11