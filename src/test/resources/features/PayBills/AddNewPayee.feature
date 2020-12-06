@Regression
@AddNewPayee


@AddNewPayee1
Feature: Add new payee under pay bills
  
  Background: 
    Given User on the Home page
    Then User navigates to the "Pay Bills" page
    
  Scenario: Add a new payee
    Given User clicks on the "Add New Payee" tab
    And creates new payee using following information
      |Payee Name | The Law Offices of Hyde, Price & Scharks|
      |Payee Address | 100 Same st, Anytown, USA, 10001 |
      |Account | Checking |
      |Payee details | XYZ account |
    And Click Add
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed
