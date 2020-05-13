package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Sign In')]")
	private WebElement signin;

	public void clickonsign() {
		signin.click();
	}

	@FindBy(xpath = "//input[@id='main']")
	private WebElement email;

	public void clickonemail() {
		email.sendKeys("shruti@prakat.in");
	}

	@FindBy(xpath = "//input[@id='mat-input-1']")
	private WebElement password;

	public void clickonpassword() {
		password.sendKeys("shruti@1996");
	}

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	private WebElement login;

	public void clickonlogin() {
		login.click();
	}

	@FindBy(xpath = "//a[contains(text(),'Resources')]")
	private WebElement resourcsepage;

	public void clickonresource() {
		resourcsepage.click();
	}

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	private WebElement signuppage;

	public void clickonsignup() {
		signuppage.click();
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
