@accountActivity @allTests
Feature: Account Activity

  Background:
    Given the user on the login page
    When the user enter valid username and password
    And the user click "Account Activity" module

  Scenario: Page Title
    Then page should have the title "Zero - Account Activity"

  Scenario: Default option
    Then In the Account drop down default option should be "Savings"

  Scenario: Account DropDown Options
    Then Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions Table Column Names
    Then Transactions table should have column names Date, Description, Deposit, Withdrawal
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |


