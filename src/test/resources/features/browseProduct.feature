@Browse
Feature: Browsing products
  As a logged user of tesco website
  I need to be able browse products
  To find a product in the results

  Rule: It is allowed to browse products through the product categories

    Background:
      Given open the main page
      And accept cookies
      And language is set to "Magyar"
      And user login

    Scenario: Browse product
      Given I am on the welcome page
      When I click on "Bevásárlás"
      And I click on "Pékáru"
      And I click on "Friss pékáru"
      And I click on "Reggeliző termék"
      Then I should see the product "Sajtos pogácsa" in the browsing list

    Scenario Outline: Browse products with datatable
      Given I am on the welcome page
      When I click on "Bevásárlás"
      And I click on "<group1>"
      And I click on "<group2>"
      And I click on "<group3>"
      Then I should see the "<product>" in the browsing list
      Examples:
        | product                                   | group1                | group2                   | group3
        | Gyermelyi spagetti 4 tojásos száraztészta | Alapvető élelmiszerek | Rizs, tészta, hüvelyesek | Nem durum tészták
        | Sajtos pogácsa 85 g                       | Pékáru                | Friss pékáru             | Reggeliző termék


