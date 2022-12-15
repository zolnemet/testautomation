package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage extends WebShopPage {

    SelenideElement productTitle = $(".product-details-tile__title");
    SelenideElement productIngredient = $(".longTextItems>p");
    SelenideElement buttonAdd = $("button small add-control button-secondary > span");

    @Override
    public WebShopPage search(String productName) {
        inputSearch.clear();
        inputSearch.setValue(productName);
        inputSearch.pressEnter();
        return new WebShopPage();
    }

    public void addProduct(int quantity) {
        for (int i = 0; i < quantity; i++) {
            buttonAdd.click();
        }
    }

    @Override
    public void validateProduct(String productName) {
        productTitle.shouldBe(visible);
        productTitle.innerText().contains(productName);
    }

    public void validateIngredients(String productDescription) {
        productIngredient.should(visible);
        productIngredient.innerText().contains(productDescription);
    }

}
