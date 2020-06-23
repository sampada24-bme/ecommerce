package MobileTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logInInvalid {

	WebDriver driver;
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
	public void verifyAddTocart() {
		// click on account link & click on log in
		driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div/a/span[2]")).click();
		driver.findElement(By.xpath("//a[@title='Log In']")).click();

		// click on email
		driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("test123@gmail.com");
		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("sam1234");
		driver.findElement(By.xpath("//button[@name='send']")).click();
		
		for (String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

//		String actuale=driver.findElements(By.xpath("//li[@class='error-msg']/descendant::span")).getText();
//		Assert.assertEquals(actuale,"Invalid login or password.");
	}
}
