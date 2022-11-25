package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();
		driver.get("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login");
	}
	
	
	@Test
	public void validCredentials() {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("ASDFwhuhpp3lhdz3k47iw%");
        driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        System.out.println("valid Password");
     }
	
	@Test
	public void BlankPassword() {
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(" ");
        driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://137.184.76.209/orangehrm-4.9/symfony/web/index.php/auth/login"));
        System.out.println("Enter password");
	}
}
	
	
	
	
	
	


