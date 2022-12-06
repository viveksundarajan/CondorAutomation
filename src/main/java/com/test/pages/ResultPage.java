package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends BasePage{


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[data-index='1'] [class*='product-image']")
    private WebElement product;

    @FindBy(css="[class*='priceToPay'] [class*='price-whole']")
    private WebElement productPriceWhole;

    @FindBy(css="[class*='priceToPay'] [class*='price-fraction']")
    private WebElement productPriceDecimal;

    @FindBy(css="[name='quantity']")
    private WebElement quantityDropdown;

    @FindBy(css="[id='quantity_1']")
    private WebElement quantityAsTwo;

    @FindBy(id="add-to-cart-button")
    private WebElement addToCart;


    public void openFirstProduct()
    {
        product.click();
    }

    public float getProductPrice()
    {

       return getProductPriceInDecimal(productPriceWhole, productPriceDecimal);

    }

    public void addQuantityAsTwo()
    {

        clickElement(quantityDropdown);
        quantityAsTwo.click();
    }

    public void addProductsToCart()
    {
        addToCart.click();
    }


}
