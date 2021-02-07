@payBills
Feature: Pay Bills
    
    Background: 
      Given the user on the login page
      When the user enter valid username and password
      And the user click "Pay Bills" module
      
  Scenario: Page Title
    Then page should have the title "Zero - Pay Bills"

  Scenario: Pay Operation
    And the user select the "Bank Of America" as a payee
    And the user select the "Credit Card" as a account
    And the user enter "123" as a amount
    And the user click the date text box
    And the user choose "3" as a date
    And the user enter "debt" as a description
    And the user click pay button
    Then The payment was successfully submitted should be displayed

  Scenario:  Payment Without Amount or Date
    And the user select the "Bank Of America" as a payee
    And the user select the "Credit Card" as a account
    And the user click the date text box
    And the user choose "3" as a date
    And the user enter "debt" as a description
    And the user click pay button
    Then Please fill out this field message! should be displayed


