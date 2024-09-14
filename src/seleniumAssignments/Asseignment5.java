/*Assignment - 5 : 25th Aug
url : http://automationbykrishna.com

Step 1 : Launch Browser
Step 2 : Load given url
Step 3 : Click on Registration link
Step 4 : Fill up registration form.
Step 5 : Click on submit button.*/

package seleniumAssignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Asseignment5 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step1 - Launch broswer");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step2 - Load the url");
		driver.get("http://automationbykrishna.com");
		
		System.out.println("Step3- Open Registration tab");
		WebElement registrationTab = driver.findElement(By.xpath("//a[@id='registration2']"));
		registrationTab.click();
		
		System.out.println("Step4 - Fill form");
		Thread.sleep(3000);
		System.out.println("4.1 - fill username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("ashwini");
		System.out.println("4.2 - fill password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("123456789");
		System.out.println("4.3 - click on remember me");
		driver.findElement(By.xpath("//input[@value='remember me']")).click();
		System.out.println("4.4 - click on submit");
		driver.findElement(By.xpath("//div[@class='row']/div[1]//div[2]//button[@type='submit']")).click();
		
		System.out.println("Step5 - handle alert");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		
		//driver.switchTo().defaultContent();
		
		System.out.println("Step6 - Fill registration form");
		System.out.println("6.1 - Enter full name");
		driver.findElement(By.xpath("//*[@id='fullName']")).sendKeys("Ashwini Raghatate");
		
		System.out.println("6.2 - Enter add");
		driver.findElement(By.xpath("//*[@id='address']")).sendKeys("Pune");
		
		System.out.println("6.3 - Enter other email id");
		driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys("ash.raghatate@gmail.com");
		
		System.out.println("6.4 - Enter city");
		driver.findElement(By.xpath("//*[@placeholder='City/Town']")).sendKeys("Pune");
		
		System.out.println("6.5 - Enter company name");
		driver.findElement(By.xpath("//input[@name='organization']")).sendKeys("TechnoCredits");
		
		System.out.println("6.6 - Select gender");
		driver.findElement(By.xpath("//label[@for='radio-02']")).click();
		
		System.out.println("6.7 - Enter username");
		driver.findElement(By.xpath("//*[@id='usernameReg']")).sendKeys("araghatate");
		
		System.out.println("6.8 - Enter password");
		driver.findElement(By.xpath("//input[@id='passwordReg']")).sendKeys("123456789");
		
		System.out.println("6.9 - Renter pswd");
		driver.findElement(By.xpath("//input[@id='repasswordReg']")).sendKeys("123456789");
		
		WebElement submitBtn = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", submitBtn);
		
		System.out.println("6.10 - Click agree T&C");
		driver.findElement(By.xpath("//input[@value='agree this condition']")).click();
		
		System.out.println("6.11 - Click on sbmit button");
		submitBtn.click();
		alert.accept();
		driver.quit();
	}
}
