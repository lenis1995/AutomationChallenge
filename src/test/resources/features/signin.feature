#Author: Alejandro Lenis R

Feature: User Sign Up
  As a Web User
  I want to Sign Up in UTest Platform
  to learn more about testing

  Scenario: UTest Sign Up
    Given that I get to UTest Page
    And   access to Sign In form
    When  I complete the first step
    And   I complete the second step
    And   I complete the third step
    And   I complete the last step
    Then  I should see the welcome message

