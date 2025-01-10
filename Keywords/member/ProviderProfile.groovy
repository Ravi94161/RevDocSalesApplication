package member

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
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

import internal.GlobalVariable

public class ProviderProfile {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnAboutProviderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/aboutProviderBtn_android'), defaultTime);
	}

	@Keyword
	def VerifyEducationAndWorkHistoryDetailsOption() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/educationDetailsOption_android'), defaultTime,FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/educationDetailsOption_android'), defaultTime);
	}
	@Keyword
	def tapOnEducationDetailsOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/educationDetailsOption_android'), defaultTime);
	}

	@Keyword
	def VerifyMedicalLicenseOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/medicalLicenseOption_android'), defaultTime);
	}

	@Keyword
	def tapOnMedicalLicenseOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/medicalLicenseOption_android'), defaultTime);
	}

	@Keyword
	def VerifyVerificationStatusOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/verificationStatus_android'), defaultTime);
	}

	@Keyword
	def tapOnVerificationStatusOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/verificationStatus_android'), defaultTime);
	}
	@Keyword
	def VerifyWorkHistoryOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/workHistoryOption_android'), defaultTime);
	}

	@Keyword
	def tapOnWorkHistoryOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/workHistoryOption_android'), defaultTime);
	}
	@Keyword
	def tapOnCloseWithBorders() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/closeWithBorder_android'), defaultTime);
	}

	@Keyword
	def verifyCloseWithBorders(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/closeWithBorder_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyWorkHistoryDetails(index, text) {
		Mobile.scrollToText(text, FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/verifyWorkHistoryDetails', ['index': index, 'text': text]), defaultTime);
	}

	@Keyword
	def verifyCheckMarkForWorkHistory(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/verifiedCheckMarkForWorkHistory', ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnSocialMediaIcon(text) {
		// text = ["linkedIn", "fb", "insta", "twitter", "web"]
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/socialMediaIcons',['iconName': text]), defaultTime);
	}

	@Keyword
	def verifySocialMediaIconDisabledState(text) {
		tapOnSocialMediaIcon(text)
		Mobile.delay(3)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/socialMediaIcons',['iconName': text]), defaultTime);
	}

	@Keyword
	def verifySocialMediaIconEnabledState(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = 15) {
		tapOnSocialMediaIcon(text)
		Mobile.delay(3)
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/socialMediaIcons',['iconName': text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyLicenseImgPresent(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/licenseImgs', ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnprofileBtnOnProviderCard(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/profileBtnOnProviderCard_android', ['index': index]), defaultTime)
	}
	//-------------------------------------------------verified popup UI-----------------------------------------------------------------------------------------------------------------
	@Keyword
	def verifyVerifiedCheck(index = 3, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Provider Profile/verifiedCheck_android', ["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyVerifiedProviderInfoBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Provider Profile/verifiedProviderInfoBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnVerifiedProviderInfoBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member Provider Profile/verifiedProviderInfoBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyNumberOfMonthsVisible(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Provider Profile/numberOfMonthsText_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyNumberOfMonthsNotVisible(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member Provider Profile/numberOfMonthsText_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyRatingOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Provider Profile/ratingOpt_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyandGetRatingcount(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Provider Profile/ratingCount_android'), defaultTime, onFailure);
		return Mobile.getText(findTestObject('Object Repository/Member/Member Provider Profile/ratingCount_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyNumberOfAppointmentsNotVisible(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member Provider Profile/numberOfAppts_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyNumberOfAppointmentsVisible(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Provider Profile/numberOfAppts_android'), defaultTime, onFailure);
	}
	//---------------------------------------------------Close verified Popup UI ----------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------Open book appt by procedure-------------------------------------------------------------------------------------------------------------------
	@Keyword
	def tapOnBookApptByProcedure() {
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/bookApptByProcedureBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSpecificProcedureCategory(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/Member Provider Profile/BookApptByProcedure/specificProcedure_android',["procedureName":procedureName]), defaultTime);
	}
	@Keyword
	def verifyProcedureCategory(procedureName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(procedureName, FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member Provider Profile/BookApptByProcedure/specificProcedure_android',["procedureName":procedureName]), defaultTime, onFailure);
	}
	@Keyword
	def getProviderFeeLable(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member Provider Profile/BookApptByProcedure/providerFeeLable_android', ["index":index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnBookWithMeBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member Provider Profile/bookWithMeBtn_android'), defaultTime, onFailure);
	}

	//---------------------------------------------------Close book appt by procedure-------------------------------------------------------------------------------------------------------------------

}
