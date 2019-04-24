package ProductsFeed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends MainPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyTrashNotDisplayed() {
        try {
            return (!findElement(CssCartPage.trash).isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle(){
        return findElement(CssCartPage.pageTitle).getText();
    }

    public String getProductQuantity(){
        return findElement(CssCartPage.quantity).getAttribute("value");
    }

    public void removeProductFromCart(){
        click(CssCartPage.trash);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.invisibilityOf(findElement(CssCartPage.trash)));
    }

    public String getProductCount(){
        return findElement(CssCartPage.productCount).getText();
    }

    public String getProductPrice (int productNumber){
        List<WebElement> elements = findElements(CssCartPage.productPrice);
        return elements.get(productNumber).getText();
    }

    public void removeAllProductFromCart() {
        List<WebElement> trashList = findElements(CssCartPage.trash);
        for (WebElement element:trashList) {
            element.click();
        }
    }

    public void registrationClick(){
        click((CssCartPage.registration));
    }

    public void deliveryClick(){
        click(CssCartPage.delivery);
    }

    public void paymentClick(){
       click(CssCartPage.payment);
    }

    public void checkoutClick(){
        click(CssCartPage.checkout);
    }

    private static class CssCartPage {
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
