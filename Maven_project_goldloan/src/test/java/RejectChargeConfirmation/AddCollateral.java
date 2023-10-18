
package RejectChargeConfirmation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.io.FileDescriptor;
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

public class AddCollateral  {

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
		
driver.get("https://ims-dev.technovative.in/#/auth/loginm");
		
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
	
	driver.findElement(By.xpath("//strong[contains(text(),'Other')]")).click();
	//District	
	driver.findElement(By.cssSelector("[placeholder='Select district']")).click();
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/div/input")).sendKeys("Thane");
	
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/ul/li")).click();
	//Branch
	driver.findElement(By.cssSelector("[placeholder='Select branch']")).click();
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/div/input")).sendKeys("Dharwad");
	
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/ul/li")).click();
	//Internal Appraiser
	driver.findElement(By.cssSelector("[ng-model='form.field.appraisalType.value']")).click();
	driver.findElement(By.cssSelector("[value='internal_appraisal']")).click();
	//Submit
	
	driver.findElement(By.xpath("//div[contains(text(),'Continue')]")).click();
	}
@Test(dependsOnMethods = { "AddCollaterl" },dataProvider="Packet ID",dataProviderClass = CollateralDataProvider.class,priority=3)
public void AddPacketWithPacketID(String PacketID) {
	
	// Click on Add PAcket 
	driver.findElement(By.xpath("//div[contains(text(),'+ New Packet')]")).click();
	//Allow without Packet ID
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[5]/div[1]/div[3]/input")).sendKeys(PacketID);
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
	    
	        driver.findElement(By.xpath("//div[contains(text(),'+ New Ornaments')]")).click();
	        

	//Ornament Type
	driver.findElement(By.cssSelector("[ng-click='ornamentType.open()']")).click();
	

	driver.findElement(By.cssSelector("#ornamentTypeScroll > div > ul > li:nth-child(10)")).click();
	
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

		Robot robot = new Robot();
		
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

	  StringSelection check1=  new StringSelection("C:\\Users\\Lenovo\\git\\repository\\Maven_project_goldloan\\Photos\\download.jpg");
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


@Test(dependsOnMethods = { "AddOrnaments" },priority=5)
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
@Test(dependsOnMethods = { "SubmitCollateral" },priority=6)
public void CloseBrowser() {
	driver.close();
}
}
