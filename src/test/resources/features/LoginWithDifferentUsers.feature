@scenarioOutline
Feature: Login functionality with different user' accounts

  Scenario Outline: Verify user information
    Given user is on the login page
    When user enters "<email>" username and "<password>" password
    Then account holder name should be "<name>"

    @students
    Examples:
      | email             | password | name            |
      | student27@library | E1uZrsAu | Test Student 27 |
      | student28@library | tJ93UQS3 | Test Student 28 |
      | student29@library | g8EyNm9B | Test Student 29 |
      | student30@library | QX6FWzj6 | Test Student 30 |
      | student31@library | yEKjyg5T | Test Student 31 |
      | student32@library | RqJkWmUu | Test Student 32 |
      | student33@library | 4V3Kd1YG | Test Student 33 |
      | student34@library | JySGHP8G | Test Student 34 |
      | student35@library | r2oOkz9m | Test Student 35 |
      | student36@library | WV2WrNrk | Test Student 36 |
      | student37@library | sqs9B1TY | Test Student 37 |
      | student38@library | nca2fAGL | Test Student 38 |
      | student39@library | kCrQEt6X | Test Student 39 |
      | student40@library | ZkFJCgOd | Test Student 40 |

    @librarians
    Examples:
      | email               | password | name              |
      | librarian13@library | YCJCbmU3 | Test Librarian 13 |
      | librarian14@library | bWN7YaaB | Test Librarian 14 |
      | librarian15@library | YLu0ZIMj | Test Librarian 15 |
      | librarian16@library | MnG7Xy72 | Test Librarian 16 |
      | librarian17@library | adE5UAha | Test Librarian 17 |
      | librarian18@library | FZLa1m9D | Test Librarian 18 |
      | librarian19@library | f7q2SyVX | Test Librarian 19 |
      | librarian20@library | MVI4SRzg | Test Librarian 20 |
      | librarian21@library | ZxlVsgKX | Test Librarian 21 |
      | librarian22@library | JUXl6dnx | Test Librarian 22 |
