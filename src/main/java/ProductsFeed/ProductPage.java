package ProductsFeed;

import org.openqa.selenium.WebDriver;

class ProductPage extends MainPage {

    ProductPage(WebDriver driver) {
        super(driver);
    }

    String getPageTitle(){
        return findElement(CSS.pageTitle).getText();
    }

    void addProductToCart(){
        click(CSS.productCart);
    }

    private static class CSS {
        private static String pageTitle = "div#content h1";
        private static String productCart = ".add-to-cart";
    }
}
