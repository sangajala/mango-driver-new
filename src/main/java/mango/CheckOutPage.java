package mango;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class    CheckOutPage extends abstractPage {
    public void gotoPayment() {

        //continue with billing address
        WebElement continuebutton1=driver.findElement(By.xpath(".//*[@id='billing-buttons-container']/button"));
        continuebutton1.click();
        //continue with shipping address
        WebElement continuebutton2=driver.findElement(By.xpath(".//*[@id='shipping-buttons-container']/button[1]"));
        continuebutton2.click();
        //continue with deafault DHL delivery method
        WebElement continuebutton3=driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button[1]"));
        continuebutton3.click();



}
}
