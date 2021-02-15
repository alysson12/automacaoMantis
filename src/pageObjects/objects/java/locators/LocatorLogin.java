package locators;

import org.openqa.selenium.By;

public class LocatorLogin {

    public static By usernameLoc = By.id("username");
    public static By passwordLoc = By.id("password");
    public static By buttonLoginLoc = By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td/input");

    public static By msgFakeLoginLoc = By.xpath("/html/body/div[2]/font");

}
