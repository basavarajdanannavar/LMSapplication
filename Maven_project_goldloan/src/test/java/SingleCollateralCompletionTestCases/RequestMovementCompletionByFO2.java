package SingleCollateralCompletionTestCases;

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

public class RequestMovementCompletionByFO2 {
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
public void StartTrip() throws AWTException, InterruptedException {
	//Click on ScheduledMovement link
	
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[3]/strong")).click();
	Thread.sleep(4000);
	//Click on 3dot Icon
	
	driver.findElement(By.cssSelector("#pageContainerInn > div.collateral-list.ng-scope > div > div:nth-child(1) > div > div.menuIcon > img")).click();
	
	Thread.sleep(3000);
	//Click on View Movement Details
	Thread.sleep(3000);

	Robot r = new Robot();
	r.mouseMove(100, 450);
	
	Actions action = new Actions(driver);
	WebElement re=driver.findElement(By.xpath("//html/body/div[4]/div/ul/li[1]/div/strong"));
	
	
	action.doubleClick(re).perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/h1")).isDisplayed();
	}

@Test(priority=3)
public void TrackOngoingTrip() throws InterruptedException {
	Thread.sleep(2000);
	
	//click on StartTrip button
	
driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[1]")).click();

//Click on Validated Packets Done
Thread.sleep(5000);
driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[2]/div")).click();


//Click on Confirm Start Trip
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[3]/div/div")).click();

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