package eQualityLab.eQualityLabs_project;

import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.TrustMarksPage;
import com.Resources.BaseClass;

public class Tc_006SignupFreeaccount extends BaseClass {
	@Test
	public void FreeAccountCreatePage() {
		HomePage hm = new HomePage(driver);
		hm.clickonsignup();
		TrustMarksPage tp = new TrustMarksPage(driver);
		tp.clickonfreeaccount();
		tp.clickonName();
		tp.clickonEmail();
		tp.clickonpassword();
		tp.clickonConfrmpassword();
		tp.clickonCreatebutton();

	}

}
