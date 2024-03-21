Feature: Operations with user information
   Background:
     Given the user is in correct URI
     And the authentication has been made for accessing api

     Scenario: The user wants to see list of all users
       When the user sends request to get list of all users
       Then the status code should be 200
       And the user should see list of all users

      Scenario: The user wants to access a specific user
        When the user sends request to get a specific jira user
        Then the status code should be 200
        And the user should see the jira user that has been requested
        And the information of user must be as expected