@Regression
@AccountSummaryFeature
Feature: Account summary
  Account	summary	page	should	have	the	title	Zero	– Account	summary.	Account
  summary	page	should	have	to	following	account	types:	Cash	Accounts,	Investment
  Accounts,	Credit	Accounts,	Loan	Accounts.	Credit	Accounts table	must	have	columns
  Account,	Credit	Card and	Balance.

  @Smoke
  Scenario: Account Summary page has the correct subtitle and columns in table
    Given User on the Account Summary page
    Then User verifies that "Zero - Account Summary" subtitle is displayed
    And User verifies that the page has next account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And User verifies that Credit account table has next columns
      | Account     |
      | Credit Card |
      | Balance     |
