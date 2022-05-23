package com.tapondjou.appiumtestsmynotesapp;


import java.net.MalformedURLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TF2 {


    AppiumDriver<MobileElement> driver;

    @Before
    public void init() throws MalformedURLException {

        driver = Utils.getDriver("UiAutomator2", "Android");

    }


    @Test
    public void itemsDisplayOnScreenTest() throws InterruptedException {

        driver.findElementById("com.tapondjou.mynotesapp:id/fab").click();
        Thread.sleep(1000);

        driver.findElementById("com.tapondjou.mynotesapp:id/edt_note_title").isDisplayed();
        driver.findElementById("com.tapondjou.mynotesapp:id/edt_note_description").isDisplayed();
        driver.findElementById("com.tapondjou.mynotesapp:id/tv_setPriority").isDisplayed();
        driver.findElementById("com.tapondjou.mynotesapp:id/spinner_for_priority").isDisplayed();
        driver.findElementById("com.tapondjou.mynotesapp:id/checkBox_color");
        driver.findElementById("com.tapondjou.mynotesapp:id/button_create_note").isDisplayed();

        //Element's labels should be also displayed
        driver.findElementByXPath("//android.widget.TextView[contains(@text, 'New Note')]").isDisplayed();
        driver.findElementByXPath("//android.widget.EditText[contains(@text, 'Title')]").isDisplayed();
        driver.findElementByXPath("//android.widget.EditText[contains(@text, 'Description')]").isDisplayed();
        driver.findElementByXPath("//android.widget.CheckBox[contains(@text, 'Check')]").isDisplayed();
        driver.findElementByXPath("//android.widget.Button[contains(@text, 'CREATE NOTE')]").isDisplayed();

    }


    @After
    public void tearDown() {

        driver.quit();

    }


}

