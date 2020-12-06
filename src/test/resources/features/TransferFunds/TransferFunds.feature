@Regression
@TransferFunds

Feature: Transfer Funds

  Background:
    Given User on the Home page
    When User navigates to the "Transfer Funds" page

  Scenario: Transfer Funds page has the correct subtitle and fields one the table. 
  In dropdown From Account default value is "Savings(Avail. balance = $ 1000)"
  In dropdown From Account default value is "Savings(Avail. balance = $ 1000)"

    Then User verifies that "Zero - Transfer Funds" subtitle is displayed
    And User verifies that following fields are displayed
      | From Account     |
      | To Account       |
      | Amount           |
      | Description      |
    Then User verifies that From Account dropdown default option is "Savings(Avail. balance = $ 1000)"
    And User verifies that To Account dropdown default option is "Savings(Avail. balance = $ 1000)"

  @TransferFunds1
    Scenario: Check transfer feature. Transfer money from Brokerage account to Loan
      Then User selects "Brokerage 6" from From Account dropdown
      And User selects "Loan 4" from to Account dropdown
      Then User enters amount "80" to Amount field on Transfer Funds Page
      And User enters "Payment" in Description field on Transfer Funds Page
      When User clicks on Continue button on Transfer Funds Page
      Then User on the confirmation page and "Please verify that the following transaction is correct by selecting the Submit button below." is displayed
      When User clicks Submit button on the Transfer Funds Page
      Then User verifies that confirmation message "You successfully submitted your transaction." is displayed on Transfer Funds Page




