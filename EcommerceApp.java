import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Here I learned how to add items to the cart dynamically and apply promo code at checkout 
// and also how to use implicit and explicit waits and there advantages and dis-avantages
// Fluent wait it finds the web element repeatedly at the regural intervals of time until timeout or the object got found.



public class EcommerceApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		// Here the implicit wait time applies to all the attributes (global level)
		// disadvantage is We cannot find the performance issues in implicit wait
		
		// explicit wait :- It applies only to the specific attribute where the problem occurs
		// Dis-advantages :- More code
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		addItems(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		// using Explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		// using Explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		

		

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int count = 0;

		for (int i = 0; i < products.size(); i++) {

			// format it to get actuall veg name
			// Brocolli - 1kg

			String[] name = products.get(i).getText().split("-");
			// Brocolli , 1kg This is after split
			// now we need to remove the space as well
			String formattedName = name[0].trim(); //by trim method space will be removed in text brocolli

			// Convert array into arraylist for easy search
			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				count++;
				if (count == itemsNeededList.size())
					break;

			}
		}
	}

}
