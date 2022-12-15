package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TrolleyPage {

    SelenideElement header = $("h1");
    SelenideElement orderSummaryPrice = $("trolley-order-summary--guide-price-row");
    SelenideElement orderSummary = $("styled__StyledDT-sc-1pmbx0m-1 ifzMBp>dd");
    SelenideElement buttonAdd = $("styled__BaseButton-rsekm1-0 styled__PrimaryButton-rsekm1-2 hEjuKw geeWOF styled__StyledButton-vtxwzb-5 hOByRi beans-quantity-controls__add-button beans-button__container");
    SelenideElement buttonMinus = $("styled__BaseButton-rsekm1-0 styled__SecondaryButton-rsekm1-3 hEjuKw iFkcax styled__StyledButton-vtxwzb-5 dKynKM beans-quantity-controls__remove-button beans-button__container");
    SelenideElement buttonEmptyTrolley = $(".empty-trolley>a");

    SelenideElement buttonYes = $(byText("Törlés"));
    SelenideElement emptySection = $("div.empty-section--heading");


    public String getOrderSummaryPrice() {
        return orderSummaryPrice.innerText();
    }

    public String getOrderSummary() {
        return orderSummary.innerText();
    }

    public void increaseWith(int num) {
        for (int i = 0; i < num; i++) {
            buttonAdd.click();
        }
    }

    public void decreaseWith(int num) {
        for (int i = 0; i < num; i++) {
            buttonMinus.click();
        }
    }

    public void emptyTrolley() {
        if (buttonEmptyTrolley.exists()) {
            buttonEmptyTrolley.click();
            SelenideElement buttonYes = $(byText("Törlés"));
            if (buttonYes.exists()) {
                buttonYes.click();
            }
        }
    }

    public void validatePage(String trolley_name) {
        header.innerText().equals(trolley_name);
    }

    public void validateEmptyTrolley() {
        emptySection = $("div.empty-section--heading");
        emptySection.shouldBe(visible);
    }

    public void validateProduct (String productName) {
        SelenideElement product = $(byPartialLinkText(productName));
        product.should(exist);
        System.out.println(product.innerText());
    }


}
