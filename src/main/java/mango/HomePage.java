package mango;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: sriramangajala
 * Date: 20/07/2014
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 */
public class HomePage extends abstractHeaderPage {


    public void gotoCategory(String category) {
        WebElement gotoCatag = driver.findElement(By.xpath("//*[@id='megamenu']/div/div/ul[1]/li[1]/a"));
        gotoCatag.click();
    }

    public void goToSubcategory(String scategory) {
    }

    public boolean isUserInHomePage()
    {
        return true;
    }
}
