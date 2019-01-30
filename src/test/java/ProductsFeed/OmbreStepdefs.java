package ProductsFeed;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OmbreStepdefs {
    public static WebDriver driver;

    @Given("^user is on homepage$")
    public void user_is_on_homepage() {
        System.setProperty("webdriver.chrome.driver","/Users/ewelina/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ombre.revhunter.pl/");
    }

    @When("^user clicks on a product$")
    public void user_clicks_on_a_product() {
        List<WebElement> numbersOfProducts = driver.findElements(By.className("name"));
        WebElement product = numbersOfProducts.get(0);
        product.click();
    }

    @When("^page with product details has been opened$")
    public void page_with_product_details_has_been_opened() {
        List<WebElement> numbersOfProducts = driver.findElements(By.className("name"));
        String productName = numbersOfProducts.get(0).getText();
//        Assert.assertThat(productName.equals()


    }

    @When("^user clicks on the cart which is under the picture of product$")
    public void user_clicks_on_the_cart_which_is_under_the_picture_of_product() {

    }

    @Then("^product has been added to the cart$")
    public void product_has_been_added_to_the_cart() {

    }

    @Then("^main cart changed colour to red$")
    public void main_cart_changed_colour_to_red() {

    }

    @Then("^number has been displayed next to the chart$")
    public void number_has_been_displayed_next_to_the_chart() {

    }

}
