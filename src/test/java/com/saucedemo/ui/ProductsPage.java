package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage {
    public static final Target ADD_TO_CART_FIRST = Target.the("first product add button").located(By.xpath("(//button[contains(@id,'add-to-cart')])[1]"));
    public static final Target ADD_TO_CART_SECOND = Target.the("second product add button").located(By.xpath("(//button[contains(@id,'add-to-cart')])[2]"));
    public static final Target CART_ICON = Target.the("cart icon").located(By.className("shopping_cart_link"));

}
