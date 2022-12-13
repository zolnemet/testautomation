@Login
Feature: login
  As a user
  I need to be able to log in
  To access my trolley

  Rule: It is allowed to login in web-shop and reach a shopping trolley

    Background:
      Given open the main page
      And accept cookies
      And language is set to "Magyar"

    Scenario: Login successful
      Given I am on the login page
      When I login account with "zoltan.n@freemail.hu" and "teszt.01"
      Then I am on the products page
      And I should see the Trolley icon

#    Scenario: Login failed
#      Given I am on the login page
#      When I login invalid account with "zoltan.n@freemail.hu" and "teszt.00"
#      Then I should see the error message on the login page