/*"STEP 1 - Launch Chrome browser
STEP 2 - Hit https://staging.dev.theeliteqa.com URL
VERFIY - Login page is visible [Login button is displayed, useremail is enabled, password is enabled]
STEP 3 - Enter valid username
STEP 4 - Enter valid password
STEP 5 - Click on Login button
VERIFY - Dashboard page is displayed"
*/package seleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ControlActions;

public class TestCase1 {

	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("STEP 1 - Launch Chrome browser");
		System.out.println("STEP 2 - Hit https://staging.dev.theeliteqa.com URL");
		driver = ControlActions.start("https://staging.dev.theeliteqa.com");
	}
	
	@Test
	public void loginPage() {
		System.out.println("VERFIY - Login page is visible [Login button is displayed, useremail is enabled, password is enabled]");
		System.out.println("Verify - Login button is displayed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
		Assert.assertTrue(loginBtn.isDisplayed());
		
		System.out.println("Verify - useremail is enabled");
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Enter email']"));
		Assert.assertTrue(username.isEnabled());
		
		System.out.println("Verify - password is enabled");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter password']"));
		Assert.assertTrue(password.isEnabled());
		
		System.out.println("STEP 3 - Enter valid username");
		username.sendKeys("ashwinimay24@gmail.com");
		
		System.out.println("STEP 4 - Enter valid password");
		password.sendKeys("May@123");
		
		System.out.println("STEP 5 - Click on Login button");
		loginBtn.click();
		
		System.out.println("VERIFY - Dashboard page is displayed");
		WebElement inviteUsed = driver.findElement(By.xpath("//span[text()='Invites Used']"));
		Assert.assertTrue(inviteUsed.isDisplayed());
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
