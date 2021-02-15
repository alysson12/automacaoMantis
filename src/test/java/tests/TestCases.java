package tests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.BasePage;
import pages.LoginPage;
import pages.ReportPage;
import java.util.Properties;

/**
 * The Test Class
 *
 * @author Alysson Pereira
 * @version 1.0
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCases {

    protected BasePage basePage = new BasePage();
    protected LoginPage loginPage;
    protected ReportPage reportPage;

    protected Properties properties = new Properties();

    public String urlMantis = new String();
    public String user = new String();
    public String pass = new String();

    @BeforeClass
    public static void start(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
    }

    @Test
    public void t1_RealLogin(){

        realParameters();
        acessLoginPage();
        dataLoginUser();
        boolean validator = dataLoginUser();
        Assert.assertTrue(validator);
        closeNavigator();


    }

    @Test
    public void t2_FakeLogin(){

        fakeParameters();
        acessLoginPage();
        boolean validator = dataLoginUser();
        Assert.assertFalse(validator);
        closeNavigator();

    }

    public void realParameters() {

        /**
         * Método responsável por carregar os dados relacionados ao Login Real
         * @param properties - Propriedades carregadas do arquivo properties
         * @param urlMantis - URL de acesso ao Mantis
         * @param user - Usuário para Login
         * @param pass - Senha para Login
         */

        try{
            properties.load(TestCases.class.getResourceAsStream("/application.properties"));
            urlMantis = properties.getProperty("urlMantis");
            user = properties.getProperty("userName");
            pass = properties.getProperty("userPass");
        } catch (Exception e){
            throw new RuntimeException("Erro ao carregar as propriedades de conexão! " + e.getMessage(), e);
        }

    }

    public void fakeParameters() {

        /**
         * Método responsável por carregar os dados relacionados ao Login Fake
         * @param properties - Propriedades carregadas do arquivo properties
         * @param urlMantis - URL de acesso ao Mantis
         * @param user - Usuário para Login
         * @param pass - Senha para Login
         */

        try {
            properties.load(TestCases.class.getResourceAsStream("/application.properties"));
            urlMantis = properties.getProperty("urlMantis");
            user = properties.getProperty("userNameFake");
            pass = properties.getProperty("userPassFake");
        } catch (Exception e){
            throw new RuntimeException("Erro ao carregar as propriedades de conexão! " + e.getMessage(), e);
        }

    }

    private void acessLoginPage(){
        this.basePage.navigatePage(urlMantis);
    }

    private void executeLogin (){
        this.loginPage = new LoginPage(this.basePage.getDriver());
        loginPage.login(user, pass);
    }

    private boolean dataLoginUser(){
        this.loginPage = new LoginPage(this.basePage.getDriver());
        this.reportPage = loginPage.login(user, pass);
        boolean validate = reportPage.acessMyAccount();
        return validate;
    }

    private void closeNavigator() {
        this.basePage.closeNavigate();
    }


}
