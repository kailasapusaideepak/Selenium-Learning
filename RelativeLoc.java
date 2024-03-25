import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*; // need to import this package manually

// In this class i'm using Relative locators 
// Purpose:- if you dont have any references to webelement we will use this
// most used  methods toLeftOf, toRightOf, above, below, near, withTagName, withText
// Syntax :- driver.findElement(with(tagname)).method(webelement)
// It doesn't work on flex tags
public class RelativeLoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameBox= driver.findElement(By.cssSelector("[name='name']"));
		
		// Here the name element has only tagname so with below text box reference we are getting text from that field.
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameBox)).getText());
		
		
		// example For below method
		WebElement dob= driver.findElement(By.xpath("//label[contains(text(),'Date of Birth')]"));
		// Here it goes to the submit tag because dob tag is flex and relative locators doesnt work on flex tags
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		// ex for toleft
		WebElement iceCream= driver.findElement(By.xpath("//label[contains(text(),'Check me out if you Love IceCreams!')]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCream)).click();
		
		
		// ex for toright
		WebElement rdb= driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		


	}

}
