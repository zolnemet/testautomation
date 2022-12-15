@Search
Feature: Searching products
  As a logged user of tesco website
  I need to be able search products
  To find a product in the results

  Rule: It is allowed to search products

    Background:
      Given open the main page
      And accept cookies
      And language is set to "Magyar"
      And login as test user

    Scenario: Search product
      Given I am on the webshop page
      When I search for a product with "Dreher Bitter Lager"
      Then I can see the "Dreher Bitter Lager" in results

    @DataTable
    Scenario Outline: Search product
      Given I am on the webshop page
      When I search for a product with "<product>"
      Then I can see the "<product>" in results
      Examples:
        | product                                   |
        | Gyermelyi spagetti 4 tojásos száraztészta |
        | Sajtos pogácsa 85 g                       |
        | fehér bor                                 |

#    Scenario: Search invalid product
#      Given I am on the products page
#      When I search product for "xyz"
#      Then I should not see any product in results