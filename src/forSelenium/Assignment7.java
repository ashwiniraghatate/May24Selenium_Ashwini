/*
 Assignment - 7 : 27th Aug
url : http://automationbykrishna.com/index.html

Step 1 : Launch Browser
Step 2 : Load given url
Step 3 : Click on Registration link
Step 4 :  Validate without giving Fullname
Step 5 : Validate with giving Fullname and Validate without giving Address
Step 6 : Validate with giving Address and Validate without giving Email
Step 7 : Validate with giving Email and Validate Without giving City
Step 8 : Validate with giving City and Validate without giving Company Name
Step 9 : Validate with giving Company Name and Validate without giving Username
Step 10 : Validate with giving Username and Validate without giving Password
Step 11 : Validate with giving Password and Validate without giving Repassword
Step 12 : Validate with giving Repassword value not matching password field value.
Step 13 : Validate with giving repassword */

package forSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Step1 - Launch Browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Step2 - Load given url");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Step3 - Click on Registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		//Thread.sleep(2000);

		System.out.println("Step 4:  Validate without giving Fullname");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement submitBtn = driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		je.executeScript("arguments[0].scrollIntoView(true)", submitBtn);
		//Thread.sleep(1000);
		submitBtn.click();

		Alert alert = driver.switchTo().alert();
		String expectedMsg = "Full name can't be blank";
		String actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}

		System.out.println("Step 5 : Validate with giving Fullname and Validate without giving Address");
		driver.findElement(By.xpath("//*[@id='fullName']")).sendKeys("Ashwini Raghatate");
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg="address cannot be blank";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}

		System.out.println("Step 6 : Validate with giving Address and Validate without giving Email");
		driver.findElement(By.xpath("//*[@id='address']")).sendKeys("Pune");
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg="Please enter email id";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}

		System.out.println("Step 7 : Validate without giving Email and Validate Without giving City");
		driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys("ash.raghatate@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg="Please enter City";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}

		System.out.println("Step 8: Validate with giving City and Validate without giving Company Name");
		driver.findElement(By.xpath("//*[@placeholder='City/Town']")).sendKeys("Pune");
		driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']")).click();
		//driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg="Please enter your current organization";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}

		System.out.println("Step 9 : Validate with giving Company Name and Validate without giving Username");
		driver.findElement(By.xpath("//*[@id='organization']")).sendKeys("DS");
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg="Username is mandatory field.";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}

		System.out.println("Step 10 : Validate with giving Username of less than 5 chars");
		WebElement userName = driver.findElement(By.xpath("//*[@id='usernameReg' ]"));
		userName.sendKeys("ashr");
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg = "Username length should be greater then 5 characters.";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}
		System.out.println("Step 10.1 : Validate with giving Username of more than 5 chars and Validate without giving Password");
		userName.clear();
		userName.sendKeys("ashwinir");
		expectedMsg = "password is mandatory field.";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}

		System.out.println("Step 11 : Validate with giving Password less than 5 chars");
		WebElement password = driver.findElement(By.xpath("//*[@id='passwordReg']"));
		password.sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg = "password length should be greater then 5 characters.";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}
		
		System.out.println("Step 11.1 : Validate with giving Password more than 5 chars and Validate without giving Repassword");
		password.clear();
		password.sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg = "please reenter password";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}
		
		System.out.println("Step 12 : Validate with giving Repassword value not matching password field value.");
		WebElement reEnterPass = driver.findElement(By.xpath("//*[@id='repasswordReg']"));
		reEnterPass.sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg = "retype password donot match.";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}
		
		System.out.println("Step 13 : Validate with giving repassword ");
		reEnterPass.clear();
		reEnterPass.sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg = "Please agree to terms of service and privacy policy";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}
		
		System.out.println("Step 14 : Agree terms and condition");
		driver.findElement(By.xpath("//*[@value='agree this condition']")).click();
		driver.findElement(By.xpath("//*[@id=\"btnsubmitsignUp\"]")).click();
		expectedMsg = "Success";
		actualMsg = alert.getText();
		if(actualMsg.equals(expectedMsg)) {
			alert.accept();
		}
		
		//List<String> tempList = new ArrayList<String>();
		String[] arrOfStep = {"Step 5 : Validate with giving Fullname", "Step 8 : Validate without giving Email"};
		String[] arrXpath = {"//*[@id='fullName']", "//*[@id='useremail']"};
		String[] arrKeys = {"Ashwini Raghatate", "ash.raghatate@gmail.com"};
		String[] arrExpectedMsg = {"address cannot be blank", "Please enter City"};
	}
}