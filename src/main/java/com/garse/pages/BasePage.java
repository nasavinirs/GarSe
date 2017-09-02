package com.garse.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/***
 * This class is the Base class of all the page object files we are going to create,
 * This framework using PageFactory while creating page object design pattern.
 * @author srinivasans
 *
 */

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public void takeScreenShot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = this.getClass().getSimpleName() + "_" + new SimpleDateFormat("ddMMYYYY_HHmmss").format(new Date()) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/screenshots/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
