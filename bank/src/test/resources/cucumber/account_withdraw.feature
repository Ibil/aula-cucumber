Feature: Withdraw
  As a user
  I want to access my bank account
  So that I can withdraw money

  Scenario Outline: Withdraw 100 dollars
    Given I have an account
    And my account has a balance of <Balance> dollars
    When I withdraw <Withdraw> dollars from the account
    Then the result should be <NewBalance> dollars

    Examples:
  		| Balance | Withdraw | NewBalance |
  		| 1000	  | 100      | 900        |
  		| 1000    | 1000     | 0          |
    	