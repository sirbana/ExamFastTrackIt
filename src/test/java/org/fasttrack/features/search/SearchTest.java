package org.fasttrack.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.serenity.LoginSteps;
import org.fasttrack.steps.serenity.SearchSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    SearchSteps searchSteps;

    @Steps
    LoginSteps loginSteps;

    @Before
    public void proceedToSearch() {
        loginSteps.navigateToHomepage();
        searchSteps.clickOnSearchIcon();
    }

    @Test
    public void invalidSearch() {

        searchSteps.typeIntoSearchField("ghighighi");
        searchSteps.clickOnSearchButtonInSearchField();
        searchSteps.searchMessageIsDisplayed("Nothing Found");

    }

    @Test
    public void validSearch() {
        searchSteps.typeIntoSearchField("album");
        searchSteps.clickOnSearchButtonInSearchField();
        searchSteps.searchMessageIsDisplayed("Search Results for: album");
    }
}