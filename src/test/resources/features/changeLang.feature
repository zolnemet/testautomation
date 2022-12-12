@Lang
Feature: change language
  As a user
  I need to be able change language

  Rule: It is allowed to change the language

    Background:
      Given open main page
      And accept cookies

    Scenario: Change the language to hungarian
      Given language is set to "english"
      When change the language to "hungarian"
      Then it shows elements in "hungarian"

    Scenario: Change the language to english
      Given language is set to "hungarian"
      When change the language to "english"
      Then it shows elements in "english"

    @DataTable
    Scenario: Change language with datatable
      Given language is set to "hungarian"
      When change the language to "english"
      Then it shows elements in "english" with
        | language  | login_button_name |
        | hungarian | Bejelentkezés     |
        | english   | Sign in           |