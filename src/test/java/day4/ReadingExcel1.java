package day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingExcel1 {

	
	@Test
	public void testData() {
		
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
	}
	
	
	
}
