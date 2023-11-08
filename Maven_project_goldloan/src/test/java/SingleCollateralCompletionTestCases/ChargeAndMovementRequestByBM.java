	
package SingleCollateralCompletionTestCases;

import java.awt.AWTException;
import java.awt.Robot;
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

public class ChargeAndMovementRequestByBM  {

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
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("[placeholder='Enter your username']")).sendKeys("test_bm");
		driver.findElement(By.cssSelector("[placeholder='Enter your password']")).sendKeys("P@ssw0rd");
		driver.findElement(By.cssSelector("[ng-click='auth.validate()']")).click();
		}
	
	@Test(priority=2)
	public void SearchCollateral () throws InterruptedException, AWTException {
		//click on the Search Collateral Link
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[2]")).click();
		Thread.sleep(300);
		try {
            // Read the text from a file
            String filePath = "C:\\Users\\Lenovo\\Downloads\\console_output.txt";
            String textFromFile = new String(Files.readAllBytes(Paths.get(filePath)));
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/input")).sendKeys(textFromFile);
			Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
		//Search with Collateral No
		
		Thread.sleep(200);
		//Click on Search Button
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div")).click();
Thread.sleep(1000);
		//Click on the Collateral No
		Thread.sleep(300);

	//	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/div/h3")).click();
		
		Thread.sleep(3000);
		
		//Click on 3dot Icon
	WebElement dotIcon=	driver.findElement(By.className("menuIcon"));
	dotIcon.click();
		//click on the Request Charge
		Thread.sleep(300);

		//click on the Request Charge
		driver.findElement(By.xpath("/html/body/div[4]/div/ul/li[2]/div/strong")).click();
		

		}
	@Test(priority=3)
	public void ChargeRequestFormFillup () throws AWTException, InterruptedException {
		
		Thread.sleep(3000);
		//click on the Lender
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/div/form/div[4]/select/option[3]")).click();
		Robot r = new Robot();
		
		
		//Click on State
		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div/form/select-location/div[1]/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/select-location/div[5]/div/ul/li[2]")).click();
		
		r.mouseWheel(2);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		r.mouseWheel(1);
		Thread.sleep(1000);
		
			//District
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/select-location/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/form/select-location/div[5]/div/div/input")).sendKeys("North Area");
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
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/div/form/select-location/div[5]/div/div/input")).sendKeys("HDFC-Dharwad");
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
		

}
	
	
	@Test(priority=4)
	public void CloseBrowser() {
		driver.close();
	}
}
