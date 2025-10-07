package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {

    public static Target productByIndex(int index) {
        return Target.the("Add to cart button for product " + index)
                .located(By.xpath("(//button[contains(@id,'add-to-cart')])[" + index + "]"));
    }

    public static final Target CART_ICON = Target.the("Shopping cart icon")
            .located(By.className("shopping_cart_link"));
}
