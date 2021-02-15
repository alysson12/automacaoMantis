package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public BasePage(){
        this.driver = new FirefoxDriver();
    }

    public void navigatePage(String url){
        driver.navigate().to(url);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void closeNavigate(){
        getDriver().close();
    }
}
