package com.test.context;

import com.test.utils.browser.BrowserDriver;
import com.test.utils.browser.BrowserFactory;
import cucumber.api.Scenario;


public class ContextInstance {

    private static ContextInstance instance;

    private BrowserDriver browserDriver;
    private Scenario scenario;

    /**
     * Singleton constructor.
     */
    private ContextInstance() {
    }

    /**
     * Initialize the context for the given scenario.
     *
     * @param scenario Cucumber Scenario
     */
    public static void setUp(Scenario scenario) {
        if (instance == null) {
            instance = new ContextInstance();
        } else {
            throw new IllegalStateException("Context already instantiated!");
        }
        instance.init(scenario);
    }

    /**
     * Destroys the context for the current scenario.
     */
    public static void tearDown() {
        if (instance == null) {
            throw new IllegalStateException("Context not instantiated!");
        }
     //   instance.destroy();
        instance = null;
    }

    public static ContextInstance getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Context not instantiated!");
        }
        return instance;
    }
    public BrowserDriver getBrowser() {
        return this.browserDriver;
    }

    public Scenario getScenario() {
        return this.scenario;
    }


    private void init(Scenario scenario) {
        this.scenario = scenario;
        this.browserDriver = BrowserFactory.create();
        browserDriver.manage().window().maximize();

    }

    private void destroy() {
        this.browserDriver.close();
    }
}
