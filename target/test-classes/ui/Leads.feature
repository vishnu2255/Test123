Feature: Lead creation and covertion

  Background: I am on Home page
#    Given I am on homepage
    And I click on Leads tab

  Scenario: Create a new Lead and covert it in to Account,Contact and Opputunities
    Given I enter first name as "test_lead" and last name as "lname"
    And I give company name as "Test_Auto_Company"
    And I select lead surce as ""
    And I input campign field as ""
    And I save to create a new lead
    When I click to convert the created lead
    And I provide opporuntiy name and subject details
    And I click on convert button on the lead page
    Then The new LEAD should be converted




