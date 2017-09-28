package com.test.utils;


import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.test.context.Context.getBrowser;


public class WebDriverHelper {

    public static void mouseHoverOverAndClickElement(By element) {

        Actions builder = new Actions(getBrowser());
        WebElement webElement = getBrowser().findElement(element);
        builder.moveToElement(webElement).click(webElement).build().perform();

    }

    public static void navigateToURL(String url) {
        getBrowser().get(url);
    }

    public static void screenshot(Scenario scenario) {
        byte[] screenshot = getBrowser().getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    public static void waitFor(long timer) {
        try {
            Thread.sleep(timer);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread sleep exception occurred...", e);
        }
    }

    public static String getText(final By locator) {
        final WebElement element = getBrowser().findElement(locator);
        return element.getText();
    }

    public static void clickOnElement(final By locator) {
        getBrowser().findElement(locator).click();
    }


    public static void setTextInTextBox(final String text, final By locator) {
        getBrowser().findElement(locator).clear();
        getBrowser().findElement(locator).sendKeys(text);

    }

    public static Boolean waitForElementToDisplay(final By element, final int waitTime) {
        try {
            return new WebDriverWait(getBrowser(), waitTime)
                    .until(new ExpectedCondition<Boolean>() {

                        //@Override
                        public Boolean apply(final WebDriver d) {
                            return getBrowser().findElement(element).isDisplayed();
                        }
                    });
        } catch (Exception e) {
            return false;
        }
    }


}


