package ProductsFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AllProductsPage extends Base{

    String productTileCss = "div.product";
    String productNameTileCss = "p.name";
    String productPriceTileCss = "p.price";
    String productCartTileCss = ".add-to-cart";
    String pageTitleCss = "div#content h1";

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        WebElement pageTitle = driver.findElement(By.cssSelector(pageTitleCss));
        return pageTitle.getText();
    }

    public void clickOnProduct(int productNumber) {
        List<WebElement> productTile = driver.findElements(By.cssSelector(productTileCss));
        System.out.println("Click on the product: " + productNumber + " tile.");
        productTile.get(productNumber).click();
    }

    public void addProductToCart (int productNumber){
        List<WebElement> productCartTile = driver.findElements(By.cssSelector(productCartTileCss));
        System.out.println("Add product " + productNumber + " to the cart." );
        productCartTile.get(productNumber).click();
    }

    public void addProductsToCart (List<Integer> productsList){
        List<WebElement> productsCartTile = driver.findElements(By.cssSelector(productCartTileCss));
        for (int productNumber:productsList) {
            System.out.println("Add product " + productNumber + " to the cart.");
            productsCartTile.get(productNumber).click();
        }
    }

    public String getProductPrice (int productNumber){
        List<WebElement> productPriceTile = driver.findElements(By.cssSelector(productPriceTileCss));
        String productPrice = productPriceTile.get(productNumber).getText();
        System.out.println("Product " + productNumber + " price: " + productPrice + ".");
        return productPrice;
    }

    public List<String> getProductsPricesFromTile (List<Integer> productsList){
        List<WebElement> productsPrices = driver.findElements(By.cssSelector(productPriceTileCss));
        List<String> listOfPrices = new ArrayList<>();
        for (int productNumber:productsList) {
            System.out.println("Add product " + productNumber + " to the cart.");
            productsPrices.get(productNumber).getText();
        }
        return listOfPrices;
    }

//    public List<String> getProductsPrices (List<String> productNames){
//        int size = productNameTile.size();
//        int i = 0;
//        List<String> listOfPrices = new ArrayList<>();
//        for (String productName:productNames) {
//            while (!productNameTile.get(i).getText().equals(productName) && i < size) {
//                i++;
//            }
//        }
//        return listOfPrices;
//    }
}
