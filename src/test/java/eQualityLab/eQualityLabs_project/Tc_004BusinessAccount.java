package eQualityLab.eQualityLabs_project;

import org.testng.annotations.Test;

import com.PageObjects.TrustMarksPage;

import com.Resources.BaseClass;

public class Tc_004BusinessAccount extends BaseClass {

	@Test
	public void BusinessAccountPage() {
		TrustMarksPage tp = new TrustMarksPage(driver);
		tp.clickontrusrmark();
		tp.clickonBusinesAccount();
		tp.clickonName();
		tp.clickonEmail();
		tp.clickonpassword();
		tp.clickonConfrmpassword();
		tp.clickonCreatebutton();

	}

}
