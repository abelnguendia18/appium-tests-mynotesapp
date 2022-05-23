package com.tapondjou.appiumtestsmynotesapp;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.io.IOException;
import java.io.File;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TF3 {

    @Rule
    public TestName name = new TestName();


    AppiumDriver<MobileElement> driver;

    @Test
    public void createNoteScreenTest_enEN() throws InterruptedException, IOException {

        driver = Utils.getDriver("UiAutomator2", "Android", "en", "EN");
        driver.findElementById("com.tapondjou.mynotesapp:id/fab").click();
        driver.findElementByXPath("//android.widget.EditText[contains(@text, 'Title')]").isDisplayed();
        driver.findElementByXPath("//android.widget.EditText[contains(@text, 'Description')]").isDisplayed();

    }

    @Test
    public void createNoteScreenTest_deDE() throws InterruptedException, IOException {

        driver = Utils.getDriver("UiAutomator2", "Android", "de", "DE");
        driver.findElementById("com.tapondjou.mynotesapp:id/fab").click();
        driver.findElementByXPath("//android.widget.EditText[contains(@text, 'Titel')]").isDisplayed();
        driver.findElementByXPath("//android.widget.EditText[contains(@text, 'Beschreibung')]").isDisplayed();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


}

