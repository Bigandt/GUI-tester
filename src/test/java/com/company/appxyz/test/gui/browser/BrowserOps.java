package com.company.appxyz.test.gui.browser;

import com.company.appxyz.test.gui.annotations.LazyComponent;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.safari.SafariOptions;

import java.util.logging.Level;

@LazyComponent
public class BrowserOps {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        chromeOptions.setCapability("goog:loggingPrefs", logPrefs);
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("devtools.console.stdout.content", true);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.DRIVER, Level.ALL);

        firefoxOptions
            .setProfile(firefoxProfile)
            .setCapability("goog:loggingPrefs", logPrefs);
        return firefoxOptions;
    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.DRIVER, Level.ALL);
        edgeOptions.setCapability("goog:loggingPrefs", logPrefs);
        return edgeOptions;
    }

    public static SafariOptions getSafariOptions() {
        SafariOptions safariOptions = new SafariOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.DRIVER, Level.ALL);
        safariOptions.setCapability("goog:loggingPrefs", logPrefs);
        return safariOptions;
    }
}
