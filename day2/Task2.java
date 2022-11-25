package day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
// Select date 26 with loop

public class Task2 {
	@Test
	public void date26() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		List<WebElement> date = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		
		for(WebElement ele:date) {
			String str = ele.getText();
			System.out.println(str);
			
			if(str.contains("26")) {
				ele.click();
				break;
			}
		}

		Assert.assertTrue(driver.getCurrentUrl().contains("http://seleniumpractise.blogspot.com"));
	}

}
