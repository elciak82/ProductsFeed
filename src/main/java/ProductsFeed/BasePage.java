package ProductsFeed;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    @FindBy(css = ".fa-home")
    private WebElement homeIcon;

    @FindBy(css = "#cart_icon")
    private WebElement cartIcon;

    @FindBy(css = "#cart_count")
    private WebElement cartCount;

    public void clickHomeIcon(){
        homeIcon.click();
    }

    public void clickCartIcon(){
        cartIcon.click();
    }

    public String numberOfElementsInCart() {
        String numberOfElements = cartCount.getText();
        return numberOfElements;
    }

    public boolean cartHasRedColor() {
        if (cartIcon.getCssValue("color") == "#ac2925");
            return true;
    }
}
