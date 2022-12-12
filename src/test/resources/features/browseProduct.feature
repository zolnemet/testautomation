@Browse
Feature: Browsing products
  As a logged user of tesco website
  I need to be able browse products
  To find a product in the results

  Background:
    Given open main page
    And accept cookies
    And language is set to "hungarian"
    And user login

  Scenario: Browse Sajtos pogácsa
    Given I am logged in
    And I am on the welcome page
    When I click on "Bevásárlás"
    And I click on "Pékáru"
    And I click on "Friss pékáru"
    And I click on "Reggeliző termék"
    Then I should see the product in the browsing list

  Scenario Outline: Browse products
    Given I am logged in
    And I am on the welcome page
    When I click on "Bevásárlás"
    And I click on "<group1>"
    And I click on "<group2>"
    And I click on "<group3>"
    Then I should see the "<product>" in the browsing list
    Examples:
      | product                                     | group1                | group2                    | group3
      | Gyermelyi spagetti 4 tojásos száraztészta   | Alapvető élelmiszerek | Rizs, tészta, hüvelyesek  | Nem durum tészták
      | Sajtos pogácsa 85 g                         | Pékáru                | Friss pékáru              | Reggeliző termék


