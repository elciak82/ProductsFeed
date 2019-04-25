package ProductsFeed;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

class AllProductsPage extends MainPage<AllProductsPage>{

    AllProductsPage(WebDriver driver) {
        super(driver);
    }

    String getPageTitle(){
        return findElement(CSS.pageTitle).getText();
    }

    void clickOnProduct(int productNumber) {
        findElements(CSS.productTile).get(productNumber).click();
    }

    void addProductToCart (int productNumber){
        findElements(CSS.productCartTile).get(productNumber).click();
    }

    String getProductPrice (int productNumber){
        return findElements(CSS.productPriceTile).get(productNumber).getText();
    }

    private List<String> getProductsPricesFromTile (List<Integer> productsList){
        List<String> listOfPrices = new ArrayList<>();
        for (int productNumber:productsList) {
            listOfPrices.add(findElements(CSS.productPriceTile).get(productNumber).getText());
        }
        return listOfPrices;
    }

    private static class CSS {
        private static String productTile = "div.product";
        private static String productNameTile = "p.name";
        private static String productPriceTile = "p.price";
        private static String productCartTile = ".add-to-cart";
        private static String pageTitle = "div#content h1";
    }

}
