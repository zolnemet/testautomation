@Search
Feature: Searching products
  As a logged user of tesco website
  I need to be able search products
  To find a product in the results

  Rule: xc

    Background:
      Given open the main page
      And accept cookies
      And the language is set to "hungarian"
      And user logged in

    Scenario Outline: Search product
      Given I am on the welcome page
      When I fill in "Keresés" with "<product>"
      And I click on the search button
      Then I should see the <product> in results
      Examples:
        | product                                   |
        | Gyermelyi spagetti 4 tojásos száraztészta |
        | Sajtos pogácsa 85 g                       |

    Scenario: Search invalid product
      Given I am on the welcome page
      When I fill in "Keresés" with "xyz"
      And I click on the search button
      Then I should not see any product in results