@Logout
Feature: logout
  As a user
  I need to be able to logout

  Background:
    Given open main page
    And accept cookies
    And language is set to "hungarian"
    And user login

  Scenario: Logout successful
    Given I am logged in
    When I sign out
    Then No "Trolley" icon accessible