package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeDriverDemo {
	@Test
	public void ChromeDemo() {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Sanjay Rajashekar");
		
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		String url = driver.getCurrentUrl();
		System.out.println("URL is "+url);
		Assert.assertTrue(driver.getCurrentUrl().contains("google.com"));
		
		driver.quit();

	}

}
