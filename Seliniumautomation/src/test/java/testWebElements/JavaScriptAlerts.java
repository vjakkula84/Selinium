package testWebElements;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlerts {

	@Test

	public void jsAlerts() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com");

		WebElement JsAlertsEle = driver.findElement(By.xpath("//a[text()='JavaScript Alerts']"));
		JsAlertsEle.click();

		WebElement JsAlertEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']")));
		JsAlertEle.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You successfully clicked an alert");
		System.out.println(message);

		driver.quit();

	}

	@Test

	public void JsConfirm() {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com");

		WebElement JsAlertsEle = driver.findElement(By.xpath("//a[text()='JavaScript Alerts']"));
		JsAlertsEle.click();

		WebElement JsConfirmEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Confirm']")));
		JsConfirmEle.click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();

		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "You clicked: Ok");
		System.out.println(message);

		driver.quit();

	}
@Test
	public void JsPrompt() {

		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com");
		
		WebElement JsAlertsEle = driver.findElement(By.xpath("//a[text()='JavaScript Alerts']"));
		JsAlertsEle.click();
		
		WebElement JsPromptEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']")));
		JsPromptEle.click();
		
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Abcd");
		
		String message = driver.findElement(By.xpath("//p[@id='result']")).getText();

		Assert.assertEquals(message, "Abcd");
		System.out.println(message);

		driver.quit();
		
		
		

	}

}
