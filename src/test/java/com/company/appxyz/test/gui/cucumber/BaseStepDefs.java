package com.company.appxyz.test.gui.cucumber;

import com.company.appxyz.test.gui.annotations.LazyAutowired;
import com.company.appxyz.test.gui.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class BaseStepDefs {

    @LazyAutowired
    private BasePage page;

    //<editor-fold desc="Given">
    //********* Given Methods Start *********//
    @Given("I am at page with URL {string}")
    public void goToUrl(String url) {
        page.openPage(url);
    }

    //********* Given Methods End *********//
    //</editor-fold>

    //<editor-fold desc="When">
    //********* When Methods Start *********//
    @When("I maximize page")
    public void maximizePage(){
        page.maximizePage();
    }

    @When("I minimize page")
    public void minimizePage(){
        page.minimizePage();
    }

    @When("I refresh page")
    public void refreshPage(){
        page.refreshPage();
    }

    @When("I go back")
    public void goBack(){
        page.goBack();
    }

    @When("I go forward")
    public void goForward(){
        page.goForward();
    }

    @When("I create a new tab")
    public void createAndGoToNewTab(){
        page.createAndGoToNewTab();
    }

    @When("I navigate to URL {}")
    public void navigateToUrl(String url) {
        page.navigateTo(url);
    }

    @When("I go to tab with index {int}")
    public void goToTabWithIndex(int index){
        page.goToTabWithIndex(index);
    }

    @When("I click button with text containing {string}")
    public void iClickOnButtonGeneric(String buttonText) {
        By[] buttonXpaths = buttonXpaths(buttonText);
        page.click(buttonXpaths);
    }

    @When("I click button secure with ID {}")
    public void iClickOnButtonGenericSecurity(String inputId) {
        page.clickSuppressException(By.xpath(String.format("//*[@id='%s']", inputId)));
    }

    @When("I click link with text containing {string}")
    public void iClickOnLinkGeneric(String linkText) {
        By[] link = linkXpaths(linkText);
        page.click(link);
    }

    @When("I enter text {string} for input with ID {}")
    public void enterTextForInputWithId(String text, String inputId) {
        page.writeText(By.xpath(String.format("//*[@id='%s']", inputId)), text);
    }

    @When("I enter text {string} secure for input with ID {}")
    public void enterTextForInputWithIdSecurity(String text, String inputId) {
        page.writeTextSuppressException(By.xpath(String.format("//*[@id='%s']", inputId)), text);
    }

    @When("I Wait {int} seconds")
    public void waitSeconds(int seconds) {
        page.pause(seconds);
    }
    // ********* When End ********* //
    //</editor-fold>


    //<editor-fold desc="Then">
    //********* Then Methods Start *********//
    @Then("I am able to see title {string}")
    public void verifyTitle(String buttonText) {
        By[] titleXpaths = titleXpaths(buttonText);
        page.waitOneOfElementsIsInDOM(titleXpaths);
    }

    @Then("I am able to see button with text {string}")
    public void verifyButton(String buttonText) {
        By[] buttonXpaths = buttonXpaths(buttonText);
        page.waitOneOfElementsIsInDOM(buttonXpaths);
    }

    //********* Then Methods Start *********//
    //</editor-fold>

    //<editor-fold desc="Private">
    //********* Private Methods Start *********//
    private By[] buttonXpaths(String buttonText) {
        return new By[]{By.xpath(String.format("//button[text()='%s']", buttonText)),
                        By.xpath(String.format("//button/span[text()='%s']", buttonText)),
                        By.xpath(String.format("//button/label[text()='%s']", buttonText))};
    }

    private By[] linkXpaths(String linkText) {
        return new By[]{By.xpath(String.format("//a[text()='%s']", linkText)),
                        By.xpath(String.format("//a/span[text()='%s']", linkText))};
    }

    private By[] titleXpaths(String titleText) {
        return new By[]{By.xpath(String.format("//h1[text()='%s']", titleText)),
                        By.xpath(String.format("//h2[text()='%s']", titleText)),
                        By.xpath(String.format("//h3[text()='%s']", titleText)),
                        By.xpath(String.format("//h4[text()='%s']", titleText))};
    }
    //********* Private Methods End *********//
    //</editor-fold>

}
