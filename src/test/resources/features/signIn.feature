@Login
Feature: login
  As a user
  I need to be able to log in
  To access my trolley

  Rule: It is allowed to login in web-shop and reach a shopping trolley

  Background:
    Given open the main page
    And accept cookies
    And the language is set to "hungarian"
    And login page opened

  Scenario: Login failed
    Given I am on the login page
    When I fill in "e-mail" with "test"
    And I fill in "password" with "test"
    And I click on the "Login" button
    Then I should see the "Error" message on the login page

  Scenario: Login successful
    Given I am on the login page
    When I fill in "e-mail" with "test"
    And I fill in "password" with "test"
    And I click on the "Login" button
    Then I am on the welcome page
    And I should see the "Trolley" icon