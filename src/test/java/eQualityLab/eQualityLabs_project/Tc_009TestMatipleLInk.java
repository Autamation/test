package eQualityLab.eQualityLabs_project;

import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.TestMatipleLinks;
import com.Resources.BaseClass;

public class Tc_009TestMatipleLInk extends BaseClass {
	@Test
	public void TestmatiplePage() {
		HomePage hp1 = new HomePage(driver);
		hp1.clickonsign();
		hp1.clickonemail();
		hp1.clickonpassword();
		hp1.clickonlogin();
		TestMatipleLinks tm = new TestMatipleLinks(driver);
		tm.clickonTestmatiplelink();
		tm.clickondownloadLink();
		tm.clickondashaboard();
		tm.clickonSignout();
		tm.clickonHome();
	}

}
