package org.example.pages;

import org.openqa.selenium.By;

public class CheckoutPageLocators {
    public By checkoutButton = By.cssSelector("button[data-test='proceed-1']");
    public By addressField = By.id("address");
    public By cityField = By.id("city");
    public By zipCodeField = By.id("zip");
    public By phoneField = By.id("phone");
    public By cardTypeDropdown = By.id("cardType");
    public By cardNumberField = By.id("cardNumber");
    public By expiryDateField = By.id("expiryDate");
    public By cvvField = By.id("cvv");
    public By placeOrderButton = By.cssSelector("button.place-order");
    public By confirmationMessage = By.id("confirmationMessage");
}
