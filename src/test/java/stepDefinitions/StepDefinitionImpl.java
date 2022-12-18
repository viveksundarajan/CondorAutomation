package stepDefinitions;

import com.test.pages.HomePage;
import com.test.pages.ResultPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.BaseInit;

import java.io.IOException;

public class StepDefinitionImpl extends BaseInit {


    public StepDefinitionImpl() throws IOException {
        super();
    }

    @Before
    public void launchTheApplication() {

        driver = invokeBrowserAndLaunchURL();
        page.getInstance(HomePage.class).acceptCookies();
    }

    @Given("^Enter the (.+) and (.+)$")
    public void enterTheOriginAndDestination(String org, String dest) {
        HomePage homePage = page.getInstance(HomePage.class);
        homePage.fillOriginAndDestinationWithAllDetails(org, dest);
    }

    @When("Click search flight button")
    public void clickSearchFlightButton() {
        page.getInstance(HomePage.class).clickSearchButton();
    }


    @Then("^Assert flight are listed with the search inputs (.+) (.+)$")
    public void assertFlightAreListedWithTheSearchInputs(String origin, String destination) {
        ResultPage resultPage = page.getInstance(ResultPage.class);
        Assert.assertTrue(resultPage.getSearchResultsOrigin().stream().allMatch(s->s.getText().contains(origin)),"Origin station is not same as search input");
        Assert.assertTrue(resultPage.getSearchResultsDestination().stream().allMatch(s->s.getText().contains(destination)) ,"Destination station is not same as search input");
    }


    @Given("^Fill all the details with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void fillAllDetails(String org, String dest)  {
        HomePage homePage =  page.getInstance(HomePage.class);
        homePage.fillOriginAndDestinationWithAllDetails(org,dest);
    }

    @When("^Click reset filter$")
    public void clickResetFilter()  {
        page.getInstance(HomePage.class).clickResetFilter();

    }

    @Then("^Verify the search inputs are reseted$")
    public void verifySearchInputsAreReseted() {
        HomePage homePage =  page.getInstance(HomePage.class);
        Assert.assertTrue(homePage.isOutboundDateFieldHidden());
        Assert.assertTrue(homePage.isPassengerFieldHidden());
    }


    @After
    public void tearDown() {
        driver.quit();
    }



}


