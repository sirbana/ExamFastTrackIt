package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa2.fasttrackit.org:8008/?page_id=7")
public class DashboardPage extends PageObject {

    @FindBy(css = "div.woocommerce-MyAccount-content > p")
    private WebElementFacade welcomeText;

    public boolean checkWelcomeText(String text) {
      return  welcomeText.containsOnlyText(text);

    }
}
