package com.saucedemo.config;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CustomChromeDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        ChromeOptions options = new ChromeOptions();

        try {
            Path tempProfile = Files.createTempDirectory("chrome-profile-");
            options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error creating temp profile: " + e.getMessage());
        }


        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2); // Block notifications

        options.setExperimentalOption("prefs", prefs);


        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-autofill-keyboard-accessory-view");
        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
