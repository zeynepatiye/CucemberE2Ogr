Feature: NewsLetter Functionality

  @SmokeTest
  Scenario: Subcribe to NewsLetter

    Given Navigate to WebSite
    When Enter username and password and click login button
    Then User should login successfully
    And enter 10 character of message
    When Click to submit
    Then Success message should be asserted