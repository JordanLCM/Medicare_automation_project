package medRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import medPages.DefaultMedicarePage;
import medPages.ManageProduct;
import medPages.login;
import medPages.logoutPage;

@Listeners(reportGenerate.med_Listeners.class)
public class runnerAdmin {
	WebDriver driver;
	login loginAct;
	ManageProduct manageAct;
	logoutPage logoutAct;
	DefaultMedicarePage homeAct;

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
	public void bLogIn() throws InterruptedException {
		loginAct = new login(driver);
		Thread.sleep(1500);
		loginAct.loginIconClick();
		loginAct.inputEmailAndPassword("vk@gmail.com", "admin");
		loginAct.loginButtonClick();
	}

	@Test
	public void cManageProduct() throws InterruptedException, IOException {
		manageAct = new ManageProduct(driver);
		Thread.sleep(1500);
		manageAct.manageProd();
		manageAct.addProd("Med001", "Moderna", "Cure all!", "123", "10", "Antibiotics");
		Thread.sleep(1000);
		manageAct.saveProd();
		manageAct.deactivateProd();
		manageAct.editProd("GodMeds");
	}

	@Test
	public void fLogout() throws InterruptedException {
		logoutAct = new logoutPage(driver);
		homeAct = new DefaultMedicarePage(driver);
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
