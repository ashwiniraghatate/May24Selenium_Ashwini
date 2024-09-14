/*Assignment - 6 : 26th Aug
url : https://automationbykrishna.com

Step 1 : Launch Browser
Step 2 : Load given url
Step 3 : Click on Registration link
Step 4 : verify login functionality for below combination.
i)verify with No pwd/char
ii)less than 8 char
iii)exact 8 char
iv) for 9char*/

package seleniumAssignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step1 - Launch Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Step1.1 - Load given url");
		driver.get("http://automationbykrishna.com/");
		
		System.out.println("Step2 - Click on Registration link");
		driver.findElement(By.xpath("//*[@id='registration2']")).click();
		Thread.sleep(2000);
		
		System.out.println("Step2.1 - Enter username");
		driver.findElement(By.xpath("//*[@id='unameSignin']")).sendKeys("araghatate");
		
		System.out.println("Step3 - Click on Submit- Not entering password");
		driver.findElement(By.xpath("//*[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
				
		System.out.println("Step3.1 - Enter wrong password");
		WebElement enterPswd = driver.findElement(By.xpath("//*[@id='pwdSignin']"));
		enterPswd.sendKeys("1234");
		String expectedMsg = "Failed! please enter strong password";
		driver.findElement(By.xpath("//*[@id='btnsubmitdetails']")).click();
		Thread.sleep(1000);
		String actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}
		enterPswd.clear();
		
		
		System.out.println("Step3.2 - Enter correct password");
		driver.findElement(By.xpath("//*[@id='pwdSignin']")).sendKeys("1234456789");
		driver.findElement(By.xpath("//*[@id='btnsubmitdetails']")).click();
		Thread.sleep(1000);
		expectedMsg = "Success!";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}		
		driver.quit();
	}
}
