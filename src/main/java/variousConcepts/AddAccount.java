package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddAccount {
	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginAndAddInfo() {

		// login

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath(" //input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath(" //button[@name='login']")).click();

		// homepage and click new account

		driver.findElement(By.xpath("//span[contains(text(),'Bank & Cash')]")).click();
		driver.findElement(By.xpath(" //a[contains(text(),'New Account')]")).click();

		// fill in new account details
		driver.findElement(By.xpath(" //input[@id='account']")).sendKeys("APR2021211");
		driver.findElement(By.xpath(" //input[@id='description']")).sendKeys("New Account");
		driver.findElement(By.xpath(" //input[@id='balance']")).sendKeys("25000.00");
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("9876543210102589122");
		driver.findElement(By.xpath("//input[@id='contact_person']")).sendKeys("Dave White");
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("819-222-2222");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

	}

	@After
	public void tearDown() {

		driver.close();
		driver.quit();

	}

}
