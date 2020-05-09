package org.fasttrack.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.Homepage;
import org.fasttrack.pages.SearchPage;
import org.junit.Assert;

public class SearchSteps {
    Homepage homepage;
    SearchPage searchPage;
    @Step
    public void clickOnSearchIcon(){
        homepage.clickOnSearchButton();
    }

    @Step
    public void typeIntoSearchField(String text){
        homepage.typeIntoSearchField(text);
    }
    @Step
    public void clickOnSearchButtonInSearchField(){
        homepage.clickOnSearchButtonInSearchField();
    }

    @Step
    public void searchMessageIsDisplayed(String text){
        Assert.assertTrue(searchPage.searchResultMessage(text));
    }

    @Step
    public void searchResultsContains(String searchedText) {
        Assert.assertTrue(searchPage.searchResultsContainsAll(searchedText));
    }
    @Step
    public void selectFromDropDownByIndex(int x){
        searchPage.selectFromDropDownSearchByIndex(x);
    }
    @Step
    public void selectFromDropDownByText(String text){
        searchPage.selectFromDropDownByText(text);
    }
}
