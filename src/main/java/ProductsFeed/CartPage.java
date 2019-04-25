package ProductsFeed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends MainPage {

    CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyTrashNotDisplayed() {
        try {
            return (!findElement(CSS.trash).isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    String getPageTitle(){
        return findElement(CSS.pageTitle).getText();
    }

    String getProductQuantity(){
        return findElement(CSS.quantity).getAttribute("value");
    }

    void removeProductFromCart(){
        click(CSS.trash);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.invisibilityOf(findElement(CSS.trash)));
    }

    String getProductCount(){
        return findElement(CSS.productCount).getText();
    }

    String getProductPrice (int productNumber){
        List<WebElement> elements = findElements(CSS.productPrice);
        return elements.get(productNumber).getText();
    }

    void removeAllProductFromCart() {
        List<WebElement> trashList = findElements(CSS.trash);
        for (WebElement element:trashList) {
            element.click();
        }
        driver.navigate().refresh();
    }

    void registrationClick(){
        click((CSS.registration));
    }

    void deliveryClick(){
        click(CSS.delivery);
    }

    void paymentClick(){
       click(CSS.payment);
    }

    void checkoutClick(){
        click(CSS.checkout);
    }

    private static class CSS {
        private static String productPrice = ".product_price";
        private static String productName = "table#cart tbody tr td:nth-child(2)"; //table z id (#) -> tbody -> tr -> td:nth-child(2)!! w td ente dzecko - child(2) za każdym razem
        private static String pageTitle = "div#content h1";
        private static String quantity = ".product_quantity";
        private static String trash =".product_remove";
        private static String productCount ="#product_count";
        private static String registration = ".fa-user";
        private static String delivery = ".fa-truck";
        private static String payment = ".fa-money-bill-alt";
        private static String checkout = ".fa-flag-checkered";
    }

}
