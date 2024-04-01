package com.company.appxyz.test.gui.browser;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

@Slf4j
public class SeleniumExtension implements ParameterResolver {

    private static final BrowserWebDriverContainer<?> CHROME_DRIVER_CONTAINER = new BrowserWebDriverContainer<>()
            .withCapabilities(BrowserOps.getChromeOptions());

    private static final BrowserWebDriverContainer<?> FIREFOX_DRIVER_CONTAINER = new BrowserWebDriverContainer<>()
            .withCapabilities(BrowserOps.getFirefoxOptions());

    private static final BrowserWebDriverContainer<?> EDGE_DRIVER_CONTAINER = new BrowserWebDriverContainer<>()
            .withCapabilities(BrowserOps.getEdgeOptions());

    private static final BrowserWebDriverContainer<?> SAFARI_DRIVER_CONTAINER = new BrowserWebDriverContainer<>()
            .withCapabilities(BrowserOps.getSafariOptions());

    private static RemoteWebDriver webDriver;

    public static RemoteWebDriver getChromeDriver() {
        if (!CHROME_DRIVER_CONTAINER.isRunning()) {
            synchronized (CHROME_DRIVER_CONTAINER) {
                if (!CHROME_DRIVER_CONTAINER.isRunning()) {
                    log.info("starting selenium docker container");
                    CHROME_DRIVER_CONTAINER.start();
                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        log.info("stopping selenium docker container");
                        CHROME_DRIVER_CONTAINER.stop();
                    }));
                    webDriver = new RemoteWebDriver(CHROME_DRIVER_CONTAINER.getSeleniumAddress(), BrowserOps.getChromeOptions());
                }
            }
        }
        return webDriver;
    }

    public static RemoteWebDriver getFirefoxDriver() {
        if (!FIREFOX_DRIVER_CONTAINER.isRunning()) {
            synchronized (FIREFOX_DRIVER_CONTAINER) {
                if (!FIREFOX_DRIVER_CONTAINER.isRunning()) {
                    log.info("starting selenium docker container");
                    FIREFOX_DRIVER_CONTAINER.start();
                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        log.info("stopping selenium docker container");
                        FIREFOX_DRIVER_CONTAINER.stop();
                    }));
                    webDriver = new RemoteWebDriver(FIREFOX_DRIVER_CONTAINER.getSeleniumAddress(), BrowserOps.getFirefoxOptions());
                }
            }
        }
        return webDriver;
    }

    public static RemoteWebDriver getEdgeDriver() {
        if (!EDGE_DRIVER_CONTAINER.isRunning()) {
            synchronized (EDGE_DRIVER_CONTAINER) {
                if (!EDGE_DRIVER_CONTAINER.isRunning()) {
                    log.info("starting selenium docker container");
                    EDGE_DRIVER_CONTAINER.start();
                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        log.info("stopping selenium docker container");
                        EDGE_DRIVER_CONTAINER.stop();
                    }));
                    webDriver = new RemoteWebDriver(EDGE_DRIVER_CONTAINER.getSeleniumAddress(), BrowserOps.getEdgeOptions());
                }
            }
        }
        return webDriver;
    }

    public static RemoteWebDriver getSafariDriver() {
        if (!SAFARI_DRIVER_CONTAINER.isRunning()) {
            synchronized (SAFARI_DRIVER_CONTAINER) {
                if (!SAFARI_DRIVER_CONTAINER.isRunning()) {
                    log.info("starting selenium docker container");
                    SAFARI_DRIVER_CONTAINER.start();
                    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        log.info("stopping selenium docker container");
                        SAFARI_DRIVER_CONTAINER.stop();
                    }));
                    webDriver = new RemoteWebDriver(SAFARI_DRIVER_CONTAINER.getSeleniumAddress(), BrowserOps.getSafariOptions());
                }
            }
        }
        return webDriver;
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(RemoteWebDriver.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return null;
    }
}