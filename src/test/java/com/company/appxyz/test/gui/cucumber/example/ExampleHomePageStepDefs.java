package com.company.appxyz.test.gui.cucumber.example;

import com.company.appxyz.test.gui.annotations.LazyAutowired;
import com.company.appxyz.test.gui.pages.example.ExampleHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleHomePageStepDefs {

    @LazyAutowired
    private ExampleHomePage page;

    @Given("I am on the example home page")
    public void iAmOnTheExampleHomePage() {
        page.goToHomePage();
    }

    @When("I click More information...")
    public void iClickOnCreateNewMeetingButton() { page.clickMoreInformation(); }

    @Then("Verify I am on example home page")
    public void verifyExampleHomepage(){
        page.verifyThatIAmAtHomePage();
    }

}
