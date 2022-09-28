package pages.imdbComPages;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePages {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(xpath = "//div[text()='Menu']")
    private WebElement menuBar;
    @FindBy(xpath = "//span[text()='Oscars']")
    private WebElement oscars;
    @FindBy(xpath = "//input[@id='suggestion-search']")
    private WebElement searchBox;
    @FindBy(xpath = "//button[@id='suggestion-search-button']")
    private WebElement searchBoxButton;

    public WebElement getMenuBar() {
        CustomElementWaits.waitUntilElementToClickable(driver,menuBar);
        return menuBar;
    }
    public WebElement getOscars() {
        CustomElementWaits.waitUntilElementToClickable(driver,oscars);
        return oscars;
    }

    public WebElement getSearchBox() {
        CustomElementWaits.waitUntilElementToClickable(driver,searchBox);
        return searchBox;
    }

    public WebElement getSearchBoxButton() {
        CustomElementWaits.waitUntilElementToClickable(driver,searchBoxButton);
        return searchBoxButton;
    }

    public void clickMenuBar(){
        getMenuBar().click();
    }
    public void clickOscars(){
        getOscars().click();
    }
    public void searchMovie(String movie){
        getSearchBox().sendKeys(movie);
        getSearchBoxButton().click();
    }
}
