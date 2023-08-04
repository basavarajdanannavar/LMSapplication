package ClientCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SearchClient extends LoginwithValidCredential{

	
	@Test(priority=2)
	public void Search() throws InterruptedException {
		Actions action = new Actions(driver);

		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath(
				"/html/body/mifosx-web-app/mifosx-shell/mat-sidenav-container/mat-sidenav-content/mifosx-content/mifosx-home/div[1]/div/button/span[1]"))
				.isDisplayed());

		WebElement Institution = driver.findElement(By.id("mat-tab-link-0"));

		action.click(Institution).perform();
		
		//Click on Client link
		driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-1\"]/div/button[1]")).click();
		
		
		
		
		
	}
}
