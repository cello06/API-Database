Feature: Actor Management Service
  Scenario: Test all actors functionality
    Given the user connect to database
    When the user sent query to database to get actor list
    Then the size of actor list should be 200
