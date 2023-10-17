package AuditMaster;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class approveAudit {

	public static  WebDriver driver;

	@Test(priority=0)
	public void Browser() {
			
WebDriverManager.chromedriver().setup();
 driver =new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
					

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		}
@Test(priority=1)
public void Login() throws InterruptedException {
driver.get("https://ims-dev.technovative.in/#/auth/login");
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys("test_bm");
	driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[4]/input[1]")).sendKeys("P@ssw0rd");
	driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
	}

@Test(dataProvider="Collateral",dataProviderClass = CollateralDataProvider.class,priority=2)
public void ApproveAudit(String collateral) throws InterruptedException, AWTException {
	
	//Click on Collateral Additions
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div[3]/strong")).click();
	Thread.sleep(3000);
	//CLick on Audit tab
	driver.findElement(By.xpath("//li[contains(text(),'audits')]")).click();
	Thread.sleep(5000);


	
	
	
	//click on search Icon
	driver.findElement(By.cssSelector("[ng-click='searchFilter.open()']")).click();
	//pass the serach information
	driver.findElement(By.cssSelector("[placeholder='Search by collateral number']")).sendKeys(collateral);
	//click on Search 
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[2]/div/div")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"pageContainerInn\"]/div[2]/div/div[1]/div/div[3]/img")).click();
	Thread.sleep(3000);
/*	//click on view
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[4]/div/ul/li[1]/div/strong")).click();
	Thread.sleep(3000);
	//Click on Packets
	driver.findElement(By.cssSelector("[ng-click='packet.active = !packet.active']")).click();
	//click on Oranments
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[2]/div/div[3]/div/div/div[2]/div/table/tbody/tr/td[1]")).click();
	Thread.sleep(10000);
	//Click on Back
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[4]")).click();
	Thread.sleep(2000);
	//click Close icon
	driver.findElement(By.cssSelector("[alt='close icon']")).click();
	
	*/
	//Click on 3dot icon
	driver.findElement(By.xpath("//*[@id=\"pageContainerInn\"]/div[2]/div/div[1]/div/div[3]/img")).click();
	Thread.sleep(5000);
	//click on approave and Active
	Robot r=new Robot();
	r.mouseMove(50, 600);
	
	
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[4]/div/ul/li[2]/div/strong")).click();
	
	
	
	Thread.sleep(2000);
	//Click on submit
	driver.findElement(By.cssSelector("[ng-click='action.confirmReason.submit()']")).click();
	
	
	driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[1]/div[2]/ul/li[2]")).isDisplayed();
	
	
}






}
