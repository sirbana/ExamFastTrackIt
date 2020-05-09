package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShopPage extends PageObject {

    @FindBy(css = "ul.products > li > div.collection_desc > div.title-cart > a > h3")
    private WebElementFacade fistProduct;

    @FindBy(css = "div.entry-summary> h1")
    private WebElementFacade productName;

    @FindBy(css = ".orderby")
    private WebElementFacade dropDownButton;

    @FindBy(css = "ins>span.amount,span.price>span.amount:first-child")
    private List<WebElementFacade> pricesList;

    @FindBy(css="li.product:nth-child(1) > div.collection_desc > div.title-cart > div.cart > a")
    private WebElementFacade firstCartButton;

    @FindBy(css=".fa-shopping-cart")
    private WebElementFacade cartButton;

    @FindBy(css="p.woocommerce-mini-cart__buttons>a:first-child")
    private WebElementFacade viewCartButton;

    public void clickOnFirstProduct() {
        clickOn(fistProduct);
    }

    public void getProductName() {
        productName.getText();
    }

    public void selectFromDropDownByIndex(int index) {
        dropDownButton.selectByIndex(index);
    }

    public boolean arePricesInLowToHighOrder() {
        List<Float> prices = new ArrayList<>();
        for (WebElementFacade price : pricesList) {
            String s = price.getText().replace(',', '.').split(" ")[0];
            prices.add(Float.parseFloat(s));
        }

        List<Float> pricesSorted = new ArrayList<>(prices);
        Collections.sort(pricesSorted);

        System.out.println(pricesSorted);
        System.out.println(prices);

        return prices.equals(pricesSorted);
    }

    public void clickOnFirstMiniCartButton(){
        clickOn(firstCartButton);
    }

    public void clickOnCartPopUp(WebDriver driver){
        Actions action= new Actions(driver);
        action.moveToElement(cartButton).perform();
        // action.build().perform();
        waitFor(1000);
    }

    public void clickOnViewCartButton(){
        clickOn(viewCartButton);
    }
}

