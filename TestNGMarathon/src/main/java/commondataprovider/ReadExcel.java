package commondataprovider;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String fileName) throws IOException
	{
		
		//Open WorkBook
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		//Enter into Worksheet
		XSSFSheet sheet = wb.getSheetAt(0);
		
		//get row count
		int rowCount = sheet.getLastRowNum();
		
		//get cell count
		int colCount = sheet.getRow(0).getLastCellNum();
		
		
		String[][] data = new String[rowCount][colCount];
		
		for (int i = 1; i <=rowCount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				
				String fileData = row.getCell(j).getStringCellValue();
				data[i-1][j]=fileData;
			}
		}
		
		wb.close();
		
		return data;
	}
	
}
