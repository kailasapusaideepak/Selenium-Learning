import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class selintroduction implements WebDriver{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Invoking Browser
		// Chrome --Chrome Browser --> methods
		// Web driver is interface it has all methods
		
		// chromedriver.exe --> chrome browser
		// step to invoke chrome driver manually or u can use selenium manager
		
		// Here we are downloading the chromedriver.exe file in local to make the execution faster but we can use sel manager which does that job easily
		
		//System.setProperty("webdriver.chrome.driver", "/Users/saideepakkailasapu/Downloads/chromedriver-mac-arm64");
		
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.google.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
		

	}

}
