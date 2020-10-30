package tests;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchChrome_WebDriverManager {

	public static void main(String[] args) {
		// IE browser - single instance of browser
		//WebDriverManager.iedriver().setup();;
		//InternetExplorerDriver driver1 = new InternetExplorerDriver();
		//driver1.get("http://facebook.com");
		//driver1.close();

		// MicroEdge browser - single instance
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver2 = new EdgeDriver();
		driver2.get("http://facebook.com");
		driver2.quit();
	}

}
