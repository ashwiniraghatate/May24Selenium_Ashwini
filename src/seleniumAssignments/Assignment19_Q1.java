/*Assignment - 19 : 1st Sep'2024
url : http://automationbykrishna.com/index.html
Step 1 : Launch Browser
Step 2 : Load given url
Step 3 : Click on DemoTable link
Step 4 : Print first table using 2 for loops.
*/
package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ControlActions;

public class Assignment19_Q1 {

	@Test
	public void printFirstTableSmartly() {
		WebDriver driver = ControlActions.start();
		WebElement demoTableElement = ControlActions.getElement("xpath", "//a[text()='Demo Tables']", driver, false);
		demoTableElement.click();
		String demoTable = ControlActions.getElement("ID", "table1", driver, true).getText();
		System.out.println(demoTable);
		driver.quit();
	}
	
	@Test
	public void printEmployeeTableFromTBody() {
		WebDriver driver = ControlActions.start();
		WebElement demoTableElement = ControlActions.getElement("linktext", "Demo Tables", driver, false);
		demoTableElement.click();
		String demoTable = ControlActions.getElement("xpath", "//table[@id='table1']/tbody", driver, true).getText();
		System.out.println(demoTable);
		driver.quit();
	}
	
	@Test
	public void printEmployeeTableUsingTr() {
		WebDriver driver = ControlActions.start();
		WebElement demoTableElement = ControlActions.getElement("linktext", "Demo Tables", driver, false);
		demoTableElement.click();
		
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		
		for (int rowIndex=1; rowIndex<=totalRows; rowIndex++) {
			String demoTable = ControlActions.getElement("xpath", "//table[@id='table1']/tbody/tr["+rowIndex+"]",
					driver, true).getText();
			System.out.println(demoTable);
		}
		driver.quit();
	}
	
	@Test
	public void printEmployeeUsingDynamicXpath(){
		WebDriver driver = ControlActions.start();
		WebElement demoTableElement = ControlActions.getElement("linktext", "Demo Tables", driver, false);
		demoTableElement.click();
		
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int totalCols = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
		
		for (int rowIndex=1; rowIndex<=totalRows; rowIndex++) {
			for (int colIndex=1; colIndex<=totalCols; colIndex++) {
				String text = ControlActions.getElement("xpath", 
						"//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]",driver, true).getText();
				System.out.print(text + " ");
			}
			System.out.println();
		}
		driver.quit();
	}
}
