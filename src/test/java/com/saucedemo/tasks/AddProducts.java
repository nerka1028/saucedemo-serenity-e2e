package com.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProducts implements Task {

    private final List<Target> products;

    public AddProducts(List<Target> products) {
        this.products = products;
    }

    public static AddProducts toCart(List<Target> products) {
        return instrumented(AddProducts.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Target product : products) {
            actor.attemptsTo(
                    Scroll.to(product),
                    Click.on(product)
            );
        }
        actor.attemptsTo(Click.on(com.saucedemo.ui.ProductsPage.CART_ICON));
    }
}
