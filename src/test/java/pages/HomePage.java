package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.PageDriver;
import utilities.CommonMethods;
import utilities.GetScreenShot;

public class HomePage extends CommonMethods{
	
	ExtentTest test;
	
	public HomePage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	//@FindBy  = driver.findelement(By.)
	@FindAll({
		@FindBy(xpath = "//a[contains(text(),'Sign in')]"),
		@FindBy(xpath = "//a[@title= 'Log in to your customer account']")
	})
	WebElement signIn;
	
	@FindAll({
		@FindBy(id = "email_create"),
		@FindBy(xpath = "//input[@name='email_create']")
	})
	WebElement emailAddress;
	
	@FindAll({
		@FindBy(id = "SubmitCreate"),
		@FindBy(xpath = "//button[@id='SubmitCreate']']")
	})
	WebElement accountButton;
	
	public void clickOnSignIn() throws IOException {
		test.info("Click on sign-in button");
		try {
			if (signIn.isDisplayed()) {
				signIn.click();   
				test.pass("<p style=\"color:DarkBlue; font-size:20px\"><b>Sign in button Clicked</b></p>");
			    timeOut();
			}
		} catch (Exception e) {
			test.fail("<p style=\"color:DarkBlue; font-size:20px\"><b>Sign in button Not Opened.</b></p>");
		    Throwable t = new InterruptedException("Exception");
		    test.fail(t);
		    @SuppressWarnings("unused")
		    String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "signInButton");
		    String dest = System.getProperty("user.dir") + "\\screnshots" + "signInButton.png";
		    test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		    Assert.assertTrue(signIn.isDisplayed());
		    PageDriver.getCurrentDriver().quit();
		}
		
	}
	
	public void sendEmail() throws IOException {
		test.info("Provide your email");
		try {
			String email = emailGenerate();
			if (emailAddress.isDisplayed()) {
				sendText(emailAddress, email);
				test.pass("<p style=\"color:green; font-size:20px\">Email Address Entered<b>");
			    timeOut(2000);
			}
			
		} catch (Exception e) {
			test.fail("<p style=\"color:red; font-size:20px\">Email Address not found<b>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "emailAddress");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "emailAddress.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(emailAddress.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
		
		timeOut(2000);
	}
	
	public void clickOnAccountButton() throws IOException {
		test.info("Click on Account Button");
		try {
			if (accountButton.isDisplayed()) {
				accountButton.click();
				test.pass("<p style=\"color:green; font-size:13px\"><b>Account Button Clicked.</b></p>");
				timeOut(8000);
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "accountButtonPass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "accountButtonPass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
			
		} catch (Exception e) {
			test.fail("<p style=\"color:red; font-size:13px\"><b>Account Button not locateable.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "accountButton");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "accountButton.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(accountButton.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}
	}	
}