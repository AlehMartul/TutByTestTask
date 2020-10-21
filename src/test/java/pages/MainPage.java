package pages;

import browsers.Browser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(MainPage.class);
    private static final String XPATH_OF_POSTER = "//a[contains (@href,'menu_www.tut.by~75')]";
    private WebElement btnPoster = Browser.getDriver().findElement(By.xpath(XPATH_OF_POSTER));

    public boolean isMainPageLoaded() {
        logger.info("Checking is main page loaded");
        return isPageLoaded(btnPoster);
    }

    public void clickOnPosterButton() {
        logger.info("Clicking on the cinema button");
        btnPoster.click();
    }
}
