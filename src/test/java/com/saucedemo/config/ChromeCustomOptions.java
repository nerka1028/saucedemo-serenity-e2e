package com.saucedemo.config;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeCustomOptions {

    public static ChromeOptions get() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments(

                "--disable-gpu",
                "--window-size=1920,1080",
                "--disable-blink-features=AutomationControlled",
                "--disable-extensions",
                "--disable-password-manager-reauthentication",
                "--disable-save-password-bubble",
                "--no-default-browser-check",
                "--disable-infobars",
                "--disable-popup-blocking"
        );

        return options;
    }
}
