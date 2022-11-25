package day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.testng.annotations.Test;

public class ReadingExcel {
	
	@Test
	public void testData() {
		
		File src = new File("./testData/LoginData.xlsx");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sh1 = wb.getSheet("LoginData");
			
			XSSFRow r1 = sh1.getRow(0);
			
			XSSFCell c1 = r1.getCell(0);
			
			String username = c1.getStringCellValue();
			
			System.out.println(username);
			
			wb.close();
			
			
			//String username = sh1.getRow(0).getCell(0).getStringCellValue();
			
			
		}catch(FileNotFoundException e) {
			System.out.println("Please check data file path"+e.getMessage());
		}catch(IOException e) {
			System.out.println("Something went wrong"+e.getMessage());
		}
		
	}
}
