package com.company.appxyz.test.gui.pages.example;

import com.company.appxyz.test.gui.annotations.LazyComponent;
import com.company.appxyz.test.gui.pages.AbstractPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class ExampleHomePage extends AbstractPage {

    @Value("${example.base.url}")
    private String baseURL;

    //********* Action elements *********//
    @FindBy(how = How.XPATH, using = "//a[text()='More information...']")
    public WebElement moreInfomationLink;

    //********* Static elements *********
    By homePageTitle = By.xpath("//h1[text()='Example Domain']");

    //********* Action Methods *********//
    public ExampleHomePage goToHomePage() {
        driver.get(baseURL);
        driver.navigate().refresh();
        driver.manage().window().fullscreen();
        driver.navigate().refresh();
        return this;
    }

    public ExampleHomePage clickMoreInformation() {
        click(moreInfomationLink);
        return this;
    }

    //********* Verification Methods *********//
    public ExampleHomePage verifyThatIAmAtHomePage() {
        Assertions.assertTrue(driver.findElement(homePageTitle).isDisplayed());
        return this;
    }
}