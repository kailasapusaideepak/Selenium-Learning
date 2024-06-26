package Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		// To maximize the window
		driver.manage().window().maximize();

		// Creating Actions class
		Actions a = new Actions(driver);

		WebElement move = driver.findElement(By.cssSelector("a[href$='/account/login?ret=/']"));

		// moving mouse to the specific element (login tab)
		// Here the build function perfom the build of that function and 
		// perfrom function executes the function
		a.moveToElement(move).build().perform();
		

		// Entering the text in capital letters
		WebElement searchTab = driver.findElement(By.xpath("//input[@class='Pke_EE']"));

		// Here we are moving to the search box clicking on it and entering text hello
		// as captial letters
		a.moveToElement(searchTab).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		// Drag and Drop was done in frames class

	}

}