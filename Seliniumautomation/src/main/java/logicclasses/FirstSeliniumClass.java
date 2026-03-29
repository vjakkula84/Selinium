package logicclasses;

import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;
public class FirstSeliniumClass {

	public static void main(String[] args) throws InterruptedException {

		Faker faker = new Faker();

		// Open Browser
		WebDriver driver = new ChromeDriver();

		driver.get("https://with-bugs.practicesoftwaretesting.com/#/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		WebElement registerTextEle = driver.findElement(By.xpath("//a[text()='Register your account']"));
		registerTextEle.click();

		WebElement firstNameTextEle = driver.findElement(By.xpath("//input[@id='first_name']"));
		firstNameTextEle.sendKeys(faker.name().firstName());

		WebElement lastNameTextEle = driver.findElement(By.xpath("//input[@id='last_name']"));
		lastNameTextEle.sendKeys(faker.name().lastName());

		WebElement dobEle = driver.findElement(By.xpath("//input[@id='dob']"));
		dobEle.sendKeys(new SimpleDateFormat("yyyy-mm-dd").format(faker.date().birthday()));

		WebElement addressEle = driver.findElement(By.xpath("//input[@id='address']"));
		addressEle.sendKeys(faker.address().streetAddress());

		WebElement postcodeEle = driver.findElement(By.xpath("//input[@id='postcode']"));
		postcodeEle.sendKeys(faker.address().zipCode());

		WebElement cityEle = driver.findElement(By.xpath("//input[@id='city']"));
		cityEle.sendKeys(faker.address().city());

		WebElement stateEle = driver.findElement(By.xpath("//input[@id='state']"));
		stateEle.sendKeys(faker.address().state());

		WebElement phoneEle = driver.findElement(By.xpath("//input[@id='phone']"));
		phoneEle.sendKeys(faker.phoneNumber().cellPhone());

		WebElement emailEle = driver.findElement(By.xpath("//input[@id='email']"));
		emailEle.sendKeys(faker.internet().emailAddress());

		WebElement passwordEle = driver.findElement(By.xpath("//input[@id='password']"));
		passwordEle.sendKeys(faker.internet().password(6, 10, true, true, true));

		WebElement registerEle = driver.findElement(By.xpath("//button[@type='submit']"));
		registerEle.click();
		driver.quit();

	}
}
