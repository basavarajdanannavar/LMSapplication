package User;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeRoleAfterFromUserListNavigation extends LoginwithValidCredential {
	public WebDriver driver;
	public Workbook workbook;
	public Sheet sheet;

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

	@Test(priority = 0)
	public void RememberMe() throws InterruptedException, IOException {
		FileInputStream file = new FileInputStream(".//DataFiles//TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		@SuppressWarnings("rawtypes")
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("sheet2");

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

			Thread.sleep(0);
		}
	}

	@Test(priority = 1)
	public void GotoUser() throws InterruptedException {
		Thread.sleep(1000);
		Actions action = new Actions(driver);

		WebElement Admin = driver.findElement(By.xpath("//*[@id=\"mat-tab-link-3\"]"));
		action.click(Admin).perform();

		// click on User
		driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-3\"]/div/button[1]")).click();
		// click on Search Box 
	WebElement	Filter=driver.findElement(By.id("mat-input-4"));
	Filter.click();
	Filter.sendKeys("Basu");
	
		//click on Basu User
		driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-users/div[2]/div[2]/table/tbody/tr")).click();
		
	}
	@Test(priority=2)
	public void EditApplication() throws AWTException, InterruptedException {
		//click on Edit Application button
		driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-view-user/div[1]/button[1]")).click();
		//click on Admin field
		driver.findElement(By.id("mat-select-16")).click();
		//Select the roles
		driver.findElement(By.xpath("//*[@id=\"mat-option-24\"]/mat-pseudo-checkbox")).click();
		driver.findElement(By.id("mat-option-23")).click();
		
		Robot r= new Robot();
		
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
		//click on the submit
		driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-edit-user/div/mat-card/form/mat-card-actions/button[2]")).click();
		
		//click on the back button
		driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-view-user/div[2]/mat-card/mat-card-content/div[2]/button")).click();
	Thread.sleep(3000);	
	}

	@Test(priority=3)
	public void VerifyUSerRole() {
		// click on Search Box 
		WebElement	Filter=driver.findElement(By.id("mat-input-9"));
		Filter.click();
		Filter.sendKeys("Basu");
		
			//click on Basu User
			driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-users/div[2]/div[2]/table/tbody/tr")).click();
			//click on Edit Application button
			driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-view-user/div[1]/button[1]")).click();
			WebElement Role= driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-view-user/div[2]/mat-card/mat-card-content/div[1]/div[12]/span"));
			Assert.assertEquals(Role.getText(), "Super User");
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
