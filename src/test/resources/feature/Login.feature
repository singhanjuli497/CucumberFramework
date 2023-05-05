@login
Feature: Login feature
  Scenario Outline: User is able to login with valid credentials
    Given I am on login page
    When I enter Username as "<Username>" and password as "<password>"
    And I click on login button
    Then I should be navigate to home page

    Examples:
      | Username                 | password   |
      | singhanjuli497@gmail.com | 1234       |


  Scenario: User is not able to login with valid credentials
    Given I am on login page
    When I enter Username as "singhanjul97@gmail.com" and password as "1234"
    And I click on login button
    Then I should get error message "Invalid login"
