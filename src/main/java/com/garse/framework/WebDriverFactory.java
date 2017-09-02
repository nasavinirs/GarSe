package com.garse.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/***
 * This class is used to call
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

	public static WebDriver getDriver(String browser) {
		return getDriver(browser, true);
	}
}
