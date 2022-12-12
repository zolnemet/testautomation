@Details
Feature: Product details
  As a logged user of tesco website
  find a product in showing products and open details of it
  To check the description and the add button

  Background:
    Given open main page
    And accept cookies
    And language is set to "hungarian"
    And user login
    And product search

  Scenario Outline: Product details 01 - Open product details
    Given I am logged in
    And I can see the "<product>" in results
    When I click on "<product>" picture
    Then I can see the picture of <product> on the product details page
    Examples:
      | product               |
      | Sajtos pogácsa 85 g   |

  Scenario Outline: Product details 02 - Check product description
    Given I am logged in
    And I can see the "<product>" in results
    When I click on "<product>" picture
    Then I can see the <product> on the product details page
    And I can see the <ingredients> of the product
    Examples:
      | product               | ingredients
      | Sajtos pogácsa 85 g   | Búzaliszt BL 55, Ivóvíz, Leveles margarin [pálmazsír, ivóvíz, étkezési só