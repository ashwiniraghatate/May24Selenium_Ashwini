/*STEP 1- Login with Valid credentials.
STEP 2 - Go to Assessments Tab
STEP 3 - Count total number of assessments from Published, Completed and Draft
STEP 4 - Go to Dashboard tab
VERIFY - Total Assessments on assessment page should be equal to sum of published, completed and draft count.
VERIFY - Total assessments count on dashboard page against Assessments tab.
VERIFY - Total assessments count is less than 6, then Recent assessments should match the same count, 
			if total assements are more than 6, then recent assessments count should be 6.*/

package seleniumAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ControlActions;

public class TestCase3 {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("STEP  - Launch Chrome browser");
		System.out.println("STEP  - Hit https://staging.dev.theeliteqa.com URL");
		driver = ControlActions.start("https://staging.dev.theeliteqa.com");
	}
	
	@Test
	public void totalAssesment() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		System.out.println("STEP 1- Login with Valid credentials.");
		driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("ashwinimay24@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("May@123");
		driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();
		
		System.out.println("STEP 2 - Go to Assessments Tab");
		driver.findElement(By.xpath("//span[(text()='Assessments')]")).click();
		
		System.out.println("published Count ");
		String published = driver.findElement(By.xpath("//span[contains(text(), 'published') and contains(@class,'MuiTypography-root')]")).getText();
		int publishedCount = Integer.parseInt(published.split("\\(")[1].replace(")", "").trim());
		System.out.println(publishedCount);
		
		System.out.println("Completed count");
		boolean flag = true;
		int completedCount = 0;
		while(flag){  
			WebElement completed = driver.findElement(
					By.xpath("//span[contains(text(),'completed') and contains(@class,'MuiTypography-root')]"));
			String text = completed.getText().trim();  //Completed (2)
			
			if(text.endsWith(")")) {
				int count = 1;
				while(count<=3){
					Thread.sleep(2000);
					text = completed.getText().trim();
					completedCount= Integer.parseInt(text.split("\\(")[1].replace(")", "").trim()); //
					if(completedCount > 0){
						break;
					}
					count++;
				}
				flag = false;
				System.out.println(text);
			}
		}
		System.out.println(completedCount);
		
//		String completed = driver.findElement(By.xpath("//span[ contains(text(), 'completed') and contains(@class,'MuiTypography-root')]")).getText();
//		int completedCount = Integer.parseInt(completed.split("\\(")[1].replace(")", "").trim());
//		System.out.println(completedCount);

		System.out.println("Draft count");
		String draft = driver.findElement(By.xpath("//span[ contains(text(), 'draft') and contains(@class,'MuiTypography-root')]"))
				.getText();
		int draftCount = Integer.parseInt(draft.split("\\(")[1].replace(")", "").trim());
		System.out.println(draftCount);
		
		int totalCount = publishedCount + completedCount + draftCount;
		
		System.out.println("Assessments count");
		String assesment = driver.findElement(By.xpath("//label[contains(text(),'Assessments ')]")).getText();
		int assesmentCount = Integer.parseInt(assesment.split("\\(")[1].replace(")", "").trim());
		System.out.println(assesmentCount);
		
		System.out.println("VERIFY - Total Assessments on assessment page should be equal to sum of published, completed and draft count.");
		Assert.assertEquals(assesmentCount, totalCount);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
