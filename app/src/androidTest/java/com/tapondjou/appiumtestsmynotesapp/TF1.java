package com.tapondjou.appiumtestsmynotesapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TF1 {

    AppiumDriver<MobileElement> driver;


    @Before
    public void init() throws MalformedURLException {

        driver = Utils.getDriver("UiAutomator2", "Android");


    }


    @Test
    public void createNoteTest() throws InterruptedException {

        String TITLE_TO_ENTER = "Title 2";
        String DESCRIPTION_TO_ENTER = "Description 2";

        //Click on the add note button
        driver.findElementById("com.tapondjou.mynotesapp:id/fab").click();

        //Wait for the items to load on the screen
        Thread.sleep(1000);

        //Enter note's title and description
        driver.findElementById("com.tapondjou.mynotesapp:id/edt_note_title").sendKeys(TITLE_TO_ENTER);
        driver.findElementById("com.tapondjou.mynotesapp:id/edt_note_description").sendKeys(DESCRIPTION_TO_ENTER);

        //Save the note
        driver.findElementById("com.tapondjou.mynotesapp:id/button_create_note").click();
        Thread.sleep(1000);

        //Verify that the note is displayed on screen
        Utils.selectClassNameWhereValueIsText(TITLE_TO_ENTER, Constants.TEXT_VIEW_CLASS_NAME, driver).isDisplayed();
        Utils.selectClassNameWhereValueIsText(DESCRIPTION_TO_ENTER, Constants.TEXT_VIEW_CLASS_NAME, driver).isDisplayed();

    }







    @After
    public void tearDown() {

        driver.quit();

    }



}

