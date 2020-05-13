package eQualityLab.eQualityLabs_project;

import org.testng.annotations.Test;

import com.PageObjects.TrustMarksPage;
import com.Resources.BaseClass;

public class Tc_002Freeaccount extends BaseClass {
	@Test

	public void freeAccountPage() {
		TrustMarksPage tp = new TrustMarksPage(driver);
		tp.clickontrusrmark();
		tp.clickonfreeaccount();
		tp.clickonName();
		tp.clickonEmail();
		tp.clickonpassword();
		tp.clickonConfrmpassword();
		tp.clickonCreatebutton();
	}

}
