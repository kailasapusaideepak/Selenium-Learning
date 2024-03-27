import java.util.Set;




import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



//Here in this section particed 
//finding number of links in webpage
//finding numnber of links in footer
//Now i want links of footer section 1st column
//check weather all the links are working or not by grab the title

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// finding number of links in webpage
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// finding numnber of links in footer
		// This is concept of limiting webdriver scope
		
		WebElement footerlink= driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footerlink.findElements(By.tagName("a")).size());
		
		// Now i want links of footer section 1st column
		
		WebElement coloumnLink= driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumnLink.findElements(By.tagName("a")).size());
		
		// check weather all the links are working or not by grab the title
		
		for(int i=1;i< coloumnLink.findElements(By.tagName("a")).size();i++)
		{
			String clickOnLink= Keys.chord(Keys.COMMAND, Keys.ENTER); // clicking on cmd key and enter key
			coloumnLink.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			// WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
			
			
		}
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}


	}

}
