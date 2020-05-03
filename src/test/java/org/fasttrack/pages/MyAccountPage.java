package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa2.fasttrackit.org:8008/")
public class MyAccountPage extends PageObject {
    @FindBy(css = "p.woocommerce-form-row > #username")
    private WebElementFacade userNameField;

    @FindBy(css = "p.woocommerce-form-row > #password")
    private WebElementFacade passwordField;

    @FindBy(css = "button.woocommerce-Button[name='login']")
    private WebElementFacade loginButton;

    @FindBy(css="div.entry-content > div.woocommerce > ul>li")
    private WebElementFacade errorMessage;

    public void setUserNameField(String username) {
        typeInto(userNameField, username);
    }

    public void setPasswordField(String password) {
        typeInto(passwordField, password);
    }

    public void clickOnLoginButton() {
        clickOn(loginButton);
    }
    public boolean errorMessageIsDisplayed(String error){
        return errorMessage.containsOnlyText(error);
    }
}
