package ProductsFeed;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".product_price")
    private List<WebElement> productInCartPrice;

    @FindBy(css = ".product_quantity")
    private List<WebElement> productInCartQuantity;

    @FindBy(css = "table#cart tbody tr td:nth-child(2)") //table z id (#) -> tbody -> tr -> td:nth-child(2)!! w td ente dzecko - child(2) za każdym razem
    private List<WebElement> productInCartName;

    public String getProductPrice (String productName){
        int size = productInCartName.size();
        int i = 0;
        while(!productInCartName.get(i).getText().equals(productName) && i < size) {
            i++;
        }
        String productPrice = productInCartPrice.get(i).getText();
        System.out.println("Product: " + productName + "price: " + productPrice + ".");
        return productPrice;
    }
}
