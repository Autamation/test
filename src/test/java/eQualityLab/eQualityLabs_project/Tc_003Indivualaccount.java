package eQualityLab.eQualityLabs_project;

import org.testng.annotations.Test;

import com.PageObjects.TrustMarksPage;

import com.Resources.BaseClass;

public class Tc_003Indivualaccount extends BaseClass {
	@Test
	public void IndivualAccountPage() {
		TrustMarksPage tp = new TrustMarksPage(driver);
		tp.clickontrusrmark();

		tp.clickonIndivualAccount();
		tp.clickonName();
		tp.clickonEmail();
		tp.clickonpassword();
		tp.clickonConfrmpassword();
		tp.clickonCreatebutton();

	}

}
