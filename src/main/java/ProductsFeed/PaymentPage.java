package ProductsFeed;

import org.openqa.selenium.WebDriver;

public class PaymentPage extends MainPage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return findElement(CssPaymentPage.pageTitle).getText();
    }

    private static class CssPaymentPage {
        private static String pageTitle = "div#content h1";
    }

}
