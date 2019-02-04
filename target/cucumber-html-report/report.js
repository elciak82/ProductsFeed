$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/ProductsFeed/ombre.feature");
formatter.feature({
  "name": "User adds products to the cart",
  "description": "  Verify if user is able to adds a product to cart",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "OmbreStepdefs.userIsOnHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User adds one product to the cart",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user clicks on a product",
  "keyword": "When "
});
formatter.match({
  "location": "OmbreStepdefs.userClicksOnAProduct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "page with product details has been opened",
  "keyword": "And "
});
formatter.match({
  "location": "OmbreStepdefs.pageWithProductDetailsHasBeenOpened()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on the cart which is under the picture of the product",
  "keyword": "And "
});
formatter.match({
  "location": "OmbreStepdefs.userClicksOnTheCartWhichIsUnderThePictureOfProduct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "product has been added to the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "OmbreStepdefs.productHasBeenAddedToTheCart()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "User adds more products to the cart",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user add \"\u003cnumber\u003e\" products to cart",
  "keyword": "When "
});
formatter.step({
  "name": "\"\u003cnumber\u003e\" products have been added to the cart",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "number"
      ]
    },
    {
      "cells": [
        "5"
      ]
    },
    {
      "cells": [
        "0"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "OmbreStepdefs.userIsOnHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User adds more products to the cart",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user add \"5\" products to cart",
  "keyword": "When "
});
formatter.match({
  "location": "OmbreStepdefs.userAddProductsToCart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"5\" products have been added to the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "OmbreStepdefs.productsHaveBeenAddedToTheCart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "OmbreStepdefs.userIsOnHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User adds more products to the cart",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user add \"0\" products to cart",
  "keyword": "When "
});
formatter.match({
  "location": "OmbreStepdefs.userAddProductsToCart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"0\" products have been added to the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "OmbreStepdefs.productsHaveBeenAddedToTheCart(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat ProductsFeed.OmbreStepdefs.productsHaveBeenAddedToTheCart(OmbreStepdefs.java:73)\r\n\tat ✽.\"0\" products have been added to the cart(src/test/resources/ProductsFeed/ombre.feature:15)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});