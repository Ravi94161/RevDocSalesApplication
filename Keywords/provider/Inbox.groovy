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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.nativekey.AndroidKey
import internal.GlobalVariable

public class Inbox {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure =FailureHandling.CONTINUE_ON_FAILURE;
	@Keyword
	def tapOnInboxIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/InboxIcon_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/InboxIcon_android'), defaultTime);
	}

	@Keyword
	def getNameOfFirstContact(index) {
		index = index-1
		return Mobile.getText(findTestObject('Object Repository/Provider/Inbox/msgContactName_android',["index":index]), defaultTime);
	}

	@Keyword
	def typeInSearchBx(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Inbox/searchTab_android'), text, defaultTime);
	}
	@Keyword
	def verifySearchBx() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/searchTab_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifymemberProfile(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/memberProfile_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifymemberName(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/memberName_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifymemberNameArrow(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/memberNameArrow_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifymemberProcedureText(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/memberProcedureName_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifymemberCityText(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/memberCity_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyMsgDateAndTime(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/msgDateAndTime_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyNoResultsFoundText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/noResultsTxt_android'),defaultTime);
	}

	@Keyword
	def verifyUserNameText(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/memberName_android',["index":index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyProviderNameText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/providerName_android'),defaultTime);
	}

	@Keyword
	def tapOnUserName(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/memberName_android',["index":index]),defaultTime);
	}

	@Keyword
	def verifyPhysicianChatText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/physicianChatTxt_android'),defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/verifyText_android',["text":text]),defaultTime, onFailure);
	}

	@Keyword
	def verifySingleMsgCountInInboxIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/singleMessageCountInInboxIcon_android'),defaultTime);
	}

	@Keyword
	def tapOnClose() {
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/closeOptn_android'),defaultTime);
	}
	@Keyword
	def verifyCloseOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/closeOptn_android'),defaultTime, onFailure);
	}
	@Keyword
	def tapOnMsgedSupervisorChat(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/msgSupervisorName_android', ["value": name]), 30);
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/msgSupervisorName_android', ["value": name]), 30);
	}

	@Keyword
	def getMemberSlotTime() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Inbox/Chat/providerTimeOnChat_android'), defaultTime);
	}

	@Keyword
	def verifyContactNameInChat(name) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Inbox/msgSupervisorName_android', ["value": name]), defaultTime)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/msgSupervisorName_android', ["value": name]), 30)
	}

	@Keyword
	def tapOnFirstChat() {
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/msgCard_android'), defaultTime);
	}

	@Keyword
	def typeInTextOnMessageMemberInput(msg) {
		Mobile.setText(findTestObject('Object Repository/Provider/Inbox/messageMemberInptBx_andriod'), msg, defaultTime);
		def driver = MobileDriverFactory.getDriver();
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	@Keyword
	def verifyTheLocalUserSentMsg(msg) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Inbox/verifyLocalUserMsg_andriod'), msg, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyElementExist(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/msgSupervisorName_android', ["value": txt]), defaultTime, onFailure)
	}
	@Keyword
	def getMsgCountInInboxIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/getMsgCountInInboxIcon_android'), defaultTime, FailureHandling.OPTIONAL)
		return Mobile.getText(findTestObject('Object Repository/Provider/Inbox/getMsgCountInInboxIcon_android'), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapAndSetTxtOnMsgTxtField(message) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), 30);
		//Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), 30);
		//Mobile.hideKeyboard();
		Mobile.setText(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), message, defaultTime);
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/Chat/sendBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnSendBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/Chat/sendBtn_android'), defaultTime)
	}

	@Keyword
	def verifyMsgCountOnChats(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/msgCountOnChat_android'), defaultTime, onFailure)
	}
	@Keyword
	def getMsgCountOnSpecificChat(name) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Inbox/msgCountForSpecificUser_android', ['user': name]), defaultTime, onFailure)
	}
	@Keyword
	def getMsgCountOnChats(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Inbox/msgCountOnChat_android'), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def verifyMsgCountAbsenceForSpecificChat(name) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Inbox/msgCountForSpecificUser_android', ['user': name]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def getSceenTitle(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Inbox/getScreenTitle_android', ['index': index]), defaultTime);
	}
	@Keyword
	def verifySceenTitle(text, onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Inbox/getScreenTitle_android'), text, onFailure);
	}
	@Keyword
	def verifyProviderNameOnChat(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/Chat/providerNameOnChat_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyProviderTimeOnChat(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/Chat/providerTimeOnChat_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyProviderLocationOnChat(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/Chat/providerLocationOnChat_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyDenialMsgFromSupervisor(value) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Inbox/Chat/sentmsg_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Inbox/msgSupervisorName_android', ['value': value]), defaultTime)
	}

	@Keyword
	def verifyMemberNameInChat(memberProfileName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Inbox/Chat/memberName', ['memberName': memberProfileName]), defaultTime)
	}

	@Keyword
	def tapOnUnreadMsg() {
		Mobile.tap(findTestObject('Object Repository/Member/Alerts/unreadMsgCount_android'), defaultTime)
	}
	@Keyword
	def verifyMsgCountAbsence(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.delay(5)
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Alerts/unreadMsgCount_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnMemberNametoVerifyAptLink(text) {
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/memberNamewithThreadName_android', ["text":text]), defaultTime);
	}
}
