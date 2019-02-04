package ProductsFeed;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OmbreStepdefs {
    public WebDriver driver;
    public Base base;
    public MainPage mainPage;
    public AllProductsPage allProductsPage;
    public ProductPage productPage;
    public Url url;

    @Before
    public void startUp() {
        driver = new ChromeDriver();
        url = new Url();
        base = new Base(driver);
        mainPage = new MainPage(driver);
        allProductsPage = new AllProductsPage(driver);
        productPage = new ProductPage(driver);
    }

    @After
    public void tearDown() throws IOException {
        base.takeScreenshot();
        driver.quit();
    }

    @Given("^user is on homepage$")
    public void userIsOnHomepage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url.ombre);
        System.out.println(allProductsPage.getPageTitle());
        Assert.assertTrue(allProductsPage.getPageTitle().equals("Products page"));
    }

    @When("^user clicks on a product$")
    public void userClicksOnAProduct() {
        allProductsPage.clickOnProduct(1);
    }

    @When("^page with product details has been opened$")
    public void pageWithProductDetailsHasBeenOpened() {
        Assert.assertTrue(productPage.getPageTitle().equals("Product page"));
    }

    @When("^user clicks on the cart which is under the picture of the product$")
    public void userClicksOnTheCartWhichIsUnderThePictureOfProduct() {
        productPage.addProductToCart();
    }

    @Then("^product has been added to the cart$")
    public void productHasBeenAddedToTheCart() {
        mainPage.waitForCart();
        Assert.assertTrue(mainPage.numberOfElementsInCart().equals("1"));
        Assert.assertTrue(mainPage.cartHasRedColor());
    }

    @Then("^\"([^\"]*)\" products have been added to the cart$")
    public void productsHaveBeenAddedToTheCart(String numberOfProducts) {
        mainPage.waitForCart();
        Assert.assertTrue(mainPage.numberOfElementsInCart().equals(numberOfProducts));
    }

    @When("^user add \"([^\"]*)\" products to cart$")
    public void userAddProductsToCart(String numberOfProducts) {
        int number = Integer.parseInt(numberOfProducts);
        for (int i=0; i < number; i++) {
            allProductsPage.addProductToCart(i);
        }
    }
}
