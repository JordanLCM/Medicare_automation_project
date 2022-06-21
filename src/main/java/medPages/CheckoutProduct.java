package medPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutProduct {
	WebDriver driver;

	public CheckoutProduct(WebDriver driver) {
		this.driver = driver;
	}
	public void quantityOfProd(String Quantity) throws InterruptedException {
		WebElement quantityOfP = driver.findElement(By.tagName("input"));
		WebElement refreshP = driver.findElement(By.xpath("//button[@name='refreshCart']"));
		quantityOfP.clear();
		quantityOfP.sendKeys(Quantity);
		Thread.sleep(1000);
		refreshP.click();
		WebElement totalP = driver.findElement(By.xpath("//td[@class='hidden-xs text-center']"));
		System.out.println(totalP.getText());
		WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='btn btn-success btn-block']"));
		checkoutButton.click();
	}
	public void finalConfirm(String Bank, String Month, String Year, String CV) throws InterruptedException {
		WebElement selectAddress = driver.findElement(By.xpath("//a[normalize-space()='Select']"));
		selectAddress.click();
		WebElement bankCard = driver.findElement(By.xpath("//input[@placeholder='Valid Card Number']"));
		bankCard.sendKeys(Bank);
		WebElement monthP = driver.findElement(By.xpath("//input[@placeholder='MM']"));
		WebElement yearP = driver.findElement(By.xpath("//input[@placeholder='YY']"));
		WebElement cvP = driver.findElement(By.xpath("//input[@placeholder='CV']"));
		monthP.sendKeys(Month);
		yearP.sendKeys(Year);
		cvP.sendKeys(CV);
		WebElement payButton = driver.findElement(By.xpath("//a[@role='button']"));
		payButton.click();
	}
}