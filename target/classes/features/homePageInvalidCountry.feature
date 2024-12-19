Feature: Home Page Invalid Country Validation

  Scenario: Respondent from Non-Eligible Country
    Given respondent is on survey page
    When respondent enters age 19
    And select Gender Male
    And select United States from Country dropdown
    And click on Next
    Then Termination message should show up
  
