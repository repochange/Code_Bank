@Regression
@AccountActivityFeature
Feature: Account Activity

  Account	Activity	page	should	have	the	title	Zero	– Account	activity.
  In	the	Account	drop	down	default	option	should	be	Savings.	Account	drop	down
  should	have	the	following	options:	Savings,	Checking,	Loan,	Credit	Card,	Brokerage.
  Transactions	table	should	have	column	names	Date,	Description,	Deposit,
  Withdrawal.

  Background:
    Given User on the Home page

    @Smoke
  Scenario: Account	Activity page should have correct subtitle and dropdown options/features.
    Given User on the "Account Activity" page
    Then User verifies that "Zero - Account Activity" subtitle is displayed
    And User verifies that Account dropdown default option is"Savings"
    And User verifies that Account dropdown has following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |
      | Savings     |
    And User verifies that Show Transactions table has next columns
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
