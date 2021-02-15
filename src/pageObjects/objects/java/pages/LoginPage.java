package pages;

import org.openqa.selenium.WebDriver;
import locators.LocatorLogin;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super (driver);
    }

    public void loginTest(String userName, String userPass){

        executeLogin(userName, userPass);

    }

    public ReportPage login(String userName, String userPass) {

        executeLogin(userName, userPass);
        return new ReportPage(getDriver());

    }

    private void executeLogin (String userName, String userPass){

        getDriver().findElement(LocatorLogin.usernameLoc).clear();
        getDriver().findElement(LocatorLogin.usernameLoc).sendKeys(userName);

        getDriver().findElement(LocatorLogin.passwordLoc).clear();
        getDriver().findElement(LocatorLogin.passwordLoc).sendKeys(userPass);

        getDriver().findElement(LocatorLogin.buttonLoginLoc).click();

    }

}
