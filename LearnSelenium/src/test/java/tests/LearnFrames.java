package tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearnFrames {
	ChromeDriver driver;

	@BeforeMethod // prerequisite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void handleFrame() {
		driver.get("http://leafground.com/pages/frame.html");

		// try to access button inside a frame directly
		// driver.findElement(By.id("Click")).click();

		driver.switchTo().frame(0); // moved focus into frame
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent(); // want the focus back to home page

	}

	@Test
	public void handleWindows() {
		driver.get("http://leafground.com/pages/Window.html");

		// store GUID or process id
		String currentWindow = driver.getWindowHandle();

		// opening mutiple windows
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button")).click();

		// store process id of 4 windows
		Set<String> windows = driver.getWindowHandles();
		int iteration = 1;

		for (String window : windows) {
			driver.switchTo().window(window);
			System.out.println(iteration + " " + driver.getTitle());
			iteration++;
		}

		driver.switchTo().window(currentWindow);
	}

	@Test
	public void handleAlert() throws InterruptedException {
		driver.get("http://leafground.com/pages/Alert.html");

		driver.findElementByXPath("//button[contains(text(),'Prompt Box')]").click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);

		System.out.println(alert.getText());
		Thread.sleep(2000);

		alert.sendKeys("you are awesome");
		Thread.sleep(2000);

		alert.accept();
		Thread.sleep(2000);

	}
}
