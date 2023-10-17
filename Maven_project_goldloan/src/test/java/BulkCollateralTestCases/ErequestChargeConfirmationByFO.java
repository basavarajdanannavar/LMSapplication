package BulkCollateralTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErequestChargeConfirmationByFO {
	public static  WebDriver driver;

	@Test(priority=0)
	public void Browser() {
			// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	driver =new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

	@Test(priority=1)
	public void Login() throws InterruptedException, AWTException {
		driver.get("https://ims-dev.technovative.in/#/auth/loginm");
		Robot r= new Robot();		
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
		
		driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys("test_fo");
		driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[4]/input[1]")).sendKeys("P@ssw0rd");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		}
	@Test(priority=2)
	public void ChargeFormOpen () throws InterruptedException, AWTException{
		Robot r1= new Robot();		
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
	
	//Click on Charges to be confirmed
 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/strong")).click();
 Thread.sleep(4000);
 //Click on Search Icon
 driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]")).click();
 Thread.sleep(2000);
 //Pass the Collateral No
 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys("014526001571");
 Thread.sleep(3000);
 //click on Search Icon
 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).click();
 Thread.sleep(5000);
 
 
 //click on 3dot Icon
 driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/img")).click();

 //Click on Confirm  
 Thread.sleep(5000);

	Robot r = new Robot();
	r.mouseMove(100, 550);
	
	Actions action = new Actions(driver);
	WebElement confirm =driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/div/strong"));
	
	
	action.doubleClick(confirm).perform();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/h1")).isDisplayed();
	}
	
	@Test(priority=3)
	public void ChargeFillup() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		Robot r= new Robot();
		r.mouseMove(80, 510);
		
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	
		Thread.sleep(1000);
	//Enter Loan Number
       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/input")).sendKeys("HDFC3269");
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
          //Enter Loan Amount
       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[2]/div/input")).sendKeys("150000");
       Thread.sleep(2000);
       r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		
       //Loan Start Date
       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[3]/input")).sendKeys("05/05/2023");
       Thread.sleep(2000);
       r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
       //Loan Maturity  Date
       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[4]/input")).sendKeys("06/05/2023");
       
       //Attach AppraisalImage
       WebElement AppraisalImage  = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[5]/upload-document/div/div/div/label/img"));
       AppraisalImage.click();
   	
  	Robot rb=new Robot();

   	rb.delay(2000);

   	  StringSelection check=  new StringSelection("C:\\IMS Attachment test\\download.png");
   	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check, null);
   	  rb.keyPress(KeyEvent.VK_CONTROL);
   	  rb.keyPress(KeyEvent.VK_V);
   	  rb.keyRelease(KeyEvent.VK_CONTROL);
   	  rb.keyRelease(KeyEvent.VK_V);
   	  
   	  
   	  rb.delay(2000);
   	  
   	  rb.keyPress(KeyEvent.VK_ENTER);
   	  rb.keyRelease(KeyEvent.VK_ENTER);
   	  
   	  Thread.sleep(6000);
   	  
   	  //click on Confirm Charge Button
   	  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div")).click();
   	  
   	  Thread.sleep(5000);
   	  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/h1")).isDisplayed();
   	  
   	  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[2]")).click();
   	  
   	Thread.sleep(5000);
	
	
	}
	
	
	@Test(priority=4)
	public void ChargeFormOpen2 () throws InterruptedException, AWTException{
		
	
	//Click on Charges to be confirmed
 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/strong")).click();
 Thread.sleep(4000);
 
 //Click on Search Icon
 driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]")).click();
 Thread.sleep(2000);
 //Pass the Collateral No
 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys("014526001572");
 Thread.sleep(3000);
 //click on Search Icon
 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).click();
 Thread.sleep(5000);
 
 
 
 //click on 3dot Icon
 driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/img")).click();

 //Click on Confirm  
 Thread.sleep(5000);

	Robot r = new Robot();
	r.mouseMove(100, 550);
	
	Actions action = new Actions(driver);
	WebElement confirm =driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/div/strong"));
	
	
	action.doubleClick(confirm).perform();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/h1")).isDisplayed();
	}
	
	@Test(priority=5)
	public void ChargeFillup2() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		Robot r= new Robot();
		r.mouseMove(80, 510);
		
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	
		Thread.sleep(1000);
	//Enter Loan Number
       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/input")).sendKeys("HDFC3269");
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
          //Enter Loan Amount
       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[2]/div/input")).sendKeys("150000");
       Thread.sleep(2000);
       r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		
		
       //Loan Start Date
       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[3]/input")).sendKeys("05/05/2023");
       Thread.sleep(2000);
       r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
       //Loan Maturity  Date
       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[4]/input")).sendKeys("06/05/2023");
       
       //Attach AppraisalImage
       WebElement AppraisalImage  = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[5]/upload-document/div/div/div/label/img"));
       AppraisalImage.click();
   	
  	Robot rb=new Robot();

   	rb.delay(2000);

   	  StringSelection check=  new StringSelection("C:\\IMS Attachment test\\download.png");
   	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check, null);
   	  rb.keyPress(KeyEvent.VK_CONTROL);
   	  rb.keyPress(KeyEvent.VK_V);
   	  rb.keyRelease(KeyEvent.VK_CONTROL);
   	  rb.keyRelease(KeyEvent.VK_V);
   	  
   	  
   	  rb.delay(2000);
   	  
   	  rb.keyPress(KeyEvent.VK_ENTER);
   	  rb.keyRelease(KeyEvent.VK_ENTER);
   	  
   	  Thread.sleep(6000);
   	  
   	  //click on Confirm Charge Button
   	  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div")).click();
   	  
   	  Thread.sleep(3000);
   	  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/h1")).isDisplayed();
   	  }
	
	@Test(priority=6)
	public void CloseBrowser() {
		driver.close();
	}
	
}
