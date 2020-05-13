package eQualityLab.eQualityLabs_project;

import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.TestPageLink;
import com.Resources.BaseClass;

public class Tc_001SignInpage extends BaseClass {
	@Test

	public void loginPage() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clickonsign();
		hp.clickonemail();
		hp.clickonpassword();
		hp.clickonlogin();
		TestPageLink tl = new TestPageLink(driver);
		tl.clickontestLink();
		tl.clickontestPage();
		tl.clickonviewReport();

	}

}
