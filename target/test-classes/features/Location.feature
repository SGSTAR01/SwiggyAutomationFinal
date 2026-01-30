Feature: Location Functionality

  Scenario Outline: Verify redirection after entering a location
    Given I am on the Swiggy landing page
    When I enter the location <location>
    And I select the first suggestion
    Then I should be redirected to the restaurant listing page
    Examples:
      | location     |
      | "Alipurduar" |
