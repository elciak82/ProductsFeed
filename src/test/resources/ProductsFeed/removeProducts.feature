#@ombreTest
Feature: User removes products from the cart
  Verify if user is able to remove a product from cart

  Background:
    Given user is on homepage

  Scenario: User removes ONE product from the cart
    When user has one product in the cart
    And user clicks on the cart on the homepage
    And cart page has been opened
    And user removes product from the cart
    Then cart is empty

  Scenario: User removes TWO products from the cart
    When user has two product in the cart
    And user clicks on the cart
    And cart page has been opened
    And user removes all product from the cart
    Then cart is empty
