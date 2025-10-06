package com.saucedemo.tasks;

import com.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Checkout implements Task {

    public static Checkout completePurchase() {
        return instrumented(Checkout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(net.serenitybdd.screenplay.targets.Target.the("checkout button")
                        .locatedBy("//button[@id='checkout']")),
                Enter.theValue("Dummy").into(CheckoutPage.FIRST_NAME),
                Enter.theValue("User").into(CheckoutPage.LAST_NAME),
                Enter.theValue("170103").into(CheckoutPage.ZIP),
                Click.on(CheckoutPage.CONTINUE_BUTTON),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }
}
