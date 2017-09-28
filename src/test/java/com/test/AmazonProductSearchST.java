package com.test;


import com.test.pages.AmazonPage;
import com.test.pages.LoginPage;
import com.test.utils.WebDriverHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AmazonProductSearchST {
    @Given("^Amazon\\.co\\.uk is open$")
    public void amazon_co_uk_is_open() throws Throwable {
        WebDriverHelper.navigateToURL("https://www.amazon.co.uk");

    }

    @When("^I click Sign-in$")
    public void i_click_Sign_in() throws Throwable {
        AmazonPage.clickingSigInButton();
        //Waiting 2 seconds to page load
        LoginPage.waitingForLogInPageToLoad(2);
    }

    @When("^enter valid user name password$")
    public void enter_valid_user_name_password() throws Throwable {

        LoginPage.enteringEmailAddress("sujan792000@yahoo.com");
        WebDriverHelper.waitFor(500);
        LoginPage.enteringPassword("Sujee42@birth");
        WebDriverHelper.waitFor(500);
        LoginPage.clickingSignInButton();

    }

    @Then("^I am logged in$")
    public void i_am_logged_in() throws Throwable {

        //Verifying welcome text after successful logged in
        Assert.assertEquals(LoginPage.getWelcomeText(),"Hello, Sujanthan");
    }

    @Given("^Amazon\\.co\\.uk is open and I am logged in$")
    public void amazon_co_uk_is_open_and_I_am_logged_in() throws Throwable {

        //Verifying welcome again make sure user has logged-in, before search an Item
        Assert.assertEquals(LoginPage.getWelcomeText(),"Hello, Sujanthan");

    }

    @When("^I search for \"(.*?)\"$")
    public void i_search_for(String keyword) throws Throwable {
        //Entering search keyword and clicking submit button
        AmazonPage.enteringSearchTerm(keyword);
        AmazonPage.clickSubmitButton();
        AmazonPage.waitingSearchResultsPageToLoad(1);
    }

    @Then("^the first result has the word  \"(.*?)\" in it$")
    public void the_first_result_has_the_word_in_it(String keyword) throws Throwable {
        //Verifying whether first search result contains search keyword or not
        Assert.assertTrue(AmazonPage.titleContainSearchKeyword(keyword,1));
    }

    @Given("^I add my favourite item to my basket$")
    public void i_add_my_favourite_item_to_my_basket() throws Throwable {
        //Clicking first item from the search results
        AmazonPage.clickFirstItem(1);
        WebDriverHelper.waitFor(500);

        //Add specific item into the basket
        AmazonPage.clickAddToBasketButton();
    }

    @When("^I check my basket total$")
    public void i_check_my_basket_total() throws Throwable {
        //Verifying number of items in the basket
        Assert.assertEquals(AmazonPage.getNumberOfItems_Basket(),1);

    }

    @Then("^it should match the price of \"(.*?)\"$")
    public void it_should_match_the_price_of(String price) throws Throwable {
        //Click basket option
        AmazonPage.clickBasketOption();
        WebDriverHelper.waitFor(500);

        //Verifying the basket item price.
        Assert.assertEquals(AmazonPage.getProductPrice_AfterAddToTheBasket(), price);
    }



}
