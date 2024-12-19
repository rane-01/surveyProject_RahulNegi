Feature: Home Page Invalid Country Validation

  Scenario: Respondent from Eligible Country
    Given respondent is on survey page
    When respondent enters age 19
    And select Gender Male
    And select Australia from Country dropdown
    And click on Next
    Then respondent should redirect to Welcome Page
