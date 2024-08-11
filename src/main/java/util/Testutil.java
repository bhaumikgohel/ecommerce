package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testutil extends ecom.TestBase {
	

	public static String TESTDATA_FILE = "D:\\Automation\\e2logy\\src\\main\\java\\e2logy\\Resource\\credentials.xls";
	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	
	public static Object[][] AddCheckoutdata(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static List<String> readSearchTermsFromExcel(String filePath) {
        List<String> searchTerms = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
             
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null) {
                    searchTerms.add(cell.getStringCellValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return searchTerms;
    }
	
	public static void capturescreenshot(WebDriver driver) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		
		File Destination = new File("D:\\Automation\\ecom\\screenshot"+ Math.random());
		
		FileUtils.copyFile(source, Destination);
		
		
	}
	
	public static void ScrollSpecificElelemnt(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scrolldown() {
		while (true) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
           
            Long lastHeight = (Long) js.executeScript("return document.body.scrollHeight");
		    
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
           
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            Long newHeight = (Long) js.executeScript("return document.body.scrollHeight");
       
            if (newHeight.equals(lastHeight)) {
                break;
            }
            
            lastHeight = newHeight;
        }
    }
		public static void WaitforElement(WebDriver driver1, WebElement element, Duration timeout){
		new WebDriverWait(driver1,timeout).until(ExpectedConditions.elementToBeClickable(element));
		}

		
}
