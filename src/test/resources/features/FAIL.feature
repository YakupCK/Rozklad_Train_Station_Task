@wip
Feature: Failing Scenarios

  Background:
    Given The user is on the homepage

  Scenario: Verify that the displayed time is GMT+1 time zone
    When The user check the 'Enter The Time' section
    Then The time is displayed in "GMT+1" time zone

  Scenario: Verify that user can not select a previous date
    When The user tries to select a previous date
    Then The user is not allowed to select a previous date

  Scenario: Verify that displayed language is English
    And The user select "POZNAŃ-" as a departure
    And The user select "WARSZAWA-" as a destination
    And The user search for trains
    And The user goes back to previous page
    When The user click on the FROM field
    Then THe user should see "Recently searched:" in English
