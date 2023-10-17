package RejectChargeConfirmation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RejectChargeConfirmationByBM  {
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
	public void OpenCharges(String collateral) throws AWTException, InterruptedException {
		Thread.sleep(2000);
		//Click on Charge Additions
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/strong")).click();
		Thread.sleep(2000);
		//click on the Search Icon 
				driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]/img")).click();
				Thread.sleep(2000);
				//Pass the Search details
				try {
		            // Read the text from a file
		            String filePath = "C:\\Users\\Lenovo\\Downloads\\console_output.txt";
		            String textFromFile = new String(Files.readAllBytes(Paths.get(filePath)));
					driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys(textFromFile);
					Thread.sleep(5000);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				
				Thread.sleep(2000);
				//Click on the Search Link
				driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div"));
				Thread.sleep(3000);
		//Click on 3 dot Icon
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]")).click();
		Thread.sleep(1000);  
		//click on View
	/*	driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[1]/div/strong")).click();
		Robot r=new Robot();
		r.mouseWheel(1);
		Thread.sleep(8000);/html/body/div[2]/div[1]/span
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/span'")).click();
		Thread.sleep(1000);  */
		//Click on Reject Charge Creation
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[4]/div/ul/li[3]/div/strong")).click();
		//Reason
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[6]/div[1]/form/div[2]/select")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[6]/div[1]/form/div[2]/select/option[2]")).click();
		
		
		//Enter the Comments 
		driver.findElement(By.cssSelector("[ng-model='action.confirmReason.field.comments.value']")).sendKeys("All Details  not are OK");
		Thread.sleep(1000);
        //click on Submit
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/h1")).isDisplayed();
        
		
		}
	/*@Test(priority=3)
	public void CloseBrowser() {
		driver.close();
	}*/
		
	}


