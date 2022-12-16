package hu.masterfield.tesco.unittest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.galenframework.api.Galen;
import com.galenframework.junit.GalenJUnitTestBase;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import hu.masterfield.tesco.pages.HomePage;
import hu.masterfield.tesco.pages.LoginPage;
import hu.masterfield.tesco.pages.WebShopPage;
import hu.masterfield.tesco.steps.TescoSteps;
import hu.masterfield.util.Crypting;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.open;
import static hu.masterfield.tesco.TestData.testData;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LayoutDesktopSteps extends GalenJUnitTestBase {

    WebDriver driver;
    String baseUrl = testData.getProperty("testUrl");
    HomePage homePage;
    LoginPage loginPage;
    WebShopPage webShopPage;
    LayoutReport layoutReport;

    @BeforeAll
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        System.setProperty("wdm.proxy", "HE202196.emea2.cds.t-internal.com:3128");
        //options.setHeadless(true);
        //WebDriverManager.chromedriver().setup();
        //Configuration.browserCapabilities = options;
        this.driver = new ChromeDriver(options);
        createDriver(); // set driver for Galen FW
    }

    @After
    public void cleanup() {
        Selenide.clearBrowserCookies();
    }

    @Override
    public WebDriver createDriver() {
        super.driver.set(this.driver);
        return this.driver;
    }

    @Test
    @DisplayName("TC1 - Tesco home page layout test")
    public void testHomePage() throws IOException {
        homePage = open(baseUrl, HomePage.class);
        homePage.validatePage();
        homePage.validateLayout();
    }

    @Test
    @DisplayName("TC2 - Tesco webshop page layout test")
    public void testWebShopPage() throws IOException {
        homePage = open(baseUrl, HomePage.class);
        homePage.validatePage();
        homePage.acceptCoockies();

        if (!homePage.getLang().equals("Magyar")) {
            homePage.changeLang();
        }
        System.out.println(homePage.getLang());
        loginPage = homePage.openLogin();
        //loginPage.validatePage();
        String testUser = testData.getProperty("testUser");
        String codedTestPass = testData.getProperty("testPass");
        String testPass = Crypting.decrypt("Bar12345Bar12345", "RandomInitVector", codedTestPass);
        webShopPage = loginPage.loginAccount(testUser, testPass);
        webShopPage = webShopPage.search("bor");
        webShopPage.validateProduct("bor");

        webShopPage.validateLayout();
    }
}
