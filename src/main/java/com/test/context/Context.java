package com.test.context;

import com.test.utils.WebDriverHelper;
import com.test.utils.browser.BrowserDriver;
import cucumber.api.Scenario;


public class Context {

    private Context() {
    }

    /**
     * Initialize the context for the given scenario.
     *
     * @param scenario Cucumber Scenario
     */
    public static void setUp(Scenario scenario) {
        ContextInstance.setUp(scenario);
    }

    /**
     * Destroys the context for the current scenario.
     */
    public static void tearDown() {
        ContextInstance.tearDown();
    }

    public static void afterScenarioFailedReport(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriverHelper.screenshot(scenario) ;
        }
    }

    public static BrowserDriver getBrowser() {

        return ContextInstance.getInstance().getBrowser();
    }

    public static Scenario getScenario() {

        return ContextInstance.getInstance().getScenario();
    }

}
