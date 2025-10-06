package com.saucedemo.tasks;

import com.saucedemo.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProducts implements Task {

    public static AddProducts toCart() {
        return instrumented(AddProducts.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsPage.ADD_TO_CART_FIRST),
                Click.on(ProductsPage.ADD_TO_CART_SECOND),
                Click.on(ProductsPage.CART_ICON)
        );
    }
}
