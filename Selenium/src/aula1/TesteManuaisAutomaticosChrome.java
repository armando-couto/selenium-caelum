package aula1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteManuaisAutomaticosChrome {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/opt/google/chrome/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bing.com/");
		WebElement q = driver.findElement(By.name("q"));
		q.sendKeys("Caelum");
		q.submit();
	}
}