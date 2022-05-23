package com.tapondjou.appiumtestsmynotesapp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Utils {



    public static AppiumDriver<MobileElement> getDriver(String driverName, String PlatformName, String language, String locale) throws MalformedURLException{

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PlatformName);
        //capabilities.setCapability("platformVersion", "11");
        //capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability(MobileCapabilityType.UDID, "897X06F1Q");
        capabilities.setCapability("automationName", driverName);
        capabilities.setCapability("app", "/Users/abelnguendiat./Documents/GitHub/appium-tests-mynotesapp/app-release.apk");
        capabilities.setCapability("appPackage", "com.tapondjou.mynotesapp");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("language", language);
        capabilities.setCapability("locale", locale);
        capabilities.setCapability("forceEspressoRebuild", "true");
        URL url = new URL("http://172.20.10.02:4723/wd/hub/");
        return new AppiumDriver<MobileElement>(url, capabilities);

    }

    public static AppiumDriver<MobileElement> getDriver(String driverName, String PlatformName) throws MalformedURLException{

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", PlatformName);
        //capabilities.setCapability("platformVersion", "11");
        //capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability(MobileCapabilityType.UDID, "897X06F1Q");
        capabilities.setCapability("automationName", driverName);
        capabilities.setCapability("app", "/Users/abelnguendiat./Documents/GitHub/appium-tests-mynotesapp/app-release.apk");
        capabilities.setCapability("appPackage", "com.tapondjou.mynotesapp");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("forceEspressoRebuild", "true");
        URL url = new URL("http://172.20.10.02:4723/wd/hub/");
        return new AppiumDriver<MobileElement>(url, capabilities);

    }

    //Find element by Text and ClassName
    public static MobileElement selectClassNameWhereValueIsText(String text, String className, AppiumDriver<MobileElement> driver) {

        String selector = "new UiSelector().text(\""+ text +"\").className(\""+ className +"\")";

        return driver.findElement(MobileBy.AndroidUIAutomator(selector));
    }



}
