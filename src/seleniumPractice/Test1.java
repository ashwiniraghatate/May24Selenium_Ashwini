package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("Step - Launch Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step - load google page");
		driver.get("https://www.google.com");
		
		System.out.println("Verify - title of goole page");
		String actualTitle = "Google";
		String expectedTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		System.out.println("Step - navigate to automation by krishna");
		driver.get("http://automationbykrishna.com/#");
		
		System.out.println("Verify - title of automation by krishna");
		actualTitle = "Login Signup Demo";
		expectedTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		System.out.println("Step - Navigate back to google");
		driver.navigate().back();
		
		System.out.println("Verify - title of goole page");
		actualTitle = "Google";
		expectedTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		System.out.println("Step - Navigate back to automation by krishna");
		driver.navigate().forward();
		
		System.out.println("Verify - title of automation by krishna");
		actualTitle = "Login Signup Demo";
		expectedTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		System.out.println("Step - close the driver");
		driver.quit();
	}
}
