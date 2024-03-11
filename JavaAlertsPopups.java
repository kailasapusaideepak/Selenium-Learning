import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAlertsPopups {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Here I'm learning how to resolve the alerts or pop-ups on the webpage

		String name = "KD";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();

		// letting the driver to know about alerts
		// Here I'm switching the browser to alert with switchto() and alert()

		// For getting the text of alert
		System.out.println(driver.switchTo().alert().getText());
		// functionn so now selenium knows that there is alert and it handels it with
		// accept method()
		driver.switchTo().alert().accept();

		// If the Pop-up has 2 options
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss(); // For No or cancel option
		// driver.switchTo().alert().accept();

	}

}
