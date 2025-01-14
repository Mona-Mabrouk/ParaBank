package com.parabank.base;

import com.parabank.config.BaseConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static com.parabank.utilities.PropertyFileReader.getProperty;

public class BaseTest extends BaseConfig {
    @BeforeTest
    public void startReport () {
        initializeReport();
    }
    @BeforeMethod
    public void setUp () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to(getProperty("application_url"));

    }
    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
    @AfterTest()
    public void endReport() {
        extent.flush();
    }
}
