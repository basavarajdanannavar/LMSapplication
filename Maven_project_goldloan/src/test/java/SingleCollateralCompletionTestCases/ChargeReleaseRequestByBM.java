package SingleCollateralCompletionTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChargeReleaseRequestByBM {
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
		
		driver.findElement(By.cssSelector("[placeholder='Enter your username']")).sendKeys("test_bm");
		driver.findElement(By.cssSelector("[placeholder='Enter your password']")).sendKeys("P@ssw0rd");
		driver.findElement(By.cssSelector("[ng-click='auth.validate()']")).click();
		}
	@Test(priority=2)
	public void ChargeReleaseForm() throws InterruptedException	{
		//click on the Search Collateral Link
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[2]")).click();
		//Search by Collateral No
		try {
            // Read the text from a file
            String filePath = "C:\\Users\\Lenovo\\Downloads\\console_output.txt";
            String textFromFile = new String(Files.readAllBytes(Paths.get(filePath)));
    		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/input")).sendKeys(textFromFile);
			Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div")).click();
		Thread.sleep(2000);
		
		//Click on the 3dot Icon
		Thread.sleep(6000);

		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul/li[1]/div[1]/div[3]/img")).click();
		//click on Request Release
		Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[4]/div/strong")).click();
		}
	@Test(priority=3)
	public void RequestClosure() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		
		Robot r= new Robot();
		
		r.mouseWheel(1);
		Thread.sleep(2000);
		r.mouseWheel(1);
		Thread.sleep(2000);
		r.mouseWheel(1);
		Thread.sleep(2000);
		r.mouseWheel(1);
		Thread.sleep(2000);
		r.mouseWheel(1);
		Thread.sleep(2000);
		r.mouseWheel(1);
		Thread.sleep(2000);
		r.mouseWheel(1);
		Thread.sleep(2000);
		//Enter Scheduled date
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys("07/08/2023");
		Thread.sleep(3000);
		//Enter Field Operator Name
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/div/div[2]/form/div[2]/select")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[value='8']")).click();
		//Click on Request Closure
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul/li[1]/div[1]/div[2]/strong")).isDisplayed();
		
	}
	@Test(priority=4)
	public void CloseBrowser() {
		driver.close();

	
}
}
