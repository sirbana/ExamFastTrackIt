package org.fasttrack.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.serenity.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;



@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    @Test
    public void validLoginTest(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials("ginger77a@yahoo.com","iuhu3RedRed");
        loginSteps.clickOnLoginButton();
        loginSteps.checkLoggedIn("Hello ginger77a (not ginger77a? Log out)");
    }

    @Test
    public void loginWithoutCredentials(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials("","");
        loginSteps.clickOnLoginButton();
        loginSteps.errorMessageIsDisplayed("Error: Username is required.");
    }

    @Test
    public void longinWithoutPassword(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials("ginger77a@yahoo.com","");
        loginSteps.clickOnLoginButton();
        loginSteps.errorMessageIsDisplayed("ERROR: The password field is empty.");
    }

    @Test
    public void loginWithInvalidEmail(){
        loginSteps.navigateToHomepage();
        loginSteps.navigateToMyAccount();
        loginSteps.enterCredentials("gigi@yahoo.com","iuhuhu");
        loginSteps.clickOnLoginButton();
        loginSteps.errorMessageIsDisplayed("ERROR: Invalid email address. Lost your password?");
    }

}
