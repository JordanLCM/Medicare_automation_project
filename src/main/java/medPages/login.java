package medPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login {
	WebDriver driver;

	public login(WebDriver driver) {
		this.driver = driver;
	}
	public void loginIconClick() {
		WebElement loginIcon = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
		loginIcon.click();
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