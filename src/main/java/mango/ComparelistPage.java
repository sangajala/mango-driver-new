package mango;

import org.junit.Assert;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.*;

/**
 * Created by SRI on 25-Jul-14.
 */
public class ComparelistPage extends abstractPage {


    public boolean isItemCompared(String item1, String item2) {


        if (driver.findElement(By.linkText(item1)).isDisplayed()) {
            if (driver.findElement(By.linkText(item2)).isDisplayed()) return true;

        }
        return true;
    }
}