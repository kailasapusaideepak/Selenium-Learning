import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// section-2
		
		String name="KD";
		// WebDriver driver = new ChromeDriver();
		// Here using safari driver
		WebDriver driver = new SafariDriver();
		// implicit wait 5 seconds for synchronize issues
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String pwd=getpassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		
		driver.findElement(By.className("signInBtn")).click();
		
		// Here even though we used implicitly wait time if selenium webdriver finds that P tag name it will perfrom action so thats the reason 
		// we are using thread.sleep by forcing the webpage to load. Here the link is not changing when the action is performed
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		// Using assertion we need testng dependency
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		
		// If any element to identity based on text using Xpath
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
	}
	
	public static String getpassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String pwd=driver.findElement(By.cssSelector("form p")).getText();
		// Please use temporary password 'rahulshettyacademy' to Login.
		
		String[] pwdarray=pwd.split("'");
		// stores in arrays
		// 0th index Please use temporary password
		// 1st index rahulshettyacademy' to Login.
		String password=pwdarray[1].split("'")[0];
		// 0th index rahulshettyacademy
		// 1st index to Login.
		return password;
		
		
		
		
	}

}
