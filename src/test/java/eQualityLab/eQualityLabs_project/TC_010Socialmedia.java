package eQualityLab.eQualityLabs_project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Resources.BaseClass;

public class TC_010Socialmedia extends BaseClass {
	@Test

	public void socialMediaclasses() {

		WebElement foot = driver.findElement(By.xpath("//li/a[contains(@href,\"https\")]/../.."));

		List<WebElement> socialmedialinks = foot.findElements(By.tagName("a"));

		Actions build1 = new Actions(driver);

		for (WebElement i : socialmedialinks)

		{

			System.out.println(i);

			build1.moveToElement(i).keyDown(Keys.CONTROL).click().build().perform();
		}
	}
}
