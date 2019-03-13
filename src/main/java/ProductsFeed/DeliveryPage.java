package ProductsFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryPage extends MainPage {

    String pageTitleCss = "div#content h1";

    public DeliveryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        WebElement pageTitle = driver.findElement(By.cssSelector(pageTitleCss));
        System.out.println("Page title is: " + pageTitle.getText() + ".");
        return pageTitle.getText();
    }

}