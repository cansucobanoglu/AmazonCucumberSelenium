@tag
Feature: Login Action


@tag1
  Scenario: Successfully login with valid username and password
    Given i am a user of amazon.com
    When i log in using valid credentials
    Then i should be logged in

@tag2
  Scenario: Unsuccessful login with invalid username and password
    Given i am a user of amazon.com
    When  i log in using invalid credentials
    Then i should not be logged in