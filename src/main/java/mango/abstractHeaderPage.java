package mango;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: sriramangajala
 * Date: 20/07/2014
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public abstract class abstractHeaderPage extends abstractPage{
    public void gotoLogin() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='shopbar-account']/a/span[1]/span[2]"));
        loginButton.click();
    }

    public void gotoShoppingCart() {

    }
    public void goToComparelist() {

    }
    public void goToWishlist()
    {

    }
    public void logout()
    {

    }
}
