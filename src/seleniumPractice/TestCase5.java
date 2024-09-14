package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ControlActions;

public class TestCase5 {

	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("STEP  - Launch Chrome browser");
		System.out.println("STEP  - Hit https://staging.dev.theeliteqa.com URL");
		driver = ControlActions.start("https://staging.theeliteqa.com/login");
	}
	
	@Test
	public void  verifyCreateQuestionErrorValidation() throws InterruptedException {
		System.out.println("STEP 1- Login with Valid credentials.");
		driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("ashwinimay24@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("May@123");
		driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		System.out.println("STEP 2 - Click on Library Menu.");
		WebElement libraryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Library']")));
		libraryElement.click();
		
		System.out.println("STEP 3 - Click on Create Question button.");
		driver.findElement(By.xpath("//p[text()='Create Question']")).click();
		
		System.out.println("STEP 4 - Click on MCQ.");
		driver.findElement(By.xpath("//div[@class='mcq-container']/label[text()='MCQ']")).click();
		
		System.out.println("STEP 5 - Click on Save button.");
		driver.findElement(By.xpath("//label[text()='Save']")).click();
		
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("VERIFY - \"Enter question title\" error message should be displayed.");
		WebElement errorMessageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Enter question title.']")));
		String titleMessageText = errorMessageTitle.getText();
		softAssert.assertTrue(errorMessageTitle.isDisplayed(), "Error message is not displayed");
        System.out.println("Error message says: " + titleMessageText);
        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
        
        System.out.println("STEP 6 - Add \"Access modifier - Theory\" Title in Question.");
        WebElement questionTitle = driver.findElement(By.xpath("//input[@placeholder='Your question title']"));
        questionTitle.sendKeys("Access modifier - Theory");
        
        System.out.println("STEP 7 - Click on Save button.");
        driver.findElement(By.xpath("//label[text()='Save']")).click();
        
        System.out.println("VERIFY - \"Enter question score\" error message should be displayed.");
        WebElement errorMessageScore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Enter question title.']")));
		String scoreMessageText = errorMessageScore.getText();
		softAssert.assertTrue(errorMessageScore.isDisplayed(), "Error message is not displayed");
		System.err.println("Error message says: " + scoreMessageText);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		
		Thread.sleep(5000);
		System.out.println("STEP 8 - Add \"1\" in the score value.");
		WebElement scoreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Score']")));
		scoreElement.sendKeys("1");
		
		System.out.println("STEP 9 - Click on Save button.");
        driver.findElement(By.xpath("//label[text()='Save']")).click();
        
        System.out.println("VERIFY - \"Enter question.\" error message should be displayed.");
        WebElement errorMessageEnterQue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Enter question.']")));
		String enterQueMessageText = errorMessageEnterQue.getText();
		softAssert.assertTrue(errorMessageEnterQue.isDisplayed(), "Error message is not displayed");
		System.err.println("Error message says: " + enterQueMessageText);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	}
	
	@AfterClass (enabled=false)
	public void closeBrowser() {
		driver.quit();
	}
}
