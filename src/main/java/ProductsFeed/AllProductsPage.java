package ProductsFeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AllProductsPage {

    @FindBy(css = "div.product")
    private List<WebElement> productTile;

    @FindBy(css = "p.name")
    private List<WebElement> productNameTile;

    @FindBy(css = "p.price")
    private List<WebElement> productPriceTile;

    @FindBy(css = ".add-to-cart")
    private List<WebElement> productCartTile;

    @FindBy(css = "div#content h1")
    private WebElement pageTitle;

    public String getPageTitle(){
        return pageTitle.getTagName();
    }

    public void clickOnProduct (String productName){
        int size = productNameTile.size();
        int i = 0;
        while(!productNameTile.get(i).getText().equals(productName) && i < size) {
            i++;
        }
        System.out.println("Click on the product: " + productName + ".");
        productNameTile.get(i).click();
    }

    public void addProductToCart (String productName){
        int size = productNameTile.size();
        int i = 0;
        while(!productNameTile.get(i).getText().equals(productName) && i < size) {
            i++;
        }
        System.out.println("Add product " + productName + " to the cart." );
        productCartTile.get(i).click();
    }

    public void addProductsToCart (List<String> productNames){
        int size = productNameTile.size();
        int i = 0;
        for (String productName:productNames) {
            while (!productNameTile.get(i).getText().equals(productName) && i < size) {
                i++;
            }
            System.out.println("Add product " + productName + " to the cart.");
            productCartTile.get(i).click();
        }
    }

    public String getProductPrice (String productName){
        int size = productNameTile.size();
        int i = 0;
        while(!productNameTile.get(i).getText().equals(productName) && i < size) {
            i++;
        }
        String productPrice = productPriceTile.get(i).getText();
        System.out.println("Product " + productName + " price: " + productPrice + ".");
        return productPrice;
    }

    public List<String> getProductsPrices (List<String> productNames){
        int size = productNameTile.size();
        int i = 0;
        List<String> listOfPrices = new ArrayList<>();
        for (String productName:productNames) {
            while (!productNameTile.get(i).getText().equals(productName) && i < size) {
                i++;
            }
        }
        return listOfPrices;
    }
}
