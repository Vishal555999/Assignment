package Test_Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assignment {
	WebDriver driver;
	SoftAssert soft = new SoftAssert();

	@BeforeMethod
	public void Logintoapp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Eclipse_data\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.tendable.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void checkAccesibility() {
		driver.findElement(By.xpath("//a//img[@alt='Tendable Logo']")).isDisplayed();
		driver.findElement(By.xpath("//a[text()='Our Story']")).isDisplayed();
		driver.findElement(By.xpath("//a[text()='Our Solution']")).isDisplayed();
		driver.findElement(By.xpath("//a[text()='Why Tendable?']")).isDisplayed();

	}

	@Test
	public void checkRequestAdemobutton() throws InterruptedException {
		System.out.println("to check whether request a demo button is availalable on Home page");
		driver.findElement(By.xpath("//a//img[@alt='Tendable Logo']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Request a Demo'])[1]")).isDisplayed();
		driver.findElement(By.xpath("(//a[text()='Request a Demo'])[1]")).isEnabled();

		System.out.println(" to check whether request a demo button is availalable on Our story");
		driver.findElement(By.xpath("//a[text()='Our Story']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Request a Demo'])[2]")).isDisplayed();
		driver.findElement(By.xpath("(//a[text()='Request a Demo'])[2]")).isEnabled();

		System.out.println("to check whether request a demo button is availalable on Our solution");
		driver.findElement(By.xpath("//a[text()='Our Solution']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Request a Demo'])[2]")).isDisplayed();
		driver.findElement(By.xpath("(//a[text()='Request a Demo'])[2]")).isEnabled();

		System.out.println(" to check whether request a demo button is availalable on why tendale");
		driver.findElement(By.xpath("//a[text()='Why Tendable?']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Request a Demo'])[2]")).isDisplayed();
		driver.findElement(By.xpath("(//a[text()='Request a Demo'])[2]")).isEnabled();
	}

	@Test
	public void contactUs_Marketing() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Contact'])[1]")).click();

		driver.findElement(By.xpath("(//input[@id='form-input-fullName'])[1]")).sendKeys("Vishal Rameshwar Kathore");

		driver.findElement(By.xpath("(//input[@id='form-input-organisationName'])[1]")).sendKeys("SA Technologies");
		driver.findElement(By.xpath("(//input[@id='form-input-cellPhone'])[1]")).sendKeys("8432497158");
		driver.findElement(By.xpath("(//input[@id='form-input-email'])[1]")).sendKeys("vishal.kathore01@gmail.com");

		WebElement role = driver.findElement(By.xpath("(//select[@id='form-input-jobRole'])[1]"));
		Select s = new Select(role);
		s.selectByValue("Other");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[1]")));

		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Submit'])[1]")));
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(2000);

		String errorMsg = driver.findElement(By.xpath("//div[@class='ff-form-errors']//p")).getText();
		soft.assertEquals(errorMsg, "Sorry, there was an error submitting the form. Please try again.");

//		if (errorMsg.equalsIgnoreCase("Sorry, there was an error submitting the form. Please try again.")) {
//			System.out.println("Test case is failed");
//		} else {
//			System.out.println("Test case is passed");
//		}
	}

	@AfterMethod
	public void logout() {
		driver.quit();
	}

}
