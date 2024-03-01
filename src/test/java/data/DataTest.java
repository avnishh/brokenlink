package data;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTest {
	
	static Workbook book;
	static Sheet sheet;

	  @DataProvider(name = "data-provider")
	  
      public static Object[][] getTetData() throws InvalidFormatException {
			FileInputStream file = null;
			try {
				file = new FileInputStream("D:\\Automation\\Brokenlinks\\src\\test\\resources\\Book1.xlsx");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet("first");
		//	sheet2 = book.getSheet("second");
			
			// we dont know data in excel is string or int so we take object array it can take any type of data
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			 
			 //System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
			 
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i+1).getCell(k).toString();
					 System.out.println(data[i][k]);
					// System.out.println(data[i][k].getC);
					
				}}
				return data;
				}

	    @Test(dataProvider = "data-provider")
	    public void testMethod(String a,String b,String c,String d) {
	    	//Object[][] datam= data;
	    	String x=a;
	        System.out.println("Data is: " + x);
	    }
	    
	    @Test
	    public void test2() {
	    	
	    	System.out.println("pass");
	    	Assert.assertTrue(true);
	    }
	    
	   
    }
	
