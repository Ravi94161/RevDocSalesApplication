package provider360

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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent


import internal.GlobalVariable
import mobile.Generic
import mobile.MobileActions

public class MySupervision {
	String os=GlobalVariable.osName;
	int defaultTime =GlobalVariable.defaultTime;
	Generic gen = new Generic()
	MobileActions MA = new MobileActions()

	@Keyword
	def tapOnMySupervisionBtn() {
		Mobile.scrollToText("My Supervision");
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/mySupervisionBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnMySupervisorBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/mySupervisorBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnCofigureBtn() {
		Mobile.delay(5);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/configurationBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnillinoisStateDropDown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/illinoisStateDropDown_'+os), defaultTime);
	}

	@Keyword
	def tapOnFloridaStateDropDown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/floridaStateDropDown_'+os), defaultTime);
	}
	@Keyword
	def tapOnEndBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/endBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyEndBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/endBtn_'+os), defaultTime);
	}

	@Keyword
	def isExistCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/closeBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnConformBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/conformBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnYesSetUpBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/yesSetUpBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyYesSetUPBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/yesSetUpBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyYesSetUPBtnNotExist() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/yesSetUpBtn_'+os), defaultTime);
	}
	@Keyword
	def isExsitMessageStating() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/aMessageStating_'+os), defaultTime);
	}
	@Keyword
	def tapOnBuildMyRevDocProfileBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpProviderProfile/BuildMyRevDocProfileBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyMySupervisonPage(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/backBtn_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/supervisingPhysicianTitle_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/supervisingTab_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/candidatesTab_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/configureTab_android'), 30);
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MySupervision/mySupervisionScreenInfoTxt_android'), "You are supervising the following care providers:");
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/illinoisState_android', ["state": name]), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/illinoisStateDrpdwn_android', ["state": name]), 30);
	}

	@Keyword
	def tapOnState(name) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/illinoisState_android', ["state": name]), 30);
	}

	@Keyword
	def verifyAndTapOnMsgSuperviseeBtn(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/msgsuperviseeBtn_android', ['name': name]), 30);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/msgsuperviseeBtn_android', ['name': name]), 30);
	}

	@Keyword
	def verifyChatPage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/closeChatBtn_android'), 30);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/supervisorChatTitle_android'), 30);
	}

	@Keyword
	def tapAndSetTxtOnChatTxtField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/chatTxtField_android'), 30);
		Mobile.hideKeyboard();
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/MySupervision/chatTxtField_android'), "Hello, How are you?", defaultTime);
		Mobile.tap(findTestObject('Object Repository/Provider/Inbox/Chat/sendBtn_android'), defaultTime)
	}

	@Keyword
	def verifyMsgOnSupervisorChatScreen() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MySupervision/sentMsgOnSupervisorChatScreen_android'), "Hello, How are you?");
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/closeChatBtn_android'), 30);
	}

	@Keyword
	def getTxtOnBtn() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/MySupervision/textOfEndOrYesSetUpBtn_android'), 30);
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/backBtn_android'), 30);
	}
	@Keyword
	def tapOnContinueBtnOnPopup() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/continueBtnOnPopup_android'), 30);
	}

	@Keyword
	def tapOnCandidatesTab() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/candidatesTab_'+os), defaultTime);
	}

	@Keyword
	def verifyDenyBtnInCandidateTab(pos) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/denyBtnInCandidatesTab_'+os,['index':pos]), defaultTime);
	}
	
	@Keyword
	def tapOnDenyBtnInCandidateTab(pos) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/denyBtnInCandidatesTab_'+os,['index':pos]), defaultTime)
	}

	@Keyword
	def verifyAcceptBtnInCandidatesTab(pos) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervision/acceptBtnInCandidatesTab_'+os,['index':pos]), defaultTime);
	}

	@Keyword
	def tapOnAcceptBtnInCandidatesTab(pos) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/acceptBtnInCandidatesTab_'+os,['index':pos]), defaultTime);
	}

	@Keyword
	def verifyProviderNameInCandidateTabSuperviseeRequest(name) {
		Mobile.scrollToText(name, FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/MySupervisor/supervisorName_android', ['name': name]), defaultTime, )
	}

	@Keyword
	def verifyproviderNameInCandidateTabisNotVisible(name) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/MySupervisor/supervisorName_android', ['name': name]), defaultTime)
	}

	@Keyword
	def tapOnSupervisingTab() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/supervisingTab_android'), defaultTime)
	}

	@Keyword
	def verifySupervisionStartAndEndDate(dateField, date) {
		Mobile.verifyElementVisible(findTestObject('Provider/Provider360/MySupervision/supervisionDateField_android', ['dateField': dateField, 'date':date]), defaultTime)
	}

	@Keyword
	def tapOnRemoveSuperviseeBtn(name) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/removeSuperviseeBtn_android', ['name': name]), defaultTime)
	}

	@Keyword
	def verifyRemoveSuperviseePopupTxt(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': text]), defaultTime, onFailure);
	}

	@Keyword
	def verifyRemoveSuperviseePopupAndTapOnRemoveBtn() {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MySupervision/bottomSheetTitle_android'), "Remove Supervisee")
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervision/removeBtn_android'), defaultTime)
	}

	@Keyword
	def verifyBottomSheetTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/MySupervision/bottomSheetTitle_android'), title)
	}

	@Keyword
	def verifyCloseBtnOnInfoPopup() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/OrderSupplies/closeInfoPopup_android'), defaultTime);
	}

	@Keyword
	def tapOnCancelRequestOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/CancelRequestOption_'+os), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnCancelRequestBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/MySupervisor/CancelRequestBtn_'+os), defaultTime, FailureHandling.OPTIONAL );
		Mobile.delay(5);
	}

	@Keyword
	def verifySuperviseeRequestExists(name) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/MySupervisor/supervisorName_android', ['name': name]), defaultTime, FailureHandling.OPTIONAL)) {
			return true
		}
		else {
			return false
		}
	}

	@Keyword
	def verifyAndDenySupervisionRequest(name) {
		if(verifySuperviseeRequestExists(name)== true) {
			tapOnDenyBtnInCandidateTab("1")
			Mobile.delay(5)
			verifyproviderNameInCandidateTabisNotVisible(name)
		}
	}

	@Keyword
	def verifyEndDateisVisibleOrNot(dateField, date) {
		if(Mobile.verifyElementVisible(findTestObject('Provider/Provider360/MySupervision/supervisionDateField_android', ['dateField': dateField, 'date':date]), defaultTime, FailureHandling.OPTIONAL)) {
			return true
		}
		else {
			return false
		}
	}

	@Keyword
	def removeRequestWhenEndDateisEmpty(dateField, date, name) {
		if (verifyEndDateisVisibleOrNot(dateField, date)==true) {
			gen.swipeUpLittle()
			tapOnRemoveSuperviseeBtn(name)
			verifyRemoveSuperviseePopupAndTapOnRemoveBtn()
		}
	}

	@Keyword
	def verifyAndCancelRequest(name) {
		if(verifySuperviseeRequestExists(name)== true) {
			tapOnCancelRequestOption()
			tapOnCancelRequestBtn()
		}
	}
}
