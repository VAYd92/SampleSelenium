Feature: Login to the application

  Scenario: Successful login
    Given I am on the login page
    When I enter valid username and password
    And I click on the login button
    Then I should be logged in successfully