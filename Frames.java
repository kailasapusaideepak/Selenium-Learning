import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		// To know hpw many frames in webpage
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		WebElement frame= driver.findElement(By.cssSelector("iframe.demo-frame"));
		
		// Here we need to switch the driver to frames before we access elements in frame.
		// We can access in 3 ways by index, name or webelement , here i'm using webelement 
		driver.switchTo().frame(frame);
		
		// by accessing index
		// driver.switchTo().frame(0); // the page has only one frame so we are using index 0 to access to but it is not a good practice 
		driver.findElement(By.id("draggable")).click();
		Actions a =new Actions(driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		// To get back from the frame 
		driver.switchTo().defaultContent();
		


	}

}
