package org.fasttrack.features.search;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.serenity.CartSteps;
import org.fasttrack.steps.serenity.LoginSteps;
import org.fasttrack.steps.serenity.ShopSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

@RunWith(SerenityRunner.class)
public class CartTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private CartSteps cartSteps;
    @Steps
    private ShopSteps shopSteps;

    @Before
    public void navigateToShop(){
        loginSteps.navigateToHomepage();
        shopSteps.clickOnShopButton();
    }

    @Test
    public void addToCartOneProduct() {
        cartSteps.clickOnFirstCartButton();
        cartSteps.hooverOverCartPopUp(driver);
        cartSteps.selectViewCartFromPopUp();
        cartSteps.checkProductName("Album");
        cartSteps.checkQuantityDropDown("1");

    }
    @Test
    public void checkUpdateCartButton(){
        cartSteps.clickOnFirstCartButton();
        cartSteps.hooverOverCartPopUp(driver);
        cartSteps.selectViewCartFromPopUp();
        cartSteps.increaseQuantity("5");
        cartSteps.clickOnUpdateCartButton();
        cartSteps.checkQuantityDropDown("5");
        cartSteps.checkUpdatedCartMessage("Cart updated.");
    }

    @Test
    public void checkCorrectPrice(){
        cartSteps.clickOnFirstCartButton();
        cartSteps.hooverOverCartPopUp(driver);
        cartSteps.selectViewCartFromPopUp();
        cartSteps.increaseQuantity("100");
        cartSteps.clickOnUpdateCartButton();
        cartSteps.checkSubtotalSum();
    }

    @Test
    public void removeOneProductFromCart(){
        cartSteps.clickOnFirstCartButton();
        cartSteps.hooverOverCartPopUp(driver);
        cartSteps.selectViewCartFromPopUp();
        cartSteps.clickOnRemoveProduct();
        cartSteps.checkEmptyCartMessage("Your cart is currently empty.");
    }
}
