package org.example.pages;

import org.openqa.selenium.By;

public class CartPageLocators {
    // Locator for the cart icon or link to view the cart
    public By cartIcon = By.cssSelector("a[href*='cart']");

    // Locator for the checkout button in the cart
    public By checkoutButton = By.cssSelector("button.checkout");

    // Locator for verifying product name in the cart
    public By productNameInCart = By.cssSelector(".product-name a");

    // Locator for quantity of the product in the cart
    public By productQuantity = By.cssSelector(".qty-input");

    // Locator for cart total price
    public By cartTotal = By.cssSelector(".cart-total-right .value");
}