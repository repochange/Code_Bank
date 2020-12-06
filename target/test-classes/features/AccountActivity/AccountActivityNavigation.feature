@Regression
  @AccountActivityNavigationFeature
Feature:    Navigating	to	specific	accounts	in	Accounts	Activity

  Scenario Outline:"<following>" account redirect
    Given User on the Home page
    When User clicks on "<following>" link on the Account Summary page
    Then The "Account Activity" page should be displayed
    And Account	dropdown should	have "<following>" selected

    Examples:
      | following   |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |


