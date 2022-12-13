@Logout
Feature: logout
  As a user
  I need to be able to logout

  Rule: It is allowed to logout from web-shop

    Background:
      Given open the main page
      And accept cookies
      And the language is set to "hungarian"
      And user logged in

    Scenario: Logout successful
      Given I am logged in
      When I sign out
      Then No "Trolley" icon accessible