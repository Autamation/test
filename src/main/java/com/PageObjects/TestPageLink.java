package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPageLink {

	WebDriver driver;
	@FindBy(xpath = "//input[@id='mat-input-2']")
	private WebElement link;

	public void clickontestLink() {
		link.sendKeys("https://www.google.com/");
	}

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement testpage1;

	public void clickontestPage() {
		testpage1.click();
	}

	@FindBy(xpath = "//button[@class='btn btn-outline-primary btn-sm ng-star-inserted']/parent::td")
	private WebElement report;

	public void clickonviewReport() {
		report.click();
	}

	public TestPageLink(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
