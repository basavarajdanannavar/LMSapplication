package AuditMaster;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScheduleRegularAudit {

	public static WebDriver  driver;

	@SuppressWarnings("deprecation")
	@Test(priority=0)
	public void Browser() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void Login()  throws InterruptedException {
	driver.get("https://ims-dev.technovative.in/#/auth/loginm");
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("[placeholder='Enter your username']")).sendKeys("test_appraiser");
		driver.findElement(By.cssSelector("[placeholder='Enter your password']")).sendKeys("P@ssw0rd");
		driver.findElement(By.cssSelector("[ng-click='auth.validate()']")).click();
		}

	@Test(dataProvider="Collateral",dataProviderClass = CollateralDataProvider.class,priority=2)
	public void SearchCollateral (String collateral) throws InterruptedException, AWTException {
		//click on the Search Collateral Link
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[2]")).click();
		//Search with Collateral No
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/div[1]/input")).sendKeys(collateral);
		Thread.sleep(2000);
		//Click on Search Button
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div")).click();
		//click on checkbox
		driver.findElement(By.cssSelector("[class='checkmark']")).click();

		//click on Schedule Audit
		driver.findElement(By.cssSelector("[ng-click='page.scheduleAppraisal()']")).click();
	}

	@Test(priority=3)
	public void AuditScheduleFormFillup() {
		//Enter the AuditType
		driver.findElement(By.cssSelector("[value='audit_regular']")).click();
		//Select the date
		driver.findElement(By.cssSelector("[ng-model='form.field.scheduledOn.value']")).sendKeys("08/024/2023");
		//click on Auditor 
		driver.findElement(By.cssSelector("[ng-click='auditor.open()']")).click();
		//click on search box
		driver.findElement(By.cssSelector("[placeholder='Search by name']")).sendKeys("test auditor");
		//Click on Test Auditor
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div[5]/div/ul/li[17]")).click();
		//click on Schedule button
		driver.findElement(By.cssSelector("[ng-click='form.request()']")).click();


		driver.findElement(By.xpath("//*[@id=\"body\"]/div[2]/div/div[1]/div/h1")).isDisplayed();

	}






}
