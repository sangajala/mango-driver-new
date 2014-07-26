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
public class ShoppingCartPage extends abstractCartPage{

    public boolean isItemPresent(){
        return true;
    }
    public void checkOutBasket() {
        WebElement checkOuBask = driver.findElement(By.xpath("//*[@id='megamenu']/div/div/ul[1]/li[1]/a"));
        checkOuBask.click();
    }

}
