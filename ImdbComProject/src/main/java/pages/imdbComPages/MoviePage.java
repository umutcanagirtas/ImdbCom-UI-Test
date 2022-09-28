package pages.imdbComPages;

import base.BasePages;
import helpers.ActionClass;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MoviePage extends BasePages {
    private final WebDriver driver;

    public MoviePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@data-testid='hero-rating-bar__aggregate-rating__score']/span[1]")
    private WebElement movieStars;
    @FindBy(xpath = "//div[3]/div[2]/div[1]/div[3]/ul[@role='presentation']/li[1]/div//a")
    private WebElement movieDirector;
    @FindBy(xpath = "//div[3]/ul[@role='presentation']/li[2]/div[@class='ipc-metadata-list-item__content-container']/ul/li")
    private List<WebElement> movieWriters;
    @FindBy(xpath = "//a[@id='home_img_holder']")
    private WebElement imdbButton;
    @FindBy(xpath = "//a[@href='/title/tt0018037/mediaindex/?ref_=tt_mi_sm']")
    private WebElement photos;


    public WebElement getPhotos() {
        CustomElementWaits.waitUntilElementToClickable(driver,photos);
        return photos;
    }

    public WebElement getMovieStars() {
        CustomElementWaits.waitUntilElementFind(driver, movieStars);
        return movieStars;
    }

    public WebElement getMovieDirector() {
        CustomElementWaits.waitUntilElementFind(driver, movieDirector);
        return movieDirector;
    }

    public List<WebElement> getMovieWriters() {
        CustomElementWaits.visibilityOfAllElements(driver, movieWriters);
        return movieWriters;
    }

    public WebElement getImdbButton() {
        CustomElementWaits.waitUntilElementToClickable(driver,imdbButton);
        return imdbButton;
    }

    public String getTextMovieStars() {
        return getMovieStars().getText();
    }

    public String  getTextMovieDirector() {
        return getMovieDirector().getText();
    }

    public List<String> getTextMovieWriters() {
        List<String> writers=new ArrayList<>();
        for(WebElement writer:getMovieWriters()){
            writers.add(writer.getText());
        }
        return writers;
    }

    public void clickImdbButton(){
        getImdbButton().click();
    }
    public void clickPhotos(){
        ActionClass.moveToElement(driver,getPhotos());
        getPhotos().click();
    }
}
