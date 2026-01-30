Feature: Cart Functionality

  Scenario: Add item to cart and verify subtotal
    Given I am on the restaurant listing page
    When I add the first item to the cart
    And I navigate to the cart page
    Then the subtotal should be greater than 0
