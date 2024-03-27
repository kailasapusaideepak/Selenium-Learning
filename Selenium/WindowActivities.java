import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		// To maximize the screen
		driver.manage().window().maximize();
		driver.get("https://google.com"); // The get method will wait till the page completely loads
		driver.navigate().to("https://rahulshettyacademy.com/"); // this method performs action very quickly doesnt wait
		// Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().forward();
		
		

	}

}
