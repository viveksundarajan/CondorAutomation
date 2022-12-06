package com.test.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public float getProductPriceInDecimal(WebElement productPriceWhole , WebElement productPriceDecimal) {


        String decimalValue= productPriceDecimal.getText();
        float value = Float.parseFloat(decimalValue);
        float fractionValue = value/100;

        String wholeValue = productPriceWhole.getText();
        int wholeNumber = Integer.parseInt(wholeValue);
        float productPrice = wholeNumber + fractionValue;
        return productPrice;
    }

    public void clickElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", element);
    }
}