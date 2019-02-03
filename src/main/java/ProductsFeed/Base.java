package ProductsFeed;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Base {

    protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot() throws IOException {
        String location = "C://Users//ewelina//IdeaProjects//Screenshots//";
        String file = " screenshot.png";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); // add S if you need milliseconds
        File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(location + df.format(new Date()) + file));
    }
}
