package testCases.imdbComTestCases.imdbComUITestCases;

import base.BaseClass;
import helpers.Listeners;
import httpRequest.HttpRequest;
import model.Movie;

import static org.junit.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.imdbComPages.*;
import retry.RetryAnalyzer;

import java.util.List;

@org.testng.annotations.Listeners(Listeners.class)
public class ImdbComUITestCases extends BaseClass {
    HomePage homePage;
    OscarsPage oscarsPage;
    MoviePage moviePage;
    SearchResultsPage searchResultsPage;
    PhotosPage photosPage;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        super.beforeMethod(browser);
        homePage = new HomePage(driver);
        oscarsPage = new OscarsPage(driver);
        moviePage = new MoviePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        photosPage = new PhotosPage(driver);
    }

    @AfterMethod
    public void terminateWebDriver() {
        super.afterMethod();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void searchMovieAssertSameInformation() {
        Movie movieFirst = new Movie();
        Movie movieSecond = new Movie();
        homePage.clickMenuBar();
        homePage.clickOscars();
        oscarsPage.clickEventYear();
        oscarsPage.clickMovie();
        movieFirst.setMovie(moviePage.getTextMovieDirector(),moviePage.getTextMovieStars(),moviePage.getTextMovieWriters());
        moviePage.clickImdbButton();
        homePage.searchMovie("The Jazz Singer");
        searchResultsPage.clickMovieResult();
        movieSecond.setMovie(moviePage.getTextMovieDirector(),moviePage.getTextMovieStars(),moviePage.getTextMovieWriters());
        assertEquals(movieFirst, movieSecond);
    }

    @Test(retryAnalyzer = retry.RetryAnalyzer.class)
    public void searchMovieAssertPhotos() {
        homePage.clickMenuBar();
        homePage.clickOscars();
        oscarsPage.clickEventYear();
        oscarsPage.clickMovie();
        moviePage.clickPhotos();
        List<String> brokenLinks=HttpRequest.httpRequestForLinks(photosPage.getPhotos());
        assertTrue(brokenLinks.isEmpty());
    }
}