import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;


// Here We are using TestNg framework for Assertions
public class Radiobuttons { // same with Checkboxes as well

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		/* // Selecting from and to destination
		driver.findElement(By.cssSelector("div[data-testid='to-testID-origin'] input[type='text']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'BLR')]")).click();
		// Here i Used parent child relationship
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(text(),'Chennai')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'MAA')]")).click();
		// Selecting current date
		// .css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu
		// driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu")).click();
		driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2 r-jwli3a r-ubezar r-16dba41') and contains(text(),'8')]")).click();
		*/
		
		
		// checking weather the Raido button is selected or not
		// Here i dont find any unique element in the web page
		// so i used text and and class name with Xpath to make it unique
		// and we can also use text but it only works with Xpath
		
		
		Assert.assertFalse(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isSelected());
		// System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Senior Citizen')] [@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa']")).isEnabled());
		driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();
		Thread.sleep(1000);
		// System.out.println(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isEnabled());
		
		// counting the number of checkboxes
		// System.out.println(driver.findElements(By.cssSelector("circle[fill='#FFF']")).size());
		// Assert.assertEquals(driver.findElements(By.cssSelector("circle[fill='#FFF']")).size(), "9");
		// When i wrote code like this got error AssertionError: expected [9] but found [9]
		// It's because data type mismatch 
		Assert.assertEquals(driver.findElements(By.cssSelector("circle[fill='#FFF']")).size(), new Integer(9));
		
		
		// driver.close();
		
		
		
		

	}

}
