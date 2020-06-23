package MobileTestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompareTwoProduct {

	/**
	 * Comparing two products
	 * 
	 * @author Sam
	 *
	 */
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

		/**
		 * Two products compare(Sony-xperia & I-phone)
		 * 
		 * @throws InterruptedException
		 */
		@Test(priority = 1)
		public void compareProduct() throws InterruptedException {
			// click on mobile menu
			driver.findElement(By.xpath("//a[@href='http://live.demoguru99.com/index.php/mobile.html']")).click();

			// Click on add to compare for sony xperia & get its name
			driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
			String mainMobile1 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
			System.out.println("Mobile 1=>" + mainMobile1);

			// Click on add to compare for Iphone & get its name
			driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
			String mainMobile2 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
			System.out.println("Mobile 2=>" + mainMobile2);

			// click on compare button
			driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]")).click();
			Thread.sleep(3000);

			// Switching to new window
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}

			String Header = ("COMPARE PRODUCTS");
			String popupTitle = driver.findElement(By.xpath("//h1[contains(text(),'Compare Products')]")).getText();
			System.out.println("POp-UP Title is " + popupTitle);

			// JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("window.scrollBy(0,400)");
			String popUpMobile1 = driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]")).getText();
			String popUpMobile2 = driver.findElement(By.xpath("//a[contains(text(),'IPhone')]")).getText();
			System.out.println("Mobile1=>" + popUpMobile1);
			System.out.println("Mobile2=>" + popUpMobile2);

			// to checking pop-up heading title Assertion:
			try {
				assertEquals(Header, popupTitle);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// to check 2 mobiles selected are same in popup & fornt page
			try {
				assertEquals(popUpMobile1, mainMobile1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// to check 2 mobiles selected are same in popup & fornt page
			try {
				assertEquals(popUpMobile2, mainMobile2);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// closing pop-up window
			driver.findElement(By.xpath("//span[contains(text(),'Close Window')]")).click();
			try {
				assertEquals(popUpMobile1, mainMobile1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// switching to new window
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
		}

	}

}
