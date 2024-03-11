import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// working on from and  to tab
		// //a[@value="MAA"] --> Xpath for chennai
		// (//a[@value="BLR"])[2] Xpath for banglore here [2] is the index for banglore in To tab
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value=\"MAA\"]")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value=\"BLR\"])[2]")).click();
		// what if you dont want to use index
		// By using parent child relationship Xpath
		
		// //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value="BLR"] --> parent to child
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value=\"BLR\"]")).click();
		

	}

}
