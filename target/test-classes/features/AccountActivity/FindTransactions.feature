@Regression
@FindTransactionsFeature

Feature: Find Transactions in Account Activity

  Background:
    Given User on the Home page
    Then User navigates to the "Account Activity" page


  Scenario: Search date range
    And User clicks on the "Find Transactions" tab
    When User enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When User refresh the page
    And User clicks on the "Find Transactions" tab
    When User enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"


  Scenario: Search description
    Given User clicks on the "Find Transactions" tab
    When User enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When User refresh the page
    And User clicks on the "Find Transactions" tab
    Then User enters description "OFFICE"
    And clicks search
    Then results table should only show descriptions containing "OFFICE"


  Scenario: Search description case insensitive
    Given User clicks on the "Find Transactions" tab
    When User enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When User refresh the page
    And User clicks on the "Find Transactions" tab
    Then User enters description "online"
    And clicks search
    Then results table should display "No results."


  Scenario: Type
    Given User clicks on the "Find Transactions" tab
    And clicks search
    Then results table should show at least one result under Deposit
    Then results table should show at least one result under Withdrawal
    When user selects type "Deposit"
    And clicks search
    Then results table should show at least one result under Deposit
    But results table should show no result under Withdrawal
    When user selects type "Withdrawal"
    And clicks search
    Then results table should show at least one result under Withdrawal
    But results table should show no result under Deposit
