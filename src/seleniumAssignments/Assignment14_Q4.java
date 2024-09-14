/*Assignment - 14 : 31st Aug
Q4. Print all the available header from the first table*/

package seleniumAssignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment14_Q4 {

	static void getHeaderName() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationbykrishna.com");
		
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel-body']/table")));
		
		List<WebElement> headerNameList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		
		
		for (int colIndex=1; colIndex<=headerNameList.size(); colIndex++) {
			WebElement headerName = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[" + colIndex +"]"));
			System.out.print(headerName.getText() + "  ");
		}
		
		System.out.println();
		for (WebElement headername : headerNameList) {
			String headerNames = headername.getText();
			System.out.print(headerNames + "  ");
		}
		
		driver.quit();
	} 
	
	public static void main(String[] args) {
		getHeaderName();
	}
}
