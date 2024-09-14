package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlActions {

	/**
	 * This method can be used to load the browser
	 * and launch the url.
	 */
	public static WebDriver start(String url) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	/**
	 * This method is an overloaded method.
	 * It opens default url as mentioned.
	 */
	public static WebDriver start() {
		return start("http://automationbykrishna.com");
	}
	
	/**
	 * This method can be used to find WebElement using 8 locator types
	 * @param locatorType
	 * @param locatorValue
	 * @param driver
	 * @param isWaitRequired
	 * @return A WebElement found using the given locator
	 */
	public static WebElement getElement(String locatorType, String locatorValue, 
			WebDriver driver, boolean isWaitRequired) {
		WebElement e = null;
		WebDriverWait wait = null;
		if (isWaitRequired) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		}
		
		switch(locatorType.toUpperCase()) {
			case "XPATH":
				if (isWaitRequired) {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				}else {
					e = driver.findElement(By.xpath(locatorValue));
				}
				break;
			case "ID":
				if (isWaitRequired) {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
				}else {
					e = driver.findElement(By.id(locatorValue));
				}
				break;
			case "NAME":
				if (isWaitRequired) {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
				}else {
					e = driver.findElement(By.name(locatorValue));
				}
				break;
			case "CLASSNAME":
				if (isWaitRequired) {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
				}else {
					e = driver.findElement(By.className(locatorValue));
				}
				break;
			case "CSSSELECTOR":
				if (isWaitRequired) {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
				}else {
					e = driver.findElement(By.cssSelector(locatorValue));
				}
				break;
			case "LINKTEXT":
				if (isWaitRequired) {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
				}else {
					e = driver.findElement(By.linkText(locatorValue));
				}
				break;
			case "PARTIALLINKTEXT":
				if (isWaitRequired) {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
				}else {
					e = driver.findElement(By.partialLinkText(locatorValue));
				}
				break;
			case "TAGNAME":
				if (isWaitRequired) {
					e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
				}else {
					e = driver.findElement(By.tagName(locatorValue));
				}
			default:
	            // Throw an object of user defined exception
				throw new InvalidLocatorTypeException ("Valid locators are ID, NAME, XPATH, TAGNAME, PARTIALLINKTEXT, "
						+ "LINKTEXT, CSSSELECTOR, CLASSNAME but you have passed " + locatorType +
						" which is not supported");
		}		
		return e;
	}
}
