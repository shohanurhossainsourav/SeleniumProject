package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.PageDriver;
import utilities.CommonMethods;
import utilities.GetScreenShot;

public class CreateAnAccountPage extends CommonMethods{
    
	ExtentTest test;
	public CreateAnAccountPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	    this.test = test;
	}
	
	@FindBy(css = "label[for='id_gender1']")
	public WebElement mrTitle;

	@FindBy(css = "label[for='id_gender2']")
	public WebElement mrsTitle;

	@FindBy(id = "customer_firstname")
	public WebElement firstName;

	@FindBy(id = "customer_lastname")
	public WebElement lastName;
	
	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(id = "passwd")
	public WebElement passwordField;

	@FindBy(id = "days")
	public WebElement dayforDOB;

	@FindBy(id = "months")
	public WebElement monthforDOB;

	@FindBy(id = "years")
	public WebElement yearforDOB;

	@FindBy(id = "newsletter")
	public WebElement newsletter;

	@FindBy(id = "optin")
	public WebElement offer;

	@FindBy(id = "company")
	public WebElement companyNameField;

	@FindBy(id = "address1")
	public WebElement yourAddressOneField;

	@FindBy(id = "address2")
	public WebElement yourAddressTwoField;

	@FindBy(id = "city")
	public WebElement cityfield;

	@FindBy(id = "id_state")
	public WebElement stateSelect;

	@FindBy(id = "postcode")
	public WebElement postCode;

	@FindBy(id = "id_country")
	public WebElement countrySelect;

	@FindBy(id = "other")
	public WebElement otherInformationfield;

	@FindBy(id = "phone")
	public WebElement homePhonefield;

	@FindBy(id = "phone_mobile")
	public WebElement mobilePhoneField;

	@FindBy(id = "alias")
	public WebElement aliasfield;

	@FindBy(id = "submitAccount")
	public WebElement registerButton;
	
	@FindBy(xpath = "//h3[normalize-space()='Your personal information']")
	public WebElement pageSubHeading;
	
	public void fillPersonalInformation() throws IOException {
		try {
			test.info("Select Mr/Mrs");
			if (mrTitle.isDisplayed()) {
				mrTitle.click();
				test.pass("<p style=\"color:green; font-size:13px\"><b>Title Selected.</b></p>");
				timeOut(8000);
				@SuppressWarnings("unused")
				String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "mrTitlePass");
				String dest = System.getProperty("user.dir") + "\\screenshots\\" + "mrTitlePass.png";
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			}
			
		} catch (Exception e) {
			test.fail("<p style=\"color:red; font-size:13px\"><b>Title not locateable.</b></p>");
			Throwable t = new InterruptedException("Exception");
			test.fail(t);
			@SuppressWarnings("unused")
			String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "mrTitleFail");
			String dest = System.getProperty("user.dir") + "\\screenshots\\" + "mrTitleFail.png";
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
			Assert.assertTrue(mrTitle.isDisplayed());
			PageDriver.getCurrentDriver().quit();
		}

//		sendText(firstName, firstNameGenerate());
//		sendText(lastName, lastNameGenerate());
//		sendText(passwordField, "test123");
//		selectItemByIndex(dayforDOB, 3);
//		selectItemByIndex(monthforDOB, 5);
//		selectItemByIndex(yearforDOB, 6);
//		newsletter.click();
//		offer.click();
		timeOut();
	}
	
	public void yourAddress() {
		sendText(companyNameField, "companyName");
		sendText(yourAddressOneField, "addressone");
		sendText(yourAddressTwoField, "addresstwo");
		sendText(cityfield, "city");
		selectItemByIndex(stateSelect, 3);
		sendText(postCode, "19801");
		selectItemByIndex(countrySelect, 1);
		sendText(otherInformationfield, "Dhaka");
		sendText(homePhonefield, phoneNumberGenerate());
		sendText(mobilePhoneField, phoneNumberGenerate());
		sendText(aliasfield, "Address");
		registerButton.click();
		timeOut(10000);
	}
}
