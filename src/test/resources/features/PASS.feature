@wip
Feature: Passing Scenarios

  Background:
    Given The user is on the homepage

  Scenario: Veify that user can select valid stations
    When The user select "POZNAŃ-" as a departure
    And The user select "WARSZAWA-" as a destination
    And The user search for trains
    Then The user can find available trains

  Scenario: Verify that user can not proceed without a destination
    When The user select "POZNAŃ-" as a departure
    But The user does not select anything as a destination
    And The user search for trains
    Then The user can not proceed
    And A warning message should be displayed

  Scenario: Verify that user can not proceed without a departure
    When The user select "POZNAŃ-" as a destination
    But The user does not select anything as a departure
    And The user search for trains
    Then The user can not proceed
    And A warning message should be displayed