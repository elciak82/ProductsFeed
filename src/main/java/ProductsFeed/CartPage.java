package ProductsFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends MainPage {

    String productPriceCss = ".product_price";
    String productInCartQuantityCss = ".product_quantity";
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
        return pageTitle.getText();
    }

    public String getProductQuantity(){ ///może zamienić na count??
        WebElement quantity = driver.findElement(By.cssSelector(quantityCss));
        System.out.println(quantity.getAttribute("value"));
        return quantity.getAttribute("value");
    }

    public void removeProductFromCart(){
        WebElement trash = driver.findElement(By.cssSelector(trashCss));
        trash.click();
    }


    public String getProductCount(){
        WebElement productCount = driver.findElement(By.cssSelector(productCountCss));
        return productCount.getText();
    }

    public String getProductPrice (int productNumber){
        List<WebElement> productInCartPrice = driver.findElements(By.cssSelector(productPriceCss));
        List<WebElement> productInCartName = driver.findElements(By.cssSelector(productNameCss));
        String productPrice = productInCartPrice.get(productNumber).getText();
        String productName = productInCartName.get(productNumber).getText();
        System.out.println("Product: " + productName + "price: " + productPrice + ".");
        return productPrice;
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
