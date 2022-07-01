@users
Feature: Verify columns names, after clicking 'Users' module in librarian account

  Scenario: Verify that Table columns names
    Given user is on the login page
    And user login as a librarian
    And user click on "Users" button
    When user should see below headers
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |

