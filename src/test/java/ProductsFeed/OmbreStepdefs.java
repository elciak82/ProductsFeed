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
    public AllProductsPage allProductsPage= new AllProductsPage();
    public ProductPage productPage= new ProductPage();
    public BasePage basePage = new BasePage();

    @Given("^user is on homepage$")
    public void user_is_on_homepage() {
//        System.setProperty("webdriver.chrome.driver","/Users/ewelina/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ombre.revhunter.pl/");
//        System.out.println(allProductsPage.getPageTitle());
//        Assert.assertTrue(allProductsPage.getPageTitle().equals("Products page"));
    }

    @When("^user clicks on a product$")
    public void user_clicks_on_a_product() {
        allProductsPage.clickOnProduct("MARYNARKA MĘSKA ELEGANCKA M36 - CZARNA");
    }

    @When("^page with product details has been opened$")
    public void page_with_product_details_has_been_opened() {
        Assert.assertTrue(productPage.getPageTitle().equals("Product page"));
    }

    @When("^user clicks on the cart which is under the picture of product$")
    public void user_clicks_on_the_cart_which_is_under_the_picture_of_product() {
        productPage.addProductToCart();
    }

    @Then("^product has been added to the cart$")
    public void product_has_been_added_to_the_cart() {
        Assert.assertTrue(basePage.numberOfElementsInCart().equals("1"));
        Assert.assertTrue(basePage.cartHasRedColor());
    }

}
