import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Scrollingwebpage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor)driver; // Here we are saying driver to use javascript
		
		// Here by this cmd we are scrolling the webpage :- we can also test it in the console tab of webpage by giving same cmd
		js.executeScript("window.scrollBy(0,500)\n");
		Thread.sleep(3000);
		
		// we are scrolling component here table on the webpage 
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000\n");
		
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for (int i=0;i<values.size();i++)
		{
			sum+=Integer.parseInt(values.get(i).getText());
		}
		
		System.out.println(sum);
		
		int givenTotal= Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(givenTotal, sum);
		
		
		// Assignment printing another table price sum now 
		
		List<WebElement> prices=driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		
		int sum2=0;
		for( int i=0;i< prices.size();i++)
		{
			sum2+=Integer.parseInt(prices.get(i).getText());
		}
		
		System.out.println(sum2);
		


	}

}
