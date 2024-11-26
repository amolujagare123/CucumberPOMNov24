package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static stepdefinitions.SharedSD.getDriver;

public class Base {
  //  WebDriver driver;


    WebElement webAction(By locator)
    {
        return getDriver().findElement(locator);
    }

    void clickOn(By locator)
    {
        webAction(locator).click();
    }

    void setValue(By locator,String value)
    {
        webAction(locator).sendKeys(value);
    }
}
