package mango;

import org.openqa.selenium.By;

/**
 * Created by SRI on 28-Jul-14.
 */
public class ConfirmationPage extends abstractHeaderPage {
    public boolean isOrderConfirmed() {
        {
            //check the order successfull message
            if (driver.findElement(By.className("text-success")).isDisplayed())
                return true;
            else return false;
        }

    }
}
