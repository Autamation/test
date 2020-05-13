package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestMatipleLinks {

	WebDriver driver;
	@FindBy(xpath = "//*[contains(text(),'Test multiple pages')]")
	private WebElement matiplelink;

	public void clickonTestmatiplelink() {
		matiplelink.click();
	}

	@FindBy(xpath = "//span[contains(text(),'Download Template')]")
	private WebElement linkdownload;

	public void clickondownloadLink() {
		linkdownload.click();
	}

	@FindBy(xpath = "//a[contains(text(),'Dashboard')]")
	private WebElement dashaboard;

	public void clickondashaboard() {
		dashaboard.click();
	}

	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	private WebElement signout;

	public void clickonSignout() {
		signout.click();
	}

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement home;

	public void clickonHome() {
		home.click();
	}

	public TestMatipleLinks(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
