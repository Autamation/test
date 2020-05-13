package eQualityLab.eQualityLabs_project;

import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.Resources.BaseClass;

public class Tc_005Resources extends BaseClass {

	@Test

	public void ResourcesPage() {

		HomePage hp = new HomePage(driver);
		hp.clickonresource();

	}

}
