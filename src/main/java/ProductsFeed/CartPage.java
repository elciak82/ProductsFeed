package ProductsFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends MainPage {

    private String productPriceCss = ".product_price";
    private String productNameCss = "table#cart tbody tr td:nth-child(2)"; //table z id (#) -> tbody -> tr -> td:nth-child(2)!! w td ente dzecko - child(2) za każdym razem
    private String pageTitleCss = "div#content h1";
    private String quantityCss = ".product_quantity";
    private String trashCss =".product_remove";
    private String productCountCss ="#product_count";
    private String registrationCss = ".fa-user";
    private String deliveryCss = ".fa-truck";
    private String paymentCss = ".fa-money-bill-alt";
    private String checkoutCss = ".fa-flag-checkered";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyTrashNotDisplayed() {
        WebElement trash = driver.findElement(By.cssSelector(trashCss));
        try {
            return (!trash.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle(){
        WebElement pageTitle = driver.findElement(By.cssSelector(pageTitleCss));
        System.out.println("Page title is: " + pageTitle.getText() + ".");
        return pageTitle.getText();
    }

    public String getProductQuantity(){
        WebElement quantity = driver.findElement(By.cssSelector(quantityCss));
        System.out.println("Product quantity is: " + quantity.getAttribute("value") + ".");
        return quantity.getAttribute("value");
    }

    public void removeProductFromCart(){
        WebElement trash = driver.findElement(By.cssSelector(trashCss));
        trash.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.invisibilityOf(trash));
    }

    public String getProductCount(){
        WebElement productCount = driver.findElement(By.cssSelector(productCountCss));
        return productCount.getText();
    }

    public String getProductPrice (int productNumber){
        List<WebElement> productInCartPrice = driver.findElements(By.cssSelector(productPriceCss));
        String productPrice = productInCartPrice.get(productNumber).getText();
        System.out.println("Product number: " + productNumber + " price is " + productPrice + ".");
        return productPrice;
    }

    public void removeAllProductFromCart() {
        List<WebElement> trashList = driver.findElements(By.cssSelector(trashCss));
        int elementsInTrash = trashList.size();
        for (int i = 0; i<elementsInTrash; i++) {
            trashList.get(i).click();
        }
        driver.navigate().refresh();
    }

    public void registrationClick(){
        WebElement registration = driver.findElement(By.cssSelector(registrationCss));
        registration.click();
    }

    public void deliveryClick(){
        WebElement delivery = driver.findElement(By.cssSelector(deliveryCss));
        delivery.click();
    }

    public void paymentClick(){
        WebElement payment = driver.findElement(By.cssSelector(paymentCss));
        payment.click();
    }

    public void checkoutClick(){
        WebElement checkout = driver.findElement(By.cssSelector(checkoutCss));
        checkout.click();
    }

    public enum CSS implements CSSElement<CartPage> {
        asdfas;

        @Override
        public String getValue() {
            return null;
        }
    }

//    public String getProductPrice (String productName){
//        int size = productInCartNameCss.size();
//        int i = 0;
//        while(!productInCartName.get(i).getText().equals(productName) && i < size) {
//            i++;
//        }
//        String productPrice = productInCartPrice.get(i).getText();
//        System.out.println("Product: " + productName + "price: " + productPrice + ".");
//        return productPrice;
//    }
}
