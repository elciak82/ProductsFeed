@ombreTest
Feature: User remove product from the cart
  Verify if user is able to remove a product from cart

  Background:
    Given user is on homepage
    And user has one product in the cart

  Scenario: User removes product from the cart
    When user clicks on the cart on the homepage
    And cart page has been opened
    Then user removes product from the cart
    And cart is empty
