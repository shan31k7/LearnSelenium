package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearnLocators {
	ChromeDriver driver;

	@BeforeMethod // prerequisite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test // testcase
	public void locator_ID() {
		WebElement textbox = driver.findElement(By.id("email"));
		textbox.sendKeys("My action is to type this");
	}

	@Test
	public void locator_name() {
		driver.findElementByName("username").clear();
		// driver.findElement(By.name("username")).clear();
		driver.findElementByName("usernamekjkjkj").sendKeys("Cognizant");
	}

	@Test
	public void locator_classname() {
		// one tag can be associated with multiple class names separated by space
		if (driver.findElement(By.className("small-12")).isEnabled() == true)
			System.out.println("div tag with class name as small-12 is present");
		else
			System.out.println("div tag with class name as small-12 is not present");
	}

	@Test
	public void locator_tagname() {
		// find all tags with tagname as script and print their attribute src
		System.out.println("Printing src of all scripts: ");
		List<WebElement> list_scripts = driver.findElementsByTagName("script");

		for (WebElement element : list_scripts) {
			System.out.println(element.getAttribute("type"));
		}
	}

	@Test
	public void locator_linktext() {
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.linkText("Go to Home Page")).click();
		// driver.findElementByLinkText("Go to Home Page").click();

		if (driver.getTitle().equalsIgnoreCase("TestLeaf - Selenium Playground"))
			System.out.println("Successfully moved to home page");
		else
			System.out.println("Not moved to home page");

	}

	@Test
	public void locator_partial_linktext() {
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.partialLinkText("Go to Home")).click();

		if (driver.getTitle().equalsIgnoreCase("TestLeaf - Selenium Playground"))
			System.out.println("Successfully moved to home page");
		else
			System.out.println("Not moved to home page");
	}

	@Test
	public void locator_css_selector() {
		// css selector is fast, efficient with IE browser
		driver.get("http://leafground.com/pages/Button.html");
		String style = driver.findElement(By.cssSelector("#color")).getAttribute("style");
		System.out.println("Style: " + style);
	}

	@Test
	public void locator_xpath() {
		// bidirectional
		// relative xpath
		driver.get("http://leafground.com/pages/Button.html");

		// count the number of buttons in this page
		int count = driver.findElements(By.xpath("//button")).size();

		System.out.println("Count of buttons: " + count);
		
		
		// Absolute xpath
		// first button click
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/section[1]/div[1]/div[1]/div[1]/button[1]")).click();
		
		
		// last button click
		//button[4]
		driver.findElement(By.xpath("//button[last()]")).click();

	}
}
