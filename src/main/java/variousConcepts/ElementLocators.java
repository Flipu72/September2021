package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementLocators {
WebDriver driver;
	
	@Before
	public void launchBrowser() {
		//Create Object and Set Property
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//set URL
		driver.get("https://objectspy.space/");
		//maximize
		driver.manage().window().maximize();
		//delete cookies
		driver.manage().deleteAllCookies();
		//define wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void learnElememntLocators() throws InterruptedException {
		driver.findElement(By.name("firstname")).sendKeys("Selenium");
		
		//Upload File if you have INPUT Tag
		//other than Input Tag use Robot Class
//		driver.findElement(By.className("input-file")).sendKeys("C:\\Users\\Dell\\Desktop\\Techfios Class\\Selenium\\Selenium\\Session 2.pptx");
		//Link Text
//		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
//		//wait
//		Thread.sleep(6000);
//		//navigate back
//		driver.navigate().back();
//		//Partial Link Text
////		driver.findElement(By.partialLinkText("TF-API")).click();
//		driver.findElement(By.partialLinkText("Product")).click();
		
		//CSS selector
		//element identification							//operation
		driver.findElement(By.cssSelector("input#sex-0")).click();
		driver.findElement(By.cssSelector("input[value='3']")).click();
		driver.findElement(By.cssSelector("input[type='radio'][id='exp-3']")).click();
		
		//xPath
		//Absolute
//		driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input")).sendKeys("Selenium is fun!!");
		//Reletive
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Selenium is fun!!");
//		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Selenium is fun!!");
		
		
		driver.findElement(By.xpath("//input[@value='Selenium Webdriver' and @name='tool' and @id='tool-2'] ")).click();
		
//		driver.findElement(By.xpath("//strong[text()='Link Test : New Page']")).click();
		driver.findElement(By.xpath("//strong[contains(text(), 'Link Test : New Page')]")).click();
	}
	
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}