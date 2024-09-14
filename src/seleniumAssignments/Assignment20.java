/*Assignment - 20 : 1st Sep'2024
url : http://automationbykrishna.com/index.html

Step 1 : Launch Browser
Step 2 : Load given url
Step 3 : Click on DemoTable link
Step 4 : Verify all the usernames are in correct format from first table. 

Note : (firstLetter of firstname + lastName) in lowercase = username.*/
package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.ControlActions;

public class Assignment20 {

	@Test
	public void verifyUserName() {
		WebDriver driver = ControlActions.start();
		//WebElement demoTable = ControlActions.getElement("linktext", "Demo Tables", driver, true);
		WebElement demoTable = ControlActions.getElement("xpath", "//a[text()='Demo Tables']", driver, true);
		demoTable.click();
		
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int colIndex=1; colIndex<=totalRows; colIndex++) {
			String name = ControlActions.getElement("xpath", "//table[@id='table1']/tbody/tr["+ colIndex +"]/td[2]", 
					driver, false).getText();
			String surname = ControlActions.getElement("xpath", "//table[@id='table1']/tbody/tr["+ colIndex +"]/td[3]", 
					driver, false).getText();
			String username = name.charAt(0)+surname;
			String actualUsername = username.toLowerCase();
			String excpectedUsername = ControlActions.getElement("xpath", "//table[@id='table1']/tbody/tr["+ colIndex +"]/td[4]", 
					driver, false).getText();
			Assert.assertEquals(actualUsername, excpectedUsername);
			System.out.println(actualUsername + " is same as " + excpectedUsername);
		}
		driver.quit();
	}
}
