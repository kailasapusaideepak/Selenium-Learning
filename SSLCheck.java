

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Here i'm learning how to get rid of sslchecks (secure scoket layer) not secure to connect error on webpages by using ChromeOptions
// https://chromedriver.chromium.org/capabilities  :- refer this website for more options 
// How to use proxy

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// using Chromeoptions method 
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true); // This method will allow the driver to accept sslcheck
		
		// option.addExtensions(null); // this method is used to add extensions to chrome page
		// if website needs proxy 
		// Proxy proxy=new Proxy();
		// proxy.setHttpProxy("ipaddress:4444"); // Security team will provide that proxy this is just example
		// option.setCapability("proxy", false);
		
		
		WebDriver driver = new ChromeDriver(option); // To know the driver we need to pass that option as argument for the driver
		driver.get("https://expired.badssl.com");
		System.out.println(driver.getTitle());
		


	}

}
