package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SharedSD {
    static WebDriver driver ;
    @Before
    public void openURL()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");
    }

    @After
    public void closeBrowser()
    {
      //  driver.close();
    }

   public  static WebDriver getDriver()
    {
        return driver;
    }
}

