@ombreTest
Feature: User check Total in the cart page
  Verify if Total are correct

  Background:
    Given user has two products in the cart


  Scenario Outline: User check product data in the cart page
    When user has products in the cart: "<product1>" and "<product2>"
    And user is in cart page
    And price of product "<product1>"
    And price of product "<product2>"
    Then total is sum prices of "<product1>" and "<product2>"
    Examples:
      |product1|product2|
      |1|4              |
      |3|5              |


