Feature: facebook

Background:
    User navigates to FB page
    Given Im on Facebook Page

Scenario:
    When I enter username 'Adam'
    And I enter password 'Adam'
    And I click on Login
    Then Login failed

Scenario:
    When I enter username '....'
    And I enter password '...'
    And I click on Login
    Then Login is succesfull

