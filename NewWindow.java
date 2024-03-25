

// Task invoking multiple windows
//scenario
//navigate to https://rahulshettyacademy.com/angularpractice/
//find the "name" field with the first course name available at https://rahulshettyacademy.com/
// captuirng ss of particular webelement
// Get Height and width of webelement

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		 // Telling driver to open new tab
		driver.switchTo().newWindow(WindowType.TAB);
		// now we need to get the id of new tab and switch driver to that new tab
		 Set<String> windows=driver.getWindowHandles();
		 Iterator<String>it =windows.iterator();
		 String parent=it.next();
		 String child=it.next();
		 driver.switchTo().window(child);
		 driver.get("https://rahulshettyacademy.com/");
		 String courseName=driver.findElements(By.cssSelector("[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		 driver.switchTo().window(parent);
		 WebElement name=driver.findElement(By.cssSelector("[name='name']"));
		 name.sendKeys(courseName);
		 // Taking screenshot
		File fs= name.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(fs, new File("test.png"));
		 
		 // getting height and width of webelement
		System.out.println( name.getRect().getDimension().getHeight());
		System.out.println( name.getRect().getDimension().getWidth());
		 
		 
		 
		 // driver.quit();
		

	}

}
