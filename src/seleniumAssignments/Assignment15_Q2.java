/*Assignment - 15 : 31st Aug
Q2. Print all duplicate surnames from the first table using List.*/
package seleniumAssignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment15_Q2 {

	static void getDuplicateSurname() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationbykrishna.com");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
		
		System.out.println("List of surname : ");
		List<WebElement> listOfSurname = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		
		for (WebElement surnames : listOfSurname) {
			String surname = surnames.getText();
			System.out.print(surname + "  ");
		}
		
		System.out.println("\n");
		System.out.println("Finding Duplicates using List method:");
		List<String> listOfSurnameText = new ArrayList<String>();
		for(WebElement surnames : listOfSurname) {
			if (listOfSurnameText.contains(surnames.getText())) {
				System.out.println("Duplicate surname is " + surnames.getText());
			}else {
				listOfSurnameText.add(surnames.getText());
			}
		}		
		
		System.out.println("\n");
		//set does not allow duplicates, if ele is already present set, and if tries to add one more time, then duplicate
		//can't add it again
		System.out.println("Finding Duplicates using Set method:");
		Set<String> setOfSurnames = new HashSet<String>();
		for(WebElement surnames : listOfSurname) {
			if (!setOfSurnames.add(surnames.getText())) {
				System.out.println("Duplicate surname is " + surnames.getText());
			}
		}
		
		System.out.println("\n");
		//using Map will have value > 1 print , if it contains then add values in front of it
		System.out.println("Finding Duplicates using MAP method:");
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for (WebElement surnames : listOfSurname) {
			String surname = surnames.getText();
			if (hm.containsKey(surname)) {
				int count = hm.get(surname); 
				hm.put(surname, count+1);
			}else {
				hm.put(surname, 1);
			}
		}
		
		Set<String> setOfKeys = hm.keySet();
		for (String key :setOfKeys) {
			if (hm.get(key)>1) {
				System.out.println("Dup ele is " + key);
			}
		}
		
		System.out.println("\n");
		//using Map will have value > 1 print , if it contains then add values in front of it
		System.out.println("Finding Duplicates using MAP and Hashset method:");
		HashSet<String> dulicateSurnameSet = new HashSet<String>(); 		//won't allow duplicates
		Map<String, Integer> mapOfSurnames = new HashMap<String,Integer>();
		for(WebElement e : listOfSurname){
			if(mapOfSurnames.containsKey(e.getText())){
				int count = mapOfSurnames.get(e.getText());		//will give the value in front of key
				mapOfSurnames.put(e.getText(),count+1);
				dulicateSurnameSet.add(e.getText());
			}else{
				mapOfSurnames.put(e.getText(),1);
			}
		}
		
		System.out.println(dulicateSurnameSet);
		
		driver.quit();
	}
	
	public static void main(String[] args) {
		getDuplicateSurname();
	}
}
