package hu.masterfield.tesco.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import hu.masterfield.tesco.pages.LoginPage;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TescoSteps {

    String baseUrl =  "https://bevasarlas.tesco.hu/groceries/hu-HU";
    WebShopPage webShopPage;
    LoginPage loginPage;

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");

    @Before
    public void setup() {
        System.setProperty("wdm.proxy", "HE202196.emea2.cds.t-internal.com:3128");
        Configuration.reportsFolder = "target/screenshots";
    }

    @After
    public void cleanup () {
    }


    @Given("open the main page")
    public void openTheMainPage() throws InterruptedException {
        webShopPage = open (baseUrl, WebShopPage.class);
        Thread.sleep(5000);
        webShopPage.validatePage();
        Thread.sleep(5000);
    }

    @And("accept cookies")
    public void acceptCookies() throws InterruptedException {
        webShopPage.acceptCoockies();
        webShopPage.validateCookiesAccepted();
        Thread.sleep(5000);
    }

    @Given("language is set to {string}")
    public void languageIsSetTo(String lang) {
        if (webShopPage.getLang().equalsIgnoreCase(lang)) {
            webShopPage.changeLang();
        }
    }

    @When("change the language to {string}")
    public void changeTheLanguageTo(String lang) throws Throwable {
        languageIsSetTo(lang);
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn(String lang) {
        assertEquals(lang, webShopPage.getLang());
    }

}
