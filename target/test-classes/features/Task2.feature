Feature: Testing employee data base

  @debug
  Scenario Outline: Adding a new person

    Given Go to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
    And I press Add person button
    And I enter "<name>" in the name field
    And I enter "<job>" in the Job field
    And I press the Add button
    Then I check that "<name>" is here
    And with job "<job>"

    Examples:
      | name  | job          |
      | Bob   | Truck Driver |
      | Amy   | Pilot        |
      | Frank | Manager      |

  Scenario: Editing a person
    Given Go to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
    And I press edit person button
    And I enter "Mickey" in the name field
    And I enter "Blogger" in the Job field
    And I press the Edit button
    Then I check that "Mickey" is here
    And with job "Blogger"

  Scenario: Remove a person
    Given Go to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
    And I press remove person button
    And Check that now there is "2" persons left


  Scenario: Checking reset after adding a person

    Given Go to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
  # Adding someone
    And I press Add person button
    And I enter "Dan" in the name field
    And I enter "Cactus Inspector" in the Job field
    And I press the Add button
    Then I check that "Dan" is here
    And with job "Cactus Inspector"
  # Resetting
    And I press the Reset List button
  # Checking the employee list is reset
    Then I check that "Mike" is here
    And with job "Web Designer"
    And I check that "Jill" is here
    And with job "Support"
    And I check that "Jane" is here
    And with job "Accountant"

  Scenario: Checking reset after editing a person

    Given Go to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
  # Editing someone
    And I press edit person button
    And I enter "Mickey" in the name field
    And I enter "Blogger" in the Job field
    And I press the Edit button
    Then I check that "Mickey" is here
    And with job "Blogger"
  # Resetting
    And I press the Reset List button
  # Checking the employee list is reset
    Then I check that "Mike" is here
    And with job "Web Designer"
    And I check that "Jill" is here
    And with job "Support"
    And I check that "Jane" is here
    And with job "Accountant"

  Scenario: Checking reset after removing a person
  # Removing someone
    Given Go to url "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html"
    And I press remove person button
    And Check that now there is "2" persons left
  # Resetting
    And I press the Reset List button
  # Checking the employee list is reset
    Then I check that "Mike" is here
    And with job "Web Designer"
    And I check that "Jill" is here
    And with job "Support"
    And I check that "Jane" is here
    And with job "Accountant"
