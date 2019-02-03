Feature: User adds a products to the cart
  Verify if user is able to adds a product to cart

  Background:
    Given user is on homepage

  Scenario: User adds one a product to the cart
    When user clicks on a product
    And page with product details has been opened
    And user clicks on the cart which is under the picture of product
    Then product has been added to the cart

  Scenario: User adds two products to the cart
    When user add two product to cart
    Then products have been added to the cart