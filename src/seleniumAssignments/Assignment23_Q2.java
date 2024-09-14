/*eliteQA.
Login to application and verify 4 labels and 2 button is displayed ! */

package seleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment23_Q2 {
	WebDriver driver;
	
	@BeforeClass
	void launchBrowser() {
		System.out.println("step launch browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://staging.theeliteqa.com/login");
	}

	@Test
	void lables() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		System.out.println("Step-Enter email for login");
		driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("ashwinimay24@gmail.com");
		
		System.out.println("Step-Enter Password for login");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("May@123");
		
		System.out.println("Step-Click on Login for login");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		System.out.println("Verify-check Invites Used is displayed");
		WebElement inviteUsed = driver.findElement(By.xpath("//span[text()='Invites Used']"));
		Assert.assertTrue(inviteUsed.isDisplayed());
		
		System.out.println("Verify-check Total Assessments is displayed");
		WebElement totalAsses = driver.findElement(By.xpath("//div[@data-tip='Total Assessments']"));
		Assert.assertTrue(totalAsses.isDisplayed());
		
		System.out.println("Verify-check Total Appeared is displayed");
		WebElement totalAppeared = driver.findElement(By.xpath("//div[@data-tip='Total Appeared']uj"));
		Assert.assertTrue(totalAppeared.isDisplayed());

		System.out.println("Verify-check Total Qualified is displayed");
		WebElement totalDisqualified = driver.findElement(By.xpath("//div[@data-tip='Total Qualified']"));
		Assert.assertTrue(totalDisqualified.isDisplayed());
		
		System.out.println("Verify-check Create Assessments is displayed");
		WebElement assesButton = driver.findElement(By.xpath("//span[text()='Create Assessments']"));
		Assert.assertTrue(assesButton.isDisplayed());	
		
		System.out.println("Verify-check Create Question is displayed");
		WebElement assesQue = driver.findElement(By.className("createQuestionButton"));
		Assert.assertTrue(assesQue.isDisplayed());
	}
	
	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
