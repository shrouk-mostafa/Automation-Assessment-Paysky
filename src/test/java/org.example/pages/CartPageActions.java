package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPageActions {
    WebDriver driver;
    WebDriverWait wait;
    CartPageLocators locators = new CartPageLocators();

    public CartPageActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Method to open the cart and wait for any overlay (toast message) to disappear
    public void openCart() {
        // Wait for the toast message to disappear if present
        waitForToastMessageToDisappear();
        // Wait for cart icon and click it to open cart page
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(locators.cartIcon));
        cartButton.click();
    }
    public void proceedToCheckout() {
        // Wait for the toast message to disappear if present
        waitForToastMessageToDisappear();
        // Wait for checkout button on the cart page and click it
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(locators.checkoutButton));
        checkoutButton.click();
    }
    private void waitForToastMessageToDisappear() {
        // Check if the toast message is present and wait for it to disappear
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locators.toastMessage));
        } catch (Exception e) {
            System.out.println("Toast message not present or already gone.");
        }
    }

}
