package ProductsFeed;

import org.openqa.selenium.WebDriver;

class CheckoutPage extends MainPage {

    CheckoutPage(WebDriver driver) {
        super(driver);
    }

    String getPageTitle(){
        return findElement(CssCheckoutPage.pageTitle).getText();
    }

    private static class CssCheckoutPage {
        private static String pageTitle = "div#content h1";
    }

}
