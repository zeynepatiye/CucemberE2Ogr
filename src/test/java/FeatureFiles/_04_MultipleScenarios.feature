Feature: Multi Scenario
  Background:
    Given Navigate to WebSite
    When Enter username and password and click login button
    Then User should login successfully

    @Regression
  Scenario: Subcribe to NewsLetter


    And enter 10 character of message
    When Click to submit
    Then Success message should be asserted

  Scenario: Subcribe to NewsLetter


    And enter 10 character of message
    When Click to submit
    Then Success message should be asserted