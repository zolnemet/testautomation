package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.$;

public class WebShopPage {

    SelenideElement buttonGreetings = $(byId("utility-header-greetings"));
    SelenideElement inputSearch = $(byId("search-input"));
    SelenideElement buttonLogout = $(byId("utility-header-logout-link"));
    SelenideElement objectMiniTrolley = $(byId("mini-trolley"));

    public WebShopPage search (String productName) {
        inputSearch.clear();
        inputSearch.setValue(productName);
        inputSearch.pressEnter();
        return new WebShopPage();
    }

    public HomePage logout(){
        buttonLogout.click();
        return new HomePage();
    }

    public void validatePage() {
        buttonLogout.shouldBe(visible).shouldBe(enabled);
        buttonGreetings.shouldBe(visible).shouldBe(enabled);
        inputSearch.shouldBe(visible).shouldBe(enabled);
    }

    public void validateProduct (String productName) {
        SelenideElement product = $(byPartialLinkText(productName));
        product.should(exist);
        //System.out.println(product.innerText());
    }

    public ProductPage clickOnProductName(String productName) {
        SelenideElement product = $(byPartialLinkText(productName));
        product.should(exist);
        return new ProductPage();
    }

    public boolean validateUserLoggedIn () {
        return buttonLogout.isDisplayed();
    }

    public void validateTrolley() {
        objectMiniTrolley.should(exist).shouldBe(visible);
    }

    public void validateMissingTrolley() {
        objectMiniTrolley.shouldNot(exist);
    }

}
