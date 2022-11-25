package day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTDemo {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.out.println("Running Before Method- Creating Browser Session");
		driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		System.out.println("Running After Method- Browser Session");
	}
	
	@Test(dataProvider="testdata")
	public void logintest(String username, String password){
		
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password1']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		Assert.assertEquals(driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).getText(),"Sign out");
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] testDataGeneration(){
		Object arr [][]=null;
		try {
			
			
			
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("./testData/LoginData.xlsx")));

			
			int rows = wb.getSheet("LoginData").getPhysicalNumberOfRows();
			
			int columns = wb.getSheet("LoginData").getRow(0).getPhysicalNumberOfCells();
			
			arr = new Object[rows][columns];
			
			for(int i=0;i<rows;i++) {
				for(int j=0;j<columns;j++) {
					
					
					arr[i][j] = wb.getSheet("LoginData").getRow(i).getCell(j).getStringCellValue();
					
				}
			}
			
			for(int i=0;i<rows;i++) {
				for(int j=0;j<columns;j++) {
			
					System.out.println(arr[i][j]);
				}
			}
			wb.close();
			
			
		}catch(FileNotFoundException e) {
			System.out.println("Please check data file path"+e.getMessage());
		}catch(IOException e) {
			System.out.println("Something went wrong"+e.getMessage());
		}
		
		return arr;
		
	}
	
}
