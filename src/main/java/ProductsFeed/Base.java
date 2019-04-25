package ProductsFeed;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Base<T extends Base> {

    protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot() throws IOException {
        String location = "C://Users//ewelina//IdeaProjects//Screenshots//";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); // add S if you need milliseconds
        System.out.println("Take a screenshot.");
        File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(location + df.format(new Date()) + " screenshot.png"));
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    WebElement findElement(String element) {
        return driver.findElement(By.cssSelector(element));
    }

    List<WebElement> findElements(String element) {
        return driver.findElements(By.cssSelector(element));
    }

    void click(String element) {
        findElement(element).click();
    }
}
