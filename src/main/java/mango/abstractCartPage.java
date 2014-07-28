package mango;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class abstractCartPage extends abstractHeaderPage {

    public void continueTheShopping()
    {
        //click on continue shopping button
        WebElement shoppingbutton=driver.findElement(By.xpath(".//*[@id='content-center']/div/div[2]/div/form/div[1]/button[1]"));
        shoppingbutton.click();


    }
    public void gotCheckOut() {
        //go to check out
        WebElement checkOuBask = driver.findElement(By.xpath(".//*[@id='checkout']"));
        checkOuBask.click();
    }


}
