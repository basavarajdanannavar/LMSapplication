package BulkCollateralTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JcollateralReleases {
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
	public void CollateralRelease() throws InterruptedException {
		Thread.sleep(2000);
		//Click on Collateral Additions
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/strong")).click();
		Thread.sleep(5000);
		//click on the Search Icon 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]/img")).click();
		Thread.sleep(2000);
		//Pass the Search details
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys("014526001571");
		Thread.sleep(2000);
		//Click on the Search Link
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).click();
		Thread.sleep(3000);
	//	click on 3dot Icon
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div/div[3]")).click();
		Thread.sleep(1000);
		//Click on Approve
        driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/div/strong")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/form/div[2]/textarea")).sendKeys("All details are Ok");
        Thread.sleep(2000);
        //click on submit
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/ul/li[2]")).isDisplayed();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[2]")).click();
        Thread.sleep(300);
        
		
		
	}
	
	@Test(priority=3)
	public void AnotherCollateralRelease() throws InterruptedException {
		Thread.sleep(2000);
		//Click on Collateral Additions
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/strong")).click();
		Thread.sleep(5000);
		//click on the Search Icon 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]/img")).click();
		Thread.sleep(2000);
		//Pass the Search details
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys("014526001572");
		Thread.sleep(2000);
		//Click on the Search Link
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).click();
		Thread.sleep(3000);
	//	click on 3dot Icon
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div/div[3]")).click();
		Thread.sleep(1000);
		//Click on Approve
        driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/div/strong")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/form/div[2]/textarea")).sendKeys("All details are Ok");
        Thread.sleep(2000);
        //click on submit
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/ul/li[2]")).isDisplayed();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[2]")).click();
        Thread.sleep(300);
        }
	@Test(priority=3)
	public void CloseBrowser() {
		driver.close();
	}
}
