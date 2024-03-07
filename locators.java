import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// section-1

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
		
		driver.findElement(By.className("signInBtn")).click();
		
		// implicit wait 5 seconds for synchronize issues
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// now we are using Css selectors
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		// using Xpath
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Deepak");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Kd@123@il.com");
		
		// when u cant find unique element  in xpath then we need to add indexing method 
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//when you cant find unique element in css use indexing
		 //  driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
		
		driver.findElement(By.cssSelector("input[placeholder$='Email']")).sendKeys("Kd@gmail.com");
		
		// writing Xpath with tags like traveling from parent to child
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("12345");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		// we are using Xpath travel from parent class to child class
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("inputUsername")).sendKeys("Kd");
		
		// By using Css expressions to find the element
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		
		// By using Xpath expressions to find the element
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
		
		
	
		
		
		

	}

}
