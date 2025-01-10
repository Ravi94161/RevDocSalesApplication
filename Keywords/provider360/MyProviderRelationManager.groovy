package provider360

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import provider.Inbox

public class MyProviderRelationManager {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Inbox inbox = new Inbox()
	@Keyword
	def tapOnMyProviderRelationManagerOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/MyProviderRelationManagerOpt_android'), defaultTime);
	}
	@Keyword
	def verifyProviderPRMtxt(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/providerPRMTxt_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnMessagePRM() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/messagePRM_android'), defaultTime);
	}
	@Keyword
	def tapAndSetTxtOnMsgTxtField(message) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), 60);
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), 30);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
		Mobile.setText(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), message, defaultTime);
//		def driver = MobileDriverFactory.getDriver();
//		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		inbox.tapOnSendBtn()
	}
	@Keyword
	def verifyMessageTxt(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/verifyMsgTxt_android', ["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyElementTxt(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/verifyMsgTxt_android', ["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyCloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/CloseOptn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyBackBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/backBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/CloseOptn_android'), defaultTime);
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/backBtn_android'), defaultTime);
	}
	@Keyword
	def verifyScreenTitles(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/verifyScreenTitles_android', ["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyProfileHeading(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/headingPRM_android'),  text, onFailure);
	}
	@Keyword
	def verifyProviderNameTxt(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/providerNameTxt_android'),  text, onFailure);
	}
	@Keyword
	def verifyEmailBx(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/emailBx_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyCallBx(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/callBx_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyMessageBx(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MyProviderRelationManager/messageBx_android'), defaultTime, onFailure);
	}
}
