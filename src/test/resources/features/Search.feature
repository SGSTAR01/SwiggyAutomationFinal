Feature: Search Functionality

  Scenario: Search for a food item
    Given I am on the restaurant listing page
    When I search for "Biryani"
    Then I should see restaurants serving "Biryani"
