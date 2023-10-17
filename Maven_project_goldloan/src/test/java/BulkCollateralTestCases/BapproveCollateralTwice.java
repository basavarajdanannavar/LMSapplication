package BulkCollateralTestCases;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BapproveCollateralTwice {
	
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
	public void CollateralAdditionLink() throws InterruptedException, AWTException {
		
		//Click on Collateral Additions Link
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/strong")).click();
		Thread.sleep(10000);
		//click on the Search Icon 
				driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]/img")).click();
				Thread.sleep(2000);
				//Pass the Search details
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys("014526001788");
				Thread.sleep(5000);
				//Click on the Search Link
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).click();
				Thread.sleep(5000);
	
//Click on 3 dot Icon
	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/img")).click();
	Thread.sleep(5000);
	//click on View
	/* driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[1]")).click();
	Thread.sleep(8000);
	// Click on Packets
	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div[1]")).click();
	//Click on Ornaments
	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div[2]/div/table/tbody/tr/td[1]")).click();
	//View the Ornament
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,600)");
	
	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div[5]/div/div/div[1]/div/div[1]/div/div/img")).click();
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("/html/body/div[4]/div/div/span")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("/html/body/div[2]/div[4]")).click();
	
	//Click on 3dot Icon
	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul/li[1]/div[1]/div[3]/img")).click();
	Thread.sleep(2000); */
	//Click on Approve
	driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]")).click();
	//Enter the Comments
	driver.findElement(By.xpath("/html/body/div[6]/div[1]/form/div[2]/textarea")).sendKeys("Collateral Details are OK");
	//Click on Submit
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[6]/div[2]/div")).click();
	
	driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/h1")).isDisplayed();
	Thread.sleep(4000);
	
	//click on Cancel
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/span")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[2]")).click();
	Thread.sleep(4000);

	
}
	@Test(priority=3)
	public void CollateralAdditionLink2() throws InterruptedException {
	//Click on Collateral Additions Link
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/strong")).click();
			Thread.sleep(10000);
			//click on the Search Icon 
					driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[1]/img")).click();
					Thread.sleep(2000);
					//Pass the Search details
					driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/input")).sendKeys("014526001789");
					Thread.sleep(5000);
					//Click on the Search Link
					driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div")).click();
					Thread.sleep(5000);
		
	//Click on 3 dot Icon
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/img")).click();
		Thread.sleep(5000);
		//click on View
		/* driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[1]")).click();
		Thread.sleep(8000);
		// Click on Packets
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div[1]")).click();
		//Click on Ornaments
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div/div[2]/div/table/tbody/tr/td[1]")).click();
		//View the Ornament
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div[5]/div/div/div[1]/div/div[1]/div/div/img")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("/html/body/div[4]/div/div/span")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[2]/div[4]")).click();
		
		//Click on 3dot Icon
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul/li[1]/div[1]/div[3]/img")).click();
		Thread.sleep(2000); */
		//Click on Approve
		driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]")).click();
		//Enter the Comments
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/form/div[2]/textarea")).sendKeys("Collateral Details are OK");
		//Click on Submit
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/h1")).isDisplayed();
		Thread.sleep(4000);
		
		//click on Cancel
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/span[2]")).click();
		Thread.sleep(5000);
}

	@Test(priority=4)
	public void CloseBrowser() {
		driver.close();
	}

}
