package org.example.pages;

import org.example.pages.ProductPageLocators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductPageActions {
    WebDriver driver;
    WebDriverWait wait;
    ProductPageLocators locators = new ProductPageLocators();

    public ProductPageActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to select exactly two random in-stock products and add them to the cart
    public void addTwoProductsToCart() {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.productCard));
        Random random = new Random();
        int addedProducts = 0;

        while (addedProducts < 2) {
            // Select a random product from the list
            WebElement product = products.get(random.nextInt(products.size()));

            // Check if the product is out of stock by looking for the "Out of Stock" label
            if (product.findElements(locators.outOfStockLabel).isEmpty()) {
                // If no "Out of Stock" label is found, click the product to go to its details page
                product.click();

                // Wait and click "Add to Cart" button
                WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(locators.addToCartButton));
                addToCartButton.click();

                // Navigate back to the home page after adding to cart
                driver.navigate().back();

                // Refresh the product list after navigating back
                products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators.productCard));
                addedProducts++; // Increment counter after successfully adding an item
            }
        }
    }

    // Method to scroll up and click the cart icon
    public void scrollToCartIconAndClick() {
        // Wait for the cart icon to be clickable and scroll it into view
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(locators.cartIcon));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartIcon);

        // Click on the cart icon to open the cart or checkout page
        cartIcon.click();
    }
}
