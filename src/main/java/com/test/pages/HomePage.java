package com.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[data-action='accept-comfort']")
    private WebElement cookies;

    @FindBy(id="searchAirportOrigin")
    private WebElement searchField;

    @FindBy(css="[id='search']")
    private WebElement searchButton;

    @FindBy(css="[id*='origin']")
    private WebElement originField;

    @FindBy(css="[id*='destination']")
    private WebElement destField;

    @FindBy(id="btngroup_oneway")
    private WebElement oneway;

    @FindBy(css="button span[class*='price']")
    private List<WebElement> prices;

    @FindBy(css="a[class='btn btn--large']")
    private WebElement continueButton;

    @FindBy(css="[aria-label*='Suche']")
    private WebElement resetFilter;

    @FindBy(css="[id='searchAirportOrigin'] [class*='input-link']")
    private WebElement inputOrigin;

   @FindBy(css="[id='searchOutboundDate'] [class*='input-link']")
    private List<WebElement> outboundDate;

   @FindBy(css="[id='searchPassenger'] [class*='content']")
   private List<WebElement> passengerField;

    public void acceptCookies() {

        try {
            cookies.click();
        }
        catch(Exception e) {
            System.out.println("No cookies found");
        }


    }
    public void getSearchField()
    {
        clickElement(searchField);
    }

    public WebElement getOriginField()
    {
       return originField;
    }

    public void selectOneWay() {
        waitForVisibilityOfAnElement(oneway);
        clickElement(oneway);
    }

    public void selectFlight()
    {
        int min = 1;
        int max = 10;

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        waitForVisibilityOfElements(prices);
        for(int i=0; i<3;i++) {
            try {
                prices.get(random_int).click();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    public WebElement getDestField()
    {
        return destField;
    }

    public void clickContinueButton() {
        waitForVisibilityOfAnElement(continueButton);
        continueButton.click();
    }


    public void clickSearchButton()
    {
        searchButton.click();
    }

    public void fillOriginAndDestinationWithAllDetails(String org, String dest) {
        getSearchField();
        getOriginField().sendKeys(org);
        getOriginField().sendKeys(Keys.ENTER);
        getDestField().sendKeys(dest);
        getDestField().sendKeys(Keys.ENTER);
        selectOneWay();
        selectFlight();
        clickContinueButton();
    }

    public void clickResetFilter() {
        waitForVisibilityOfAnElement(resetFilter);
        resetFilter.click();
    }

    public WebElement getInputOrigin()
    {
        return inputOrigin;
    }

    public boolean isOutboundDateFieldHidden() {
        boolean flag = false;
        System.out.println(outboundDate.size());
      if (outboundDate.size() ==0)
      {
          flag = true;
      }
      return flag;
    }

    public boolean isPassengerFieldHidden() {
        boolean flag = false;
        System.out.println(passengerField.size());
        if (passengerField.size() ==0)
        {
            flag = true;
        }
        return flag;
    }

}
