package org.example.StepDefs;

import io.cucumber.java.en.*;
import org.example.pages.ProductPageActions;
import org.example.pages.CheckoutPageActions;
import org.example.utils.JsonDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CheckoutStepDef {
    WebDriver driver = new ChromeDriver();
    ProductPageActions productPage = new ProductPageActions(driver);
    CheckoutPageActions checkoutPage = new CheckoutPageActions(driver);

    // Load test data from JSON file
    List<Map<String, String>> checkoutData = JsonDataReader.getCheckoutData();

    @Given("I open the nopCommerce website")
    public void openNopCommerceWebsite() {
        driver.get("https://practicesoftwaretesting.com/");
    }

    @When("I add product from data set {int} to the cart")
    public void addProductToCart(int dataSetIndex) {
        // You can use the product name from JSON if needed
        Map<String, String> data = checkoutData.get(dataSetIndex);
        String product = data.get("product");
        productPage.addToCart();
    }

    @And("I proceed to checkout")
    public void proceedToCheckout() {
        checkoutPage.proceedToCheckout();
    }

    @And("I enter shipping information for data set {int}")
    public void enterShippingInformation(int dataSetIndex) {
        Map<String, String> data = checkoutData.get(dataSetIndex);
        String address = data.get("address");
        String city = data.get("city");
        String zip = data.get("zipCode");
        String phone = data.get("phone");

        checkoutPage.enterShippingInformation(address, city, zip, phone);
    }

    @And("I enter billing information for data set {int}")
    public void enterBillingInformation(int dataSetIndex) {
        Map<String, String> data = checkoutData.get(dataSetIndex);
        String cardType = data.get("cardType");
        String cardNumber = data.get("cardNumber");
        String expiryDate = data.get("expiryDate");
        String cvv = data.get("cvv");

        checkoutPage.enterBillingInformation(cardType, cardNumber, expiryDate, cvv);
    }

    @Then("I should see the confirmation message for data set {int}")
    public void verifyConfirmationMessage(int dataSetIndex) {
        Map<String, String> data = checkoutData.get(dataSetIndex);
        String expectedMessage = data.get("confirmationMessage");
        String actualMessage = checkoutPage.getConfirmationMessage();

        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
