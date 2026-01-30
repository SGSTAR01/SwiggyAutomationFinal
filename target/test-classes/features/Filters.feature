Feature: Filters Functionality

  Scenario: Apply Veg Only filter
    Given I am on the restaurant listing page
    When I search for "Biriyani"
    When I apply the "Veg Only" filter
    Then the "Veg Only" filter should be active
