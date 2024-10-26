package org.example.pages;

import org.openqa.selenium.By;

public class CartPageLocators {
    // Locator for the cart icon
    public By cartIcon = By.cssSelector("a[data-test='nav-cart']");
    // Locator for the toast message overlay
    public By toastMessage = By.cssSelector("div.toast-message");
    public By checkoutButton = By.cssSelector("button[data-test='proceed-1']");
}