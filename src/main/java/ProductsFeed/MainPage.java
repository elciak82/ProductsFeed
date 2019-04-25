package ProductsFeed;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage<T extends MainPage> extends Base<T>{

    MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickHomeIcon(){
        click(CssMainPage.homeIcon);
    }

    void clickCartIcon(){
        click(CssMainPage.cartIcon);
    }

    String getNumberOfProductsInCart() {
        return findElement(CssMainPage.cartCount).getText();
    }

    public boolean cartHasRedColor() {
        if (findElement(CssMainPage.cartIcon).getCssValue("color").equals("#ac2925")) {
            return true;
        }else {
            System.out.println("Cart icon is not red");
            return false;
        }
    }

    void waitForCart(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(findElement(CssMainPage.cartIcon)));
    }

    private static class CssMainPage {
        private static String homeIcon = ".fa-home";
        private static String cartIcon = "div#header a:nth-child(2)";
        private static String cartCount = "#cart_count";
    }
}
