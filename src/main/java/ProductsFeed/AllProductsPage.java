package ProductsFeed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

class AllProductsPage extends MainPage<AllProductsPage>{

    AllProductsPage(WebDriver driver) {
        super(driver);
    }

    String getPageTitle(){
        return findElement(CssAllProductPage.pageTitle).getText();
    }

    void clickOnProduct(int productNumber) {
        findElements(CssAllProductPage.productTile).get(productNumber).click();
    }

    void addProductToCart (int productNumber){
        findElements(CssAllProductPage.productCartTile).get(productNumber).click();
    }

    String getProductPrice (int productNumber){
        return findElements(CssAllProductPage.productPriceTile).get(productNumber).getText();
    }

    private List<String> getProductsPricesFromTile (List<Integer> productsList){
        List<WebElement> productsPrices = findElements(CssAllProductPage.productPriceTile);
        List<String> listOfPrices = new ArrayList<>();
        for (int productNumber:productsList) {
            listOfPrices.add(productsPrices.get(productNumber).getText());
        }
        return listOfPrices;
    }

    private static class CssAllProductPage {
        private static String productTile = "div.product";
        private static String productNameTile = "p.name";
        private static String productPriceTile = "p.price";
        private static String productCartTile = ".add-to-cart";
        private static String pageTitle = "div#content h1";
    }

}
