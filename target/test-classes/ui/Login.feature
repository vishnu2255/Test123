Feature: Test Login feature

Scenario: Login test with valid credentials
  Given I navigate to the url
  When I enter valid credentials
  Then I see home page

Scenario: Login test with Invalid credentials
  Given I navigate to the url
  When I enter invalid credentials
  Then I see error message



