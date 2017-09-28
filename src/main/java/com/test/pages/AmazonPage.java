package com.test.pages;

import com.test.utils.WebDriverHelper;
import org.openqa.selenium.By;


public class AmazonPage {

    private static By searchBox = By.id("twotabsearchtextbox");
    private static By submitButton = By.cssSelector(".nav-input");

    //Clicking Sign in button
    public static void clickingSigInButton(){
        By yourAccount = By.id("nav-link-yourAccount");
        WebDriverHelper.mouseHoverOverAndClickElement(yourAccount);
    }


    //entering the search keyword in to the search box
    public static void enteringSearchTerm(String searchTerm ){
        WebDriverHelper.setTextInTextBox(searchTerm,searchBox);
    }

    //Click submit button
    public static void clickSubmitButton(){
        WebDriverHelper.clickOnElement(submitButton);
    }

    //Waiting until every components are load
    public static void waitingSearchResultsPageToLoad(int time){
        By resultsColumn = By.id("resultsCol");
        WebDriverHelper.waitForElementToDisplay(resultsColumn,time);
    }

    //Get First result's title should  contain search keyword
    public static boolean titleContainSearchKeyword(String keyword, int itemNum){
        By title = By.cssSelector("#s-results-list-atf>#result_"+ itemNum+"" +
                ">.s-item-container .s-access-detail-page>h2");
        return WebDriverHelper.getText(title).contains(keyword);
    }

    //Click any item from the search results page.
    public static void clickFirstItem(int itemNum){
        By item = By.cssSelector("#s-results-list-atf>.s-result-item:nth-child("+ itemNum+") .a-link-normal");
        WebDriverHelper.mouseHoverOverAndClickElement(item);
    }

    //Click add to Basket button
    public static void clickAddToBasketButton(){
        By basket = By.id("add-to-cart-button");
        WebDriverHelper.clickOnElement(basket);
    }


    //get number of items add into the basket
    public static int getNumberOfItems_Basket(){
        By item = By.cssSelector("#nav-cart-count");
        return Integer.parseInt(WebDriverHelper.getText(item));
    }

    //Click basket option
    public static void clickBasketOption(){
        By basket = By.id("nav-cart");
        WebDriverHelper.mouseHoverOverAndClickElement(basket);

    }
    //Get product price, which is added into the basket
    public static String getProductPrice_AfterAddToTheBasket(){
        By title = By.cssSelector(".sc-price");
        return WebDriverHelper.getText(title);
    }

}
