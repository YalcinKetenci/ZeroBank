@accountSummary
Feature: Account Summary

  Background:
    Given the user on the login page
    When the user enter valid username and password

  Scenario: Page Title
    Then page should have the title "Zero – Account summary"

  Scenario: Account Types
    Then Account summary page should have to following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Columns
    Then Credit Accounts table must have columns Account, Credit Card and Balance.
      | Account     |
      | Credit Card |
      | Balance     |