package member360

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

public class InviteCode {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnInviteCodeTab() {
		Mobile.delay(5);
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/InviteCode/inviteCode_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/InviteCode/inviteCode_android'), defaultTime);
	}

	@Keyword
	def typeInviteCode(code) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/InviteCode/inviteCodeField_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/Member360/InviteCode/inviteCodeField_android'), code, defaultTime);
	}

	@Keyword
	def tapOnEnterACodeOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/InviteCode/enterACodeOption_android'), defaultTime);
	}

	@Keyword
	def typeReEnterInviteCode(code) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/InviteCode/reEnterInviteCode_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/Member360/InviteCode/reEnterInviteCode_android'), code, defaultTime);
	}

	@Keyword
	def tapOnSubmitBtn() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/InviteCode/submitBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/InviteCode/submitBtn_android'), defaultTime);
	}

	@Keyword
	def verifyBottomSheetTitle(text) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/InviteCode/bottomSheetTitle_android'), defaultTime);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/InviteCode/bottomSheetTitle_android'), text);
	}

	@Keyword
	def verifyElementTextExists(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/InviteCode/elementText_android', ['text': text]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnOkayBtn() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/InviteCode/okayBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/InviteCode/okayBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/InviteCode/backBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/InviteCode/backBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnEnterACodeTab() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/InviteCode/enterACodeOption_android'), defaultTime);
	}
	@Keyword
	def verifyAlertIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/InviteCode/alertIcon_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnInviteTab() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/InviteCode/invitetab_android'), defaultTime);
	}
	@Keyword
	def tapOnHaveACodeTab() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/InviteCode/haveACodeTab_android'), defaultTime);
	}
	@Keyword
	def verifyRevFriendsListElementNotExist(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/InviteCode/verifyRevFriendsList'), defaultTime, onFailure);
	}
}
