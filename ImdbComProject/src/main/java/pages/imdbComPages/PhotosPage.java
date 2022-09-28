package pages.imdbComPages;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PhotosPage extends BasePages {
    private final WebDriver driver;
    public PhotosPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @FindBy(xpath = "//div[@id='media_index_thumbnail_grid']/a")
    private List<WebElement> photos;

    public List<WebElement> getPhotos() {
        CustomElementWaits.visibilityOfAllElements(driver,photos);
        return photos;
    }
}
