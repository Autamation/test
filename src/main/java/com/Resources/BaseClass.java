package com.Resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void selectBrowsers(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {
	
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
		
			driver = new InternetExplorerDriver();
		}
		driver.get("http://119.82.97.217:9091/equality/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}
}
