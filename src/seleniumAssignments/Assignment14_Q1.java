/*Assignment - 14 : 31st Aug
Q1. How many tables are there on the page.*/
package seleniumAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment14_Q1 {
	
	static int getNumberOfTable() {
		System.out.println("Step1 : Launch the chrome broswer");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		//to maximize the window
		
		System.out.println("Step 2 : Load the url");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step 3 : Navigate to Demo Tables tab");
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel-body']/table")));
		
		System.out.println("Step 4 : Get List of tables");
		List<WebElement> listOfTables = driver.findElements(By.xpath("//div[@class='panel-body']/table"));
		
		System.out.println("Step 5 : Get size of the List of tables");
		int totalNoOfTables = listOfTables.size();
		
		return totalNoOfTables;
	}
	
	public static void main(String[] args) {
		System.out.println("Total no. of tables are there on the page : " + Assignment14_Q1.getNumberOfTable());
	}
	
}
