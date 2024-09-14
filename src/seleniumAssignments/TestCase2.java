/*STEP 1 - Launch Chrome browser
STEP 2 - Hit https://staging.dev.theeliteqa.comlogin URL.
STEP 3 - Enter valid username
STEP 4 - Enter Invalid password
STEP 5 - Click on Login button
VERIFY - Popup with the error message "Authentication failed, please check your username and password." should be displayed
VERIFY - Login page is still visible.*/

package seleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ControlActions;

public class TestCase2 {

	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("STEP 1 - Launch Chrome browser");
		System.out.println("STEP 2 - Hit https://staging.dev.theeliteqa.com URL");
		driver = ControlActions.start("https://staging.dev.theeliteqa.com");
	}
	
	@Test
	public void invalidPswd() {
		System.out.println("VERFIY - Login page is visible [Login button is displayed, useremail is enabled, password is enabled]");
		System.out.println("Verify - Login button is displayed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
		
		System.out.println("STEP 3 - Enter valid username");
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Enter email']"));
		username.sendKeys("ashwinimay24@gmail.com");
		
		System.out.println("STEP 4 - Enter invalid password");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter password']"));
		password.sendKeys("May@1234");
		
		System.out.println("STEP 5 - Click on Login button");
		loginBtn.click();
		
		System.out.println("VERIFY - Popup with the error message \"Authentication failed, please check your username and password.\" "
				+ "should be displayed");
		//Alert alert = driver.switchTo().alert();
		String alertText = driver.findElement(By.xpath("//div[contains(@class,'Toastify__toast-container')]")).getText();
		System.out.println(alertText + " is displayed");
		
		System.out.println("VERIFY - Login page is still visible.");
		Assert.assertTrue(loginBtn.isDisplayed());
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
