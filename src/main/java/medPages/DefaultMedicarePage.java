package medPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultMedicarePage {
	WebDriver driver;

	public DefaultMedicarePage(WebDriver driver) {
		this.driver = driver;
	}

	public void medicareHome() {
		WebElement medicareHomeButton = driver.findElement(By.xpath("//a[@class='navbar-brand']"));
		medicareHomeButton.click();
	}

}