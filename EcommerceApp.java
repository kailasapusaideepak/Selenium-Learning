import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcommerceApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int count = 0;

		for (int i = 0; i < products.size(); i++) {

			// format it to get actuall veg name
			// Brocolli - 1kg
			// Brocolli , 1kg
			String[] name = products.get(i).getText().split("-");
			// now we need to remove the space as well
			String formattedName = name[0].trim();

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
