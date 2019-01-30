Feature: User adds a product to the cart
  Verify if user is able to adds a product to cart

  Scenario: User adds one a product to the cart
    Given user is on homepage
    When user clicks on a product
    And page with product details has been opened
    And user clicks on the cart which is under the picture of product
    Then product has been added to the cart
    And main cart changed colour to red
    And number has been displayed next to the chart