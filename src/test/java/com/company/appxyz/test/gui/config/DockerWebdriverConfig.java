package com.company.appxyz.test.gui.config;

import com.company.appxyz.test.gui.annotations.LazyConfiguration;
import com.company.appxyz.test.gui.annotations.WebdriverScopeBean;
import com.company.appxyz.test.gui.browser.BrowserOps;
import com.company.appxyz.test.gui.browser.SeleniumExtension;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("docker")
@LazyConfiguration
public class DockerWebdriverConfig {

    @Autowired
    private BrowserOps browserOps;

    @WebdriverScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Primary
    public WebDriver remoteChromeDriver(){
        return SeleniumExtension.getChromeDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Primary
    public WebDriver remoteFirefoxDriver(){
        return SeleniumExtension.getFirefoxDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Primary
    public WebDriver remoteEdgeDriver(){
        return SeleniumExtension.getEdgeDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "safari")
    @Primary
    public WebDriver remoteSafariDriver(){
        return SeleniumExtension.getSafariDriver();
    }
}
