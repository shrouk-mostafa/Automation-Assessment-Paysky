package org.example.pages;

import org.openqa.selenium.WebDriver;

public class CartPageActions {
    WebDriver driver;
    CartPageLocators locators = new CartPageLocators();

    public CartPageActions(WebDriver driver) {
        this.driver = driver;
    }

    // Method to open the cart
    public void openCart() {
        driver.findElement(locators.cartIcon).click();
    }

    // Method to verify product in the cart by name
    public boolean isProductInCart(String expectedProductName) {
        String actualProductName = driver.findElement(locators.productNameInCart).getText();
        return actualProductName.equalsIgnoreCase(expectedProductName);
    }

    // Method to get the quantity of a product in the cart
    public int getProductQuantity() {
        String quantityText = driver.findElement(locators.productQuantity).getAttribute("value");
        return Integer.parseInt(quantityText);
    }

    // Method to get the cart total price
    public String getCartTotal() {
        return driver.findElement(locators.cartTotal).getText();
    }

    // Method to proceed to checkout
    public void proceedToCheckout() {
        driver.findElement(locators.checkoutButton).click();
    }
}
