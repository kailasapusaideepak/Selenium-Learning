import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

// Brokenlinks:- like error 404 not found

// softassertion
// how to access url connection
// what are requestmethods GET, POST, HEAD, PUT, DELETE

//GET: This method is used to request data from a specified resource. It retrieves data from the server without causing any side effects.
//
//POST: This method is used to submit data to be processed to a specified resource. It often results in a change in server state or the creation of a new resource.
//
//HEAD: This method is similar to GET, but it requests the headers of the resource without actually fetching the resource's body. It's useful for retrieving metadata about a resource without transferring the entire content.
//
//PUT: This method is used to upload a representation of a resource to the server. It replaces the current representation of the target resource with the uploaded content.
//
//DELETE: This method is used to request the removal of a specified resource.

public class Brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// we need to find the link is working or not using java
		// Here in network tab at status code we can find the link is working or not if the status code >400 then it is not working
		// step-1 get all the urls tied up to the links using selenium
		// step-2 java methods will call those urls and get the status code
		// step-3 if the status code >400 then the url is not working or broken link
		List<WebElement> links= driver.findElements(By.cssSelector(".gf-li a"));
		SoftAssert a=new SoftAssert(); // Deceleration of soft assertion
		for(WebElement link:links)
		{
		String url=link.getAttribute("href");
		HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);
		a.assertTrue(respCode<400, "The link with text "+link.getText()+" is broken with code "+respCode); // it will store all the links which broke the condition
		
		/*if(respCode>400)
		{
			System.out.println("The link with tetx"+link.getText()+"is broken with code "+respCode);
			Assert.assertTrue(false);	
			
			// Here in this assertion after the it founds false it will stop there it will not continue so we need to use softassertion
			
		} */
		
		}
		
		a.assertAll(); // This method will print all the catched results
		
		

	}

}
