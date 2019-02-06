package ProductsFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Base{

    String homeIconCss = ".fa-home";
    String cartIconCss = "div#header a:nth-child(2)";
    String cartCountCss = "#cart_count";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickHomeIcon(){
        WebElement homeIcon = driver.findElement(By.cssSelector(homeIconCss));
        homeIcon.click();
    }

    public void clickCartIcon(){
        WebElement cartIcon = driver.findElement(By.cssSelector(cartIconCss));
        cartIcon.click();
    }

    public String getNumberOfProductsInCart() {
        WebElement cartCount = driver.findElement(By.cssSelector(cartCountCss));
        System.out.println("Number of products in the cart: " + cartCount.getText() + ".");
        return cartCount.getText();
    }

    public boolean cartHasRedColor() {
        WebElement cartIcon = driver.findElement(By.cssSelector(cartIconCss));
        if (cartIcon.getCssValue("color") == "#ac2925") {
            return true;
        }else {
            System.out.println("Cart icon is not red");
            return false;
        }
    }

    public void waitForCart(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cartIconCss)));
    }
}
