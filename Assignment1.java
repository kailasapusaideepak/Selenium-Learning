import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Here In this Assignment we need to enter all the details and select search flight button.
		// Here i didnt worked on current date and return date method 
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		
				
		// Selecting from and to destination
		driver.findElement(By.cssSelector("div[data-testid='to-testID-origin'] input[type='text']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'BLR')]")).click();
		// Here i Used parent child relationship
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//div[contains(@class, 'css-76zvg2 r-cqee49 r-ubezar r-1kfrs79') and contains(text(),'Chennai')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'MAA')]")).click();
		//Thread.sleep(1000);
		// Selecting current date
		// .css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu
		System.out.println(driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[1]/div/div[3]/div[3]/div[2]/div/div")).getText());
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[1]/div/div[3]/div[3]/div[2]/div/div")).click();
		// driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2 r-jwli3a r-ubezar r-16dba41') and contains(text(),'16')]")).click();
		// System.out.println(driver.findElement(By.xpath("//div[contains(@class,'css-76zvg2 r-jwli3a r-ubezar r-16dba41') and contains(text(),'16')]")).getText());
		// here i didnt find any unique element i will update it later
		
		
		// how to make sure something is enabled or not like here Return date
		// First finding the attribute which is changing when it is enabled and disabled here it is Style attribute
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Return Date')]")).getAttribute("Style"));
		// driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Return Date')]")).getAttribute("Style"));
						
				
		// Here We are checking that return date column is enabled after clicking round trip radio bitton
		if(driver.findElement(By.xpath("//div[contains(text(),'Return Date')]")).getAttribute("Style").contains("1"))
		{
			Assert.assertTrue(true);
			// System.out.println("Is Enabled");
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		 driver.findElement(By.xpath("//div[contains(text(),'Passengers')]")).click();
		 
		 for(int i=1;i<5;i++) 
		 {
		driver.findElement(By.xpath("//div[@data-testid=\"Adult-testID-plus-one-cta\"]")).click(); 
		 }
		driver.findElement(By.xpath("//div[@data-testid=\"home-page-travellers-done-cta\"]")).click();
		driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();
		driver.findElement(By.xpath("//div[@data-testid=\"one-way-radio-button\"]")).click();
		driver.findElement(By.xpath("//div[@data-testid=\"home-page-flight-cta\"]")).click();


	}

}
