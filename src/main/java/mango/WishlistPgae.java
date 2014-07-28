package mango;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by SRI on 25-Jul-14.
 */
public class WishlistPgae extends abstractPage {


    public boolean isItemPresent(String item) {
        {
            if (driver.findElement(By.linkText(item)).isDisplayed())  return true;
            else return false;
        }

    }


    public void addToCartFromWishlist() {

        //Click on the checkbox related to add to cart option
        WebElement checkbox=driver.findElement(By.xpath(".//*[@id='content-center']/div/div[3]/div[1]/form/table/tbody/tr/td[2]/input"));
        checkbox.click();
        //Click on add to cart button
        WebElement addtocartbutton=driver.findElement((By.name("addtocartbutton")));
        addtocartbutton.click();



        //when we add the item to cart it directly navigates to cart
    }
    public boolean isItemRemoved() {
        return true;
    }



}
