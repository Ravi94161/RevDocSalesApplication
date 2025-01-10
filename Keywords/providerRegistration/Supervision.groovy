package providerRegistration

import org.openqa.selenium.chrome.ChromeDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.internal.PathUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement

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

public class Supervision {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnSupervisionOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/supervisionOption_android'), 30);
	}

	@Keyword
	def verifySupervisionTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/supervisionPageTitle_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifySupervisionQues(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Supervision/superVisionPageQuesTitle_android'), "What states are you going to be practicing in via RevDoc?", onFailure);
	}

	@Keyword
	def verifyFloridaState(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/floridaState_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyExpiryLabel(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/expiryLabel_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyAddSupervisorBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorsBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def selectFloridaState() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/floridaState_android'), 30);
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
	def verifyCloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/closeBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyStateInSupervisorFlow(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/stateSupervision_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyStateInSendingRequestSupervisionFlow(state, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/stateInSupervisonFlow_android', ['state': state]), defaultTime, onFailure);
	}

	@Keyword
	def verifylabelsInSupervisorFlow(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorPageQues_android'), "Do you need a supervisor in this state?", onFailure);
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Supervision/addsupervisorQuesInfo_android'), "Supervising Roles and Responsibilities", onFailure);
	}

	@Keyword
	def tapOnYesBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorYesBtn_android'), defaultTime);
	}

	@Keyword
	def verifyYesBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorYesBtn_android'), defaultTime);
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
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorContinueBtn_android'), defaultTime);
	}

	@Keyword
	def verifyContinueBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/addSupervisorContinueBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyDoYouHaveSupervisorLabel(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Supervision/doYouHaveExistingSupervisorQues_android'), "Do you have an existing supervisor in this state?", onFailure);
	}

	@Keyword
	def verifySupervisorSearchBox(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/supervisorSearchBox_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchBoxDescription(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Supervision/searchResultsInfoLabel_android'), "Your search results will appear here", onFailure);
	}


	@Keyword
	def verifyBackBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/backBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def enterTxtInSearchBox(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Supervision/supervisorSearchBox_android'), name, defaultTime);
	}

	@Keyword
	def verifySearchResult(name, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def searchedResult = Mobile.getText(findTestObject('Object Repository/Provider/Registration/Supervision/searchedSupervisorResult_android', ['value': name]), defaultTime);

		if (searchedResult.contains(name)) {
			println(name);
		}
	}

	@Keyword
	def verifySearchForSupervisorField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Supervision/selectAProviderLabel_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyMultipleProvidersAreVisible() {
		int value= MobileDriverFactory.getDriver().findElementsByXPath('//android.view.ViewGroup[contains(@content-desc,"checkboxEmpty, avatar, providerName")]').size()
		println (value);
		if(value > 1) {
			println("We are having more than 1 providers")
		}

		for(def i = 1; i <=value; i++) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SupervisionNP/supervisorStateName_android', ["index":i]), defaultTime)
		}
	}

	@Keyword
	def selectFirstProviderSupervisor() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/firstProviderSupervisor_android'), defaultTime);
	}

	@Keyword
	def tapOnSendRequestBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/sendRequestBtn_android'), defaultTime);
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
	def tapOnSpecificState(text, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/elementText_android', ['text': text]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnDoneBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Supervision/doneBtn_android'), defaultTime);
	}
	@Keyword
	def setTextInProviderSearchField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Supervision/supervisorSearchField_android'), text, defaultTime)
	}
}
