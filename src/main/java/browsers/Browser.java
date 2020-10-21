package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Browser.class);

    public Browser() {
    }

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
            logger.info("Opening browser");
            return driver = new ChromeDriver();
        }
        return driver;
    }

    public void goTo(String url) {
        logger.info("Opening " + url);
        getDriver().get(url);
    }

    public void fullScreenMode() {
        logger.info("Making fullscreen Window");
        driver.manage().window().maximize();
    }

    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}