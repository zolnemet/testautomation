@Trolley
Feature: Shopping trolley
  As a logged user of tesco website
  I want to have a shopping trolley
  So that I can see the products and costs of what I want to purchase

  Rule: It is allowed to add products into the trolley open the trolley, remove products and empty the trolley

    Background:
      Given open the main page
      And accept cookies
      And the language is set to "hungarian"
      And user logged in

    Scenario Outline: Trolley 01 - Add a product to trolley
      Given I open the "<product>" deatil page
      And I am on a product detail page of the "<product>"
      When I set quantity to "<quantity>"
      And I click the "Hozzáad" button
      Then the product is added to my shopping trolley
      Examples:
        | product                                   | quantity
        | Gyermelyi spagetti 4 tojásos száraztészta | 1
        | Sajtos pogácsa 85 g                       | 3

    Scenario: Trolley 02 - Open the shopping trolley
      Given I have added an item of "Gyermelyi spagetti 4 tojásos száraztészta" to my shopping trolley
      When I click the shopping trolley icon
      Then I land on the "Kosár" page
      And I can see the product in my shopping trolley

    Scenario: Trolley 03 - Modify the quantity of a product in shopping trolley
      Given I have added 3 of the item of "Sajtos pogácsa 85 g" to my shopping trolley
      When I click the shopping trolley icon
      And I am on the "Kosár" page
      And I can see the product in my shopping trolley
      And I can decrease the quantity of a product in shopping trolley
      Then I can see the modified quantity of the product in shopping trolley

    Scenario: Trolley 04 - Empty trolley
      Given I have added any items to my shopping trolley
      When I click the "Kosár ürítése" button
      And I click on "Törlés" button in popup window
      Then I can see that "trolley is empty" or "A kosarad jelenleg üres"

