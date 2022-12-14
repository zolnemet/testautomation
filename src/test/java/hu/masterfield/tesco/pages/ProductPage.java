package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends WebShopPage {

    @Override
    public WebShopPage search(String productName) {
        inputSearch.clear();
        inputSearch.setValue(productName);
        inputSearch.pressEnter();
        return new WebShopPage();
    }


    @Override
    public void validateProduct(String productName) {
        SelenideElement product = $(byPartialLinkText(productName));
        product.should(exist);
    }

    public void validateIngredients(String productIngredient) {
        SelenideElement ingredient = $(byPartialLinkText(productIngredient));
        ingredient.should(exist);
    }

}
