package mango;

import mango.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends abstractPage {
    public void loginAsConsumer(String username, String password) {
        WebElement usernameText = driver.findElement(By.id("Username"));
        usernameText.sendKeys(username);
        WebElement passwordText = driver.findElement(By.id("Password"));
        passwordText.sendKeys(password);
        //Click on login button
        WebElement submit=driver.findElement(By.xpath(".//*[@id='content-center']/div/div[2]/div[1]/div[2]/div/div[2]/form/div[3]/div/div/button"));
        submit.click();
        WaitUtils.pause(50);
    }
}
