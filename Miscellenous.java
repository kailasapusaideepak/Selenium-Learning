import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;


// here i have praticed how to maximize the window 
// how to delete and add the cookies to the webpage
// how to take screenshot of webpage

public class Miscellenous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // used to maximize the window
		driver.manage().deleteAllCookies(); //this cmd will delete all the cookies
		// driver.manage().deleteCookieNamed(null); // will delete only a particular cookie
		// driver.manage().addCookie(null); // will add the cookie
		
		driver.get("https:google.com");
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Here we are telling the driver to take screenshot and save it as file
		FileUtils.copyFile(src, new File("/Users/saideepakkailasapu\\ScreenShot.jpg")); // saving the ss as file in the specified path
		

		


	}

}
