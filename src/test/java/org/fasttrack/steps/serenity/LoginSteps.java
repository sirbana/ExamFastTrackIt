package org.fasttrack.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.fasttrack.pages.DashboardPage;
import org.fasttrack.pages.Homepage;
import org.fasttrack.pages.MyAccountPage;
import org.junit.Assert;


public class LoginSteps  {
    Homepage homepage;
    MyAccountPage myAccountPage;
    DashboardPage dashboardPage;

    @Step
    public void navigateToHomepage() {
        homepage.open();
    }

    @Step
    public void navigateToMyAccount() {
        homepage.clickOnMyAccountButton();
    }

    @Step
    public void enterCredentials(String email, String pass) {
        myAccountPage.setUserNameField(email);
        myAccountPage.setPasswordField(pass);

    }

    @Step
    public void clickOnLoginButton() {
        myAccountPage.clickOnLoginButton();
    }

    @Step
    public void checkLoggedIn(String user) {
        Assert.assertTrue(dashboardPage.checkWelcomeText(user));
    }

    @Step
    public void errorMessageIsDisplayed(String message){
        Assert.assertTrue(myAccountPage.errorMessageIsDisplayed(message));
    }

    @Step
    public void login(String email, String pass){
        navigateToHomepage();
        navigateToMyAccount();
        enterCredentials(email, pass);
        clickOnLoginButton();
    }
}
