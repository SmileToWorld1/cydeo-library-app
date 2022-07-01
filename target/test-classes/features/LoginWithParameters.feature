@parameterization
Feature: Library app login feature with parameterization
  User Story:
  As a user, I should be able to login with correct
  credentials to different accounts

  Accounts are: librarian and student

  Background: User should be on login page
    Given user is on the login page

  Scenario: Login as librarian with parameterization
    When user enters librarian "librarian2@library"
    And user enters librarian "uYrhHmmj"
    Then user should see the dashboard

  Scenario: Login as student with parameterization
    When user enters student "student2@library"
    And user enters student "zyxa10vg"
    Then user should see the dashboard

  Scenario: Login as librarian in the same line
    When user enters librarian username "librarian1@library" and user enters librarian password "qU9mrvur"
    Then user should see the dashboard
    And there should be 47 'Borrowed Books'