package MobileTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileList {
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

		// getting second page title
		driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']")).click();
		String title = driver.getTitle();
		System.out.println("Second title=> " + title);
		Assert.assertEquals(title, "Mobile");

		// Select dropdown and find Name
		Select dropdown = new Select(driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]")));
		dropdown.selectByVisibleText("Name");

		// this will take screenshot
		// scc=(scc+1);
		// File
		// scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// String png=("C:\\Guru99\\ecommerce Live project\\Day_01\\Mobile
		// product sorted"+scc+".png");
		// FileUtils.copyFile(scrFile,newFile(png));
		//
		//
		System.out.println("Mobile phones sorted by name");
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 0)
	public void costCompareTest() {
		driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']")).click();
		String MobilePageValue =driver.findElement(By.xpath("//span[contains(text(),'$100.00')]")).getText();
		

		driver.findElement(By.xpath("//h2[@class='product-name']//a[contains(text(),'Sony Xperia')]")).click();
		String SecondPageValue= driver.findElement(By.xpath("//span[contains(text(),'$100')]")).getText();

		Assert.assertEquals(MobilePageValue,SecondPageValue);
		System.out.println("Both page have same value");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
