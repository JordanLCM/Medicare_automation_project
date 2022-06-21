package medPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUp {
	WebDriver driver;

	public SignUp(WebDriver driver) {
		this.driver = driver;
	}

	public void signUpIcon() {
		WebElement signUpIcon = driver.findElement(By.xpath("//a[normalize-space()='Sign Up']"));
		signUpIcon.click();
	}

	public void signUpFields(String FirstName, String LastName, String Email, String Contact, String Password,
			String PasswordConfirm) {
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement contact = driver.findElement(By.xpath("//input[@id='contactNumber']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
		WebElement userCheck = driver.findElement(By.xpath("//input[@value='USER']"));
		WebElement nextBilling = driver.findElement(By.xpath("//button[@name='_eventId_billing']"));
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		email.sendKeys(Email);
		contact.sendKeys(Contact);
		password.sendKeys(Password);
		passwordConfirm.sendKeys(PasswordConfirm);
		if (!userCheck.isSelected()) {
			userCheck.click();
		} else {
			System.out.println("User option is already checked!");
		}
		nextBilling.click();
	}

	public void signUpFieldsPart2(String Address1, String Address2, String City, String Postal, String State,
			String Country) {
		WebElement address1 = driver.findElement(By.xpath("//input[@placeholder='Enter Address Line One']"));
		WebElement address2 = driver.findElement(By.xpath("//input[@placeholder='Enter Address Line Two']"));
		WebElement city = driver.findElement(By.xpath("//input[@placeholder='Enter City Name']"));
		WebElement postal = driver.findElement(By.xpath("//input[@placeholder='XXXXXX']"));
		WebElement state = driver.findElement(By.xpath("//input[@placeholder='Enter State Name']"));
		WebElement country = driver.findElement(By.xpath("//input[@placeholder='Enter Country Name']"));
		WebElement nextConfirm = driver.findElement(By.xpath("//button[@name='_eventId_confirm']"));
		address1.sendKeys(Address1);
		address2.sendKeys(Address2);
		city.sendKeys(City);
		postal.sendKeys(Postal);
		state.sendKeys(State);
		country.sendKeys(Country);
		nextConfirm.click();
	}

	public void detailsVerification() {
		WebElement personalDetail = driver.findElement(By.xpath("//h4[normalize-space()='Personal Details']"));
		WebElement pName = driver.findElement(By.tagName("h3"));
		WebElement personalList = driver.findElement(By.xpath("(//div)[12]"));
		if (personalDetail.getText().equals("Personal Details")) {
			System.out.println(pName.getText());
			List<WebElement> Rows = personalList.findElements(By.tagName("h4"));
			for (WebElement RowElement : Rows) {
				System.out.println("------------------------------");
				System.out.println(RowElement.getText());
			}
		}
	}

	public void billingVerification() {
		WebElement billingDetail = driver.findElement(By.xpath("//h4[normalize-space()='Billing Address']"));
		WebElement pName = driver.findElement(By.tagName("h3"));
		WebElement billingList = driver.findElement(By.xpath("(//div)[17]"));
		WebElement confirmButton = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-primary']"));
		if (billingDetail.getText().equals("Billing Address")) {
			System.out.println(pName.getText());
			List<WebElement> Rows = billingList.findElements(By.tagName("p"));
			for (WebElement RowElement : Rows) {
				System.out.println("------------------------------");
				System.out.println(RowElement.getText());
			}
		}
		confirmButton.click();
	}

	public void greenLoginButton() {
		WebElement loginBTN = driver.findElement(By.xpath("//a[@class='btn btn-lg btn-success']"));
		loginBTN.click();
	}
}
