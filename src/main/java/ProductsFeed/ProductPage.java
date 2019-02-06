package ProductsFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends MainPage {

    String pageTitleCss = "div#content h1";
    String productCartCss = ".add-to-cart";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        WebElement pageTitle = driver.findElement(By.cssSelector(pageTitleCss));
        System.out.println("Product title is: " + pageTitle.getText() + ".");
        return pageTitle.getText();
    }

    public void addProductToCart(){
        WebElement productCart = driver.findElement(By.cssSelector(productCartCss));
        productCart.click();
    }
}
