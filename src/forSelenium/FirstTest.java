package forSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) {
		System.out.println("Step1- launch web driver");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Step-2 Navigate to url");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		
		System.out.println("Step3- get title");
		String title = driver.getTitle();
		System.out.println(title);
		
		//String source = driver.getPageSource();
		//System.out.println(source);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		System.out.println("Step4- close driver");
		driver.quit();
	}
}
