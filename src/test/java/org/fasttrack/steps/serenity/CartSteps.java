package org.fasttrack.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.CartPage;
import org.fasttrack.pages.DashboardPage;
import org.fasttrack.pages.Homepage;
import org.fasttrack.pages.ShopPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartSteps {
    Homepage homepage;
    CartPage cartPage;
    ShopPage shopPage;
    DashboardPage dashboardPage;

    @Step
    public void clickOnFirstCartButton() {
        shopPage.clickOnFirstMiniCartButton();
    }

    @Step
    public void hooverOverCartPopUp(WebDriver driver) {
        shopPage.clickOnCartPopUp(driver);
    }

    @Step
    public void selectViewCartFromPopUp() {
        shopPage.clickOnViewCartButton();
    }

    @Step
    public void checkProductName(String product) {
        Assert.assertTrue(cartPage.checkProductName(product));
    }

    @Step
    public void checkQuantityDropDown(String quantity) {
        Assert.assertTrue(cartPage.checkQuantityDropDown(quantity));
    }
    @Step
    public void increaseQuantity(String biggerQuantity){
        cartPage.increaseQuantity(biggerQuantity);
    }

    @Step
    public void clickOnUpdateCartButton(){
        cartPage.clickOnUpdateCartButton();
    }
    @Step
    public void checkUpdatedCartMessage(String updateMessage){
        cartPage.checkUpdatedCartMessage(updateMessage);
    }
    @Step
    public void checkSubtotalSum(){
        Assert.assertTrue(cartPage.checkSubtotalSum());
    }

    @Step
    public void clickOnRemoveProduct(){
        cartPage.clickOnRemoveProductButton();
    }
    @Step
    public void checkEmptyCartMessage(String message){
        Assert.assertTrue(cartPage.checkEmptyCartMessage(message));
    }
}
