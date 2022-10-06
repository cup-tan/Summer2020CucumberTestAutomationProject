package com.practice.pages;

import com.practice.utils.BrowserUtils;
import com.practice.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCarPage extends BasePage{

@FindBy(css = "[title='Create Car']")
    private WebElement createCarBtn;

@FindBy(name = "custom_entity_type[LicensePlate]")
    private WebElement licensePlateInputBox;

    @FindBy(name = "custom_entity_type[ModelYear]")
    private  WebElement modelYearInputBox;

public void clickOnCreateCar(){
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
    wait.until(ExpectedConditions.elementToBeClickable(createCarBtn)).click();
    System.out.println("Clicking on 'Create Car' button");
}
public  void enterLicensePlate(String licensePlate){
    BrowserUtils.enterText(licensePlateInputBox, licensePlate);
/*    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
    wait.until(ExpectedConditions.visibilityOf(licensePlateInputBox));
    licensePlateInputBox.clear();
    licensePlateInputBox.sendKeys(licensePlate);
 */
    //sometimes, for every longs string webDriver might enter text not fully.
}


public void enterModelYear(String modelYear){
    BrowserUtils.enterText(modelYearInputBox, modelYear);
}
}
