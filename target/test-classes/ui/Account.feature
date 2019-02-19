Feature: Account creation feature

  Background: I am on Home page
    Given I am on homepage
    And I click on Accounts tab

  Scenario: Create an Account with mandatory fields
    Given I enter account name as "TestAuto_Accnt"
    And   I select business type as "Manufacturer"
    And   I select customer priority as "High"
    And I select SLA as "Platinum"
    And I enter num of locations as 3
    When I click on save button
    Then New account is created

