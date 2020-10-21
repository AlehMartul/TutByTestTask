package pages;

import browsers.Browser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PosterPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(PosterPage.class);
    private static final String XPATH_OF_ONLINE_CINEMA = "//a[contains(@href, 'online-cinema')]";
    private WebElement btnFilms = Browser.getDriver().findElement(By.xpath(XPATH_OF_ONLINE_CINEMA));

    public boolean isPosterPageLoaded() {
        logger.info("Checking is poster page loaded");
        return isPageLoaded(btnFilms);
    }

    public void clickOnOnlineCinemaButton() {
        logger.info("Clicking on the cinema button");
        btnFilms.click();
    }
}
