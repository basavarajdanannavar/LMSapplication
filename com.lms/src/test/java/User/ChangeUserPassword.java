package User;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeUserPassword extends LoginwithValidCredential {
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
	@Test(priority = 2)
	public void ChangePassword() throws InterruptedException, AWTException  {
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-view-user/div[1]/button[3]")).click();
		
	Robot rb=new Robot();
	Thread.sleep(2000);
	//Passw0rd= Magpassword1@
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	rb.keyPress(KeyEvent.VK_SHIFT);
	rb.keyPress(KeyEvent.VK_M);
	rb.keyRelease(KeyEvent.VK_M);
	rb.keyRelease(KeyEvent.VK_SHIFT);
	rb.keyPress(KeyEvent.VK_A);
	rb.keyRelease(KeyEvent.VK_A);
	rb.keyPress(KeyEvent.VK_G);
	rb.keyRelease(KeyEvent.VK_G);
	rb.keyPress(KeyEvent.VK_P);
	rb.keyRelease(KeyEvent.VK_P);
	rb.keyPress(KeyEvent.VK_A);
	rb.keyRelease(KeyEvent.VK_A);
	rb.keyPress(KeyEvent.VK_S);
	rb.keyRelease(KeyEvent.VK_S);
	rb.keyPress(KeyEvent.VK_S);
	rb.keyRelease(KeyEvent.VK_S);
	rb.keyPress(KeyEvent.VK_W);
	rb.keyRelease(KeyEvent.VK_W);
	rb.keyPress(KeyEvent.VK_O);
	rb.keyRelease(KeyEvent.VK_O);
	rb.keyPress(KeyEvent.VK_R);
	rb.keyRelease(KeyEvent.VK_R);
	rb.keyPress(KeyEvent.VK_D);
	rb.keyRelease(KeyEvent.VK_D);
	rb.keyPress(KeyEvent.VK_1);
	rb.keyRelease(KeyEvent.VK_1);
	rb.keyPress(KeyEvent.VK_SHIFT);
	rb.keyPress(KeyEvent.VK_2);
	rb.keyRelease(KeyEvent.VK_SHIFT);
	rb.keyRelease(KeyEvent.VK_2);

	
	
	
	Thread.sleep(2000);
	rb.keyPress(KeyEvent.VK_TAB);
	rb.keyRelease(KeyEvent.VK_TAB);

	rb.keyPress(KeyEvent.VK_SHIFT);
	rb.keyPress(KeyEvent.VK_M);
	rb.keyRelease(KeyEvent.VK_M);
	rb.keyRelease(KeyEvent.VK_SHIFT);
	

	rb.keyPress(KeyEvent.VK_A);
	rb.keyRelease(KeyEvent.VK_A);
	rb.keyPress(KeyEvent.VK_G);
	rb.keyRelease(KeyEvent.VK_G);
	rb.keyPress(KeyEvent.VK_P);
	rb.keyRelease(KeyEvent.VK_P);
	rb.keyPress(KeyEvent.VK_A);
	rb.keyRelease(KeyEvent.VK_A);
	rb.keyPress(KeyEvent.VK_S);
	rb.keyRelease(KeyEvent.VK_S);
	rb.keyPress(KeyEvent.VK_S);
	rb.keyRelease(KeyEvent.VK_S);
	rb.keyPress(KeyEvent.VK_W);
	rb.keyRelease(KeyEvent.VK_W);
	rb.keyPress(KeyEvent.VK_O);
	rb.keyRelease(KeyEvent.VK_O);
	rb.keyPress(KeyEvent.VK_R);
	rb.keyRelease(KeyEvent.VK_R);
	rb.keyPress(KeyEvent.VK_D);
	rb.keyRelease(KeyEvent.VK_D);
	rb.keyPress(KeyEvent.VK_1);
	rb.keyRelease(KeyEvent.VK_1);
	rb.keyPress(KeyEvent.VK_SHIFT);
	rb.keyPress(KeyEvent.VK_2);
	rb.keyRelease(KeyEvent.VK_SHIFT);
	rb.keyRelease(KeyEvent.VK_2);
	
	//click on confirm
	driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/mifosx-change-password-dialog/mat-dialog-actions/button[2]")).click();
	//click on user profile
	driver.findElement(By.xpath("//*[@id=\"mifosx-toolbar\"]/div[5]/button")).click();
	Thread.sleep(200);
	driver.findElement(By.id("logout")).click();
	}
	
	
	@Test(priority=3)
	public void CheckLoginWithChangedPassword() throws InterruptedException {
		
		// Enter username and password
					WebElement usernameField = driver.findElement(By.cssSelector("[formcontrolname='username']"));
					WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
					usernameField.sendKeys("basu.danu");
					passwordField.sendKeys("Magpassword1@");

					// Submit the form
					WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button[1]"));
					loginButton.click();

					Thread.sleep(0);
					
		WebElement Homepage = driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-home/div[2]/mat-card/mat-card-header/div/mat-card-title"));
		
		Assert.assertEquals(Homepage.getText(), "Welcome, basu.danu!");
		
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
