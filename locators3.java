import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Parent to child 
		// Absolute Xpath:- //html/body/header/div/button[1]/following-sibling::button[1] { we need to start with / and travel from root to child
		// Relative Xpath:- //header/div/button[1]/following-sibling::button[1] { we need to start with // and start from any point (Good pratice)
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1] ")).getText());
		 
		// sibling - parent traverse child-parent --> 2 types we can write
		// 
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		driver.quit();

	}

}
