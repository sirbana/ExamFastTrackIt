package org.fasttrack.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.pages.Homepage;
import org.fasttrack.steps.serenity.LoginSteps;
import org.fasttrack.steps.serenity.ShopSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ShopTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Steps
    private ShopSteps shopSteps;

    @Steps
    private LoginSteps loginSteps;

    @Test(expected = AssertionError.class)
    public void sortByProductsByPrice(){
        loginSteps.navigateToHomepage();
        shopSteps.clickOnShopButton();
        shopSteps.selectFromDropDownByIndex(3);
        shopSteps.orderByLowToHighValue();
    }

}
