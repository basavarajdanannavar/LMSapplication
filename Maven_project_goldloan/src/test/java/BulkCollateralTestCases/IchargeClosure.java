package BulkCollateralTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IchargeClosure {
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
	public void ChargeClosure() throws InterruptedException {
		Thread.sleep(2000);
		//click on ChargeAdditions 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/strong")).click();
		Thread.sleep(2000);
		//click on the Search Icon 
				driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]/img")).click();
				Thread.sleep(2000);
				//Pass the Search details
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys("014526001571");
				Thread.sleep(2000);
				//Click on the Search Link
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).click();
				Thread.sleep(3000);
		//click on 3 dot Icon
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/img")).click();
		Thread.sleep(1000);
	//	Click on View
		driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[1]/div/strong")).click();
		Thread.sleep(5000);
		//Click on Cancel
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span")).click();
		Thread.sleep(2000);
		//click on 3 dot Icon
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/img")).click();
		Thread.sleep(1000);
		//Click on Approve Charge Closure
		driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[3]/div/strong")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/form/div[2]/textarea")).sendKeys("All Details are OK");
		Thread.sleep(1000);
		//click on submit
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/h1")).isDisplayed();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/span")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[2]")).click();
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=03)
	public void AnotherChargeClosure() throws InterruptedException {
		Thread.sleep(2000);
		//click on ChargeAdditions 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/strong")).click();
		Thread.sleep(2000);
		//click on the Search Icon 
				driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]/img")).click();
				Thread.sleep(2000);
				//Pass the Search details
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys("014526001572");
				Thread.sleep(2000);
				//Click on the Search Link
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).click();
				Thread.sleep(3000);
		//click on 3 dot Icon
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/img")).click();
		Thread.sleep(1000);
	//	Click on View
		driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[1]/div/strong")).click();
		Thread.sleep(5000);
		//Click on Cancel
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span")).click();
		Thread.sleep(2000);
		//click on 3 dot Icon
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/img")).click();
		Thread.sleep(1000);
		//Click on Approve Charge Closure
		driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[3]/div/strong")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/form/div[2]/textarea")).sendKeys("All Details are OK");
		Thread.sleep(1000);
		//click on submit
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/h1")).isDisplayed();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[2]")).click();
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void CloseBrowser() {
		driver.close();
	}
	
}
