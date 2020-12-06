@Regression
  @PurchaseForeignCurrency
Feature: Purchase Foreign Currency

  Background:
    Given User on the Home page
    Then User navigates to the "Pay Bills" page
    Given User clicks on the "Purchase Foreign Currency" tab


  Scenario: Available currencies

    Then following currencies should be available
      |Australia (dollar) |
      |Canada (dollar) |
      |Switzerland (franc) |
      |China (yuan) |
      |Denmark (krone) |
      |Eurozone (euro) |
      |Great Britain (pound)|
      |Japan (yen) |
      |Mexico (peso) |
      |Norway (krone) |
      |New Zealand (dollar) |
      |Singapore (dollar) |



  Scenario: Error message for not selecting currency
    When User tries to calculate cost without selecting a currency
    Then error message should be displayed

  @PurchaseForeignCurrency1
  Scenario: Error message for not entering value
    When User tries to calculate cost without entering a value
    Then error message should be displayed
