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
import mobile.MobileActions

import internal.GlobalVariable

public class SupervisionNP {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def state;
	MobileActions act = new MobileActions()

	@Keyword
	def tapOnBuildYourProfile() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/buildYourProfileBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnSupervisionOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/supervisionOption_'+os), defaultTime);
	}
	@Keyword
	def tapOnSelectStateRadioBtn(index=1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/selectStateRadioBtn_android',['index':index]), defaultTime);
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/selectStateName_android',['index':index]), defaultTime);
	}

	@Keyword
	def getStateName(i) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/selectStateTextOne_android', ['value': i]), 30);
	}

	@Keyword
	def tapOnAddSupervisorOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/addSupervisorsOption_'+os), defaultTime);
	}
	@Keyword
	def tapOnYesRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/yesRadioBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/continueBtn_'+os), defaultTime);
	}
	@Keyword
	def typeinSearchbar(npi) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/searchNpiOrName_'+os),npi, defaultTime);
	}
	@Keyword
	def tapOnAddSupervisorRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/addSupervisorRadioBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnSendRequestBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/sendRequestBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnNoRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/noRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnDoneBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/doneBtn_'+os), defaultTime);
	}
	@Keyword
	def isMySupervisorsTitleExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/mySupervisorsTitle_'+os), defaultTime);
	}
	@Keyword
	def isLabelOneExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/labelOne_'+os), defaultTime);
	}
	@Keyword
	def isLabelTwoExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/labelTwo_'+os), defaultTime);
	}
	@Keyword
	def isYesOptionExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/yesRadioBtn_'+os), defaultTime);
	}
	@Keyword
	def isNoOptionExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/noRadioBtn_'+os), defaultTime);
	}
	@Keyword
	def isAddSupervisionTitleExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/addSupervisorTitle_'+os), defaultTime);
	}
	@Keyword
	def isCloseButtonExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/closeButton_'+os), defaultTime);
	}
	@Keyword
	def isSupervisionLabelExists(state) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/supervisionLabel_'+os), state+" Supervision");
	}
	@Keyword
	def isProgressBarExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/progressBar_'+os), defaultTime);
	}
	@Keyword
	def isSubLabelOneExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/subLableOne_'+os), defaultTime);
	}
	@Keyword
	def isContinueBtnExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/continueBtn_'+os), defaultTime);
	}
	@Keyword
	def isModalBtnSheetExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/modalButtonSheet_android'+os), defaultTime);
	}
	@Keyword
	def isPageTitleExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/pageTitle_'+os), defaultTime);
	}
	@Keyword
	def isTitlePageLabelExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/titlePageLabel_'+os), defaultTime);
	}
	@Keyword
	def isSelectStateRadioBtnExists(index =1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/selectStateRadioBtn_'+os,['index':index]), defaultTime);
	}
	@Keyword
	def isexpiresDateOptionExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/expiresDateOption_'+os), defaultTime);
	}
	@Keyword
	def verifySubmitBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/submitBtn_android'), defaultTime)
	}
	@Keyword
	def isAddSupervisorOptionExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/addSupervisorsOption_'+os), defaultTime);
	}
	@Keyword
	def yesRadioBtnChecked() {
		boolean b=Mobile.verifyElementChecked(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/yesRadioBtn_'+os), defaultTime);
		if(b) {
			println("Yes Button Selected.")
		}
		else {
			println("yes button not selected ")
		}
	}
	@Keyword
	def verifyDoNotNeedSupervisionRadioBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/doNotNeedSupervisionRadioBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnDoNotNeedSupervisionRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/doNotNeedSupervisionRadioBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyBackBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/backBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyInfoSavedTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/infoSavedTitle_'+os), defaultTime);
	}
	@Keyword
	def verifyInfoSavedMessage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/infoSavedMessage_'+os), defaultTime);
	}
	@Keyword
	def verifyStartOverBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/startOverBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyDoneBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/doneBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/backBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyStatePendingRequest(name) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/statePendingRequest_android',["value": name]), defaultTime);
	}

	@Keyword
	def verifyAndTapOnFirstSuperVisionInfoLabel(label) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/firstSupervisionInfoIconText_android', ['label': label]), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/firstSupervisionInfoIconText_android', ['label': label]), defaultTime)
	}

	@Keyword
	def verifyInfoPopupTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/bottomSheetTitle_android'), title)
	}

	@Keyword
	def verifyAndTapOnCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/bottomSheetCloseBtn_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/bottomSheetCloseBtn_android'), defaultTime)
	}

	@Keyword
	def verifyInfoPopupTxtTitle(txt) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/textElement_android', ['txt': txt]), defaultTime)
	}

	//UNder Add Supervisor Search Supervisor By name screen
	@Keyword
	def getSupervisorNameByStateAndTap(state, index) {
		def name = Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/supervisorNameByStateInAddSupervisorScreen_android',['state': state, 'index': index]), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/supervisorNameByStateInAddSupervisorScreen_android',['state': state, 'index': index]), defaultTime)
		return name
	}

	@Keyword
	def verifyRequestSentMsg(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/supervisorRequestSent_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyAcceptAndDoneBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/doneBtn_android'), defaultTime, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/startoverBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def selectState(state) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/selectState_android', ['state': state]), 30);
	}

	@Keyword
	def tapOnAddSupervisorBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorsBtn_android'), 30);
	}

	@Keyword
	def verifyAddSupervisorPageTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorPageTitle_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyStateInSendingRequestSupervisionFlow(state, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/stateInSupervisonFlow_android', ['state': state]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnYesBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorYesBtn_android'), defaultTime);
	}

	@Keyword
	def verifyNoBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorNoBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnNoBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorNoBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnFirstProviderSelectedStateRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/supervisionNPprofile/selectFirstProviderRadioBtn_android'), defaultTime);
	}

	@Keyword
	def sendSupervisorRequest(state, st) {
		selectState(state)
		tapOnAddSupervisorBtn()
		verifyAddSupervisorPageTitle()
		verifyStateInSendingRequestSupervisionFlow(state)
		act.tapOnElementByText("Yes")
		act.verifyElementPresentByText("No")
		tapOnContinueBtn()
		act.tapOnElementByText("No")
		tapOnContinueBtn()
		def name = getSupervisorNameByStateAndTap(st,"1")
		tapOnSendRequestBtn()
		verifyRequestSentMsg()
		verifyAcceptAndDoneBtn()
		tapOnDoneBtn()
		return name
	}


	@Keyword
	def sendSupervisorRequestBySupervisorName(state, name) {
		selectState(state);
		tapOnAddSupervisorOption();
		act.tapOnElementByText("Yes")
		isContinueBtnExists();
		tapOnContinueBtn();
		act.tapOnElementByText("No")
		tapOnContinueBtn();
		typeinSearchbar(name);
		tapOnFirstProviderSelectedStateRadioBtn();
		tapOnSendRequestBtn()
		tapOnDoneBtn();
	}
	
	@Keyword
	def tapOnNOInAddSupervisor2ndScreen() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/noBtnIn2ndAddSupervisorScreen_android'), defaultTime)
	}
}
