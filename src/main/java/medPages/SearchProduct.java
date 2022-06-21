package medPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProduct {
	WebDriver driver;

	public SearchProduct(WebDriver driver) {
		this.driver = driver;
	}
	public void searchProd() {
		WebElement searchP = driver.findElement(By.xpath("//a[normalize-space()='View Products']"));
		searchP.click();
	}
	public void filterProd(String Search) {
		WebElement filterP = driver.findElement(By.id("a_Antibiotics"));
		filterP.click();
		WebElement searchBar = driver.findElement(By.xpath("//input[@type='search']"));
		searchBar.sendKeys(Search);
		WebElement CiprofloxacinP = driver.findElement(By.xpath("//td[normalize-space()='Ciprofloxacin']"));
		if (CiprofloxacinP.getText().equals(Search)) {
			WebElement viewP = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
			viewP.click();
		}
	}
	public void verifyProd(String Verify) {
		WebElement productName = driver.findElement(By.xpath("//h3[normalize-space()='Ciprofloxacin']"));
		WebElement descriptionP = driver.findElement(By.xpath("//p[contains(text(),'A commonly used antibiotic for bacterial infection')]"));
		WebElement priceP = driver.findElement(By.xpath("//h4[1]"));
		WebElement quantityP = driver.findElement(By.tagName("h6"));
		WebElement addToCart = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
		if (productName.getText().equals(Verify)) {
			System.out.println(descriptionP.getText());
			System.out.println(priceP.getText());
			System.out.println(quantityP.getText());
			addToCart.click();
		}
	}
}