package ClientCreation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UploadProfileImage extends LoginwithValidCredential{
	
	
	@Test(priority=01)
	public void GotoClientDetailsPage() throws InterruptedException, AWTException {
		Actions action = new Actions(driver);

		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath(
				"/html/body/mifosx-web-app/mifosx-shell/mat-sidenav-container/mat-sidenav-content/mifosx-content/mifosx-home/div[1]/div/button/span[1]"))
				.isDisplayed());

		WebElement Institution = driver.findElement(By.cssSelector("#mat-tab-link-0"));

		action.click(Institution).perform();
		Thread.sleep(1000);
		WebElement Clients = driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-1\"]/div/button[1]"));
		action.click(Clients).perform();
		
		//Enter values in search box
		driver.findElement(By.id("mat-input-4")).sendKeys("ba pa da");
		
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		
		driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-clients/mat-card/div[2]/table/tbody/tr")).click();
	
	}
	
	@Test(priority=02)
	public void UploadImage() throws AWTException, InterruptedException {
		
		
		driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-clients/mat-card/div[2]/table/tbody/tr/td[2]")).click();
		//click on Upload Image
		driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-clients-view/mat-card/mat-card-header/mat-card-title-group/div[2]/div[2]/button[1]")).click();
		Thread.sleep(300);
		
		Robot r= new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(500);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			
			
			
	}

}
