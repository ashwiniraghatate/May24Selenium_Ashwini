/*eliteQA.
Login to application and verify 4 labels and 2 button is displayed ! */

package seleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment23_Q1 {
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
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("Step-Enter email for login");
		WebElement mail = driver.findElement(By.xpath("//input[@placeholder='Enter email']"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter email']")));
		js.executeScript("arguments[0].style.border='3px solid red'", mail);		
		mail.sendKeys("ashwinimay24@gmail.com");
		js.executeScript("arguments[0].style.border='0px solid red'", mail);
		
		System.out.println("Step-Enter Password for login");
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Enter password']"));
		js.executeScript("arguments[0].style.border='3px solid red'", password);
		password.sendKeys("May@123");
		js.executeScript("arguments[0].style.border='0px solid red'", password);
		
		System.out.println("Step-Click on Login for login");
		WebElement login = driver.findElement(By.xpath("//button[text()='Login']"));
		js.executeScript("arguments[0].style.border='3px solid red'", login);
		login.click();
		
		System.out.println("Verify-check Invites Used is displayed");
		WebElement inviteUsed = driver.findElement(By.xpath("//span[text()='Invites Used']"));
		js.executeScript("arguments[0].style.border='3px solid red'", inviteUsed);
		Assert.assertTrue(inviteUsed.isDisplayed());
		js.executeScript("arguments[0].style.border='0px solid red'", inviteUsed);
		
		System.out.println("Verify-check Total Assessments is displayed");
		WebElement totalAsses = driver.findElement(By.xpath("//div[@data-tip='Total Assessments']"));
		js.executeScript("arguments[0].style.border='3px solid red'", totalAsses);
		Assert.assertTrue(totalAsses.isDisplayed());
		js.executeScript("arguments[0].style.border='0px solid red'", totalAsses);
		
		System.out.println("Verify-check Total Appeared is displayed");
		WebElement totalAppeared = driver.findElement(By.xpath("//div[@data-tip='Total Appeared']"));
		js.executeScript("arguments[0].style.border='3px solid red'", totalAppeared);
		Assert.assertTrue(totalAppeared.isDisplayed());
		js.executeScript("arguments[0].style.border='0px solid red'", totalAppeared);

		System.out.println("Verify-check Total Qualified is displayed");
		WebElement totalDisqualified = driver.findElement(By.xpath("//div[@data-tip='Total Qualified']"));
		js.executeScript("arguments[0].style.border='3px solid red'", totalDisqualified);
		Assert.assertTrue(totalDisqualified.isDisplayed());
		js.executeScript("arguments[0].style.border='0px solid red'", totalDisqualified);
		
		System.out.println("Verify-check Create Assessments is displayed");
		WebElement assesButton = driver.findElement(By.xpath("//span[text()='Create Assessments']"));
		js.executeScript("arguments[0].style.border='3px solid red'", assesButton);
		Assert.assertTrue(assesButton.isDisplayed());	
		js.executeScript("arguments[0].style.border='0px solid red'", assesButton);
		
		System.out.println("Verify-check Create Question is displayed");
		WebElement assesQue = driver.findElement(By.className("createQuestionButton"));
		js.executeScript("arguments[0].style.border='3px solid red'", assesQue);
		Assert.assertTrue(assesQue.isDisplayed());
		js.executeScript("arguments[0].style.border='0px solid red'", assesQue);
	}
	
	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
	
	
}
