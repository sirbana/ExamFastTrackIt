package org.fasttrack.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.Homepage;
import org.fasttrack.pages.SearchPage;

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
        searchPage.searchResultMessage(text);
    }
}
