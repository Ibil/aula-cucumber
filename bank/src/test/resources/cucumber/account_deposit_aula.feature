Feature: DepositAula
  As a user
  I want to access my bank account
  So that I can store money

  Scenario: Deposit 50 dollars
    Given I have an account
    And my account has a balance of 10 dollars
    When I deposit 50 dollars from the account
    Then the result should be 60 dollars

