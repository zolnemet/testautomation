package hu.masterfield.tesco.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebShopPage {

    String lang = null;

    SelenideElement buttonCookies = $(byText("Minden Cookie elfogadása"));
    //SelenideElement buttonCookies = $(byClassName("base-components__BaseElement-sc-1mosoyj-0 styled__TextSpan-rsekm1-4 oznwo GDiMp beans-button__text"));

    SelenideElement buttonLanguage = $(byId("utility-header-language-switch-link"));
//    SelenideElement buttonLanguageHu = $(byLinkText("Magyar"));
//    SelenideElement buttonLanguageEn = $(byLinkText("English"));
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

}
