package member

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

import api.Member
import mobile.Generic
import mobile.MobileActions
import provider.LoginPage

import internal.GlobalVariable

public class Login {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();
	LoginPage log = new LoginPage();
	MobileActions ma = new MobileActions();
	Member memApi = new Member()

	@Keyword
	def launchMemberAppAndroid(boolean deleteAfterDone = true) {
		gen.launchMemberApp(deleteAfterDone);
	}

	@Keyword
	def typeInEmailTxtBx(email) {
		Mobile.setText(findTestObject('Object Repository/Member/Login/emailTxtBox_'+os), email, defaultTime);
		Mobile.hideKeyboard()
	}

	@Keyword
	def typeInPasswordTxtBx(pass) {
		Mobile.setText(findTestObject('Object Repository/Member/Login/passwordTxtBox_'+os), pass, defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def verifyErrorMsgForInvalidLogin() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/errorMsgForInvalidLogin_'+os), defaultTime)
	}

	@Keyword
	def verifyRequiredMsgForInvalidLogin() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/requiredTxt_android', ['i': "1"]), defaultTime)
	}

	@Keyword
	def clickOnForgotPasswordLink() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/forgotPasswordLink_'+os), defaultTime);
	}

	@Keyword
	def verifyForgotPasswordLinkPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/forgotPasswordLink_'+os), defaultTime);
	}

	@Keyword
	def verifyEmailTxtBxPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/emailTxtBox_'+os), defaultTime);
	}

	@Keyword
	def verifyPasswordTxtBxPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/passwordTxtBox_'+os), defaultTime);
	}
	@Keyword
	def tapOnSignInBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/signInBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnAllowBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = 10) {
		if(Mobile.waitForElementPresent(findTestObject('Object Repository/allowPopUp_android'), defaultTime, onFailure)) {
			Mobile.tap(findTestObject('Object Repository/allowPopUp_android'), defaultTime, onFailure);
		}
	}

	@Keyword
	def verifySignInBtnElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/signInBtn_'+os), defaultTime);
	}

	@Keyword
	def verifySearchField() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBar_android'), defaultTime,FailureHandling.CONTINUE_ON_FAILURE );
	}

	@Keyword
	def closeTheApp() {
		gen.closeTheApp();
	}

	@Keyword
	def tapOnOkayInAppUpdatePopup() {
		Mobile.tap(findTestObject('Object Repository/Provider/Login/appUpdateOkayBtn_'+os), 15, FailureHandling.OPTIONAL);
	}


	@Keyword
	def tapOnProgramPopUpCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/programPopUpCloseBtn_'+os), 15, FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnButtonsheetClose() {
		Mobile.tap(findTestObject('Member/Member360/SearchFunctionality/bottomSheetClose_android'), 15, FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnSignInLink(text = "Come on in!",defaultTime = 10) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/verifyText_android',['text':text]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Login/signInLink_'+os), defaultTime, FailureHandling.OPTIONAL);
		}
	}

	@Keyword
	def memberLogin(mobileNumber, pass = GlobalVariable.MemberOTP, closeThePopup = true) {
		verifyOTAPopupAndTapOnYesBtn()
		//tapOnOkayInAppUpdatePopup()
		typeMobileNumber(mobileNumber)
		tapOnContinueBtn()
		Mobile.delay(5);
		typeOtpPassCode(pass);
		tapOnContinueBtn()
		Mobile.delay(20)
		tapOnProgramPopUpCloseBtn()
		tapOnButtonsheetClose()
		//handleMaximumAttemptsError(pass)
		//verifyAndFillStateEmailFields(zipCode, email, state)
		//tapOnAllowBtn();
		if(closeThePopup) {
			def memRes = memApi.getMemberDetails(mobileNumber, pass)
			return memRes
		}
	}

	@Keyword
	def newMemberLogin(mobileNumber, pass = GlobalVariable.MemberOTP, closeThePopup = true, zipCode = '48867',  email = gen.generateRandomEmail(), state = 'MI') {
		verifyOTAPopupAndTapOnYesBtn()
		//tapOnOkayInAppUpdatePopup()
		typeMobileNumber(mobileNumber)
		tapOnContinueBtn()
		Mobile.delay(5);
		typeOtpPassCode(pass);
		tapOnContinueBtn()
		//handleMaximumAttemptsError(pass)
		verifyAndFillStateEmailFields(zipCode, email, state)
		tapOnAllowBtn();
		Mobile.delay(10)
		tapOnProgramPopUpCloseBtn()
		tapOnButtonsheetClose()
		if(closeThePopup) {
			def memRes = memApi.getMemberDetails(mobileNumber, pass)
			return memRes
		}
	}

	@Keyword
	def existedMemberLogin(mobileNumber, passcode = GlobalVariable.MemberOTP, isAllowPopPresent = false) {
		verifyOTAPopupAndTapOnYesBtn()
		//tapOnOkayInAppUpdatePopup()
		typeMobileNumber(mobileNumber)
		tapOnContinueBtn()
		Mobile.delay(5);
		typeOtpPassCode(passcode);
		tapOnContinueBtn()
		if(isAllowPopPresent) {
			tapOnAllowBtn();
		}
		tapOnButtonsheetClose()
	}

	@Keyword
	def typeMobileNumber(mobileNumber) {
		Mobile.setText(findTestObject('Object Repository/Member/Login/mobileNumber_android'), mobileNumber, 120)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	@Keyword
	def verifyMobileNumberFieldExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/mobileNumber_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/continueBtn_android'), defaultTime);
	}

	@Keyword
	def typeOtpPassCode(otp) {
		Mobile.clearText(findTestObject('Object Repository/Member/Login/otpPassCode_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/Login/otpPassCode_android'), otp, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnStartBrowsingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/startBrowsingBtn_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyStartBrowsingBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/startBrowsingBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSettingsIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/accountIcon_'+os), defaultTime);
	}

	@Keyword
	def tapOnLogoutBtn() {
		Mobile.scrollToText("Log Out", FailureHandling.OPTIONAL);
		Mobile.delay(5);
		Mobile.tap(findTestObject('Object Repository/Member/Settings/logoutBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyOTAPopupAndTapOnYesBtn() {
		Mobile.delay(5)
		try{
			Mobile.tap(findTestObject('Object Repository/Provider/Registration/yesBtnOTAPopup_android'), 10, FailureHandling.OPTIONAL)
			if(verifyMobileNumberFieldExist(FailureHandling.OPTIONAL, 8)==false) {
				AppiumDriverManager.getDriver().launchApp()
				Mobile.tap(findTestObject('Object Repository/Provider/Registration/noLaterOTAPopup_android'), 10, FailureHandling.OPTIONAL)
			}
		}
		catch(Exception e) {
			Mobile.comment("OTA Pop up not visible")
		}
	}
	@Keyword
	def verifyOtpPassCodePresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/otpPassCode_'+os), defaultTime);
	}
	@Keyword
	def verifyRevDocIconPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/revdocIcon_'+os), defaultTime);
	}

	@Keyword
	def tapOnSelectState() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/selectState_'+os), defaultTime);
	}

	@Keyword
	def verifySelectStateField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/selectState_'+os), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def typeInZipCode(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Login/zipcode_android'), text, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def typeInSearchState(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Login/searchState_'+os), text, defaultTime);
	}

	@Keyword
	def verifyResidentStateFieldExists(isExist = true) {
		if(isExist == true) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/residentState_'+os),defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Login/residentState_'+os),defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
		}
	}

	@Keyword
	def getTextOfResidentStateField() {
		return Mobile.getText(findTestObject('Object Repository/Member/Login/residentState_'+os),defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifySearchStateField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/searchState_'+os),defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnSelectSearchedState(state) {
		Mobile.tap(findTestObject('Object Repository/Member/Login/selectSearchedState_'+os,['state':state]), defaultTime);
	}

	@Keyword
	def verifySelectSearchedState(state) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/selectSearchedState_'+os,['state':state]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def typeInEmailInput(email = gen.generateRandomEmail(), index = 1) {
		Mobile.setText(findTestObject('Object Repository/Member/Login/emailInput_'+os,['index':index]), email, defaultTime);
	}

	@Keyword
	def typeInEmailInputInPopUp(index = 2, email = gen.generateRandomEmail()) {
		Mobile.setText(findTestObject('Object Repository/Member/Login/emailInput_'+os,['index':index]), email, defaultTime);
	}

	@Keyword
	def verifyEmailInput(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/emailInput_'+os,['index':index]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyAndFillStateEmailFields(zipCode = '48867', email = gen.generateRandomEmail(), state = 'MI') {
		def text = "Help Us Match You With Local Doctors"
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/verifyText_android',['text':text]), defaultTime, FailureHandling.OPTIONAL)) {
			typeInZipCode(zipCode)
			verifyResidentStateFieldExists()
			typeInEmailInput(email);
			tapOnStartBrowsingBtn();
		}
	}

	@Keyword
	def verifyExploreLinkExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/exploreLink_android'), defaultTime);
	}

	@Keyword
	def tapOnExploreLink() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/exploreLink_android'), defaultTime);
	}

	@Keyword
	def tapOnClosePopupRevPlusRevPrivate(onFailure =FailureHandling.OPTIONAL, defaultTime = 10) {
		Mobile.tap(findTestObject('Object Repository/Member/Login/popupCloseBtnRevPlusRevPrivate_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnHomeIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/homeIcon_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyBuyBtnExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/buyNowBtn_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyBuyBtnPriceExists(price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/buyNowBtnPrice_android', ['price': price]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnBuyNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/buyNowBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/cancelBtn_android'), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyMaximumAttemptsError() {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': "You have reach the maximum number of attempts."]), 5, FailureHandling.OPTIONAL)
	}

	@Keyword
	def handleMaximumAttemptsError(pass = GlobalVariable.MemberOTP) {
		if(verifyMaximumAttemptsError()) {
			tapOnCancelBtn();
			tapOnContinueBtn()
			typeOtpPassCode(pass);
			Mobile.hideKeyboard(FailureHandling.OPTIONAL);
			tapOnContinueBtn()
		}
	}

	@Keyword
	def verifyStartBrowsingBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/startBrowsingBtn_android'), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Login/startBrowsingBtn_android'), defaultTime, onFailure);
		}
	}

	@Keyword
	def verifyBecomeAMemberBtnExist(isExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/becomeAMemberBtn_android'), defaultTime, onFailure);
		} else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Login/becomeAMemberBtn_android'), defaultTime, onFailure);
		}
	}

	@Keyword
	def tapOnUpdateBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/updateBtn_'+os), defaultTime);
	}
}
