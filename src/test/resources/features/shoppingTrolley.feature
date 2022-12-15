@Trolley
Feature: Shopping trolley
  As a logged user of tesco website
  I want to have a shopping trolley
  So that I can see the products and costs of what I want to purchase

  Rule: It is allowed to add products into the trolley open the trolley, remove products and empty the trolley

    Background:
      Given open the main page
      And accept cookies
      And language is set to "Magyar"
      And login as test user
      And I am on the webshop page

    Scenario: Trolley - Open the shopping trolley
      When I open shopping trolley
      Then I am on the "Kosár" page

    Scenario: Trolley - Empty the shopping trolley
      Given I open shopping trolley
      And I am on the "Kosár" page
      When I remove items from the trolley
      Then I can see that trolley is empty

    Scenario Outline: Trolley - Add a product to trolley
      When I add "<quantity>" of "<product>" to the Trolley
      And I open shopping trolley
      Then the "<product>" is added to my "Kosár"
      Examples:
        | product                                   | quantity
        | Gyermelyi spagetti 4 tojásos száraztészta | 1
        | Sajtos pogácsa 85 g                       | 3

#
#
#    Scenario: Trolley 03 - Modify the quantity of a product in shopping trolley
#      Given I have added 3 of the item of "Sajtos pogácsa 85 g" to my shopping trolley
#      When I click the shopping trolley icon
#      And I am on the "Kosár" page
#      And I can see the product in my shopping trolley
#      And I can decrease the quantity of a product in shopping trolley
#      Then I can see the modified quantity of the product in shopping trolley
#

#
