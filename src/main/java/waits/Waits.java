package waits;

import browsers.Browser;
import configuration.Configuration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waits {

    private static final int TIMEOUT = Integer.parseInt(Configuration.getData("timeout"));

    public Waits() {
    }

    public boolean elementIsPresent(WebElement element) {
        return new WebDriverWait(Browser.getDriver(), TIMEOUT).
                until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
}
