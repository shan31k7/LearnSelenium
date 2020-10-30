package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearnExplicitWait {
	ChromeDriver driver;

	@BeforeMethod // prerequisite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void explicitWait() {
		driver.get("https://erail.in/");

		// Date to tomorrow
		driver.findElement(By.className("icon-right-big")).click();

		// click on Gettrains
		driver.findElement(By.xpath("//input[@value='Get Trains']")).click();

		// wait for the last train
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("02494"))));

		driver.findElement(By.linkText("02494")).click();
		// Fluent wait - max duration, how many verify that conditional
		driver.quit();
	}

	@Test
	public void brokenLinks() throws InterruptedException {
		driver.get("http://leafground.com/pages/Link.html");

		// list down all the links in that page
		// click on each link and verify the page title
		// if page title contains number 404 - test is failed.

		int count_links = driver.findElements(By.tagName("a")).size();
		
		for(int i =1;i<=count_links;i++)
		{
			String dynamicxPath = "(//a)[" + i + "]";
			System.out.println("dynamic Path: " + dynamicxPath);
			driver.findElement(By.xpath(dynamicxPath)).click();
			Assert.assertEquals(driver.getTitle().contains("404"), false, "This is a broken link");
			driver.navigate().back();
		}
		
		/* throws staleElement exception
		 * for (WebElement link : links) { Thread.sleep(2000); link.click();
		 * Assert.assertEquals(driver.getTitle().contains("404"), false,
		 * "This is a broken link"); driver.navigate().back(); }
		 */
		
		driver.quit();
	}
}
