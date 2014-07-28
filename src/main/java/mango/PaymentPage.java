package mango;

import mango.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class    PaymentPage extends abstractPage{
    public boolean isPaymentOptionsShown() {
        if (driver.findElement(By.xpath(".//*[@id='opc-payment_method']/div[1]/h2")).isDisplayed())  return true;
        else return false;
    }

    public void confirmOrderWithCashAfterDeliveryMethod() {
        //continue with cash on delivery payment method
        WebElement continuebutton4 = driver.findElement(By.xpath(".//*[@id='payment-method-buttons-container']/button[1]"));
        continuebutton4.click();
        //continue with payment information
        WebElement continuebutton5 = driver.findElement(By.xpath(".//*[@id='payment-info-buttons-container']/button[1]"));
        continuebutton5.click();
    }
    public void acceptTerms() {
        //click the terms and conditions checkbox
        WebElement terms = driver.findElement(By.id("termsofservice"));
        terms.click();
    }
    public void confirmOdrer(){
        //confirem the order
        WebElement confirm=driver.findElement(By.xpath(".//*[@id='confirm-order-buttons-container']/button[2]"));
        confirm.click();
        WaitUtils.pause(50);
    }
}
