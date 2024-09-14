package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase3 {

	public static void main(String[] args) {
		System.out.println("Step - Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step - open html page");
		driver.get("file:///C:/Users/are13/Downloads/index.html");
		
		System.out.println("Step - enter first name");
		WebElement name = driver.findElement(By.id("firstName"));
		name.sendKeys("Ashwini");
		
		System.out.println("Step - enter last name");
		name = driver.findElement(By.name("lname"));
		name.sendKeys("Raghatate");
		
		System.out.println("Step - select gender");
		WebElement gender = driver.findElement(By.id("female"));
		gender.click();
		
		System.out.println("Step - Select hobby");
		WebElement hobbies = driver.findElement(By.className("red2"));
		hobbies.click();
		hobbies = driver.findElement(By.className("red1"));
		hobbies.click();
		
		System.out.println("Step - Select branch");
		//driver.findElement(By.id("branch")).sendKeys("M");
		
		WebElement branch = driver.findElement(By.id("branch"));
		Select branchElement = new Select(branch);
		branchElement.selectByVisibleText("CS");
		branchElement.deselectByValue("CS");
		
	}
}
