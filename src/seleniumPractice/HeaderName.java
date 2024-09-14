package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderName {

	int getHeaderIndex(String headerName) {
		int headerIndex=0;
		WebDriver driver = new ChromeDriver();
		WebElement headerIndex1 = driver.findElement(By.xpath(""));
		
		return headerIndex;
	}
}
