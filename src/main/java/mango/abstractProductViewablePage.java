package mango;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: sriramangajala
 * Date: 20/07/2014
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
public class abstractProductViewablePage extends abstractHeaderPage {

    public void selectProduct(String product) {
        WebElement selecProd = driver.findElement(By.xpath("//*[@id='megamenu']/div/div/ul[1]/li[1]/a"));
        selecProd.click();
    }

    public void addProductToBasket(int qty) {

    }
    public void addToComparelist() {
    }

    public void addToWishlist() {

    }
}
