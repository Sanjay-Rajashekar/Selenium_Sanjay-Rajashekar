package day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selectorshub {

	public void test() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		driver.manage().window().maximize();
		
		
		
	}
	
	
}
