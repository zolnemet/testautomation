package hu.masterfield.tesco.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import hu.masterfield.tesco.pages.LoginPage;
import hu.masterfield.tesco.pages.ProductsPage;
import hu.masterfield.tesco.pages.WebShopPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TescoSteps {

    String baseUrl =  "https://bevasarlas.tesco.hu/groceries/hu-HU";
    WebShopPage webShopPage;
    LoginPage loginPage;
    ProductsPage productsPage;

//    @RegisterExtension
//    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        System.setProperty("wdm.proxy", "HE202196.emea2.cds.t-internal.com:3128");
        Configuration.browserCapabilities = options;
        //Configuration.reportsFolder = "target/screenshots";
    }

    @After
    public void cleanup () {
    }

    @Given("open the main page")
    public void openTheMainPage() throws InterruptedException {
        webShopPage = open (baseUrl, WebShopPage.class);
        webShopPage.validatePage();
    }

    @And("accept cookies")
    public void acceptCookies() throws InterruptedException {
        webShopPage.acceptCoockies();
        webShopPage.validateCookiesAccepted();
    }

    @Given("language is set to {string}")
    public void languageIsSetTo(String lang) {
        if (!webShopPage.getLang().equals(lang)) {
            webShopPage.changeLang();
        }
    }

    @When("change the language to {string}")
    public void changeTheLanguageTo(String lang) {
        languageIsSetTo(lang);
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn(String lang) {
        assertEquals(lang, webShopPage.getLang());
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage = webShopPage.openLogin();
        loginPage.validatePage();
    }

    @When("I login account with {string} and {string}")
    public void loginAccountWith(String email, String password) {
        productsPage = loginPage.loginAccount(email,password);
    }

    @Then("I am on the products page")
    public void iAmOnTheProductsPage() {
        productsPage.validatePage();
    }

    @And("I should see the Trolley icon")
    public void iShouldSeeTheTrolleyIcon() {
        productsPage.validateTrolley();
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        iAmOnTheProductsPage();
        iShouldSeeTheTrolleyIcon();
    }

    @When("I sign out")
    public void signOut() {
        webShopPage = productsPage.logout();
        webShopPage.validatePage();
    }


    @Then("No trolley accessible")
    public void noTrolleyAccessible() {
        productsPage.validateMissingTrolley();
    }

    @And("user login")
    public void userLogin() {
        iAmOnTheLoginPage();
        loginAccountWith("zoltan.n@freemail.hu", "teszt.01");
    }
}
