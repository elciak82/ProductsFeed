#@ombreTest
Feature: User adds products to the cart
  Verify if user is able to adds a product to cart

  Background:
    Given user is on homepage

  Scenario: User adds one product to the cart
    When user clicks on a product
    And page with product details has been opened
    And user clicks on the cart which is under the picture of the product
    Then product has been added to the cart
    And one product is visible on the cart page

  Scenario: User adds more products to the cart
    When user add some products to cart
    Then some products have been added to the cart
