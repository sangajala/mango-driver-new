package mango;

import mango.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class abstractProductViewablePage extends abstractHeaderPage {




    public void addProductToBasket(String qty) {
        //Enter quantity
        //xpath is dynamically changing for each product so didn't use the direct xpath
        //Here put the xpath which starts with addtocart ,this is unique for qty button
        WebElement qutyinput=driver.findElement(By.xpath("//input[starts-with(@id, 'addtocart')]"));
        qutyinput.clear();
        qutyinput.sendKeys(qty);
        //Click on add to cart button
        WebElement addToCart=driver.findElement(By.linkText("Add to cart"));
        addToCart.click();
        WaitUtils.pause(50);


    }
    public void addToComparelist(String compare) {

        WebElement addtocomaparelist =driver.findElement(By.linkText("Add to compare list"));

        addtocomaparelist.click();
    }

    public void addToWishlist() {
        WebElement addtowishlist =driver.findElement(By.linkText("Add to wishlist"));
        addtowishlist.click();
        WaitUtils.pause(50);


    }


}
