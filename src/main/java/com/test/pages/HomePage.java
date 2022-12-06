package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(css="input[id*='submit']")
    private WebElement submitButton;

    public WebElement getSearchField()
    {
        return searchField;
    }

    public void clickSubmitButton()
    {
         submitButton.click();
    }
}
