#@ombreTest
Feature: User adds products to the cart
  Verify if user is able to adds a product to cart

  Background:
    Given user is on homepage

  Scenario: User adds ONE product to the cart
    When user clicks on a product
    And page with product details has been opened
    And user clicks on the cart which is under the picture of the product
    Then product has been added to the cart
    And one product is visible on the cart page

  Scenario: User adds TWO products to the cart
    When user adds two products to cart
    Then two products have been added to the cart
