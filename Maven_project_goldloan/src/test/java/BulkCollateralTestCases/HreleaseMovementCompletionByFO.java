package BulkCollateralTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HreleaseMovementCompletionByFO {
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
	
public void login () throws InterruptedException {
	driver.get("https://ims-dev.technovative.in/#/auth/loginm");
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys("test_fo");
	driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[4]/input[1]")).sendKeys("P@ssw0rd");
	driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	}

@Test(priority=2)
public void StartTrip() throws AWTException, InterruptedException {
	//Click on ScheduledMovement link
	
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[3]/strong")).click();
	Thread.sleep(4000);
	//Select Multiple Collaterals
	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[1]/span")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[2]/div/div[1]/span")).click();
	
}

@Test(priority=3)
public void TrackOngoingTrip() throws InterruptedException {
	Thread.sleep(2000);
	
	//click on StartTrip button
	
driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[3]/div/div/div")).click();
//Enter Release Amount
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[3]/ul/li[5]/div/div/div/div/input")).sendKeys("160000");
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[4]/ul/li[5]/div/div/div/div/input")).sendKeys("140000");



//Click on Confirm Start Trip
Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[1]")).click();

//Click on Validated Packets Done
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]/div")).click();
//Click on End Trip
Thread.sleep(8000);
driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[1]")).click();

Thread.sleep(4000);
driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/h1")).isDisplayed();
}

@Test(priority=4)
public void CloseBrowser() {
	driver.close();
}
	
	
}
