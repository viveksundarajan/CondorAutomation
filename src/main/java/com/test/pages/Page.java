package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {

    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public abstract String getPageTitle();

    public abstract void waitForPageTitle(String title);

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}