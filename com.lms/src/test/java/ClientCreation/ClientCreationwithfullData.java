package ClientCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClientCreationwithfullData extends LoginwithValidCredential {
	
@Test(priority=0)
public void ClickOnCreateClient() throws InterruptedException {
	Actions action = new Actions(driver);
	
	Thread.sleep(5000);
	System.out.println(driver.findElement(By.xpath("/html/body/mifosx-web-app/mifosx-shell/mat-sidenav-container/mat-sidenav-content/mifosx-content/mifosx-home/div[1]/div/button/span[1]")).isDisplayed());

	WebElement Institution = driver.findElement(By.cssSelector("#mat-tab-link-0"));
	Institution.isDisplayed();
	System.out.println(Institution.isDisplayed());
	action.contextClick(Institution).perform();
	driver.findElement(By.cssSelector("[_ngcontent-rao-c260 mat-menu-item routerlink ='/clients']")).click();
}

}

