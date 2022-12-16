package hu.masterfield.tesco.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import hu.masterfield.tesco.pages.*;
import hu.masterfield.util.Crypting;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static hu.masterfield.tesco.TestData.testData;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TescoSteps {

    String baseUrl = testData.getProperty("testUrl");
    HomePage homePage;
    LoginPage loginPage;
    WebShopPage webShopPage;
    ProductPage productPage;
    TrolleyPage trolleyPage;

//    @RegisterExtension
//    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        System.setProperty("wdm.proxy", "HE202196.emea2.cds.t-internal.com:3128");
        //options.setHeadless(true);
        //WebDriverManager.chromedriver().setup();
        Configuration.browserCapabilities = options;
        //Configuration.reportsFolder = "target/screenshots";
    }

    @After
    public void cleanup() {
        Selenide.clearBrowserCookies();
    }

//    @AfterAll
//    public void quit() {
//        Selenide.closeWindow();
//    }

    @Given("open the main page")
    public void openTheMainPage() throws InterruptedException {
        homePage = open(baseUrl, HomePage.class);
        homePage.validatePage();
    }

    @And("accept cookies")
    public void acceptCookies() throws InterruptedException {
        homePage.acceptCoockies();
        homePage.validateCookiesAccepted();
    }

    @Given("language is set to {string}")
    public void setLanguageTo(String lang) {
        if (!homePage.getLang().equals(lang)) {
            homePage.changeLang();
        }
    }

    @When("change the language to {string}")
    public void changeTheLanguageTo(String lang) {
        setLanguageTo(lang);
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn(String lang) {
        assertEquals(lang, homePage.getLang());
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage = homePage.openLogin();
        loginPage.validatePage();
    }

    @When("I login account with {string} and {string}")
    public void loginWith(String email, String password) {
        webShopPage = loginPage.loginAccount(email, password);
    }

    @And("login as test user")
    public void loginAsTestUser() throws InterruptedException {
        iAmOnTheLoginPage();
        String testUser = testData.getProperty("testUser");
        String codedTestPass = testData.getProperty("testPass");
        String testPass = Crypting.decrypt("Bar12345Bar12345", "RandomInitVector", codedTestPass);
        loginWith(testUser, testPass);
    }

    @Then("I am on the webshop page")
    public void iAmOnTheWebshopPage() {
        webShopPage.validatePage();
    }

    @And("I should see the Trolley icon")
    public void isTrolleyIconVisible() {
        webShopPage.validateTrolley();
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        iAmOnTheWebshopPage();
        isTrolleyIconVisible();
    }

    @When("I sign out")
    public void signOut() {
        homePage = webShopPage.logout();
        homePage.validatePage();
    }

    @Then("No trolley accessible")
    public void noTrolleyAccessible() {
        webShopPage.validateMissingTrolley();
    }

    @When("I search for a product with {string}")
    public void searchProductWith(String productName) {
        webShopPage = webShopPage.search(productName);
        webShopPage.validateProduct(productName);
    }

    @Then("I can see the {string} in results")
    public void isProductInResults(String productName) {
        webShopPage.validateProduct(productName);
    }

    @When("I open {string} detail")
    public void openProductDetail(String productName) {
        productPage = webShopPage.clickOnProductName(productName);
    }

    @And("I am on the product page")
    public void iAmOnTheProductPage() {
        productPage.validatePage();
    }

    @Then("I can see the {string} on the product details page")
    public void isProductOnDetailsPage(String productName) {
        productPage.validateProduct(productName);
    }

    @And("I can see the {string} of the product")
    public void isProductIngredientsVisible(String productIngredient) {
        productPage.validateIngredients(productIngredient);
    }


    @When("I open shopping trolley")
    public void openShoppingTrolley() throws InterruptedException {
        trolleyPage = productPage.clickOnTrolley();
        Thread.sleep(5000);
    }

    @Then("I am on the {string} page")
    public void iAmOnTheTrolleyPage(String header) {
        trolleyPage.validatePage(header);
    }

    @When("I remove items from the trolley")
    public void removeItemsFromTrolley() {
        trolleyPage.emptyTrolley();
    }

    @Then("I can see that trolley is empty")
    public void iCanSeeThatTrolleyIsEmpty() {
        trolleyPage.validateEmptyTrolley();
    }

    @When("I add {integer} of {string} to the Trolley")
    public void addProductToTrolley(String quantity, String productName) {
        int quantityInt = Integer.valueOf(quantity);
        searchProductWith(productName);
        openProductDetail(productName);
        iAmOnTheProductPage();
        isProductOnDetailsPage(productName);
        productPage.addProduct(quantityInt);
    }

    @Then("the {string} is added to my {string}")
    public void isProductAddedToTrolley(String productName, String header) {
        trolleyPage.validatePage(header);
        trolleyPage.validateProduct(productName);
    }
}
