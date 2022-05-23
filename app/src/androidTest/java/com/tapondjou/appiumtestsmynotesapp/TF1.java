package com.tapondjou.appiumtestsmynotesapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
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
        String PATH_TO_PRIORITY_3 = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]";

        //Click on the add note button
        driver.findElementById("com.tapondjou.mynotesapp:id/fab").click();

        //Wait for the items to load on the screen
        Thread.sleep(1000);

        //Enter note information
        driver.findElementById("com.tapondjou.mynotesapp:id/edt_note_title").sendKeys(TITLE_TO_ENTER);
        driver.findElementById("com.tapondjou.mynotesapp:id/edt_note_description").sendKeys(DESCRIPTION_TO_ENTER);
        driver.findElementById("com.tapondjou.mynotesapp:id/spinner_for_priority").click();
        //Set notes's priority to 3
        Utils.selectClassNameWhereValueIsText("3", Constants.CHECKED_TEXT_VIEW_CLASS_NAME, driver).click();
        driver.findElementById("com.tapondjou.mynotesapp:id/checkBox_color").click();

        //Save the note
        driver.findElementById("com.tapondjou.mynotesapp:id/button_create_note").click();
        Thread.sleep(1000);

        //Verify that the note is displayed on screen
        Utils.selectClassNameWhereValueIsText(TITLE_TO_ENTER, Constants.TEXT_VIEW_CLASS_NAME, driver).isDisplayed();
        Utils.selectClassNameWhereValueIsText(DESCRIPTION_TO_ENTER, Constants.TEXT_VIEW_CLASS_NAME, driver).isDisplayed();
        Utils.selectClassNameWhereValueIsText("3", Constants.TEXT_VIEW_CLASS_NAME, driver).isDisplayed();
        Utils.selectClassNameWhereValueIsText("Checked", Constants.TEXT_VIEW_CLASS_NAME, driver).isDisplayed();

    }







    @After
    public void tearDown() {

        driver.quit();

    }



}

