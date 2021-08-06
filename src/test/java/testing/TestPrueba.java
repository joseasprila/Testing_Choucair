package testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class TestPrueba {
	
	WebDriver driver;
	By searchBoxLocator = By.id("search_top");
	By resultsLocator = By.cssSelector("span.heading-counter");
	
	
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		 driver = new ChromeDriver ();
		 driver.manage().window().maximize();
		 driver.get("http://automationpractice.com");
	}
	
	@Test
	public void  search_blouses() {
		
		WebElement searchbox = driver.findElement(searchBoxLocator);
		searchbox.clear();
		searchbox.sendKeys("blouse");
		searchbox.submit();
		
		WebDriverWait wait = new WebDriverWai(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(resultsLocator));
		
		System.out.print("Este es el resultado nomber:" + findElement(resultsLocator).getText());
		
		assertTrue(driver.findElement(resultsLocator).isDisplayed(), "No se encuentran resultado")
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
	
//	@BeforeSuite
//	public void beforeSuite() {
//	}
//	
//	@BeforeTest
//	public void beforeTest() {
//	}
	

//	
//	@BeforeMethod
//	public void beforeMethod() {
//	}
	
	
	
	
//	@AfterMethod
//	public void afterMethod() {
//	}
//joseasprilla
	
	
//
//	@AfterTest
//	public void afterTest() {
//	}
//
//	@AfterSuite
//	public void afterSuite() {
//	}

}
