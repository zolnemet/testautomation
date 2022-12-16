package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.galenframework.api.Galen;
import com.galenframework.reports.model.LayoutReport;
import hu.masterfield.util.ReportGalen;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    public static final String COOKIE_ELFOGADÁSA = "Minden Cookie elfogadása";    
    String lang = null;

    SelenideElement buttonCookies = $(byText(COOKIE_ELFOGADÁSA));
    SelenideElement buttonLanguage = $(byId("utility-header-language-switch-link"));
    SelenideElement buttonSignIn = $(byId("utility-header-login-link"));

    public void acceptCoockies(){
        if (buttonCookies.isDisplayed()) {
            buttonCookies.click();
        }
    }

    public String getLang() {
        setLangvalue();
        return this.lang;
    }

    private void setLangvalue() {
        if (buttonLanguage.innerText().equals("Magyar")){
            this.lang = "English";
        }
        else if (buttonLanguage.innerText().equals("English")){
            this.lang = "Magyar";
        }
    }

    public void changeLang() {
        buttonLanguage.click();
    }

    public LoginPage openLogin(){
        buttonSignIn.click();
        return new LoginPage();
    }

    public void validatePage() {
        buttonLanguage.shouldBe(visible).shouldBe(enabled);
        buttonSignIn.shouldBe(visible).shouldBe(enabled);
    }

    public void validateCookiesAccepted() {
        buttonCookies.shouldNotBe(exist);
    }

    public void validateLayout () throws IOException {
        WebDriver driver = WebDriverRunner.getWebDriver();
        // Galen check layout
        LayoutReport layoutReport;
        layoutReport = Galen.checkLayout(driver, "/specs/homeLayout.gspec", Arrays.asList(new String[]{"desktop"}));
        ReportGalen.reportUpdate(layoutReport);

    }

}
