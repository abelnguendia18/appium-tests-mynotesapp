package com.tapondjou.appiumtestsmynotesapp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TF4 {

    AppiumDriver<MobileElement> driver;

    @Before
    public void init() throws MalformedURLException {

        driver = Utils.getDriver("UiAutomator2", "Android");

    }

    @Test
    public void createEmptyNoteTest() throws InterruptedException {

        driver.findElementById("com.tapondjou.mynotesapp:id/fab").click();
        Thread.sleep(1000);
        driver.findElementById("com.tapondjou.mynotesapp:id/button_create_note").click();
        Thread.sleep(1000);
        MobileElement toastWidget = driver.findElementByXPath("//android.widget.Toast[1]");
        Assert.assertEquals("Title required",toastWidget.getText().toString());


    }

    @After
    public void tearDown() {

        driver.quit();

    }
}
