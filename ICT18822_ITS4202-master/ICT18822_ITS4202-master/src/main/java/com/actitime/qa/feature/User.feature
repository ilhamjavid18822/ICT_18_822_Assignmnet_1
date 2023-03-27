
@tag
Feature: Admin Create New User

  @tag1
  Scenario: admin should be able create new user
    Given admin navigated to Actitime Loging Page
    When admin enter credentials and I click on Loging button
    And admin can be able to successfuly loging to Actitime
    When admin click on the Users section
    Then admin should be able to successfuly switch Users Section
    When admin Click on the New User button
    Then admin can be able to fill the New user Form and click on submit button and verify the creation
    And Close the browser


