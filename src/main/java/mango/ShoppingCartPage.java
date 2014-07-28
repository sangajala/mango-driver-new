package mango;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: sriramangajala
 * Date: 20/07/2014
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartPage extends abstractCartPage {

    public boolean isItemPresent(String item) {
        {
            if (driver.findElement(By.linkText(item)).isDisplayed()) return true;
            else return false;
        }
    }


}


