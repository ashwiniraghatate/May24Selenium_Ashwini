/*Assignment - 18 : 31st Aug
Q2. Print the lastname of employee Abhishek. Considering rows are dynamic and cols are fixed.*/
package seleniumAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment18_Q2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationbykrishna.com");
		
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel-body']/table")));
		
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		
		for (int rowIndex=1; rowIndex<=listOfRows.size(); rowIndex++) {
			String name = driver.findElement(
					By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex +"]/td[2]")).getText();
			if (name.equals("Abhishek")) {
				String surname = driver.findElement(
						By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex +"]/td[3]")).getText();
				System.out.println(surname);
			}
		}
		
		driver.quit();
	}
}
