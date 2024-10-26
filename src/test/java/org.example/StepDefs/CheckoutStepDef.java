package org.example.StepDefs;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import org.example.pages.ProductPageActions;
import org.example.pages.CartPageActions;
import org.example.pages.CheckoutPageActions;
import org.example.utils.BaseDriver;
import org.example.utils.JsonDataReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CheckoutStepDef {
    private static WebDriver driver;
    private static ProductPageActions productPage;
    private static CartPageActions cartPage;
    private static CheckoutPageActions checkoutPage;

    // Load test data from JSON file
    List<Map<String, String>> checkoutData = JsonDataReader.getCheckoutData();

    @BeforeAll
    public static void setup() {
        driver = BaseDriver.getDriver();
        productPage = new ProductPageActions(driver);
        cartPage = new CartPageActions(driver);
        checkoutPage = new CheckoutPageActions(driver);
    }

    @Given("I open the nopCommerce website")
    public void i_open_the_nop_commerce_website() {
        driver.get("https://practicesoftwaretesting.com/");
    }

    @When("I add two random products to the cart")
    public void i_add_two_random_products_to_the_cart() {
        productPage.addTwoProductsToCart(); // Add two products and return to the home page
    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout() {
        productPage.scrollToCartIconAndClick(); // Scroll up and click the cart icon to proceed
        cartPage.openCart(); // Open the cart page
        cartPage.proceedToCheckout(); // Click checkout on the cart page to continue
    }

    @When("I enter shipping information for data set {int}")
    public void i_enter_shipping_information_for_data_set(Integer dataSetIndex) {
        Map<String, String> data = checkoutData.get(dataSetIndex);
        checkoutPage.enterShippingInformation(
                data.get("address"),
                data.get("city"),
                data.get("zipCode"),
                data.get("phone")
        );
    }

    @And("I enter billing information for data set {int}")
    public void i_enter_billing_information_for_data_set(Integer dataSetIndex) {
        Map<String, String> data = checkoutData.get(dataSetIndex);
        checkoutPage.enterBillingInformation(
                data.get("cardType"),
                data.get("cardNumber"),
                data.get("expiryDate"),
                data.get("cvv")
        );
    }

    @Then("I should see the confirmation message for data set {int}")
    public void i_should_see_the_confirmation_message_for_data_set(Integer dataSetIndex) {
        Map<String, String> data = checkoutData.get(dataSetIndex);
        String expectedMessage = data.get("confirmationMessage");
        String actualMessage = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @AfterAll
    public static void tearDown() {
        // Quit the driver after all scenarios are completed
        BaseDriver.quitDriver();
    }
}
