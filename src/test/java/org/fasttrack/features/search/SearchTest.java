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
   private SearchSteps searchSteps;

    @Steps
    private LoginSteps loginSteps;

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
        String textToSearch = "hoodie";
        searchSteps.typeIntoSearchField(textToSearch);
        searchSteps.clickOnSearchButtonInSearchField();
        searchSteps.searchMessageIsDisplayed("Search Results for: " + textToSearch);
        searchSteps.searchResultsContains(textToSearch);
    }

    @Test
    public void searchWithASelectedDropDownValue(){
        searchSteps.typeIntoSearchField("hoodie");
        searchSteps.selectFromDropDownByIndex(1);
        searchSteps.clickOnSearchButtonInSearchField();
        searchSteps.searchResultsContains("hoodie");
    }

    @Test
    public void searchForUnknownProduct(){
        searchSteps.typeIntoSearchField("ray");
        searchSteps.selectFromDropDownByText("Post");
        searchSteps.clickOnSearchButtonInSearchField();
        searchSteps.searchMessageIsDisplayed("Nothing Found");
    }

    @Test
    public void searchForASingleLetter(){
        searchSteps.typeIntoSearchField("h");
        searchSteps.selectFromDropDownByIndex(0);
        searchSteps.clickOnSearchButtonInSearchField();
        searchSteps.searchResultsContains("h");
    }

}