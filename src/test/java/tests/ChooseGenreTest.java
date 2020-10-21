package tests;

import browsers.Browser;
import configuration.Configuration;
import data.Genres;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OnlineCinemaPage;
import pages.PosterPage;

public class ChooseGenreTest extends BaseTest {

    private static final String MAIN_URL = Configuration.getData("mainUrl");
    private static final String ONLINE_CINEMA_URL = Configuration.getData("onlineCinemaUrl");
    private static final String ANIMATION_URL = Configuration.getData("animationOnlineCinemaUrl");
    private static final String MOVIE_GENRE = String.valueOf(Genres.HORROR);
    private static final String SERIES_GENRE = String.valueOf(Genres.DETECTIVE);
    private static final String CARTOON_GENRE = String.valueOf(Genres.ANIME);
    private Browser browser = new Browser();

    @Test
    @Parameters("movieGenre")
    public void testChooseMovieByGenre(String movieGenre) {
        browser.goTo(MAIN_URL);
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Main page didn't load");
        mainPage.clickOnPosterButton();
        PosterPage posterPage = new PosterPage();
        Assert.assertTrue(posterPage.isPosterPageLoaded(), "Poster page page didn't load");
        posterPage.clickOnOnlineCinemaButton();
        OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage();
        Assert.assertTrue(onlineCinemaPage.isOnlineCinemaPageLoaded(), "Online cinema page page didn't load");
        onlineCinemaPage.searchDesiredMovies(MOVIE_GENRE);
        Assert.assertTrue(onlineCinemaPage.isMoviesDesiredGenre(movieGenre));
    }

    @Test
    @Parameters("seriesGenre")
    public void testChooseSeriesByGenre(String seriesGenre) {
        browser.goTo(ONLINE_CINEMA_URL);
        OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage();
        Assert.assertTrue(onlineCinemaPage.isOnlineCinemaPageLoaded(), "Online cinema page page didn't load");
        onlineCinemaPage.clickOnSeriesButton();
        onlineCinemaPage.searchDesiredSeries(SERIES_GENRE);
        Assert.assertTrue(onlineCinemaPage.isMoviesDesiredGenre(seriesGenre));
    }

    @Test
    @Parameters("cartoonsGenre")
    public void testChooseCartoonsByGenre(String cartoonsGenre) {
        browser.goTo(ANIMATION_URL);
        OnlineCinemaPage onlineCinemaPage = new OnlineCinemaPage();
        Assert.assertTrue(onlineCinemaPage.isCartoonsTabActive(), "Cartoons tab is not active");
        onlineCinemaPage.searchDesiredCartoons(CARTOON_GENRE);
        Assert.assertTrue(onlineCinemaPage.isMoviesDesiredGenre(cartoonsGenre));
    }
}