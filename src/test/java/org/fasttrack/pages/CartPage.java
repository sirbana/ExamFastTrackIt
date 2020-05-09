package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CartPage extends PageObject {
    @FindBy(css = ".product-name>a")
    private WebElementFacade productName;

    @FindBy(css = ".product-quantity>div.quantity>input")
    private WebElementFacade quantityDropDown;

    @FindBy(css = "button[name=update_cart]")
    private WebElementFacade updateCartButton;

    @FindBy(css = "div.woocommerce>div.woocommerce-message")
    private WebElementFacade updatedCartMessage;

    @FindBy(css = "tr.cart-subtotal>td>span.woocommerce-Price-amount.amount")
    private WebElementFacade subtotalSum;

    @FindBy(css = "tr.woocommerce-cart-form__cart-item>td.product-price>span")
    private WebElementFacade productPrice;

    @FindBy(css = "a.remove")
    private WebElementFacade removeProductButton;

    @FindBy(css="div.woocommerce>p.cart-empty")
    private WebElementFacade emptyCartMessage;

    public boolean checkProductName(String product) {
        return productName.containsOnlyText(product);
    }

    public boolean checkQuantityDropDown(String quantity) {
        return quantityDropDown.getValue().equals(quantity);
    }

    public void increaseQuantity(String biggerQuantity) {
        quantityDropDown.clear();
        quantityDropDown.sendKeys(biggerQuantity);
    }

    public void clickOnUpdateCartButton() {
        clickOn(updateCartButton);
    }


    public boolean checkUpdatedCartMessage(String updateMessage) {
        return updatedCartMessage.containsOnlyText(updateMessage);
    }

    public boolean checkSubtotalSum() {
        float sum, price;
        int quantity = Integer.parseInt(quantityDropDown.getValue());

        try {
            NumberFormat nf = NumberFormat.getInstance(new Locale("ro", "RO"));
            sum = nf.parse(subtotalSum.getText()).floatValue();
            price = nf.parse(productPrice.getText()).floatValue();
        } catch (ParseException e) {
            return false;
        }

        return price * quantity == sum;
    }

    public void clickOnRemoveProductButton(){
        clickOn(removeProductButton);
    }

    public boolean checkEmptyCartMessage(String message){
       return emptyCartMessage.containsOnlyText(message);
    }

}
