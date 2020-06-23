package laptopTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaptopList {
	WebDriver driver;
	String expected;
	String actual;
	String Base = ("http://live.demoguru99.com/");
	public int scc = 0;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(Base);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	@Test(priority = 1)
	public void sortByName() {
		// getting Home page title
		String Title = driver.getTitle();
		System.out.println("Page Title=> " + Title);
		Assert.assertEquals(Title, "Home page");
	}

}
