@Details
Feature: Product details
  As a logged user of tesco website
  find a product in showing products and open details of it
  To check the description and the add button

  Rule: It is allowed to open product details page and check product description

    Background:
      Given open the main page
      And accept cookies
      And language is set to "Magyar"
      And login as test user
      And I am on the webshop page

    Scenario Outline: Product - Open product details
      Given I search for a product with "<product>"
      When I open "<product>" detail
      And I am on the product page
      Then I can see the "<product>" on the product details page
      Examples:
        | product             |
        | Sajtos pogácsa 85 g |

    Scenario Outline: Product - Check product description
      Given I search for a product with "<product>"
      When I open "<product>" detail
      Then I can see the "<product>" on the product details page
      And I can see the "<ingredients>" of the product
      Examples:
        | product             | ingredients
        | Sajtos pogácsa 85 g | Búzaliszt BL 55, Ivóvíz, Leveles margarin [pálmazsír, ivóvíz, étkezési só