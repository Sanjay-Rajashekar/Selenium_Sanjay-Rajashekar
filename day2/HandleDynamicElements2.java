package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleDynamicElements2 {
	@Test
	public void Handle() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        
        driver.get("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("sapient");
        
        driver.findElement(By.xpath("//input[@value='Show me']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
        
         WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='passnew']")));



        element.sendKeys("Sanjay");
        
        Assert.assertTrue(driver.getCurrentUrl().contains("http://seleniumpractise.blogspot.com"));
         
         //driver.quit();

	}

}
