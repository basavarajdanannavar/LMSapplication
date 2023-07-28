package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateUser extends LoginwithValidCredential {
	
@Test(priority=0)
public void GotoUser() throws InterruptedException {
	Thread.sleep(4000);
	Actions action = new Actions(driver);

	WebElement Admin =driver.findElement(By.xpath("//*[@id=\"mat-tab-link-0\"]"));
	action.click(Admin).perform();

	driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-440\"]/div/button[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"mifosx-shell-container\"]/mat-sidenav-content/mifosx-content/mifosx-users/div[1]/div")).click();
	
	
	
	
	
}

}
