package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement txtBoxEmail = $("#email");
    SelenideElement txtBoxPassword = $(byId("password"));
    SelenideElement buttonSignIn = $(byText("Bejelentkezés"));

    public WebShopPage loginAccount(String email, String password) {
        txtBoxEmail.setValue(email);
        txtBoxPassword.setValue(password);
        txtBoxPassword.pressEnter();
        return new WebShopPage();
    }

    public void validatePage() {
        txtBoxEmail.should(exist).shouldBe(visible).shouldBe(enabled);
        txtBoxPassword.should(exist).shouldBe(visible).shouldBe(enabled);
    }


}