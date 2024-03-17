import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// finding number of links in webpage
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// finding numnber of links in footer
		// This is concept of limiting webdriver scope
		
		WebElement footerlink= driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footerlink.findElements(By.tagName("a")).size());


	}

}
