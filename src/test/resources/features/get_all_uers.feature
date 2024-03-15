Feature: Get all users

  Background:
    Given the user is on the base uri
    And the authentication is completed to reach jira api

    Scenario: Test get all users method functionality
      When the user send request to jira api to get all users
      Then the status code should be 200
      And the user list should not be empty or null
      And the user list must be the same as the list in database

