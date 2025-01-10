package provider

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

public class MemberProfile {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def verifyBottomSheetTitle(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/MemberProfile/bottomSheetTitle_android'), defaultTime, onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/MemberProfile/bottomSheetTitle_android'), text, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapBottomSheetCloseBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/MemberProfile/bottomSheetClose_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyMemberName(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/MemberProfile/memberName_android'), defaultTime, onFailure)
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/MemberProfile/memberName_android'), text, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyElementText(text, OnFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/MemberProfile/elementText_android', ['text': text]), defaultTime, OnFailure)
	}

	@Keyword
	def tapOkayBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/MemberProfile/AppointmentCancelled/okayBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyApptCancelledBtnInMemberProfileExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/MemberProfile/apptCancelledBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapApptCancelledBtnInMemberProfile(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/MemberProfile/apptCancelledBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCrossRedIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/MemberProfile/AppointmentCancelled/crossRedIcon_android'), defaultTime, onFailure);
	}
	//------------------------------------member-chat-----------------------
	
	@Keyword
	def verifyChatBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/MemberProfile/chatBtn_android'), defaultTime, onFailure);
	}
	
	@Keyword
	def tapOnChatBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/MemberProfile/chatBtn_android'), defaultTime, onFailure);
	}
	
	@Keyword
	def verifyBootstrapMessageOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/MemberProfile/bootstrapMessageOpt_android'), defaultTime, onFailure);
	}
	//------------------------------------close-member-chat-------------------
}
