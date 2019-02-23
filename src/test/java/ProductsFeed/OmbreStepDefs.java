package ProductsFeed;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class OmbreStepDefs {
    public WebDriver driver;
    public Base base;
    public MainPage mainPage;
    public AllProductsPage allProductsPage;
    public ProductPage productPage;
    public Url url;
    public CartPage cartPage;
    public Random random;
    public int numberOfProducts;


    @Before
    public void startUp() {
        driver = new ChromeDriver();
        url = new Url();
        base = new Base(driver);
        mainPage = new MainPage(driver);
        allProductsPage = new AllProductsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        random = new Random();
        numberOfProducts = 5;//random.nextInt(5) + 1;
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
        Assert.assertThat(allProductsPage.getPageTitle(), is(equalTo("Products page")));
    }

    @When("^user clicks on a product$")
    public void userClicksOnAProduct() {
        allProductsPage.clickOnProduct(1);
    }

    @When("^page with product details has been opened$")
    public void pageWithProductDetailsHasBeenOpened() {
        Assert.assertThat(productPage.getPageTitle(), is(equalTo("Product page")));
    }

    @When("^user clicks on the cart which is under the picture of the product$")
    public void userClicksOnTheCartWhichIsUnderThePictureOfProduct() { productPage.addProductToCart(); }

    @Then("^product has been added to the cart$")
    public void productHasBeenAddedToTheCart() {
        mainPage.waitForCart();
        String productsInCart = mainPage.getNumberOfProductsInCart();
        if (productsInCart.equals("1")) {
            System.out.println(productsInCart + " products has been added to the cart.");
        }
        else {System.out.println("Number of product is not equal 1.");
        }
    }

    @Then("^some products have been added to the cart$")
    public void productsHaveBeenAddedToTheCart() {
        mainPage.waitForCart();
        String productsInCart = mainPage.getNumberOfProductsInCart();
        Assert.assertThat(productsInCart, is(equalTo(Integer.toString(numberOfProducts))));
    }

    @When("^user add some products to cart$")
    public void userAddProductsToCart() {
        for (int i=0; i < numberOfProducts; i++) {
            allProductsPage.addProductToCart(i);
        }
    }

    @And("^user has one product in the cart$")
    public void userHasOneProductInTheCart() {
        allProductsPage.addProductToCart(1);
    }

    @When("^user clicks on the cart on the homepage$")
    public void userClicksOnTheCartOnTheHomepage() {
        mainPage.clickCartIcon();
        base.waitForLoad(driver);
    }

    @And("^cart page has been opened$")
    public void cartPageHasBeenOpened() {
        Assert.assertThat(cartPage.getPageTitle(), is(equalTo("Cart page")));
//        Assert.assertThat(cartPage.getProductCount(), is(equalTo(Integer.toString(numberOfProducts))));
    }

    @Then("^user removes product from the cart$")
    public void userRemovesProductFromTheCart() {
        cartPage.removeProductFromCart();
    }

    @And("^cart is empty$")
    public void cartIsEmpty() {
        Assert.assertThat(cartPage.getProductCount(), is(equalTo("0")));
    }

    @And("^one product is visible on the cart page$")
    public void oneProductIsVisibleOnTheCartPage() {
        mainPage.clickCartIcon();
        Assert.assertThat(cartPage.getProductQuantity(), is(equalTo("1")));
    }

    @When("^user has some product in the cart$")
    public void userHasSomeProductInTheCart() {
        userAddProductsToCart();
    }

    @And("^user removes all product from the cart$")
    public void userRemovesAllProductFromTheCart() {
        cartPage.removeAllProductFromCart();

    }
}
