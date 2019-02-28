Feature: Test Login feature

  Scenario:UI - Login test with Invalid credentials
  Given I navigate to the Firmex home page
  And I verify home page title
  And I click on login button
  And I verify I am on login page
  When I enter invalid credentials and click login button
  Then I see error message displayed

  Scenario: API - Login test with Invalid credentials.
    Given I create a payload with email "test@gmail.com" password "test"
    And   I send a post request to the url "https://login.firmex.com/authenticate/global"
    Then  I validate the response contains error message "User credentials are invalid."


