@ombreTest
Feature: User goes through the whole shopping process
  Verify if user is able to go through the whole shopping process
  Adding product, making registration, choosing delivery method, choosing payment method and checkout

  Background:
    Given user is on homepage

  Scenario: User goes through the whole shopping process
    When user clicks on a product
    And page with product details has been opened
    And user clicks on the cart which is under the picture of the product
    And product has been added to the cart
    And one product is visible on the cart page
    And user clicks on the cart
    And cart page has been opened
    Then one product is visible on the cart page
    And user makes a registration
    And user chooses delivery method
    And user chooses payment method
    And user makes checkout

