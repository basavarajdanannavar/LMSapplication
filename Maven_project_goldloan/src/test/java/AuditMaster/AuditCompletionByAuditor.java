package AuditMaster;

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

public class AuditCompletionByAuditor {

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
	
	driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys("test_auditor");
	driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[4]/input[1]")).sendKeys("P@ssw0rd");
	driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	}

@Test(priority=2)
public void OpenPendingAudits() throws InterruptedException, AWTException {
	
	//Click on PendingAudits
	driver.findElement(By.xpath("//strong[contains(text(),'Pending Audits')]")).click();
	Thread.sleep(3000);
	
	//Click on 3dot Icon
	driver.findElement(By.xpath("//body/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/img[1]")).click();
	Thread.sleep(3000);
	//Click on Start link
	
		driver.findElement(By.xpath("//strong[contains(text(),'Start')]")).click();
	//	driver.findElement(By.xpath("//strong[contains(text(),'Edit')]")).click();
	
	
	Thread.sleep(3000);
	//click on Ornaments
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[1]")).click();
	Thread.sleep(3000);
	//Enter the Gross weight
	driver.findElement(By.cssSelector("[ng-model='form.field.grossWeight.value']")).sendKeys("");
	Thread.sleep(2000);
	//Enter the Purity
	driver.findElement(By.cssSelector("[ng-model='form.field.purity.value']")).sendKeys("21");
	Thread.sleep(2000);
	//Enter the HallMark
	driver.findElement(By.cssSelector("[ng-model='form.field.hallmark.value']")).sendKeys("Hallmarked");
	Thread.sleep(2000);
	//Enter the StoneDeduction
	driver.findElement(By.cssSelector("[ng-model='form.field.stoneDeduction.value']")).sendKeys("");
	Thread.sleep(2000);
	//Enter the Wastage
	driver.findElement(By.cssSelector("[ng-model='form.field.wastage.value']")).sendKeys("");
	Thread.sleep(2000);
	//Click on Update
    driver.findElement(By.cssSelector("[ng-click='form.add()']")).click();
    Thread.sleep(3000);
    //Click on Finish
    driver.findElement(By.cssSelector("[ng-click='finish.action()']")).click();
    Thread.sleep(3000);
    
  //click on send an email
  	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[5]/div[1]/div[2]/div[1]/div[2]/a[2]")).click();
  	
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[5]/div[1]/div[4]/div[1]/div[2]/a[2]")).click();
  	
  	Thread.sleep(3000);
  	
  WebElement Attach =driver.findElement(By.xpath("//body[1]/div[2]/div[5]/div[1]/div[2]/div[2]/upload-document[1]/div[1]/div[1]/div[1]/label[1]/img[1]"));
   Attach.click();
   
   /* Thread.sleep(5000);
  	Runtime.getRuntime().exec("C:\\IMS Attachment test\\certificate.exe"); */
   Robot rb2=new Robot();

  	rb2.delay(2000);

  	  StringSelection check2=  new StringSelection("C:\\IMS Attachment test\\customer_appraisal_certificate_014526001417.pdf");
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

  	WebElement Attach1 =driver.findElement(By.xpath("//*[@id=\"'internalAppraisalCertificate-images'\"]/div/div/div/label/img"));
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
    
    //Click on Submit
  	 driver.findElement(By.cssSelector("[ng-click='finish.submitDamageDoc()']")).click();
    
  	 
  	 driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[1]/div/div/h1")).isDisplayed();
}




@Test(priority=6)
public void CloseBrowser() {
	
}

}
