package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

import static base.Constants.BASE_URL;


public class BaseClass {
    public static WebDriver driver;

    @Parameters({"browser"})
    public void beforeMethod(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
           buildUpFirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            buildUpChromeDriver();
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
        driver.navigate().to(BASE_URL);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    private void buildUpFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.desktop-notification", 1);
        DesiredCapabilities capabilities=DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(capabilities);
    }
    private void buildUpChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    public void afterMethod() {
        driver.quit();
    }
}