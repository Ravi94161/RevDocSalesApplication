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

public class ReviewHealthRecord {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE

	@Keyword
	def verifyElementExist(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Review Health Record/verifyElementExist_android',["txt":txt]), defaultTime,onFailure);
	}
	@Keyword
	def verifyCheckOrange() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Review Health Record/checkOrange_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyCompleteNowBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Review Health Record/completeNowBtn_android'), defaultTime,onFailure);
	}
	@Keyword
	def tapOnCompleteNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Review Health Record/completeNowBtn_android'), defaultTime,onFailure);
	}
	@Keyword
	def verifyRemindMeLaterBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Review Health Record/remindMeLaterBtn_android'), defaultTime,onFailure);
	}
	@Keyword
	def tapOnRemindMeLaterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Review Health Record/remindMeLaterBtn_android'), defaultTime);
	}
	@Keyword
	def verifyreviewHealthRecordTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Review Health Record/reviewHealthRecordTitle_android'), defaultTime,onFailure);
	}
	@Keyword
	def tapOnNoChangesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Review Health Record/noChangesBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnYesReviewBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Review Health Record/yesReviewBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnDoneBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Cart/Review Health Record/doneBtn_android'), defaultTime);
	}
	@Keyword
	def verifyNoChangesBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/ThankYou/noChangeBtn_android'), defaultTime);
	}
	@Keyword
	def verifyYesReviewBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Review Health Record/yesReviewBtn_android'), defaultTime);
	}
	@Keyword
	def verifyUpdatedDate() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Review Health Record/yesReviewBtn_android'), defaultTime);
	}
}
