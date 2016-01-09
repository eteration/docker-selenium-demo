package com.eteration.selenium.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WikipediaTest {

	private static RemoteWebDriver driver;

	WebElement element;

	@BeforeClass
	public static void firefoxSetUp() throws MalformedURLException {

		DesiredCapabilities capability = DesiredCapabilities.firefox();
		// DesiredCapabilities capability =
		// DesiredCapabilities.internetExplorer();

		driver = new RemoteWebDriver(new URL("http://selfirefox:4444/wd/hub"), capability);

		// driver = new FirefoxDriver(); //for local check

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920, 1080));
	}

	@Test
	public void valid_WikipediaMainpage() {

		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		WebElement mediawiki = null;

		try {
			mediawiki = driver.findElementByClassName("mediawiki");
		} catch (Exception e) {
		}
		Assert.assertNotNull(mediawiki);
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
