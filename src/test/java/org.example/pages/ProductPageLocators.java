package org.example.pages;
import org.openqa.selenium.By;

public class ProductPageLocators {
    public By addToCartButton = By.id("btn-add-to-cart");
    public By productCard = By.cssSelector("a.card");
    public By outOfStockLabel = By.cssSelector(".out-of-stock");
    public By cartIcon = By.cssSelector("a[data-test='nav-cart']");
}
