import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//select passangers
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i=1;
		while(i<5) 
		{
			
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;

		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
	}

}
