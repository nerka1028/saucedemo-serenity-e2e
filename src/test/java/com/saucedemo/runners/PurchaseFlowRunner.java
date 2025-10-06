package com.saucedemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/purchase_flow.feature",
        glue = "com.saucedemo.steps",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class PurchaseFlowRunner {
}
