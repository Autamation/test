package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrustMarksPage {

	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'TrustMark')]")
	private WebElement trustmarks;

	public void clickontrusrmark() {
		trustmarks.click();
	}

	@FindBy(xpath = "//button[@id='main']")
	private WebElement changeplan;

	public void clickonfreeaccount() {
		changeplan.click();
	}

	@FindBy(xpath = "//*[@id=\"parent\"]/app-plans/div[2]/div[2]/div/div[2]/div/div[2]/div/button")
	private WebElement changeplan1;

	public void clickonIndivualAccount() {
		changeplan1.click();
	}

	@FindBy(xpath = "//div[@class='text-center']//following::button[3]")
	private WebElement changeplan2;

	public void clickonBusinesAccount() {
		changeplan2.click();
	}

	@FindBy(xpath = "//input[@id='main']")
	private WebElement freeaccountname;

	public void clickonName() {
		freeaccountname.sendKeys("shruti");
	}

	@FindBy(xpath = "//input[@id='mat-input-2']")
	private WebElement freeaccountemail;

	public void clickonEmail() {
		freeaccountemail.sendKeys("shruti@prakat.in");
	}

	@FindBy(xpath = "//input[@id='mat-input-3']")
	private WebElement freeaccountpassword;

	public void clickonpassword() {
		freeaccountpassword.sendKeys("shruti@1996");
	}

	@FindBy(xpath = "//input[@id='mat-input-4']")
	private WebElement freeaccountconfrmpassword;

	public void clickonConfrmpassword() {
		freeaccountconfrmpassword.sendKeys("shruti@1996");
	}

	@FindBy(xpath = "//span[contains(text(),'Create account')]")
	private WebElement freeaccountcreate;

	public void clickonCreatebutton() {
		freeaccountcreate.click();
	}

	public TrustMarksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
