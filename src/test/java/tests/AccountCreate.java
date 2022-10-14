package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.CreateAnAccountPage;
import pages.HomePage;
import utilities.ExtentFactory;

public class AccountCreate extends BaseDriver{
	
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void startUrl() {
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Create An Account</b></p>")
					.assignAuthor("QA TEAM").assignDevice("Windows");
		PageDriver.getCurrentDriver().get(baseURL);
		PageDriver.getCurrentDriver().manage().window().maximize();
	}
	
	@Test(priority = 0)
	public void CLickonSIgnIn() throws IOException {
		childTest = parentTest
				.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click on Sign In</b></p>");
		HomePage homePage = new HomePage(childTest);
		homePage.clickOnSignIn();
	}
	
	@Test(priority = 1)
	public void emailProvide() throws IOException {
		childTest = parentTest
				.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Account Create Process</b></p>");
		HomePage homePage = new HomePage(childTest);
		homePage.sendEmail();
		homePage.clickOnAccountButton();
	}
	
	@AfterClass
	public void afterClass() {
		report.flush();
	}
	
}