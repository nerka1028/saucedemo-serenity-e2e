package com.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target FIRST_NAME = Target.the("first name field").located(By.id("first-name"));
    public static final Target LAST_NAME = Target.the("last name field").located(By.id("last-name"));
    public static final Target ZIP = Target.the("postal code").located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("continue button").located(By.id("continue"));
    public static final Target FINISH_BUTTON = Target.the("finish button").located(By.id("finish"));
    public static final Target CONFIRM_MESSAGE = Target.the("thank you message").located(By.className("complete-header"));

}
