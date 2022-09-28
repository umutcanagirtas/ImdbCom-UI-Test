package pages.imdbComPages;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePages {
    private final WebDriver driver;
    public SearchResultsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @FindBy(xpath = "//a[@href='/title/tt0018037/?ref_=fn_al_tt_1']")
    private WebElement movie;

    public WebElement getMovie() {
        CustomElementWaits.waitUntilElementToClickable(driver,movie);
        return movie;
    }

    public void clickMovieResult(){
        getMovie().click();
    }
}
