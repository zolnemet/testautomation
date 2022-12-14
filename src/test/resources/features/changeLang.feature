@Lang
Feature: change language
  As a user
  I need to be able change language

  Rule: It is allowed to change the language

    Background:
      Given open the main page
      And accept cookies

    @DataTable
    Scenario Outline: Change language with datatable
      Given language is set to "<languageFrom>"
      When change the language to "<languageTo>"
      Then it shows elements in "<languageTo>"
      Examples:
        | languageFrom | languageTo |
        | Magyar       | English    |
        | English      | Magyar     |

#    Scenario: Change the language to english
#      Given language is set to "Magyar"
#      When change the language to "English"
#      Then it shows elements in "English"
#
#    Scenario: Change the language to hungarian
#      Given language is set to "English"
#      When change the language to "Magyar"
#      Then it shows elements in "Magyar"

