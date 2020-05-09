package org.fasttrack.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.fasttrack.pages.DashboardPage;
import org.fasttrack.pages.Homepage;
import org.fasttrack.pages.ShopPage;
import org.junit.Assert;

public class ShopSteps extends PageObject {
    Homepage homepage;
    ShopPage shopPage;

    @Step
    public void clickOnShopButton() {
        homepage.clickShopButton();
    }

    @Step
    public void selectFromDropDownByIndex(int index) {
        shopPage.selectFromDropDownByIndex(index);
    }

    @Step
    public void orderByLowToHighValue() {
        Assert.assertTrue(shopPage.arePricesInLowToHighOrder());
    }


}
