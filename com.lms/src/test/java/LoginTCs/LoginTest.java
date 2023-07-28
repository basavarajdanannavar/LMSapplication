package LoginTCs;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
public class LoginTest {

	private WebDriver driver;
	private Workbook workbook;
	private Sheet sheet;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() {
		// Set the path to ChromeDriver based on your system configuration
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void testLogin() throws IOException, InterruptedException{// Set the path to the ChromeDriver executable.
	       
	        FileInputStream file = new FileInputStream(".//DataFiles//TestData.xlsx");
	        Workbook workbook = WorkbookFactory.create(file);
	        @SuppressWarnings("rawtypes")
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("sheet1");

	        // Loop through the rows and perform the login test cases
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            String username = getCellValueAsString(row.getCell(0));
	            String password = getCellValueAsString(row.getCell(1));
	            
	            driver.get("https://lms.technovative.in/#/home");

	    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    		// Enter username and password
	    		WebElement usernameField = driver.findElement(By.cssSelector("[formcontrolname='username']"));
	    		WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
	    		usernameField.sendKeys(username);
	    		passwordField.sendKeys(password);

	    		// Submit the form
	    		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button[1]"));
	    		loginButton.click();

            Thread.sleep(1000);	          

	          

	            // Clear the fields for the next iteration
            driver.findElement(By.cssSelector("[formcontrolname='username']")).clear();
            driver.findElement(By.cssSelector("[type='password']")).clear();
	        }

	        Actions action = new Actions(driver);
	        WebElement userprofile = driver.findElement(By.id("user-dropdown"));
	        action.contextClick(userprofile);
	        file.close(); 
	        
	    }
	@AfterClass
	public void closeDriver() {
		// Close the browser and the Excel file
	    driver.quit();
	    
		
	}

	    private static String getCellValueAsString(Cell cell) {
	        if (cell == null) {
	            return "";
	        }

	        if (cell.getCellType() == CellType.STRING) {
	            return cell.getStringCellValue();
	        } else if (cell.getCellType() == CellType.NUMERIC) {
	            return String.valueOf((int) cell.getNumericCellValue());
	        } else {
	            return "";
	        }
	    }
	}



