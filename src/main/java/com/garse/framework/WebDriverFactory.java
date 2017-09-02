package com.garse.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/***
 * This class will instantiate the webdriver based on the browser which is called.
 * 
 * @author srinivasans
 *
 */

public class WebDriverFactory {

	private static WebDriver driver = null;
	private static DesiredCapabilities desiredCapabilities = null;

	private static WebDriver getDriver(String browser, boolean jsEnabled) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
			return new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			return new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {

		} else if (browser.equalsIgnoreCase("safari")) {
			return new SafariDriver();
		}
		return driver;
	}

	/***
	 * This is the single public method which is accessible to tbe user. T
	 * his method will call the actual method which will return the required webdriver based on the browser passed. 
	 * @param browser
	 * @return
	 */
	public static WebDriver getDriver(String browser) {
		return getDriver(browser, true);
	}
}
