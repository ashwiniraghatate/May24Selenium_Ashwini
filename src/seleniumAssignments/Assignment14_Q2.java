/*Assignment - 14 : 31st Aug
Q2. How many employees are there in the first table.*/

package seleniumAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment14_Q2 {

	static int getNumberOfEmployess() {
		System.out.println("Step1 : Launch the chrome broswer");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step 2 : Load the url");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step 3 : Navigate to Demo Tables tab");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel-body']/table")));
		
		System.out.println("Step 4 : Get List of tables");
		List<WebElement> listOfEmployees = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		
		System.out.println("Step  5 : Total no of employees are there in the first table.");
		int totalNoOfEmployees = listOfEmployees.size();
		
		return totalNoOfEmployees;
	}
	
	public static void main(String[] args) {
		System.out.println("Total no of employees are there in the first table : " + getNumberOfEmployess());
	}
}
