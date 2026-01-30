Feature: Location Functionality

  Scenario: Verify redirection after entering a location
    Given I am on the Swiggy landing page
    When I enter the location "Bangalore"
    And I select the first suggestion
    Then I should be redirected to the restaurant listing page
