Feature: facebook

Background:
    User navigates to FB page
    Given Im on Facebook Page

Scenario:
    When I enter username 'Adam'
    And I enter password 'Adam'
    And Click on Login
    Then Login failed

