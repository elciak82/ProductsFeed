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

    public String numberOfProductsInCart() {
        WebElement cartCount = driver.findElement(By.cssSelector(cartCountCss));
        String numberOfProducts = cartCount.getText();
        return numberOfProducts;
    }

    public boolean cartHasRedColor() {
        WebElement cartIcon = driver.findElement(By.cssSelector(cartIconCss));
        if (cartIcon.getCssValue("color") == "#ac2925");
            return true;
    }

    public void waitForCart(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cartIconCss)));
    }
}
