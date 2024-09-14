package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) {
		System.out.println("Step - Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step - open html page");
		driver.get("file:///D:/PROJECTS/Assignments/htmlAssignment.html");
		
		System.out.println("Step - input elements");
		WebElement name = driver.findElement(By.id("firstName"));
		name.sendKeys("Ashwini");
		name = driver.findElement(By.id("lastName"));
		name.sendKeys("Raghatate");
		
		WebElement gender = driver.findElement(By.id("female"));
		gender.click();
		
		WebElement hobbies = driver.findElement(By.id("Reading"));
		hobbies.click();
		hobbies = driver.findElement(By.id("Dancing"));
		hobbies.click();
	}
}
