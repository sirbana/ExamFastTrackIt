package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ShopPage extends PageObject {

    @FindBy(css = "ul.products > li > div.collection_desc > div.title-cart > a > h3")
    private WebElementFacade fistProduct;

    @FindBy(css="div.entry-summary> h1")
    private WebElementFacade productName;

    public void clickOnFirstProduct() {
        clickOn(fistProduct);
    }

    public void getProductName(){
        productName.getText();
    }
}
