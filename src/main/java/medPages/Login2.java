package medPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login2 {
	WebDriver driver;

	public Login2(WebDriver driver) {
		this.driver = driver;
	}

	public void loginIcon() {
		WebElement loginIcon = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
		if (!loginIcon.isDisplayed()) {
			System.out.println("No need to click");
		} else if (loginIcon.isDisplayed()) {
			loginIcon.click();
		}
	}

	public void inputEmailAndPassword(String InputEmail, String InputPassword) {
		WebElement emailField = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
		try {
			emailField.sendKeys(InputEmail);
			passwordField.sendKeys(InputPassword);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void loginButtonClick() {
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		loginButton.click();
	}
}
