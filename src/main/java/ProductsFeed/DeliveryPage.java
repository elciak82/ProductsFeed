package ProductsFeed;

import org.openqa.selenium.WebDriver;

 class DeliveryPage extends MainPage {

    DeliveryPage(WebDriver driver) {
        super(driver);
    }

    String getPageTitle(){
        return findElement(CssDeliveryPage.pageTitle).getText();
    }

    private static class CssDeliveryPage{
        private static String pageTitle = "div#content h1";
    }

}
