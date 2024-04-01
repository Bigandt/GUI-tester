package com.company.appxyz.test.gui.pages;

import com.company.appxyz.test.gui.annotations.LazyAutowired;
import com.company.appxyz.test.gui.browser.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHook extends AbstractPage {

    @LazyAutowired
    private ScreenshotUtil screenshotUtil;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.screenshotUtil.getScreenshot(), "image/png", driver.getCurrentUrl());
            scenario.log(scenario.getName());
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        scenario.attach(driver.getCurrentUrl(), "url", driver.getCurrentUrl());
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}