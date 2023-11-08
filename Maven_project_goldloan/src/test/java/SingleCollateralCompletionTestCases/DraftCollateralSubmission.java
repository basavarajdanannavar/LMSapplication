
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
import java.nio.file.Files;
import java.nio.file.Paths;
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

public class DraftCollateralSubmission  {

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
	



@Test(priority=2)
public void GotoCollateral() throws InterruptedException, AWTException {
	
	//Click on Burger Icon
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[1]/div[1]")).click();
	//Click on Pending action page
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/ul/li[5]")).click();
	Thread.sleep(5000);
	//click on search Icon
	driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]/img")).click();
	Thread.sleep(1000);
	try {
        // Read the text from a file
        String filePath = "C:\\Users\\Lenovo\\Downloads\\console_output.txt";
        String textFromFile = new String(Files.readAllBytes(Paths.get(filePath)));
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys(textFromFile);
		//Click on the Search Link
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div")).click();Thread.sleep(500);
    } catch (IOException e) {
        e.printStackTrace();
    }
	
	Thread.sleep(3000);
	//click on 3dot icon
	driver.findElement(By.xpath("//*[@id=\"pageContainerInn\"]/div[2]/div/div/div/div[3]")).click();
	//click on view
	Robot r = new Robot();
	Actions action = new Actions(driver);
	r.mouseMove(50, 500);
	
	WebElement view = driver.findElement(By.xpath("//*[@id=\"body\"]/div[4]/div/ul/li[2]"));
	

	Thread.sleep(500);
	action.doubleClick(view).perform();
	}

@Test(priority=3)
public void NewOrnamentAddition() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
	
	    
	        driver.findElement(By.xpath("//div[contains(text(),'+ New Ornaments')]")).click();
	        

	//Ornament Type
	driver.findElement(By.cssSelector("[ng-click='ornamentType.open()']")).click();
	

	driver.findElement(By.cssSelector("#ornamentTypeScroll > div > ul > li:nth-child(8)")).click();
	
	//driver.findElement(By.xpath("//*[@id=\"ornamentTypeScroll\"]/div/ul/li[1]")).click();
	

	//Count
	driver.findElement(By.cssSelector("[placeholder='Enter Count']")).sendKeys("05");
	

	//GW
	driver.findElement(By.cssSelector("[placeholder='Enter Weight']")).sendKeys("34.545");
	
	
	WebElement WeighScale = driver.findElement(By.xpath("//*[@id=\"'weighingScaleImage-images'\"]/div/div/div/label/img"));
	WeighScale.click();
	
	
	/*Runtime.getRuntime().exec("C:\\IMS Attachment test\\Uploadfile.exe");
	Thread.sleep(5000); */
	
	Robot rb=new Robot();

	rb.delay(2000);
	

	  StringSelection check=  new StringSelection("C:\\Users\\Lenovo\\git\\repository\\Maven_project_goldloan\\Photos\\download (1).jpg");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check, null);
	  rb.keyPress(KeyEvent.VK_CONTROL);
	  rb.keyPress(KeyEvent.VK_V);
	  rb.keyRelease(KeyEvent.VK_CONTROL);
	  rb.keyRelease(KeyEvent.VK_V);
	  
	  
	  rb.delay(2000);
	  
	  rb.keyPress(KeyEvent.VK_ENTER);
	  rb.keyRelease(KeyEvent.VK_ENTER);
		
		rb.mouseWheel(1);
		Thread.sleep(500);
		rb.mouseWheel(1);
		Thread.sleep(500);
		rb.mouseWheel(1);
		Thread.sleep(500);
		rb.mouseWheel(1);
		Thread.sleep(500);
		rb.mouseWheel(1);
		Thread.sleep(500);
	//Purity
	driver.findElement(By.cssSelector("[ng-model='form.field.purity.value']")).click();
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[3]/div[1]/div[1]/select/option[2]")).click();


	//Hallmark
	driver.findElement(By.cssSelector("[ng-model='form.field.hallmark.value']")).click();
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[3]/div[1]/div[2]/select/option[2]")).click();
	
	
	rb.mouseMove(55, 577);
	
	//Stone Deduction
	driver.findElement(By.cssSelector("[ng-model='form.field.stoneDeduction.value']")).sendKeys("2.36");
	

	//Wastage
	driver.findElement(By.cssSelector("[ng-model='form.field.wastage.value']")).sendKeys("0.373");
	

	Actions action =new Actions(driver);
	action.scrollByAmount(0, 400);
	WebElement OrnamentImg = driver.findElement(By.xpath("//*[@id=\"'ornamentImages-images'\"]/div/div/div/label/img"));
	OrnamentImg.click();
	
	rb.mouseMove(55, 577);
	
/* Thread.sleep(2000);
	Runtime.getRuntime().exec("C:\\IMS Attachment test\\OrnamentUPload.exe");
	Thread.sleep(10000); */
	Robot rb1=new Robot();

	rb1.delay(2000);

	  StringSelection check1=  new StringSelection("C:\\Users\\Lenovo\\git\\repository\\Maven_project_goldloan\\Photos\\Khda.jpeg");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check1, null);
	  rb1.keyPress(KeyEvent.VK_CONTROL);
	  rb1.keyPress(KeyEvent.VK_V);
	  rb1.keyRelease(KeyEvent.VK_CONTROL);
	  rb1.keyRelease(KeyEvent.VK_V);
	  
	  
	  
	  
	  rb1.keyPress(KeyEvent.VK_ENTER);
	  rb1.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(5000);


	driver.findElement(By.cssSelector("[ng-click='form.add()']")).click();
	}


@Test(priority=4)
public void SubmitCollateral() throws InterruptedException, IOException, AWTException {
	Thread.sleep(5000);
	//Click on Finish Button
	driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[5]/div[1]/div[1]/div[2]/div[1]")).click();
	Thread.sleep(100);
	//click on send an email
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/a[2]")).click();
	
	Thread.sleep(300);
	
WebElement Attach =driver.findElement(By.xpath("/html/body/div[2]/div[7]/div[1]/div[2]/div[2]/upload-document/div/div/div/label/img"));
 Attach.click();
 
 /* Thread.sleep(5000);
	Runtime.getRuntime().exec("C:\\IMS Attachment test\\certificate.exe"); */
 Robot rb2=new Robot();

	rb2.delay(2000);

	  StringSelection check2=  new StringSelection("C:\\Users\\Lenovo\\git\\repository\\Maven_project_goldloan\\Photos\\customer_appraisal_certificate_010126001974.pdf");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check2, null);
	  rb2.keyPress(KeyEvent.VK_CONTROL);
	  rb2.keyPress(KeyEvent.VK_V);
	  rb2.keyRelease(KeyEvent.VK_CONTROL);
	  rb2.keyRelease(KeyEvent.VK_V);
	  
	  
	  rb2.delay(2000);
	  
	  rb2.keyPress(KeyEvent.VK_ENTER);
	  rb2.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(5000);	
 Thread.sleep(1000); 

	WebElement Attach1 =driver.findElement(By.xpath("/html/body/div[2]/div[7]/div[1]/div[4]/div[2]/upload-document/div/div/div/label/img"));
	 Attach1.click();
	 
	/*  Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\IMS Attachment test\\certificate.exe"); */
	 Robot rb3=new Robot();

		rb2.delay(2000);

		  StringSelection check3=  new StringSelection("C:\\Users\\Lenovo\\git\\repository\\Maven_project_goldloan\\Photos\\internal_appraisal_certificate_010126001974 (1).pdf");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check3, null);
		  rb3.keyPress(KeyEvent.VK_CONTROL);
		  rb3.keyPress(KeyEvent.VK_V);
		  rb3.keyRelease(KeyEvent.VK_CONTROL);
		  rb3.keyRelease(KeyEvent.VK_V);
		  
		  
		  rb3.delay(2000);
		  
		  rb3.keyPress(KeyEvent.VK_ENTER);
		  rb3.keyRelease(KeyEvent.VK_ENTER);	
	 Thread.sleep(5000);

		driver.findElement(By.xpath("//div[contains(text(),'Submit')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[1]/div")).isDisplayed();
		
		}
@Test(priority=5)
public void CloseBrowser() {
	driver.close();
}
}
