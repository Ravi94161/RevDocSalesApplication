package providerRegistration

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

public class BackgroundCheckStatus {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def verifyBackgroundCheckStatusTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/backgroundCheckStatusText_'+os), defaultTime,FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyTextInBackgroundCheck(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/verifyTextInBackgroundCheck_'+os,['text':text]), defaultTime,FailureHandling.OPTIONAL)
	}

	@Keyword
	def tapOnMsgPRM(text) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/verifyTextInBackgroundCheck_'+os,['text':text]), defaultTime,FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyOptionsCrossMark(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/verifyOptionsCrossMark_'+os,['text':text]), defaultTime,FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyPRMChatTitle(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/verifyPRMChatTitle_'+os),text,FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyProviderName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/verifyProviderName_'+os), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyProviderAddress() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/verifyProviderAddress_'+os), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyMsgInputBox() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/msgInputBox_'+os), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/closeBtn_'+os), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/closeBtn_'+os), defaultTime)
	}

	@Keyword
	def verifyBuildYourProfileBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/buildYourProfileBtn_'+os), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyBuildYourProfileBtnEnable() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/buildYourProfileBtnEnable_'+os), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifySetUpProfileTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/SetUpProfile/setUpProfileText_'+os), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyBackBtnElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/SetUpProfile/backBtn_'+os), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def tapGoLiveBtn(defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/goLiveBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnVerificationStatus() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/Provider Profile/verificationStatus_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def verifyTextInBackgroundCheckNotPresent(text) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/verifyTextInBackgroundCheck_'+os,['text':text]), defaultTime,FailureHandling.OPTIONAL)
	}
	@Keyword
	def tapOnCloseBtnXSymbol() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/closeBtnXSymbol_'+os), defaultTime)
	}
	@Keyword
	def tapOnSearchBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/searchBackBtn_'+os), defaultTime)
	}
	@Keyword
	def tapOnAvatarInfoBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/BackgroundCheckStatus/avatarBtn_'+os), defaultTime)
	}
}
