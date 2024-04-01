package com.company.appxyz.test.gui.pages;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public abstract class AbstractPage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @Autowired
    protected JavascriptExecutor javascriptExecutor;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    //<editor-fold desc="Click">
    // ********* Click Start ********* //
    public void click(WebElement webElement) {
        waitElementIsVisible(webElement);
        webElement.click();
    }

    public void click(By by) {
        waitElementIsInDOM(by);
        byToWebElement(by).click();
    }

    public void clickSuppressException(By by) {
        try {
            waitElementIsInDOM(by);
            byToWebElement(by).click();
        } catch (Exception e) {
            log.error("Suppressing Exception on click");
        }
    }

    public void click(By[] bys) {
        waitOneOfElementsIsInDOM(bys);
        bysToWebElement(bys).click();
    }

    public void clickTwice(WebElement webElement) {
        waitElementIsVisible(webElement);
        webElement.click();
        webElement.click();
    }

    public void clickTwice(By by) {
        waitElementIsInDOM(by);
        WebElement webElement = byToWebElement(by);
        webElement.click();
        webElement.click();
    }

    public void clickByAction(WebElement webElement) {
        Actions at = new Actions(driver);
        at.moveToElement(webElement).click().perform();
    }

    public void clickIfExist(By by) {
        List<WebElement> webElements = byToWebElements(by);
        if(webElements.isEmpty()) {
            log.info("Element did not exist for method clickIfExist(). Continuing");
            return;
        }
        webElements.get(0).click();
    }

    public void clickIfExist(WebElement webElement) {
        if(webElement.isDisplayed()) {
            log.info("Element did not exist for method clickIfExist(). Continuing");
            return;
        }
        webElement.click();
    }

    public void jsClick(By by) {
        javascriptExecutor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }
    // ********* Click End ********* //
    //</editor-fold>

    //<editor-fold desc="Text fields">
    // ********* Text fields Start ********* //
    public void writeText(By by, String text) {
        waitElementIsInDOM(by);
        WebElement webElement = byToWebElement(by);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void writeTextSuppressException(By by, String text) {
        try {
            waitElementIsInDOM(by);
            WebElement webElement = byToWebElement(by);
            webElement.clear();
            webElement.sendKeys(text);
        } catch (Exception e) {
            log.error("Suppressing Exception on write");
        }
    }

    public void writeText(WebElement webElement, String text) {
        waitElementIsVisible(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public String readText(By by) {
        WebElement webElement = byToWebElement(by);
        return webElement.getText();
    }

    public String readText(WebElement webElement) {
        return webElement.getText();
    }
    // ********* Text fields End ********* //
    //</editor-fold>

    //<editor-fold desc="Wait">
    // ********* Wait Start ********* //
    public void waitElementIsInDOM(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitElementIsVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitElementIsClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitAllElementsIsInDOM(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitAllElementsIsVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    public void waitOneOfElementsIsInDOM(By... bys) {
        ExpectedCondition[] ec = new ExpectedCondition[bys.length];
        for (int i = 0 ; i < bys.length ; i++) {
            ec[i] = ExpectedConditions.presenceOfElementLocated(bys[i]);
        }
        wait.until(ExpectedConditions.or(ec));
    }
    // ********* Wait End ********* //
    //</editor-fold>

    //<editor-fold desc="Navigate">
    // ********* Navigate Start ********* //
    public void openPage(String url) {
        driver.get(url);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void createAndGoToNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void goToTabWithIndex(int index) {
        driver.switchTo().window(driver.getWindowHandles().stream().skip(index-1).findFirst().get());
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void maximizePage() {
        driver.manage().window().maximize();
    }

    public void minimizePage() {
        driver.manage().window().minimize();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void scrollToTopOfPage() {
        javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    public void scrollToBottomOfPage() {
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void jsFocus(By by) {
        javascriptExecutor.executeScript("arguments[0].focus();", wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }
    // ********* Navigate End ********* //
    //</editor-fold>

    public void pause(double delayTimeInSeconds) {
        final int delay = (int) Math.round(delayTimeInSeconds * 1000);
        try {
            Thread.sleep(delay);
        } catch (final InterruptedException e) {
            log.error("Error while sleeping!" + e);
            Thread.currentThread().interrupt();
        }
    }

    //<editor-fold desc="Mappings">
    // ********* Mappings Start ********* //
    public WebElement byToWebElement(By by) {
        return driver.findElement(by);
    }

    public WebElement bysToWebElement(By[] bys) {
        for (By by : bys) {
            List<WebElement> elements = driver.findElements(by);
            if (elements.size() > 0)
                return elements.get(0);
        }
        return driver.findElement(bys[0]);
    }

    public List<WebElement> byToWebElements(By by) {
        return driver.findElements(by);
    }
    // ********* Mappings End ********* //
    //</editor-fold>

   /* TODO missing implementation
    public String dateChecker(String date) {
        if (date.equalsIgnoreCase("TODAY")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date newDate = new Date();
            return dateFormat.format(newDate);
        }
        return date;
    }

    public String changeDateFormat(String date) throws ParseException {
        SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy");
        Date dateValue = input.parse(date);
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
        return output.format(dateValue);
    }
    */

}
