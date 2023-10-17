package BulkCollateralTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GchargeReleaseRequestByBM {
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
	public void ChargeReleaseForm() throws InterruptedException	{
		//click on the Search Collateral Link
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[2]")).click();
		//Search by Collateral No
	    driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/input")).sendKeys("014526001571");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/div/h3")).click();
		//Click on the 3dot Icon
		Thread.sleep(6000);

		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul/li[1]/div[1]/div[3]/img")).click();
		//click on Request Release
		Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[4]/div/strong")).click();
		}
	@Test(priority=3)
	public void RequestClosure() throws InterruptedException {
		Thread.sleep(2000);
		//Enter Scheduled date
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys("05/25/2023");
		Thread.sleep(3000);
		//Enter Field Operator Name
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/form/div[2]/select")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/form/div[2]/select/option[55]")).click();
		//Click on Request Closure
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul/li[1]/div[1]/div[2]/strong")).isDisplayed();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span/img")).click();
		Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/span/img")).click();
		
	}
	@Test(priority=4)
	public void ChargeReleaseForm2() throws InterruptedException	{
		//click on the Search Collateral Link
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[2]")).click();
		//Search by Collateral No
	    driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/input")).sendKeys("014526001572");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/div/h3")).click();
		//Click on the 3dot Icon
		Thread.sleep(6000);

		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul/li[1]/div[1]/div[3]/img")).click();
		//click on Request Release
		Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[4]/div/strong")).click();
		}
	@Test(priority=5)
	public void RequestClosure2() throws InterruptedException {
		Thread.sleep(2000);
		//Enter Scheduled date
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys("05/25/2023");
		Thread.sleep(3000);
		//Enter Field Operator Name
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/form/div[2]/select")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/form/div[2]/select/option[55]")).click();
		//Click on Request Closure
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul/li[1]/div[1]/div[2]/strong")).isDisplayed();
		Thread.sleep(3000);
	}
	@Test(priority=6)
	public void CloseBrowser() {
		driver.close();
	}
}
	
