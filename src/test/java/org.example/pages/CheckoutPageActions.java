package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPageActions {
    WebDriver driver;
    CheckoutPageLocators locators = new CheckoutPageLocators();

    public CheckoutPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout() {
        driver.findElement(locators.checkoutButton).click();
    }

    public void enterShippingInformation(String address, String city, String zip, String phone) {
        driver.findElement(locators.addressField).sendKeys(address);
        driver.findElement(locators.cityField).sendKeys(city);
        driver.findElement(locators.zipCodeField).sendKeys(zip);
        driver.findElement(locators.phoneField).sendKeys(phone);
    }

    public void enterBillingInformation(String cardType, String cardNumber, String expiry, String cvv) {
        new Select(driver.findElement(locators.cardTypeDropdown)).selectByVisibleText(cardType);
        driver.findElement(locators.cardNumberField).sendKeys(cardNumber);
        driver.findElement(locators.expiryDateField).sendKeys(expiry);
        driver.findElement(locators.cvvField).sendKeys(cvv);
        driver.findElement(locators.placeOrderButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(locators.confirmationMessage).getText();
    }
}
