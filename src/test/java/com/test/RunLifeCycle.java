package com.test;


import com.test.context.Context;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class RunLifeCycle {

    @Before
    public void setUp(Scenario scenario) {
        Context.setUp(scenario);

    }

    @Given("^pending$")
    public void pending() {
        throw new cucumber.api.PendingException();
    }

    @After
    public void afterScenario(Scenario scenario) {
        Context.afterScenarioFailedReport(scenario);
        Context.tearDown();

    }


}
