package com.test.pages;

import com.test.utils.WebDriverHelper;
import org.openqa.selenium.By;

public class LoginPage {

    private static final By button = By.id("signInSubmit");

    //Entering user email address
    public static void enteringEmailAddress(String emailAddress){
        By email = By.id("ap_email");
        WebDriverHelper.setTextInTextBox(emailAddress,email);
    }
    //Entering user password
    public static void enteringPassword(String userPassword){
        By password = By.id("ap_password");
        WebDriverHelper.setTextInTextBox(userPassword,password);
    }

    //Clicking sign in button
    public static void clickingSignInButton(){
        WebDriverHelper.clickOnElement(button);
    }

    //Get the current logged in user name
    public static String getWelcomeText(){
        By welcome = By.cssSelector("#nav-link-yourAccount>.nav-line-1");
        return WebDriverHelper.getText(welcome);
    }

    //Waiting until every components are load
    public static void waitingForLogInPageToLoad(int time){
        WebDriverHelper.waitForElementToDisplay(button,time);
    }

}
