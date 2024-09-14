/*Assignment - 15 : 31st Aug
Q1. Print all the usernames from the first table,*/

package seleniumAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assigment15_Q1 {

	static void getUserName() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationbykrishna.com");
		
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel-body']/table")));
		
		List<WebElement> listOfUserNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		
		for (WebElement userNames : listOfUserNames) {
			String userName = userNames.getText();
			System.out.println(userName + "  ");
		}
		
		for (int rowIndex=0; rowIndex<listOfUserNames.size(); rowIndex++) {
			WebElement userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]"));
			System.out.println(userName.getText() + "  ");
		}
		
		driver.quit();
	}
}
