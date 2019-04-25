package ProductsFeed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage<T extends MainPage> extends Base<T>{

    MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickHomeIcon(){
        click(CSS.homeIcon);
    }

    void clickCartIcon(){
        click(CSS.cartIcon);
    }

    String getNumberOfProductsInCart() {
        return findElement(CSS.cartCount).getText();
    }

    public boolean cartHasRedColor() {
        if (findElement(CSS.cartIcon).getCssValue("color").equals("#ac2925")) {
            return true;
        }else {
            return false;
        }
    }

    void waitForCart(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(findElement(CSS.cartIcon)));
    }

    private static class CSS {
        private static String homeIcon = ".fa-home";
        private static String cartIcon = "div#header a:nth-child(2)";
        private static String cartCount = "#cart_count";
    }
}
