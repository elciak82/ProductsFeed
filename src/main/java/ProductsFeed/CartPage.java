package ProductsFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends MainPage {

    String productPriceCss = ".product_price";
    String productNameCss = "table#cart tbody tr td:nth-child(2)"; //table z id (#) -> tbody -> tr -> td:nth-child(2)!! w td ente dzecko - child(2) za każdym razem
    String pageTitleCss = "div#content h1";
    String quantityCss = ".product_quantity";
    String trashCss =".product_remove";
    String productCountCss ="#product_count";

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
        for (WebElement trash: trashList) {
            System.out.println(trash.getAttribute("data-product-id"));
            trash.click();
            driver.navigate().refresh();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.invisibilityOfAllElements(trashList));
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
