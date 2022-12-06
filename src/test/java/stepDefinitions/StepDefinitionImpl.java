package stepDefinitions;

import com.test.pages.AddCartPage;
import com.test.pages.HomePage;
import com.test.pages.ResultPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.BaseInit;

import java.io.IOException;

public class StepDefinitionImpl extends BaseInit {


    public float productPrice;
    HomePage homePage;
    ResultPage resultPage;
    AddCartPage addCartPage;

    public StepDefinitionImpl() throws IOException {
        super();
    }

    @Before
    public void launchTheEcommerceApplication() {

        driver = invokeBrowserAndLaunchURL();
    }

    @Given("^search for the (.+)$")
    public void search_for_the(String productName) {

       homePage =  page.getInstance(HomePage.class);
       homePage.getSearchField().sendKeys(productName);
       homePage.clickSubmitButton();

    }

    @When("^Add the first product in add cart twice$")
    public void add_the_first_product_in_add_cart_twice()  {
        resultPage =   page.getInstance(ResultPage.class);
        resultPage.openFirstProduct();
        productPrice = resultPage.getProductPrice();
        resultPage.addQuantityAsTwo();
        resultPage.addProductsToCart();
    }

    @And("Assert that total price and quantity are correct")
    public void assert_that_the_total_price_and_quantity_are_correct() {
        addCartPage =   page.getInstance(AddCartPage.class);
       float totalPriceInCart = addCartPage.getTotalCost();
       float  sumOfAllProducts = productPrice*2;
       Assert.assertEquals(sumOfAllProducts , totalPriceInCart);
    }

    @And("Reduce quantity to one in Cart section for the item selected")
    public void reduce_quantity_to_one_in_cart_section_for_the_item_selected() {
        addCartPage.goToCartSection();
        addCartPage.reduceQuantityToOne();
    }

    @Then("Assert that total price has been correctly changed")
    public void assert_that_total_price_has_been_correctly_changed()  {
      float updatedProductPrice = addCartPage.getUpdatedAmount();
        Assert.assertEquals(productPrice, updatedProductPrice);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
