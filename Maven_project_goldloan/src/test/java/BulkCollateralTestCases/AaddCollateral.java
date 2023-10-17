package BulkCollateralTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AaddCollateral {
	
public static  WebDriver driver;

	@Test(priority=0)
	public void Browser() {
			
WebDriverManager.chromedriver().setup();
 driver =new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
					

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		}
@Test(priority=1)
public void Login() throws InterruptedException {
driver.get("https://ims-dev.technovative.in/#/auth/login");
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys("test_appraiser");
	driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[4]/input[1]")).sendKeys("P@ssw0rd");
	driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	}

@Test(priority=2)
public void AddCollaterl() throws InterruptedException {
	driver.findElement(By.xpath("//img[@src='images/add-collateral-icon.svg']")).click();
	//State
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[1]/input")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/ul/li[3]")).click();
	//District
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[2]/input")).click();
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/div/input")).sendKeys("Thane");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/ul/li")).click();
	//Branch
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[3]/input")).click();
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/div/input")).sendKeys("Dharwad");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/select-location/div[5]/div/ul/li")).click();
	//Internal Appraiser
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/div[3]/select")).click();
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/form/div[3]/select/option[2]")).click();
	//Submit
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[3]/div/div/div")).click();
	}
@Test(priority=3)
public void AddPacketWithoutPacketID() {
// Click on Add PAcket 
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/div/div[3]/div")).click();
	//Allow without Packet ID
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[5]/div[1]/div[4]/label")).click();
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[5]/div[2]/div")).click();
	}
@Test(priority=4)
public void AddOrnaments() throws InterruptedException, IOException, AWTException {

	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[4]/div/div/div[3]/div")).click();
	Thread.sleep(3000);

	//Ornament Type
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[1]/div[1]/input")).click();
	Thread.sleep(3000);

	driver.findElement(By.xpath("//*[@id=\"ornamentTypeScroll\"]/div/div/input")).sendKeys("Chain");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"ornamentTypeScroll\"]/div/ul/li[1]")).click();
	Thread.sleep(3000);

	//Count
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[1]/div[2]/div[1]/input")).sendKeys("05");
	Thread.sleep(3000);

	//GW
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[1]/div[2]/div[2]/input")).sendKeys("34.545");
	Thread.sleep(3000);
	
	WebElement WeighScale = driver.findElement(By.xpath("//*[@id=\"'weighingScaleImage-images'\"]/div/div/div/label/img"));
	WeighScale.click();
	
	
	/*Runtime.getRuntime().exec("C:\\IMS Attachment test\\Uploadfile.exe");
	Thread.sleep(5000); */
	
	Robot rb=new Robot();

	rb.delay(2000);
	rb.keyPress(KeyEvent.VK_PAGE_DOWN);
	rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
	rb.keyPress(KeyEvent.VK_PAGE_DOWN);
	rb.keyRelease(KeyEvent.VK_PAGE_DOWN);

	  StringSelection check=  new StringSelection("C:\\IMS Attachment test\\download (3).jpg");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check, null);
	  rb.keyPress(KeyEvent.VK_CONTROL);
	  rb.keyPress(KeyEvent.VK_V);
	  rb.keyRelease(KeyEvent.VK_CONTROL);
	  rb.keyRelease(KeyEvent.VK_V);
	  
	  
	  rb.delay(2000);
	  
	  rb.keyPress(KeyEvent.VK_ENTER);
	  rb.keyRelease(KeyEvent.VK_ENTER);

	
	//Purity
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[3]/div[1]/div[1]/select")).click();
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[3]/div[1]/div[1]/select/option[2]")).click();
	Thread.sleep(3000);

	//Hallmark
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[3]/div[1]/div[2]/select")).click();
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[3]/div[1]/div[2]/select/option[2]")).click();
	Thread.sleep(3000);
	
	rb.mouseMove(55, 577);
	
	//Stone Deduction
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[3]/div[2]/div[1]/input")).sendKeys("2.36");
	Thread.sleep(3000);

	//Wastage
	driver.findElement(By.xpath("//*[@id=\"pageContainer\"]/div/form/div[3]/div[2]/div[2]/input")).sendKeys("0.373");
	Thread.sleep(10000);

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

	  StringSelection check1=  new StringSelection("C:\\IMS Attachment test\\download (2).jpg");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check1, null);
	  rb1.keyPress(KeyEvent.VK_CONTROL);
	  rb1.keyPress(KeyEvent.VK_V);
	  rb1.keyRelease(KeyEvent.VK_CONTROL);
	  rb1.keyRelease(KeyEvent.VK_V);
	  
	  
	  rb1.delay(2000);
	  
	  rb1.keyPress(KeyEvent.VK_ENTER);
	  rb1.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(5000);


	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[3]/div/div/div[2]/div")).click();
	}


@Test(priority=5)
public void SubmitCollateral() throws InterruptedException, IOException, AWTException {
	Thread.sleep(5000);
	//Click on Finish Button
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[5]/div/div/div[2]/div")).click();
	Thread.sleep(5000);
	//click on send an email
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/a[2]")).click();
	
	Thread.sleep(3000);
	
WebElement Attach =driver.findElement(By.xpath("/html/body/div[2]/div[7]/div[1]/div[2]/div[2]/upload-document/div/div/div/label/img"));
 Attach.click();
 
 /* Thread.sleep(5000);
	Runtime.getRuntime().exec("C:\\IMS Attachment test\\certificate.exe"); */
 Robot rb2=new Robot();

	rb2.delay(2000);

	  StringSelection check2=  new StringSelection("C:\\IMS Attachment test\\internal.pdf");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check2, null);
	  rb2.keyPress(KeyEvent.VK_CONTROL);
	  rb2.keyPress(KeyEvent.VK_V);
	  rb2.keyRelease(KeyEvent.VK_CONTROL);
	  rb2.keyRelease(KeyEvent.VK_V);
	  
	  
	  rb2.delay(2000);
	  
	  rb2.keyPress(KeyEvent.VK_ENTER);
	  rb2.keyRelease(KeyEvent.VK_ENTER);
	  Thread.sleep(5000);	
 Thread.sleep(5000); 

	WebElement Attach1 =driver.findElement(By.xpath("/html/body/div[2]/div[7]/div[1]/div[4]/div[2]/upload-document/div/div/div/label/img"));
	 Attach1.click();
	 
	/*  Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\IMS Attachment test\\certificate.exe"); */
	 Robot rb3=new Robot();

		rb2.delay(2000);

		  StringSelection check3=  new StringSelection("C:\\IMS Attachment test\\internal.pdf");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(check3, null);
		  rb3.keyPress(KeyEvent.VK_CONTROL);
		  rb3.keyPress(KeyEvent.VK_V);
		  rb3.keyRelease(KeyEvent.VK_CONTROL);
		  rb3.keyRelease(KeyEvent.VK_V);
		  
		  
		  rb3.delay(2000);
		  
		  rb3.keyPress(KeyEvent.VK_ENTER);
		  rb3.keyRelease(KeyEvent.VK_ENTER);	
	 Thread.sleep(10000);

		driver.findElement(By.xpath("/html/body/div[2]/div[7]/div[2]/div")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[1]/div")).isDisplayed();
		
		}


@Test(priority=6)
public void CloseBrowser() {
	driver.close();
}


}
