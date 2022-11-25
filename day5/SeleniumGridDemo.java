package day5;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGridDemo {

	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("browserName", "Edge");
		
		capabilities.setCapability("browserVersion", "latest");
		
		capabilities.setCapability("os", "Windows");
		
		capabilities.setCapability("osVersion", "11");
		
		URL url = null;
		try {
			
			url = new URL("https://sanjayrajashekar_Qh0mul:yLtFrmG3zez93vbeKy7S@hub-cloud.browserstack.com/wd/hub");
		
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver = new RemoteWebDriver(url, capabilities);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testURL() {
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/automate/capabilities");
		Assert.assertEquals(driver.getTitle().contains("capabilities"),true);
		
	}
	
}
