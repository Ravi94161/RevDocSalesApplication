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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.Keys

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import mobile.MobileActions

public class InvitePatients {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	MobileActions mob = new MobileActions()

	@Keyword
	def tapOnMoreBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/moreBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnInvitePatientstoFollowYouOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/invitePatientstoFollowYouOption_'+os), defaultTime)
	}

	@Keyword
	def tapOnShareLinkBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/shareLinkBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnCopyLinkBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/copyLinkBtn_'+os), defaultTime)
	}

	@Keyword
	def getInviteLink() {
		return Mobile.getText(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/getInviteLink_android'), defaultTime)
	}

	@Keyword
	def verifyShareLinkBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/shareLinkBtn_'+os), defaultTime)
	}

	// --------------- Messaging App - Start ------------------------

	@Keyword
	def tapOnMessagesAppOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/messagesAppOption_'+os), defaultTime)
	}

	@Keyword
	def tapOnNewMessageOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/newMessageOption_'+os), defaultTime)
	}

	@Keyword
	def tapOnFirstNameFromList() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/firstNameFromList_'+os), defaultTime)
	}

	@Keyword
	def tapOnSendSmsBtn() {
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/sendSmsBtn_'+os), defaultTime)
	}

	@Keyword
	def verifyInviteLinkSent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/verifyLink_'+os), defaultTime)
	}

	@Keyword
	def getInviteLinkSent() {
		return Mobile.getText(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/verifyLink_'+os), defaultTime)
	}

	@Keyword
	def tapOnInviteLink() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/verifyLink_'+os), defaultTime)
	}

	@Keyword
	def tapOnUseMsgsWithoutAnAcntBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/useMsgsWithoutAnAcntBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnStartChatBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/startChatBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnMsgInputField() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/msgInputField_'+os), defaultTime)
	}

	@Keyword
	def typeInMsgInputField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/Invite Patients to Follow You/MessagesApp/msgInputField_'+os), text, defaultTime)
	}

	@Keyword
	def sendDeepLinkThroughMsgs(deepLink) {
		tapOnMessagesAppOption()
		tapOnUseMsgsWithoutAnAcntBtn()
		//		tapOnNewMessageOption()
		tapOnStartChatBtn()
		tapOnFirstNameFromList()
		tapOnMsgInputField()
		typeInMsgInputField(deepLink)
		tapOnSendSmsBtn()
		Mobile.hideKeyboard()
		mob.tapOnElementByText(deepLink)
	}

	@Keyword
	def sendDeepLinkViaOpenedMessagesApp(deepLink) {
		tapOnMsgInputField()
		typeInMsgInputField(deepLink)
		tapOnSendSmsBtn()
		Mobile.hideKeyboard()
		mob.tapOnElementByText(deepLink)
	}

	// --------------- Messaging App - End ------------------------
}
