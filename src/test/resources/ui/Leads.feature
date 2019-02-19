Feature: Lead creation and conversion

  Background: I am on Home page
    Given I am on homepage
    And I click on Leads tab

  Scenario: Create a new Lead and covert it in to Account,Contact and Opputunities
    Given I enter first name as "Test_fname" and last name as "Test_lname"
    And I give company name as "Test_Auto_Company"
    And I select lead source as "Web"
    And I input campaign field as "HondaTyres"
    And I save to create a new lead
    When I click on covert button to convert the created lead
    And I provide opportuntiy name "TestOp" and subject "Call" details
    And I click on convert button on the lead page
    Then The new LEAD should be converted




