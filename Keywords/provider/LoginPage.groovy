package provider

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.appium.driver.AppiumDriverManager
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable
import memberSignUp.SignUp
import mobile.Generic

public class LoginPage {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();
	SignUp signup=new SignUp();

	@Keyword
	def tapOnSignUpLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/Login/signupLink_Ios'), defaultTime);
	}

	@Keyword
	def tapOnSignInLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/Login/signInLink_'+os), 10, FailureHandling.OPTIONAL);
	}

	@Keyword
	def typeInEmailTxtBx(email) {
		Mobile.setText(findTestObject('Object Repository/Provider/Login/emailTxtBx_'+os), email, defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def typeInPasswordTxtBx(password) {
		Mobile.setText(findTestObject('Object Repository/Provider/Login/passwordTxtBx_'+os), password, defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def tapOnLoginBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Login/loginBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyLoginBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Login/loginBtn_'+os), defaultTime);
	}

	@Keyword
	def providerLogin(email, pass) {
		verifyOTAPopupAndTapOnYesBtn()
		Mobile.delay(8)
		tapOnSignInLink();
		typeInEmailTxtBx(email)
		typeInPasswordTxtBx(pass)
		tapOnLoginBtn();
		signup.tapOnIAgreeBtn();
		Mobile.delay(2)
		tapOnAllowBtn();
		//Mobile.delay(2)
	}
	
	@Keyword
	def providerLaunchAndLogin(email, pass) {
		gen.launchProviderApp()
		providerLogin(email, pass)
	}
	
	@Keyword
	def tapOnAllowBtn() {
		Mobile.tap(findTestObject('Object Repository/allowPopUp_android'), 15, FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyErrorMsgForInvalidLogin() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Login/errorMsgForInvalidLogin_'+os), defaultTime)
	}

	@Keyword
	def clickOnForgotPasswordLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/Login/forgotPasswordLink_'+os), defaultTime);
	}
	@Keyword
	def isEmailTxtBxExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Login/emailTxtBx_'+os), defaultTime);
	}
	@Keyword
	def isPasswordTxtBxExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Login/passwordTxtBx_'+os), defaultTime);
	}
	@Keyword
	def isForgotPasswordLinkExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Login/forgotPasswordLink_'+os), defaultTime);
	}
	@Keyword
	def isLoginBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Login/loginBtn_'+os), defaultTime);
	}
	@Keyword
	def isSignupLinkExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Login/signupLink_'+os), defaultTime);
	}
	@Keyword
	def tapOnSignInBtn() {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Login/signInBtn_andriod'), defaultTime);
		}
		catch(Exception e) {
		}
	}

	@Keyword
	def verifyEmailFieldExists(defaultTime = 60) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Login/emailTxtBx_'+os), defaultTime, FailureHandling.OPTIONAL)) {
			return true
		}
		else {
			return false
		}
	}
	@Keyword
	def verifyOTAPopupAndTapOnYesBtn() {
		Mobile.delay(5)
		//Mobile.tap(findTestObject('Object Repository/Provider/Registration/yesBtnOTAPopup_android'), 30, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Provider/Login/appUpdateNoLaterBtn_'+os), defaultTime, FailureHandling.OPTIONAL)
		//		try{
		//			Mobile.tap(findTestObject('Object Repository/Provider/Registration/yesBtnOTAPopup_android'), 30, FailureHandling.OPTIONAL)
		//			Mobile.delay(5)
		//			//			if(verifyEmailFieldExists()==false) {
		//			//				AppiumDriverManager.getDriver().launchApp()
		//			//				Mobile.tap(findTestObject('Object Repository/Provider/Registration/noLaterOTAPopup_android'), 10, FailureHandling.OPTIONAL)
		//			//			}
		//		}
		//		catch(Exception e) {
		//			Mobile.comment("OTA Pop up not visible")
		//		}
	}
}
