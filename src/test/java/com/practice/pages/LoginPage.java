package com.practice.pages;

import com.practice.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    //To not use web elements directly in step definition classes
    //helps to prevent code duplication and keep step definitions clean
    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password; // private because we don't want to extend this method, therefore it will be more less mess

    @FindBy(css = "[class ='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText() throws InterruptedException {
        Thread.sleep(5000);
        return warningMessage.getText().trim();

    }

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER); // THIS MEANS LOGIN BUTTON CLICK
    }

    public void login() {
        String usernameValue = ConfigurationReader.getProperty("storemanager.username"); // command bottom to see the value
        String passwordValue = ConfigurationReader.getProperty("password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String role) {

        String usernameValue = "";
        String passwordValue = ConfigurationReader.getProperty("password");

        if (role.equalsIgnoreCase("sales manager")) {
            usernameValue = ConfigurationReader.getProperty("salesmanager.username");
        } else if (role.equalsIgnoreCase("driver")) {
            usernameValue = ConfigurationReader.getProperty("driver.username");
        } else {
            usernameValue = ConfigurationReader.getProperty("storemanager.username");
        }


        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

}
