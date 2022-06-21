package medRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import medPages.CheckoutProduct;
import medPages.DefaultMedicarePage;
import medPages.OrderConfirmed;
import medPages.SearchProduct;
import medPages.SignUp;
import medPages.login;
import medPages.logoutPage;

@Listeners(reportGenerate.med_Listeners.class)
public class runnerUser {
	WebDriver driver;
	login loginAct;
	SignUp signAct;
	logoutPage logoutAct;
	DefaultMedicarePage homeAct;
	SearchProduct searchAct;
	CheckoutProduct checkoutAct;
	OrderConfirmed orderAct;

	@BeforeClass
	public void aLaunchMedicare() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\Medicare_automation_project\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/medicare");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	@Ignore
	public void bRegister() throws InterruptedException, IOException {
		signAct = new SignUp(driver);
		homeAct = new DefaultMedicarePage(driver);
		Thread.sleep(1500);
		signAct.signUpIcon();
		signAct.signUpFields("Jordan", "Liu", "J@mail.com", "Jordan", "12345", "12345");
		signAct.signUpFieldsPart2("Singapore 100", "Singapore 200", "Singapore", "111222", "Singapore", "Singapore");
		Thread.sleep(1000);
		signAct.detailsVerification();
		Thread.sleep(1000);
		signAct.billingVerification();
		Thread.sleep(1500);
		signAct.greenLoginButton();
	}

	@Test
	public void cLogIn() throws InterruptedException {
		loginAct = new login(driver);
		Thread.sleep(1500);
		loginAct.loginIconClick();
//		loginAct.inputEmailAndPassword("kn@gmail.com", "12345");
		loginAct.inputEmailAndPassword("J@mail.com", "12345");
		loginAct.loginButtonClick();
		System.out.println("User can log in!");
	}

	@Test
	public void dFilterProduct() throws InterruptedException {
		searchAct = new SearchProduct(driver);
		Thread.sleep(1500);
		searchAct.searchProd();
		Thread.sleep(1000);
		searchAct.filterProd("Ciprofloxacin");
		Thread.sleep(1000);
		searchAct.verifyProd("Ciprofloxacin");
	}

	@Test
	public void eCheckoutProduct() throws InterruptedException {
		checkoutAct = new CheckoutProduct(driver);
		Thread.sleep(1500);
		checkoutAct.quantityOfProd("1");
		Thread.sleep(1000);
		checkoutAct.finalConfirm("123456789000", "07", "2030", "123");
	}

	@Test
	public void fOrderConfirmed() throws InterruptedException {
		orderAct = new OrderConfirmed(driver);
		Thread.sleep(1500);
		orderAct.orderConfirmVerify();
	}

	@Test
	public void yLogout() throws InterruptedException {
		logoutAct = new logoutPage(driver);
		homeAct = new DefaultMedicarePage(driver);
		homeAct.medicareHome();
		Thread.sleep(1000);
		logoutAct.userNameClick();
		logoutAct.logoutButton();
		Thread.sleep(1000);
		homeAct.medicareHome();
	}

	@AfterClass
	public void zStopMedicare() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
