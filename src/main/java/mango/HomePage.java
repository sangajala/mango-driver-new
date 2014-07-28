package mango;

import mango.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomePage extends abstractHeaderPage {




    public boolean isUserInHomePage(String scategory)
    {
        if (driver.findElement(By.linkText(scategory)).isDisplayed())  return true;
        else return false;
    }
}
