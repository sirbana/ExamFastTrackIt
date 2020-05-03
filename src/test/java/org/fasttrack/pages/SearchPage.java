package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class SearchPage extends PageObject {
    @FindBy(css=".page-header>h1")
    private WebElementFacade searchResultMessage;

    public boolean searchResultMessage(String text){
        return searchResultMessage.containsOnlyText(text);
    }
}
