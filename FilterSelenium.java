import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


// Checking the search filter items displaying the text related to search text
public class FilterSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("ch");
		
		List<WebElement> veggie=driver.findElements(By.xpath("//tr/td[1]"));
		//veggie.stream().filter(x->x.getText()).forEach(x->System.out.println(x));
		// System.out.println(veggie.size());
		List<WebElement> sortedList=veggie.stream().filter(x->x.getText().contains("Ch")).collect(Collectors.toList());
		// System.out.println(sortedList.size());
		Assert.assertEquals(veggie.size(), sortedList.size());

	}

}
