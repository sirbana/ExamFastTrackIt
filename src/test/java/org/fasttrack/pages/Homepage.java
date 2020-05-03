package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa2.fasttrackit.org:8008/")
public class Homepage extends PageObject {


    @FindBy(css = "#primary-menu > li a[href$='page_id=4']")
    private WebElementFacade shopButton;

    @FindBy(css = "#primary-menu > li > a[href$='page_id=7']")
    private WebElementFacade myAccountButton;

    @FindBy(css = "div.right-links >div.header-search > a[href*='javascript']")
    private WebElementFacade searchButton;

    @FindBy(css = "div.search-box>form>input")
    private WebElementFacade searchField;

    @FindBy(css="button.searchsubmit>i")
    private WebElementFacade searchButtonInSearchField;

    public void clickShopButton() {
        clickOn(shopButton);

    }

    public void clickOnMyAccountButton() {
        clickOn(myAccountButton);
    }

    public void clickOnSearchButton() {
        clickOn(searchButton);
    }

    public void clickOnSearchField() {
        clickOn(searchField);
    }

    public void typeIntoSearchField(String text) {
        searchField.sendKeys(text);
    }
    public void clickOnSearchButtonInSearchField(){
        clickOn(searchButtonInSearchField);
    }
}
