package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddCartPage extends BasePage {


    public AddCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[id='sw-subtotal']")
    private WebElement totalCost;

    @FindBy(css="#nav-cart-count-container")
    private WebElement cartSection;

    @FindBy(css="[class*='dropdown quantity']")
    private WebElement quantityDropdown;

    @FindBy(css="#quantity_1")
    private WebElement quantityAsOne;

    @FindBy(css="[id ='gutterCartViewForm'] [id*='subtotal-amount'] span")
    private WebElement updatedAmount;

    @FindBy(css="[value='Save for later']")
    private WebElement saveForLater;


    public float getTotalCost()
    {
       String total = totalCost.getAttribute("data-price");
       String[] value = total.split(" ");
       return Float.parseFloat(value[1]);

    }

    public void goToCartSection() {
        cartSection.click();
    }

    public void reduceQuantityToOne()
    {
        wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown)).click();
        quantityAsOne.click();
    }

    public float getUpdatedAmount() {
        wait.until(ExpectedConditions.elementToBeClickable(saveForLater));
        String  value  = updatedAmount.getText();
        String[] prices = value.split("\\$");
        return Float.parseFloat(prices[1]);

    }


}
