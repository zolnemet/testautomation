package hu.masterfield.tesco.unittest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.galenframework.api.Galen;
import com.galenframework.junit.GalenJUnitTestBase;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import hu.masterfield.tesco.TestDevice;
import hu.masterfield.tesco.pages.HomePage;
import hu.masterfield.tesco.pages.LoginPage;
import hu.masterfield.tesco.pages.WebShopPage;
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
    public void test() throws IOException {


    }
}
