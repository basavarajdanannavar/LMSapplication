package ClientCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClientCreationwithfullData extends LoginwithValidCredential {
	
@Test(priority=0)
public void ClickOnCreateClient() throws InterruptedException {
	Actions action = new Actions(driver);
	
	Thread.sleep(2000);


	driver.findElement(By.id("mat-tab-link-3")).click();
	
	driver.findElement(By.cssSelector("[_ngcontent-rao-c260 mat-menu-item routerlink ='/clients']")).click();
}

}

