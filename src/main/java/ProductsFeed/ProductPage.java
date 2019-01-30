package ProductsFeed;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage {
    @FindBy(css = "div#content h1")
    private WebElement pageTitle;

    @FindBy(css = ".add-to-cart")
    private WebElement productCart;

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void addProductToCart(){
        productCart.click();
    }
}
