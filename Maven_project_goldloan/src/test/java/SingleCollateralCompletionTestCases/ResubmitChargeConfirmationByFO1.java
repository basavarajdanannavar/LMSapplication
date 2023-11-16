package SingleCollateralCompletionTestCases;

import java. awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResubmitChargeConfirmationByFO1  {
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
	public void Login() throws InterruptedException {
	driver.get("https://ims-dev.technovative.in/#/auth/loginm");
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("[placeholder='Enter your username']")).sendKeys("test_fo");
		driver.findElement(By.cssSelector("[placeholder='Enter your password']")).sendKeys("P@ssw0rd");
		driver.findElement(By.cssSelector("[ng-click='auth.validate()']")).click();
		}

	@Test(priority=2)
	public void ChargeFormOpen () throws InterruptedException, AWTException{
		Robot r1= new Robot();		
	
	
	//Click on Charges to be confirmed
 driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/strong")).click();
 Thread.sleep(4000);
//click on the Search Collateral Link
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[1]/div[1]/span[1]/img")).click();
		//Search by Collateral No
		try {
            // Read the text from a file
            String filePath = "C:\\Users\\Lenovo\\Downloads\\console_output.txt";
            String textFromFile = new String(Files.readAllBytes(Paths.get(filePath)));
    		driver.findElement(By.cssSelector("[placeholder='Search by collateral number']")).sendKeys(textFromFile);
			Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("[ng-click='searchFilter.search()']")).click();
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
	       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/input")).sendKeys("");
       Thread.sleep(1000);
	       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[1]/input")).sendKeys("HDFC3269");
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
          //Enter Loan Amount
	       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[2]/div/input")).sendKeys("");
	       Thread.sleep(1000);

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
		
		
		
		
		
       //Loan Start Date
	       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[3]/input")).sendKeys("");
	       Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[3]/input")).sendKeys("05/11/2023");
       Thread.sleep(2000);
       r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
       //Loan Maturity  Date
	       driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[4]/input")).sendKeys("");
	       Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/form/div[4]/input")).sendKeys("06/11/2023");
       
       
   	  
   	  Thread.sleep(6000);
   	  
   	  //click on Confirm Charge Button
   	  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div")).click();
   	  
   	  Thread.sleep(3000);
   	  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/h1")).isDisplayed();
   	  }
	
	@Test(priority=4)
	public void CloseBrowser() {
		driver.close();
	}
	
	
}
