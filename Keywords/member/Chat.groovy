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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.nativekey.AndroidKey

public class Chat {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def typeMessage(message) {
		Mobile.setText(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), message, defaultTime)
	}

	@Keyword
	def tapAndSetTxtOnMsgTxtField(message) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), 30);
		Mobile.tap(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), 30);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
		Mobile.setText(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), message, defaultTime);
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/Chat/sendBtn_android'), defaultTime)
	}

	@Keyword
	def getMessageInChat() {
		Mobile.getText(findTestObject('Object Repository/Member/Alerts/Chat/messageInChat_android'), defaultTime)
	}

	@Keyword
	def verifyProviderNameInChat(providerName) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Alerts/Chat/apptProviderName_android'), providerName,FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifyMsgFieldNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Appointments/Upcoming/PRMChat/newMessageField_android'), defaultTime, FailureHandling.STOP_ON_FAILURE);
	}
}
