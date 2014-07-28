package mango;

import mango.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public abstract class abstractHeaderPage extends abstractPage{
    public void gotoLogin() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='shopbar-account']/a/span[1]/span[2]"));
        loginButton.click();
    }
    public void goToBasket(){
        //open basket
        WebElement basket=driver.findElement(By.xpath(".//*[@id='shopbar-cart']/a"));
        basket.click();

    }
    public void gotoShoppingCart() {

        //navigate to shopping cart
        WebElement cart=driver.findElement(By.linkText("Go to cart"));
        cart.click();

    }
    public void goToComparelist(){
        //open compare list at the top of the page
        WebElement comparelist=driver.findElement(By.xpath(".//*[@id='shopbar-compare']/a/span[1]"));
        comparelist.click();
        WaitUtils.pause(50);

    }
    public void goToComparelistPage() {

        //navigate to Compare products list page
        WebElement compareproduct=driver.findElement(By.linkText("Compare products list"));
        compareproduct.click();
        WaitUtils.pause(50);


    }
    public void goToWishlist(){
        //open wishlist at the top of the page
        WebElement wishlist=driver.findElement(By.xpath(".//*[@id='shopbar-wishlist']/a"));
        wishlist.click();
        WaitUtils.pause(50);

    }
    public void goToWishlistPage(){

        //navigate to Compare products list page
        WebElement viewwishlist=driver.findElement(By.linkText("View Wishlist"));
        viewwishlist.click();
        WaitUtils.pause(50);
    }


    public void logout()
    {
        //Click on My account drop down
        WebElement myaccount=driver.findElement(By.xpath(".//*[@id='shopbar-account']/a/span[1]"));
        myaccount.click();
        //Logout
        WebElement logoutoption=driver.findElement(By.linkText("Log out"));
        logoutoption.click();
        WaitUtils.pause(25);

    }
    public void gotoCategory(String category) {
        WebElement gotoCateg = driver.findElement(By.linkText(category));
        gotoCateg.click();
    }

    public void goToSubcategory(String scategory) {
        WebElement subcateg=driver.findElement(By.linkText(scategory));
        subcateg.click();
        WaitUtils.pause(50);
    }
    public void selectProduct(String product)
    {
        WebElement selecProd = driver.findElement(By.linkText(product));
        selecProd.click();
        WaitUtils.pause(50);
    }
}
