package ProductsFeed;

import org.openqa.selenium.WebDriver;

class CheckoutPage extends MainPage {

    CheckoutPage(WebDriver driver) {
        super(driver);
    }

    String getPageTitle(){
        return findElement(CssCheckoutPage.pageTitleCss).getText();
    }

    private static class CssCheckoutPage {
        private static String pageTitleCss = "div#content h1";
    }

}
