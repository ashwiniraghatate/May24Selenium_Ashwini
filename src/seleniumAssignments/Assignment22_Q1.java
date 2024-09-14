/*Assignment 22 Date:4th Sep

Note:Use Random class.
https://www.facebook.com/
Step 1) Open the Browser
Step 2) goto the URL
step 3) click On Create New Account
step 4) Fill the form.*/

package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ControlActions;

public class Assignment22_Q1 {
	WebDriver driver;

	@BeforeClass 
	void startBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ControlActions.start("https://www.facebook.com/");
	}
	
	@Test
	void createAccount() {
		WebElement createAcc = driver.findElement(By.xpath("//a[text()='Create new account']"));
		System.out.println(createAcc.getText());
		createAcc.click();
	}
	
	@AfterClass(enabled=false)
	void closeSession() {
		driver.quit();
	}
}
