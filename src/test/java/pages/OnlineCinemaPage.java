package pages;

import browsers.Browser;
import methods.OtherMethods;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnlineCinemaPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(OnlineCinemaPage.class);
    private static final String XPATH_OF_TOP_LOGO = "//a[contains(@href,'top-logo')]";
    private static final String FIRST_PART_OF_XPATH_FILMS = "//div[@id='tab-films']";
    private static final String FIRST_PART_OF_XPATH_SERIES = "//div[@id='tab-tv-series']";
    private static final String FIRST_PART_OF_XPATH_CARTOONS = "//div[@id='tab-cartoons']";
    private static final String SECOND_PART_OF_XPATH_GENRES = "//button[@title='Жанры']";
    private static final String SECOND_PART_OF_XPATH_DESIRED_GENRES = "//span[contains(text(),'%s')]";
    private static final String XPATH_OF_SERIES = "//a[contains(@href, 'serial')]";
    private static final String XPATH_OF_MOVIE_INFO = "//div[@class = 'txt']//p";
    private WebElement lblTopLogo = Browser.getDriver().findElement(By.xpath(XPATH_OF_TOP_LOGO));
    private WebElement btnFilms = Browser.getDriver().findElement(By.xpath(FIRST_PART_OF_XPATH_FILMS
            + SECOND_PART_OF_XPATH_GENRES));
    private WebElement sltSeries = Browser.getDriver().findElement(By.xpath(FIRST_PART_OF_XPATH_SERIES
            + SECOND_PART_OF_XPATH_GENRES));
    private WebElement btnSeries = Browser.getDriver().findElement(By.xpath(XPATH_OF_SERIES));
    private WebElement sltCartoons = Browser.getDriver().findElement(By.xpath(FIRST_PART_OF_XPATH_CARTOONS
            + SECOND_PART_OF_XPATH_GENRES));

    public boolean isOnlineCinemaPageLoaded() {
        logger.info("Checking is online cinema page loaded");
        return isPageLoaded(lblTopLogo);
    }

    public boolean isCartoonsTabActive() {
        logger.info("Checking is cartoons tab active");
        return isPageLoaded(sltCartoons);
    }

    private WebElement btnDesiredMoviesGenre(String genre) {
        return Browser.getDriver().findElement(By.xpath(FIRST_PART_OF_XPATH_FILMS
                + String.format(SECOND_PART_OF_XPATH_DESIRED_GENRES, genre)));
    }

    private WebElement btnDesiredSeriesGenre(String genre) {
        return Browser.getDriver().findElement(By.xpath(FIRST_PART_OF_XPATH_SERIES
                + String.format(SECOND_PART_OF_XPATH_DESIRED_GENRES, genre)));
    }

    private WebElement btnDesiredCartoonGenre(String genre) {
        return Browser.getDriver().findElement(By.xpath(FIRST_PART_OF_XPATH_CARTOONS
                + String.format(SECOND_PART_OF_XPATH_DESIRED_GENRES, genre)));
    }

    private List<WebElement> getMovieList() {
        logger.info("Getting list of chosen movies");
        return Browser.getDriver().findElements(By.xpath(XPATH_OF_MOVIE_INFO));
    }

    public boolean isMoviesDesiredGenre(String genre) {
        logger.info("Checking is chosen movies are " + genre);
        return OtherMethods.isElementContainsText(getMovieList(), genre);
    }

    private void clickOnMovieDropDown() {
        logger.info("Clicking on the dropdown button");
        btnFilms.click();
    }

    private void clickOnSeriesDropDown() {
        logger.info("Clicking on the dropdown button");
        sltSeries.click();
    }

    public void clickOnSeriesButton() {
        logger.info("Clicking on the series tab");
        btnSeries.click();
    }

    private void clickOnCartoonsDropDown() {
        logger.info("Clicking on the dropdown button");
        sltCartoons.click();
    }

    public void searchDesiredMovies(String genre) {
        clickOnMovieDropDown();
        logger.info("Choosing " + genre + " from dropdown");
        btnDesiredMoviesGenre(genre).click();
    }

    public void searchDesiredSeries(String genre) {
        clickOnSeriesDropDown();
        logger.info("Choosing " + genre + " from dropdown");
        btnDesiredSeriesGenre(genre).click();
    }

    public void searchDesiredCartoons(String genre) {
        clickOnCartoonsDropDown();
        logger.info("Choosing " + genre + " from dropdown");
        btnDesiredCartoonGenre(genre).click();
    }
}
