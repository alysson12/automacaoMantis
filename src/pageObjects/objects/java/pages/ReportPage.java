package pages;

import locators.LocatorReport;
import org.openqa.selenium.WebDriver;

public class ReportPage extends LoginPage{

    public ReportPage(WebDriver driver) {super (driver);}

    public boolean acessMyAccount (){

        getDriver().findElement(LocatorReport.myAccountLoc).click();
        if (getDriver().getCurrentUrl() == "https://mantis-prova.base2.com.br/my_view_page.php"){
            return true;
        }
        return false;

    }
}
