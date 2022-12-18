package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultPage extends BasePage {


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='search-result-v4'] [class*='text-left']")
    private List<WebElement> searchResultsOrigin;


    @FindBy(css="[class*='content-title text-right']")
    private List<WebElement> searchResultsDestination;

    public List<WebElement> getSearchResultsOrigin() {
        waitForVisibilityOfElements(searchResultsOrigin);
        return searchResultsOrigin;
    }

    public List<WebElement> getSearchResultsDestination() {
        return searchResultsDestination;
    }

}
