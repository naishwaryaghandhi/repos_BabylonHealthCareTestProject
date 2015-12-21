package test.babylon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemCount extends BaseClass {
	
	public void count(){
		driver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'activity_home_page_settings')]")).click();
		List<WebElement> allItems = driver.findElements(By.className("android.widget.TextView"));
		System.out.println("Number of items in the list view is: "+allItems.size());
		for (int i=0; i<allItems.size();i++){
			System.out.println("Items are: "+allItems.get(i).getText());
		}
	}
}
