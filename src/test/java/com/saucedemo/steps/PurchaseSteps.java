package com.saucedemo.steps;

import com.saucedemo.questions.OrderConfirmation;
import com.saucedemo.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Managed;
import com.saucedemo.utils.UserLoader;
import org.openqa.selenium.chrome.ChromeDriver;
import com.saucedemo.config.ChromeCustomOptions;

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

    @Given("the user logs in with valid credentials")
    public void login() {
        user.attemptsTo(Login.withCredentials(
                UserLoader.getUsername("standard_user"),
                UserLoader.getPassword("standard_user")
        ));
    }

    @When("the user adds two products to the cart")
    public void addProducts() {
        user.attemptsTo(AddProducts.toCart());
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
