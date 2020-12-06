@Regression

Feature: Login
  Only	authorized	users	should	be	able	to	login	to	the	application.	When	user	logs in
  with	valid	credentials,	Account	summary	page	should	be	displayed.
  Users	with	wrong	username	or	wrong	password	should	not	be	able	to	login.	Users
  with	blank	username	or	password	should	also	not	be	able	to	login.	When	user	tries
  to	login	with	invalid	information,	error	message	Login	and/or	password	are	wrong.
  should	be	displayed.

  @Smoke
  @LoginWithValidCredentials
  Scenario: Login with valid credentials
    Given User on the login page
    When User logs in with valid credentials
    Then User verifies that "Zero - Account Summary" subtitle is displayed

  @LoginWithInvalidCredentials
  Scenario Outline: Login with invalid credentials "<value>"
    Given User on the login page
    When User enters username "<username>" and password "<password>"
    Then User verifies that warning message "Login and/or password are wrong." is displayed

    Examples:
      | username      | password      | value                         |
      | wrongusername | password      | (wrong username)              |
      | username      | wrongpassword | (wrong password)              |
      | wrongusername | wrongpassword | (wrong username and password) |
      |               | password      | (blank username)              |
      | username      |               | (blank password)              |
      |               |               | (blank username and password) |

