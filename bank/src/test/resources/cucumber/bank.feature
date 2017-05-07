Feature: Calculator
  As a user
  I want to use a bank account
  So that I deposit money

  Scenario: Deposit 200 dollars
    Given I have an account
    When I deposit 200 dollars in an empty account
    Then the result should be 200
