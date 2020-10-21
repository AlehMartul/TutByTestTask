package tests;

import browsers.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private Browser browser = new Browser();

    @BeforeMethod
    public void createDriver() {
        Browser.getDriver();
        browser.fullScreenMode();
    }

    @AfterMethod
    public void afterTest() {
        {
            Browser.quitDriver();
        }
    }
}
