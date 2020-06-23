package MobileTestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {
	static WebDriver driver;
	String expected;
	String actual;
	String Base = ("http://live.demoguru99.com/");

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(Base);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test
	public static void addToCart() {
		// click on mobile
		driver.findElement(By.xpath("//a[@class='level0 '][text()='Mobile']")).click();
		
		// click on Add to cart for sony-xperia
		driver.findElement(
				By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button"))
				.click();

		// entering quantity 1000
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");

		// click on update button
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button/span/span")).click();

		// error msg verification
		String errorMsg = driver
				.findElement(By.xpath("//span[contains(text(),'Some of the products cannot be ordered in requeste')]"))
				.getText();
		Assert.assertEquals(errorMsg, "Some of the products cannot be ordered in requested quantity.");
		System.out.println("Product unable to add due to huge quantity ");

		// click on empty cart link
		driver.findElement(By.xpath("//*[@id='empty_cart_button']/span/span")).click();

		// verify cart is empty
		driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div/div/a/span[2]")).click();
		String msg = driver.findElement(By.xpath("//*[@id='header-cart']/div[3]/p[2]")).getText();
		Assert.assertEquals(msg, "You have no items in your shopping cart.");
		System.out.println("No item in  shopping cart");
	}

	@AfterMethod
	public static void closeBrowser() {
		driver.quit();

	}

}
