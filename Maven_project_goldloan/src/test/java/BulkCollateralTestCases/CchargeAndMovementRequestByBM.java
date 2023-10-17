package BulkCollateralTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CchargeAndMovementRequestByBM {
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
		
		driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys("test_bm");
		driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[4]/input[1]")).sendKeys("P@ssw0rd");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		}	
	
	@Test(priority=2)
	public void SearchCollateral () throws InterruptedException, AWTException {
		//click on the Search Collateral Link
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[2]")).click();
			//Search with Collateral No
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[2]/div[1]/input")).sendKeys("05/25/2023");
		Thread.sleep(2000);
		//Click on Search Button
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div")).click();

		//Select Multiple Collaterals
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div[1]/div/span")).click();
		
		Thread.sleep(1000);
		
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div[2]/div/span")).click();
		
		Thread.sleep(3000);
		
		//Click on Request Charge Button 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div/div[1]")).click();
		
		Thread.sleep(8000);
	
		}
	@Test(priority=3)
	public void ChargeRequestFormFillup () throws AWTException, InterruptedException {
		
	
		//click on the Lender
				driver.findElement(By.cssSelector("[ng-model='form.field.lenderId.value']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/div[2]/form/div[3]/select/option[3]")).click();
				Robot r = new Robot();
				
				
				//Click on State
				driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div/form/select-location/div[1]/input")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/select-location/div[5]/div/ul/li[3]")).click();
				
				r.mouseWheel(1);
				Thread.sleep(5000);
				r.mouseWheel(1);
				Thread.sleep(5000);
				r.mouseWheel(1);
				Thread.sleep(5000);
				r.mouseWheel(1);
				Thread.sleep(5000);
				r.mouseWheel(1);
				Thread.sleep(5000);
				r.mouseWheel(1);
				Thread.sleep(5000);
				
					//District
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/select-location/div[2]/input")).click();
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/select-location/div[5]/div/div/input")).sendKeys("Thane");
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/select-location/div[5]/div/ul/li")).click();
				
				Actions action = new Actions(driver);
				action.scrollByAmount(683, 594);
				
				
				Thread.sleep(3000);
			
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
				
				
				
				//Click on Branch
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/select-location/div[3]/input")).click();
				driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/div/form/select-location/div[5]/div/div/input")).sendKeys("Dharward - HDFC");
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/select-location/div[5]/div/ul/li")).click();
				
				
			
				
				
				
				Thread.sleep(1000);
				//Click on Scheduled oN
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div[5]/input")).sendKeys("07/05/2023");
				Thread.sleep(1000);
				//Select Fo
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/div[6]/select")).sendKeys("Test Field Operator");
				
				Thread.sleep(3000);
				//Click on Request Charge
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/div[1]")).click();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/h1")).isDisplayed();
				Thread.sleep(4000);
				driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/span/img")).click();
				Thread.sleep(3000);
}
	
	
	/*@Test(priority=4)
	public void CloseBrowser() {
		driver.close();
	} */
}
