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

public class HandleDynamicElements3 {
	@Test
	public void alertDemo() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        
        driver.get("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
        
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
        @SuppressWarnings("unused")
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='myFunction']")));

        Assert.assertTrue(driver.getCurrentUrl().contains("http://seleniumpractise.blogspot.com"));

	}

}
