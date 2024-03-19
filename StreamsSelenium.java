import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



// Here I'm collecting the list of webelements and storing the text of webelements 
// into list and now compare it with the sorted list
public class StreamsSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

//		click on the button
		driver.findElement(By.xpath("//tr/th[1]")).click();
//		collect all the webelements into list
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
//		convert the webelements into list by geeting text using stream
		List<String> actualElements = elements.stream().map(x -> x.getText()).collect(Collectors.toList());

//		sort the array list 
		List<String> SortedElements = actualElements.stream().sorted().collect(Collectors.toList());
//		compare the array list with original value 
		Assert.assertEquals(actualElements, SortedElements);

		// Getting the price of the rice
		// scan the element with gettext of Beans and then get the value of price
		// limitation it is searching only first page
		// so we need to concat the pages for searching the price of rice
		// Below step i have created own method getveggieprice(x) to get the price of
		// veggie
		List<String> price;
		do {

			List<WebElement> values = driver.findElements(By.xpath("//tr/td[1]"));

			price = values.stream().filter(x -> x.getText().contains("Rice")).map(x -> getveggieprice(x))
					.collect(Collectors.toList());
			price.forEach(x -> System.out.println(x));
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	private static String getveggieprice(WebElement x) {
		// TODO Auto-generated method stub
		String pricevalue = x.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
