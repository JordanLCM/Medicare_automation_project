package medPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmed {
	WebDriver driver;

	public OrderConfirmed(WebDriver driver) {
		this.driver = driver;
	}
	public void orderConfirmVerify() throws InterruptedException {
		WebElement orderConfirmVerify = driver.findElement(By.xpath("//h3[normalize-space()='Your Order is Confirmed!!']"));
		WebElement billTo = driver.findElement(By.xpath("//div[@class='row']//div[2]//div[1]//address[1]"));
		WebElement shippedTo = driver.findElement(By.xpath("(//div)[12]"));
		System.out.println(orderConfirmVerify.getText());
		System.out.println("=============================================");
		System.out.println(billTo.getText());
		System.out.println("=============================================");
		System.out.println(shippedTo.getText());
		System.out.println("=============================================");
	}
}