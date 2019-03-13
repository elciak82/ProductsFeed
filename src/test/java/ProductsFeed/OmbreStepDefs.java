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
    private WebDriver driver;
    private Base base;
    private MainPage mainPage;
    private AllProductsPage allProductsPage;
    private ProductPage productPage;
    private Url url;
    private CartPage cartPage;
    private Random random;
    private int numberOfProducts;
    private RegistrationPage registrationPage;
    private DeliveryPage deliveryPage;
    private PaymentPage paymentPage;
    private CheckoutPage checkoutPage;


    @Before
    public void startUp() {
        driver = new ChromeDriver();
//        url = new Url();
        base = new Base(driver);
        mainPage = new MainPage(driver);
        allProductsPage = new AllProductsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        random = new Random();
        numberOfProducts = 2;//random.nextInt(5) + 1;
        registrationPage = new RegistrationPage(driver);
        deliveryPage = new DeliveryPage(driver);
        paymentPage = new PaymentPage(driver);
        checkoutPage = new CheckoutPage(driver);
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
        driver.get(Url.ombre);
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

    @Then("^two products have been added to the cart$")
    public void productsHaveBeenAddedToTheCart() {
        mainPage.waitForCart();
        String productsInCart = mainPage.getNumberOfProductsInCart();
        Assert.assertThat(productsInCart, is(equalTo(Integer.toString(numberOfProducts))));
    }

    @When("^user adds two products to cart$")
    public void userAddsTwoProductsToCart() {
        for (int i=0; i < numberOfProducts; i++) {
            allProductsPage.addProductToCart(i);
        }
    }

    @And("^user has one product in the cart$")
    public void userHasOneProductInTheCart() {
        allProductsPage.addProductToCart(1);
    }

    @When("^user clicks on the cart$")
    public void userClicksOnTheCart() {
        mainPage.click(MainPage.CSS.CART_ICON);
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

    @When("^user has two product in the cart$")
    public void userHasTwoProductInTheCart() {
        userAddsTwoProductsToCart();
    }

    @And("^user removes all product from the cart$")
    public void userRemovesAllProductFromTheCart() {
        cartPage.removeAllProductFromCart();
    }

    @And("^user is on cart page$")
    public void userIsOnCartPage() {
        allProductsPage.clickCartIcon();
    }

    @And("^user makes a registration$") //TODO
    public void userMakesARegistration() {
        cartPage.registrationClick();
        Assert.assertThat(registrationPage.getPageTitle(), is(equalTo("Registration page")));
    }

    @And("^user chooses delivery method$")
    public void userChoosesDeliveryMethod() { //TODO
        cartPage.deliveryClick();
        Assert.assertThat(deliveryPage.getPageTitle(),is(equalTo("Delivery page")));
    }

    @And("^user chooses payment method$")
    public void userChoosesPaymentMethod() { //TODO
        cartPage.paymentClick();
        Assert.assertThat(paymentPage.getPageTitle(),is(equalTo("Payment page")));
    }

    @And("^user makes checkout$")
    public void userMakesCheckout() {
        cartPage.checkoutClick();
        Assert.assertThat(checkoutPage.getPageTitle(), is(equalTo("Checkout page")));
        Assert.assertThat(cartPage.getNumberOfProductsInCart(), is(equalTo("")));

    }
}
