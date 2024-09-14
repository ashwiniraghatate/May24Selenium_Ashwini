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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4_Selenium {

	public static void main(String[] args) {
		System.out.println("Step1 - Launch broswer");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step2 - Load the url");
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/#google_vignette");
		
		System.out.println("Step3 - Get the drop down options");
		WebElement dropdownEle = driver.findElement(By.xpath("//select"));
		dropdownEle.click();
		
		System.out.println("Step4 - Get total the options available from the drop down");
		Select branchSelect = new Select(dropdownEle);
		List<WebElement> branchEle = branchSelect.getOptions();
		System.out.println(branchEle.size());
		
		System.out.println("Step5 - Select options at index3,5 and 10");
		int[] indexarr = {3, 5, 10};
		for (int i: indexarr) {
			branchSelect.selectByIndex(i);
		}
		
		System.out.println("Verify - how many options are selected");
		List<WebElement> allElement = branchSelect.getAllSelectedOptions();
		System.out.println(allElement.size());
		
		System.out.println("Step6 - print selected option");
		WebElement selectedOption = branchSelect.getFirstSelectedOption();
		System.out.println(selectedOption.getText());
		
		System.out.println("Ste7 - close session");
		driver.quit();
	}
}
