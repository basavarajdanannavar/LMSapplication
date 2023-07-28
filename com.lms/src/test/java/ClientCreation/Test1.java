package ClientCreation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
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

			Thread.sleep(1000);
		}
	}

	@Test(priority = 1)
	public void ClickOnCreateClient() throws InterruptedException {
		Actions action = new Actions(driver);

		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath(
				"/html/body/mifosx-web-app/mifosx-shell/mat-sidenav-container/mat-sidenav-content/mifosx-content/mifosx-home/div[1]/div/button/span[1]"))
				.isDisplayed());

		WebElement Institution = driver.findElement(By.cssSelector("#mat-tab-link-0"));

		action.click(Institution).perform();
		Thread.sleep(1000);
		WebElement Clients = driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-1\"]/div/button[1]"));
		action.click(Clients).perform();
		driver.findElement(By.xpath(
				"//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-clients/mat-card/div[1]/div[3]/button[2]"))
				.click();

	}

	@Test(priority = 2, dependsOnMethods = { "ClickOnCreateClient" })
	public void GenrealtabDataFillup() throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream file = new FileInputStream(".//DataFiles//LMS Client Creation.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		@SuppressWarnings("rawtypes")
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("General");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);

			String firstname = getCellValueAsString(row.getCell(0));
			String middlename = getCellValueAsString(row.getCell(1));
			String lastname = getCellValueAsString(row.getCell(2));
			String DOB = getCellValueAsString(row.getCell(3));
			String externalId = getCellValueAsString(row.getCell(4));
			String MobileNo = getCellValueAsString(row.getCell(5));
			String email = getCellValueAsString(row.getCell(6));
			String submittedOn = getCellValueAsString(row.getCell(7));

			Thread.sleep(2000);
			driver.findElement(By.id("mat-select-12")).click();

			driver.findElement(By.id("mat-option-25")).click();

			// select Legal Form
			driver.findElement(By.id("mat-select-value-15")).click();
			driver.findElement(By.id("mat-option-31")).click();
			// select staff

			driver.findElement(By.id("mat-select-value-17")).click();

			// Enter the Firstname
			driver.findElement(By.id("mat-input-14")).sendKeys(firstname);
			// Enter the Middlename
			driver.findElement(By.id("mat-input-15")).sendKeys(middlename);
			// Enter the Lastname
			driver.findElement(By.id("mat-input-16")).sendKeys(lastname);
			// Enter the DOB
			driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/mifosx-client-general-step/form/div[1]/mat-form-field[7]/div/div[1]/div[2]/mat-datepicker-toggle/button")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"mat-datepicker-0\"]"))));
			
			String aMonth = driver.findElement(By.id("mat-calendar-button-0")).getText();
			
			while(!(aMonth.equals("JUL 2020"))) {
				driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[2]")).click();
				aMonth = driver.findElement(By.id("mat-calendar-button-0")).getText();
			}
			
			driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[4]/td[2]/button/div[1]")).click();
			
			
			// Enter the External Id
			driver.findElement(By.id("mat-input-7")).sendKeys(externalId);
			// select Gender
			driver.findElement(By.id("mat-select-value-27")).click();
			driver.findElement(By.id("mat-option-33")).click();
			// Enter the Mobile no
			driver.findElement(By.id("mat-input-8")).sendKeys(MobileNo);
			// Enter the Email
			driver.findElement(By.id("mat-input-9")).sendKeys(email);
			// Enter submitted ON
		//	driver.findElement(By.id("mat-input-10")).sendKeys(submittedOn);
			// Enter Next
			driver.findElement(By.cssSelector("[type='submit']")).click();
		}
	}

	@Test(priority = 3, dependsOnMethods = "GenrealtabDataFillup")
	public void FamilytabDataFillup() throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream file = new FileInputStream(".//DataFiles//LMS Client Creation.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		@SuppressWarnings("rawtypes")
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("FamilyMember");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);

			String firstname = getCellValueAsString(row.getCell(0));
			String middlename = getCellValueAsString(row.getCell(1));
			String lastname = getCellValueAsString(row.getCell(2));
			String qualification = getCellValueAsString(row.getCell(3));
			String age = getCellValueAsString(row.getCell(4));
			String dob = getCellValueAsString(row.getCell(5));

			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-1\"]/mifosx-client-family-members-step/div/div[1]/button")).click();

			// ENter the Firstname
			driver.findElement(By.id("mat-input-17")).sendKeys(firstname);
			// ENter the middlename
			driver.findElement(By.id("mat-input-18")).sendKeys(middlename);
			// ENter the lastname
			driver.findElement(By.id("mat-input-19")).sendKeys(lastname);
			// ENter the qualification
			driver.findElement(By.id("mat-input-20")).sendKeys(qualification);
			// ENter the age
			driver.findElement(By.id("mat-input-21")).sendKeys(age);
		
			// Select the Relashionship
			driver.findElement(By.id("mat-select-value-29")).click();
			// Select the Relashionship
			driver.findElement(By.id("mat-option-36")).click();
			// Select the gender
			driver.findElement(By.id("mat-select-value-31")).click();
			// Select the gender
			driver.findElement(By.id("mat-option-40")).click();
			// Select the Maritial status
			driver.findElement(By.id("mat-select-value-35")).click();
			driver.findElement(By.id("mat-option-44")).click();
			// ENter the dob
			driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/mifosx-client-family-member-dialog/form/div/mat-form-field[10]/div/div[1]/div[2]")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"mat-datepicker-2\"]/mat-calendar-header/div/div/button[1]"))));
			
			String aMonth = driver.findElement(By.id("mat-calendar-button-1")).getText();
			
			while(!(aMonth.equals("JUL 2020"))) {
				driver.findElement(By.xpath("//*[@id=\"mat-datepicker-2\"]/mat-calendar-header/div/div/button[2]")).click();
				aMonth = driver.findElement(By.id("mat-calendar-button-1")).getText();
			}
			driver.findElement(By.xpath("//*[@id=\"mat-datepicker-2\"]/div/mat-month-view/table/tbody/tr[4]/td[5]/button/div[1]")).click();
			// Confirm the details
			driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/mifosx-client-family-member-dialog/form/mat-dialog-actions/button[2]/span[1]")).click();
			// click the next
			driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-1\"]/mifosx-client-family-members-step/div/div[2]/button[2]")).click();
}

	}
	@Test(priority = 4, dependsOnMethods = "FamilytabDataFillup")
	public void AddresstabDataFillup() throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream file = new FileInputStream(".//DataFiles//LMS Client Creation.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		@SuppressWarnings("rawtypes")
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Address");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			String addressline1 = getCellValueAsString(row.getCell(0));
			String addressline2 = getCellValueAsString(row.getCell(1));
			String addressline3 = getCellValueAsString(row.getCell(2));
			String city = getCellValueAsString(row.getCell(3));
			String postalcode = getCellValueAsString(row.getCell(4));
			
			driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-2\"]/mifosx-client-address-step/div/div[1]/button")).click();
			
			//Select type of the address
			driver.findElement(By.id("mat-select-value-37")).click();
			driver.findElement(By.id("mat-option-48")).click();
			//select Addreestype1
			driver.findElement(By.id("mat-input-23")).sendKeys(addressline1);
			//select Addreestype2
			driver.findElement(By.id("mat-input-24")).sendKeys(addressline2);
			//select Addreestype3
			driver.findElement(By.id("mat-input-25")).sendKeys(addressline3);
			//select city
			driver.findElement(By.id("mat-input-26")).sendKeys(city);
			//select postal code
			driver.findElement(By.id("mat-input-27")).sendKeys(postalcode);
			//select the state
			driver.findElement(By.id("mat-select-value-39")).click();
			driver.findElement(By.id("mat-option-50")).click();
			//select the country
			driver.findElement(By.id("mat-select-value-41")).click();
			driver.findElement(By.id("mat-option-51")).click();
			
			//click on Add
			driver.findElement(By.xpath("//*[@id=\"mat-dialog-1\"]/mifosx-form-dialog/mat-dialog-actions/button[2]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-2\"]/mifosx-client-address-step/div/div[2]/button[2]")).click();
			}}
	@Test(priority = 5, dependsOnMethods = "AddresstabDataFillup")
	public void Nomination() throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream file = new FileInputStream(".//DataFiles//LMS Client Creation.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		@SuppressWarnings("rawtypes")
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Nomination");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			String fullname = getCellValueAsString(row.getCell(0));
			String share = getCellValueAsString(row.getCell(1));
			String KYCNo = getCellValueAsString(row.getCell(2));
			
			//Enter the fullname
			driver.findElement(By.id("mat-input-11")).sendKeys(fullname);
			//select the Relation ship
			driver.findElement(By.id("mat-select-value-23")).click();
			driver.findElement(By.id("mat-option-17")).click();
			//Enter the share value
			driver.findElement(By.id("mat-input-12")).sendKeys(share);
            //Select the document
			driver.findElement(By.id("mat-select-value-25")).click();
			driver.findElement(By.id("mat-option-20")).click();
			//Enter the KYC No
			driver.findElement(By.id("mat-input-13")).sendKeys(KYCNo);
			
			driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-3\"]/mifosx-client-datatable-step/form/div[2]/button[2]")).click();
			}}
	@Test(priority = 6, dependsOnMethods = "Nomination")
	public void KYC() throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream file = new FileInputStream(".//DataFiles//LMS Client Creation.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		@SuppressWarnings("rawtypes")
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("KYC");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
	
			String uniqid = getCellValueAsString(row.getCell(0));
			driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-4\"]/mifosx-client-kyc-step/div/button")).click();
			//select the document type
			driver.findElement(By.id("mat-select-value-43")).click();
			driver.findElement(By.id("mat-option-56")).click();
			//select the status type
			driver.findElement(By.id("mat-select-value-45")).click();
			driver.findElement(By.id("mat-option-59")).click();
			//Enter the values
			driver.findElement(By.id("mat-input-28")).sendKeys(uniqid);
			
			driver.findElement(By.id("mat-checkbox-7")).click();
			driver.findElement(By.id("mat-checkbox-8")).click();
			
			driver.findElement(By.xpath("//*[@id=\"mat-dialog-2\"]/mifosx-form-dialog/mat-dialog-actions/button[2]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-4\"]/mifosx-client-kyc-step/div/div/button[2]")).click();
			
		}}
	
	@Test(priority = 7, dependsOnMethods = "KYC")
	public void ApplicationSubmit() {
		Actions action=new Actions(driver);
		WebElement Submit = driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-5\"]/mifosx-client-preview-step/div[2]/button[3]"));
		action.scrollToElement(Submit).click().perform();
     Submit.click();
		
	}
	@Test(priority = 8, dependsOnMethods = "ApplicationSubmit")
	public void DeleteClient() {
		//click on Burger icon
		driver.findElement(By.className("mat-focus-indicator mat-menu-trigger mat-icon-button mat-button-base")).click();
		
	
	
	
			
			
			
			
			
			
			
			
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
