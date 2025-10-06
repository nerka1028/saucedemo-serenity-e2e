package com.saucedemo.questions;

import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class OrderConfirmation implements Question<String> {

    public static OrderConfirmation message() {
        return new OrderConfirmation();
    }

    @Override
    public String answeredBy(Actor actor) {
        return CheckoutPage.CONFIRM_MESSAGE.resolveFor(actor).getText();
    }
}