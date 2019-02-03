package ProductsFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends Base {

    String productInCartPriceCss = ".product_price";
    String productInCartQuantityCss = ".product_quantity";
    String productInCartNameCss = "table#cart tbody tr td:nth-child(2)"; //table z id (#) -> tbody -> tr -> td:nth-child(2)!! w td ente dzecko - child(2) za każdym razem

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice (int productNumber){
        List<WebElement> productInCartPrice = driver.findElements(By.cssSelector(productInCartPriceCss));
        List<WebElement> productInCartName = driver.findElements(By.cssSelector(productInCartNameCss));
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
