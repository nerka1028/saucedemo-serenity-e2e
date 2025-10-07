package com.saucedemo.steps;

import com.saucedemo.questions.OrderConfirmation;
import com.saucedemo.tasks.*;
import com.saucedemo.ui.ProductsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.chrome.ChromeDriver;
import com.saucedemo.config.ChromeCustomOptions;
import net.serenitybdd.screenplay.targets.Target;
import java.util.ArrayList;
import java.util.List;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PurchaseSteps {

    @Managed(driver = "chrome")
    WebDriver browser;

    private final Actor user = Actor.named("Shopper");

    @Before
    public void setup() {
        WebDriver driver = new ChromeDriver(ChromeCustomOptions.get());
        user.can(BrowseTheWeb.with(driver));
    }

    @Given("the user logs in with username {string} and password {string}")
    public void loginWithParams(String username, String password) {
        user.attemptsTo(Login.withCredentials(username, password));
    }

    @When("the user adds {int} products to the cart")
    public void addProducts(int productCount) {
        List<Target> products = new ArrayList<>();
        for (int i = 1; i <= productCount; i++) {
            products.add(ProductsPage.productByIndex(i));
        }
        user.attemptsTo(AddProducts.toCart(products));
    }


    @And("completes the checkout process")
    public void completeCheckout() {
        user.attemptsTo(Checkout.completePurchase());
    }

    @Then("the confirmation message should be {string}")
    public void verifyConfirmation(String message) {
        user.should(seeThat(OrderConfirmation.message(), equalTo(message)));
    }
}
