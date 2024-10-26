package org.example.pages;

import org.openqa.selenium.WebDriver;

public class ProductPageActions {
    WebDriver driver;
    ProductPageLocators locators = new ProductPageLocators();

    public ProductPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(locators.addToCartButton).click();
    }
}
