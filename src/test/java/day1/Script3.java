package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Script3 {
	@Test
	public void Script() {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://ineuron-courses.vercel.app/signup");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement name = driver.findElement(By.name("name1"));
		
		name.sendKeys("Sanjay Rajashekar");
		
		WebElement username = driver.findElement(By.name("name"));
		
		username.sendKeys("Sanjay Rajashekar");
		
		driver.findElement(By.id("password1")).sendKeys("sanjaygr007@gmail.com");
		
		
		
		WebElement stateDropDown = driver.findElement(By.id("state"));
		
		Select state = new Select(stateDropDown);
		
		state.selectByIndex(2);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		state.selectByValue(null);
		
		
		driver.findElement(By.className("signup-btn")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://ineuron-courses.vercel.app/signup"));
	}

}
