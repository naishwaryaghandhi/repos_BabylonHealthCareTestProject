package test.babylon;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterAndLoginTest extends BaseClass {

	public void register() throws Exception {
		driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
		driver.findElement(By.id("emailEdt")).sendKeys("testuser@gmail.com");
		driver.findElement(By.xpath("//android.widget.EditText[@index='1']")).sendKeys("Testerpwd123");
		driver.findElement(By.id("nameEdt")).sendKeys("Test");
		driver.findElement(By.id("lastNameEdt")).sendKeys("User");
		driver.findElement(By.id("dateofBirthEdt")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> date = driver.findElements(By.className("android.widget.NumberPicker"));
		date.get(0).sendKeys("12");
		date.get(1).sendKeys("Apr");
		date.get(2).sendKeys("1980");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.id("button1")).click();
		driver.findElement(By.id("create_account_terms_and_conditions_check_box")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'createAccountBtn')]")).click();
		System.out.println("Registered successfully");
	}
}