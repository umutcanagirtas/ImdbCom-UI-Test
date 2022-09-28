package pages.imdbComPages;

import base.BasePages;
import helpers.ActionClass;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OscarsPage extends BasePages {
    private final WebDriver driver;
    public OscarsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @FindBy(xpath = "//a[text()='1929']")
    private WebElement eventYear;
    @FindBy(xpath = "(//a[text()='The Jazz Singer'])[last()]")
    private WebElement movie;

    public WebElement getEventYear() {
        CustomElementWaits.waitUntilElementToClickable(driver,eventYear);
        return eventYear;
    }

    public WebElement getMovie() {
        CustomElementWaits.waitUntilElementFind(driver,movie);
        return movie;
    }

    public void clickEventYear(){
        getEventYear().click();
    }
    public void clickMovie(){
        ActionClass.moveToElement(driver,getMovie());
        getMovie().click();
    }
}
