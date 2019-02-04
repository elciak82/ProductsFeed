Feature: User adds products to the cart
  Verify if user is able to adds a product to cart

  Background:
    Given user is on homepage

  Scenario: User adds one product to the cart
    When user clicks on a product
    And page with product details has been opened
    And user clicks on the cart which is under the picture of the product
    Then product has been added to the cart

  Scenario Outline: User adds more products to the cart
    When user add "<number>" products to cart
    Then "<number>" products have been added to the cart
    Examples:
    |number|
    |5     |
    |0    |