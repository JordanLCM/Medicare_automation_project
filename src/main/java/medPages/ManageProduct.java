package medPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ManageProduct {
	WebDriver driver;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
	}
	public void manageProd() {
		WebElement manageP = driver.findElement(By.xpath("//a[normalize-space()='Manage Product']"));
		manageP.click();
	}
	public void addProd(String Name, String Brand, String Description, String Price, String Quantity, String MedName)
			throws IOException {
		WebElement productN = driver.findElement(By.xpath("//input[@placeholder='Product Name']"));
		WebElement productB = driver.findElement(By.xpath("//input[@id='brand']"));
		WebElement productD = driver.findElement(By.xpath("//textarea[@placeholder='Enter your description here!']"));
		WebElement productP$ = driver.findElement(By.xpath("//input[@id='unitPrice']"));
		WebElement productQ = driver.findElement(By.xpath("//input[@id='quantity']"));
		WebElement productImg = driver.findElement(By.xpath("//input[@id='file']"));
		WebElement productCat = driver.findElement(By.xpath("//select[@id='categoryId']"));
		Select selection = new Select(productCat);
		productN.sendKeys(Name);
		productB.sendKeys(Brand);
		productD.sendKeys(Description);
		productP$.clear();
		productP$.sendKeys(Price);
		productQ.clear();
		productQ.sendKeys(Quantity);
//		productImg.click();
//		NOT SURE WHY BUT SELENIUM IS UNABLE TO CLICK ON "CHOOSE FILES" BUTTON
//		Runtime.getRuntime().exec("C:\\Test AutoIT\\Phase5_ImageUpload_Medicare.exe");
		selection.selectByVisibleText(MedName);
	}
	public void saveProd() {
		WebElement saveP = driver
				.findElement(By.xpath("//form[@action='/medicare/manage/product']//div//div//input[@name='submit']"));
		saveP.click();
	}
	public void deactivateProd() throws InterruptedException {
		WebElement paracetamolP = driver.findElement(By.xpath("//td[normalize-space()='Paracetamol']"));
		WebElement deactivateP = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/label[1]/div[1]"));
		if (paracetamolP.getText().equals("Paracetamol")) {
			if (deactivateP.isEnabled()) {
				deactivateP.click();
				WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
				Thread.sleep(1000);
				okButton.click();
				Thread.sleep(1000);
				WebElement okButton2 = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
				okButton2.click();
				Thread.sleep(2000);
			}
		} else if (!deactivateP.isEnabled()) {
			System.out.println("Product is already deactivated!");
		}
	}
	public void editProd(String Name) throws InterruptedException {
		WebElement CombiflameP = driver.findElement(By.xpath("//td[normalize-space()='Combiflame']"));
		WebElement editP = driver.findElement(By.xpath("(//a[@class='btn btn-primary'])[2]"));
		if (CombiflameP.getText().equals("Combiflame")) {
			editP.click();
		}
		WebElement BrandField = driver.findElement(By.xpath("//input[@id='brand']"));
		Thread.sleep(1000);
		BrandField.clear();
		BrandField.sendKeys(Name);
		WebElement saveP = driver
				.findElement(By.xpath("//form[@action='/medicare/manage/product']//div//div//input[@name='submit']"));
		saveP.click();
	}
}