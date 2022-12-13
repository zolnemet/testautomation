package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    SelenideElement buttonGreetings = $(byId("utility-header-greetings"));
    SelenideElement inputSearch = $(byId("search-input"));
    SelenideElement buttonLogout = $(byId("utility-header-logout-link"));
    SelenideElement objectMiniTrolley = $(byId("mini-trolley"));


    public WebShopPage logout(){
        buttonLogout.click();
        return new WebShopPage();
    }

    public void validatePage() {
        buttonGreetings.should(exist).shouldBe(visible).shouldBe(enabled);
        inputSearch.should(exist).shouldBe(visible).shouldBe(enabled);
    }

    public void validateTrolley() {
        objectMiniTrolley.should(exist).shouldBe(visible);
    }

    public void validateMissingTrolley() {
        objectMiniTrolley.shouldNot(exist);
    }

}
