package tests;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	public static void main(String[] args) {
		// Selenium jars - browser driver(System inform) - launch

		System.setProperty("webdriver.chrome.driver", ".//src//test//resources//chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//Chrome browser - 86 version , driver 86
		

	}

}
