package package1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class SampleSeleniumTest {
	

	public static void main(String[] args) throws IOException {
		//read common data from properties file
		FileInputStream fis = new FileInputStream("./xlxs/prad.txt");
		Properties pobj = new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER = pobj.getProperty("browser");
		
 FileInputStream fise = new FileInputStream("./xlxs/tytestxl.xlsx");
		 Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
	String orgName = row.getCell(2).getStringCellValue();
		   
	}
}
