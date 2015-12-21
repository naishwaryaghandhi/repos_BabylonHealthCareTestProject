package test.babylon;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
public static WebDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "Appium"); 
		capabilities.setCapability("appium-version", "1.4.0"); 
		capabilities.setCapability("platformName", "Android"); 
		capabilities.setCapability("platformVersion", "4.4.4"); 
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("appPackage", "com.babylon"); 
		capabilities.setCapability("appActivity", "com.babylon.activity.RegistrationActivity");
		URL serveraddress = new URL("http://127.0.0.1:4723/wd/hub");  
		driver = new AndroidDriver<WebElement>(serveraddress, capabilities); // driver initialisation 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws Exception{
		RegisterAndLoginTest reg = new RegisterAndLoginTest(); 
		reg.register(); // register and signing into babylon app
		ItemCount item = new ItemCount();
		item.count(); // count the number of items in the settings menu
	}
	
	@AfterTest
	public void tearDown() throws Exception { 
		driver.quit();
	}
}
