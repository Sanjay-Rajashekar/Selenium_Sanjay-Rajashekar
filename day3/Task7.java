package day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task7 {
	@Test
	public void ineurontask(){
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ineuron-courses.vercel.app/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("ineuron@ineuron.ai");
		driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("ineuron");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		
		WebElement manage =driver.findElement(By.xpath("//span[normalize-space()='Manage']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(manage).perform();
		
		
		driver.findElement(By.xpath("//span[normalize-space()='Manage Categories']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		List<String>arr = new ArrayList<String>(driver.getWindowHandles());
	        
	    @SuppressWarnings("unused")
		String page = arr.get(0);
	    String page1 = arr.get(1);
	        
	    driver.switchTo().window(page1);
	    driver.findElement(By.xpath("//button[normalize-space()='Add New Category']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://ineuron-courses.vercel.app"));
	}

}
