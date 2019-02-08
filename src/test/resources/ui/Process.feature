Feature: Mortgage Calculator Test

  Background: Navigate to calculator page
    Given I am on home page
    And I navigate to Calculator page

  Scenario: UI- Test calculator with valid inputs -1
    Given I am on Calculator page
    When I give payment type as purchase price
    And  I give price amount as 250000
    And  I input downpayment amount as 12500
    And  I input interest rate as 2
    And  I click on calculate button
    Then I should see the result

  Scenario: UI- Test calculator with valid input -2
    Given I am on Calculator page
    When I give payment type as mortgage amount
    And  I give price amount as 500000
    And  I input interest rate as 5
    And  I click on calculate button
    Then I should see the result


  Scenario: UI- Test calculator with invalid input -1
    Given I am on Calculator page
    When I give payment type as purchase price
    And  I give price amount as 250000
    And  I input downpayment amount as 1500
    And  I input interest rate as 2
    And  I click on calculate button
    Then I should not see the result




