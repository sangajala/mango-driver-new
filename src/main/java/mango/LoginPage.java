package mango;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: sriramangajala
 * Date: 20/07/2014
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends abstractPage {
    public void loginAsConsumer(String username, String password) {
        WebElement usernameText = driver.findElement(By.id("username"));
        usernameText.sendKeys(username);
        WebElement passwordText = driver.findElement(By.id("Password"));
        passwordText.sendKeys(password);
    }
}
