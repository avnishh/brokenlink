package xe;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class hy {
	static Logger logger;
	
	public static void main(String[] args) {
	//	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();


		// Navigate to BStackDemo Website
		driver.get("https://www.enterslice.com");


		// Finding all the available links on webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());
		// Iterating each link and checking the response status
		for (WebElement link : links) {
		String url = link.getAttribute("href");
		verifyLink(url);
		}

		}


		public static void verifyLink(String url) {
		try {
		URL link = new URL(url);
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(8000); // Set connection timeout to 3 seconds
		httpURLConnection.connect();


		if (httpURLConnection.getResponseCode() == 200) {
		System.out.println(url + " - " + httpURLConnection.getResponseMessage());
		} else {
		System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
		}
		} catch (Exception e) {
		System.out.println(url + " - " + "is a broken link");
		}
		}
		}