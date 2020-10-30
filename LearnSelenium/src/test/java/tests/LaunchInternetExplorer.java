package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchInternetExplorer {

	public static void main(String[] args) {
		// Selenium jars - browser driver(System inform) - launch

		System.setProperty("webdriver.ie.driver", ".//src//test//resources//IEDriverServer.exe");
		//ChromeDriver driver = new ChromeDriver();
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("https://www.facebook.com/");
		

	}

}
