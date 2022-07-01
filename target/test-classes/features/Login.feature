@login
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct
  credentials to different accounts

  Accounts are: librarian and student

  Background: User should be on login page
    Given user is on the login page

  @librarians
  Scenario: Login as librarian
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard

  @students
  Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see the dashboard

