package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {
	@Test
	public void datepicker() {
		// Select date 25 without loop
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		driver.findElement(By.xpath("//a[text()='25']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("http://seleniumpractise.blogspot.com"));
	}

}
