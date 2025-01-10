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

public class Revplus {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def verifyElementTextExist(text,onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/revplus/elementText_android', ['text': text]), defaultTime, onFailure)
	}

	@Keyword
	def verifyManageBtnExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/revplus/manageBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyManageBtnNotExists(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.delay(15);
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/revplus/manageBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapManageBtn() {
		Mobile.scrollToText("Manage", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/manageBtn_android'), defaultTime)
	}

	@Keyword
	def tapCancelMembershipBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/cancelMembership_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCancelMembershipBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/revplus/cancelMembership_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnYesBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/yesBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/closeBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyRevplusIconPresentOnRevplusCard(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/RevPlusCard/revPlusIcon_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyRevplusIconNotPresentOnRevplusCard(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/RevPlusCard/revPlusIcon_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapElementByText(text) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/elementText_android', ['text': text]), defaultTime)
	}

	@Keyword
	def scrollToUpgradePlusCard() {
		def eHeight = Mobile.getElementHeight(findTestObject('Object Repository/Member/HomePage/card_android'), defaultTime)
		def eWidth = Mobile.getElementWidth(findTestObject('Object Repository/Member/HomePage/card_android'), defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(findTestObject('Object Repository/Member/HomePage/card_android'), defaultTime)
		def eTopPos = Mobile.getElementTopPosition(findTestObject('Object Repository/Member/HomePage/card_android'), defaultTime)

		def startx  = eWidth - 100
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = eLeftPos + 400
		def endy =  starty
		int i= 1;

		while (!verifyRevplusIconPresentOnRevplusCard(FailureHandling.OPTIONAL, 5) && i <= 4) {
			i = i + 1;
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
		}
		if(i>=4) {
			return false;
		}
	}

	@Keyword
	def tapOnRevPlusMembershipOption() {
		Mobile.scrollToText("Membership", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/revPlusMembershipOption_android'), defaultTime);
	}

	@Keyword
	def tapOnManageBtnInRevPlusScreen() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/manageBtnInRevPlus_android'), defaultTime);
	}

	@Keyword
	def tapOnMessageYourProviderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/revplus/messageYourProvider_android'), defaultTime)
	}
	
	
	// RevPlus
	
	@Keyword
	def tapOnManageIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Provider/manageIcon_android'), defaultTime)
	}
	
	@Keyword
	def tapOnChangeMyProviderBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/My Provider/changeMyProviderBtn_android'), defaultTime)
	}
}
