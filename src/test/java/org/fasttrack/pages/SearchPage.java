package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends PageObject {
    @FindBy(css = ".page-header>h1")
    private WebElementFacade searchResultMessage;

    @FindBy(css = ".entry-title>a")
    private List<WebElementFacade> searchResults;

    @FindBy(css = ".select-search-type")
    private WebElementFacade searchDropDownSelect;

    public boolean searchResultMessage(String text) {
        return searchResultMessage.containsOnlyText(text);
    }

    public boolean searchResultsContainsAll(String searchedText) {
        if(searchResults.size()==0){
            return false;
        }
        for (WebElementFacade s : searchResults) {
            if (!s.getText().toLowerCase().contains(searchedText)) {
                return false;
            }
        }

        return true;
    }

    public void selectFromDropDownSearchByIndex(int x) {
        searchDropDownSelect.selectByIndex(x);
    }

    public void selectFromDropDownByText(String text){
        searchDropDownSelect.selectByVisibleText(text);
    }

}
