/*Assignment - 4 : 25th Aug

URL : https://www.globalsqa.com/demo-site/select-dropdown-menu/#google_vignette

Step 1 : Launch Browser
Step 2 : Hit above url.
Step 3 : Print total available optinos in dropdown
Step 4 : Select options at index3,5 and 10.
Step 5: Verify how many options are selected. [1]
Step 6 : Print all selected options. []*/
package seleniumAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) {
		System.out.println("Step - Open broswer");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step - load the site");
		//driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/#google_vignette");
		driver.get("http://automationbykrishna.com/index.html#");
		
		System.out.println("Step - get branch element");
		//WebElement branchElement = driver.findElement(By.xpath("//select"));
		WebElement regi = driver.findElement(By.xpath("//a[@id='registration2']"));
		regi.click();
		WebElement branchElement = driver.findElement(By.xpath("//input[@value='agree this condition']"));
		branchElement.click();
		
		System.out.println("Step - getall options");
		Select branchSelect = new Select(branchElement);
		List<WebElement> allElement = branchSelect.getOptions();
		//System.out.println(allElement.size());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",branchElement );
	}
}
