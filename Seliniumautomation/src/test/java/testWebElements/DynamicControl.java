package testWebElements;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControl {

	@Test

	public void testDynamicControl() {

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement dynamicControls = driver.findElement(By.xpath("// a[text() = 'Dynamic Controls']"));
		dynamicControls.click();

		WebElement enableButtonEle = driver.findElement(By.xpath("//button[text()='Enable']"));
		enableButtonEle.click();

		wait.until(ExpectedConditions.textToBePresentInElement(enableButtonEle, "Disable"));

		WebElement disableButtoneEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Disable']")));
		
		String check = disableButtoneEle.getText();
		
		Assert.assertEquals(check, "Disable");
		
		WebElement messageEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='message']")));

		String message = messageEle.getText();

		Assert.assertEquals(message, "It's enabled!");
		
		System.out.println("Message is displayed");

		driver.quit();

	}

}
