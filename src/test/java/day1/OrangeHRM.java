package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRM {
	
	@Test
	public void Orange() {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
		
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//a//b[text()='Admin']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		driver.findElement(By.xpath("//input[@name='systemUser[employeeName][empName]']")).sendKeys("Mukesh Otwani");
		driver.findElement(By.xpath("//input[@name='systemUser[userName]']")).sendKeys("Sanjay");
		driver.findElement(By.xpath("//input[@name='systemUser[password]']")).sendKeys("Sanjay@123");
		driver.findElement(By.xpath("//input[@name='systemUser[confirmPassword]']")).sendKeys("Sanjay@123");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//input[@name='btnSave']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Sanjay");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Sanjay@123");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("index.php"));
	}

}
