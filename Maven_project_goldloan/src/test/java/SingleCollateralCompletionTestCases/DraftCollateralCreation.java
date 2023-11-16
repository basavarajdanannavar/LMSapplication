
package SingleCollateralCompletionTestCases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DraftCollateralCreation  {

public static WebDriver  driver;


@BeforeClass
public void Browser() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}

	@Test(priority=1)
	public void Login()  throws InterruptedException {
		
driver.get("https://ims-dev.technovative.in/#/auth/login");
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("[placeholder='Enter your username']")).sendKeys("test_appraiser");
		driver.findElement(By.cssSelector("[placeholder='Enter your password']")).sendKeys("P@ssw0rd");
		driver.findElement(By.cssSelector("[ng-click='auth.validate()']")).click();
		}	
	
@Test(dependsOnMethods = { "Login" },priority=2)
public void AddCollaterl() throws InterruptedException {
	
	driver.findElement(By.xpath("//div[contains(text(),'Add Collateral')]")).click();
	//State
	driver.findElement(By.cssSelector("[placeholder='Select state']")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//strong[contains(text(),'Karnataka')]")).click();
	//District	
	driver.findElement(By.cssSelector("[placeholder='Select district']")).click();
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/div/input")).sendKeys(" Area");
	
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/ul/li")).click();
	//Branch
	driver.findElement(By.cssSelector("[placeholder='Select branch']")).click();
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/div/input")).sendKeys("Hubli");
	
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/ul/li")).click();
	//Internal Appraiser
	driver.findElement(By.cssSelector("[ng-model='form.field.appraisalType.value']")).click();
	driver.findElement(By.cssSelector("[value='internal_appraisal']")).click();
	//Submit
	
	driver.findElement(By.xpath("//div[contains(text(),'Continue')]")).click();
	}
@Test(priority=3)
public void AddPacketWithPacketID() throws EncryptedDocumentException, IOException, InterruptedException {
	
	// Click on Add PAcket 
	driver.findElement(By.xpath("//div[contains(text(),'+ New Packet')]")).click();
	//Allow with Packet ID


	// Specify the Excel file path
	String excelFilePath = ".//PacketIDList//Book2.xlsx";

	FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
	Workbook workbook = new XSSFWorkbook(fileInputStream);
	org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet1"); // Replace with your sheet name
    // Specify the starting row and column index
    int startRowIndex = 1; // Replace with the starting row index
    int columnIndex = 0; // Replace with the column index (0 for the first column)

    // Iterate through the cells to find the first non-null value
    String cellValue = null;
    for (int rowIndex = startRowIndex; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
        Row row = sheet.getRow(rowIndex);
        if (row != null) {
            Cell cell = row.getCell(columnIndex);
            if (cell != null) {
                if (cell.getCellType() == CellType.STRING) {
                    cellValue = cell.getStringCellValue();
                }
            }
        }
        // If a non-null value is found, break the loop
        if (cellValue != null && !cellValue.isEmpty()) {
            break;
        }
    }

    // Perform actions with the found cellValue
    if (cellValue != null) {
        // Do something with the cellValue
    	WebElement Packet =	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[5]/div[1]/div[3]/input"));
    	Packet.sendKeys(cellValue);
    } else {
        System.out.println("No non-null value found.");
    }
    
    System.out.println(cellValue);
    
    String targetValue = cellValue; // Replace with the value you are searching for

    // Iterate through the cells to search for the target value
    Cell foundCell = null;
    for (Row row : sheet) {
        for (Cell cell : row) {
            if (cell != null && cell.getCellType() == CellType.STRING) {
                String cellValue1 = cell.getStringCellValue();
                if (cellValue1.equals(targetValue)) {
                    foundCell = cell;
                    break;
                }
            }
        }
        if (foundCell != null) {
            break;
        }
    }


   
        int rowIndex2 = foundCell.getRowIndex();
        int columnIndex2 = foundCell.getColumnIndex();
        
        System.out.println(rowIndex2);
        System.out.println(columnIndex2);


        
        Row row = sheet.getRow(foundCell.getRowIndex());
        if (row != null) {
            Cell cell1 = row.getCell(0);
            if (cell1 != null) {
                // Clear the cell value
                cell1.setCellValue("");

                // Close the input stream
                fileInputStream.close();

                // Save the modified Excel file
                FileOutputStream outputStream = new FileOutputStream(excelFilePath);
                workbook.write(outputStream);
                outputStream.close();
            }
        }
        driver.findElement(By.xpath("//div[contains(text(),'Add')]")).click();
    } 




@Test(dependsOnMethods = { "AddPacketWithPacketID" },priority=4)
public void AddOrnaments() throws InterruptedException, IOException, AWTException {

	
	
	Thread.sleep(2000);
WebElement CollateralNo =	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/h1"));
	
	String Collateral = CollateralNo.getText();
	System.out.println(Collateral);
	        try {
	        	
	            // Create a FileOutputStream to write the console output to a file
	            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Lenovo\\Downloads\\console_output.txt");
	            
	            // Create a PrintStream that will write to the file
	            PrintStream printStream = new PrintStream(fileOutputStream);
	            
	            // Redirect the console output to the file
	            System.setOut(printStream);
	            
	            // Now, any output to the console will be saved to the "console_output.txt" file
	            System.out.println(Collateral);
	       
	            
	            // Close the file and restore the console output
	            printStream.close();
	            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
}
@Test(priority=5)
public void CloseBrowser() {
	driver.close();
}
}
