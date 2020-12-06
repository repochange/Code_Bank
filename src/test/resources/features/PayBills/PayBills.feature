@Regression
@PayBillsFeature
Feature: Pay	Bills
  Account	Activity	page	should	have	the	title	Zero	– Pay	Bills.	When	user	completes	a
  successful	Pay	operation,	The	payment	was	successfully	submitted.	should	be
  displayed.	When	user	tries	to	make	a	payment	without	entering	the	amount	or	date,
  Please	fill	out	this	field	message! should	be	displayed.
  Amount	field	should	not	accept	alphabetical	or	special	characters.	Date	field	should
  not	accept	alphabetical	characters.
  NOTE:	.	For	the	date	input	field	you	can	just	use	sendKeys.	No	need	to	click	on	the	date	navigator.


  Scenario: User verifies that subtitle of the page is displayed.
    Given User on the Home page
    When User on the "Pay Bills" page
    Then User verifies that "Zero - Pay Bills" subtitle is displayed


  Scenario: User verifies that confirmation or warning message is displayed after Pay operation is done.
    Given User on the Home page
    When User navigates to the "Pay Bills" page
    And User completes successful Pay operation with following data
      | Apple       |
      | Credit Card |
      | 100         |
      | 2020-07-05  |
      | description |
    Then User verifies that confirmation message "The payment was successfully submitted." is displayed


  Scenario: When user tries	to make	a payment without entering the amount or date warning message should be displayed
    Given User on the Home page
    When User navigates to the "Pay Bills" page
    And User doesn't fill the Amount field and clicks Pay
    Then User verifies that warning message for Amount field "Please fill out this field." is appears


  Scenario: When user tries	to make	a payment without entering the date warning message should be displayed
    Given User on the Home page
    When User navigates to the "Pay Bills" page
    And User doesn't fill the Date field and clicks Pay
    Then User verifies that warning message for Data field "Please fill out this field." is appears


  Scenario:  Amount	field should not accept alphabetical or special characters. Date field should
  not accept alphabetical characters.
    Given User on the Home page
    Then User navigates to the "Pay Bills" page
    And User fills all the fields properly but enters alphabetical or specials characters to the Amount field
    Then User clicks Pay and verifies that warning message for Amount field "Please fill out this field." is appears

  @PayBills1Feature
  Scenario:  Date field should not accept alphabetical characters.
    Given User on the Home page
    Then User navigates to the "Pay Bills" page
    And User fills all the fields properly but enters alphabetical or specials characters to the Date field
    Then User clicks Pay and verifies that warning message for Data field "Please fill out this field." is appears










