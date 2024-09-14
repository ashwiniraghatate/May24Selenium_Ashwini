/*Assignment - 18 : 31st Aug
Q1. Print all the unique departments from second table.*/

package seleniumAssignments;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment18_Q1 {

	static void getUniqueDepartment() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationbykrishna.com");
		
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
		
		List<WebElement> listOfDept = driver.findElements(
				By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		
		Map<String, Integer> mapOfDep = new HashMap<String, Integer>();
		Set<String> setOfDept = new HashSet<String>();
		
		for (WebElement dept : listOfDept) {
			String deptId = dept.getText();
			if (mapOfDep.containsKey(deptId)) {
				int count = mapOfDep.get(deptId);
				mapOfDep.put(deptId, count+1);
			}else {
				mapOfDep.put(deptId, 1);
				setOfDept.add(deptId);
			}
		}
		
		System.out.println(setOfDept);
		
		driver.quit();
	}
	
	public static void main(String[] args) {
		getUniqueDepartment();
	}
}
