package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import waits.Waits;

import static org.apache.log4j.LogManager.getLogger;

public abstract class BasePage {

    private static final Logger logger = getLogger(BasePage.class);

    boolean isPageLoaded (WebElement element) {
        logger.info("Element is displayed");
        return new Waits().elementIsPresent(element);
    }
}