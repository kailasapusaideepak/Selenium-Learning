import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ChildWindowHandels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.cssSelector(".blinkingText")).click();
		// Now a new tab will open but the driver is still in the parent window only 
		// First know how many windows are open 
		Set<String> windows=driver.getWindowHandles(); // [parentid] [childid]
		// now we need to access the parent and child id's for that we need iterator
		Iterator<String> it=windows.iterator();
		String parentId=it.next(); // the Controller will go to the parent id
		String childId=it.next();
		
		// Now we got the child window id and we need to given child window access to driver
		driver.switchTo().window(childId); // now the driver is the child id window
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		// Here we are parsing and triming the string 
		String emailId=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		// again we need to switch to the parent window
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
		
		
	}

}
