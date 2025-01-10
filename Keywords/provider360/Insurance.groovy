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

import internal.GlobalVariable

public class Insurance {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;

	@Keyword
	def verifyBackBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/backBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/backBtn_android'), defaultTime);
	}
	@Keyword
	def verifyInsurancesTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/insurancesTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnInsuranceOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/insuranceBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnAddInsuranceBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/addAcceptedInsuranceBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnAutoSearchField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/insuranceAutoSearchField_'+os), defaultTime);
	}

	@Keyword
	def enterTextInAutoSearch(insuranceName) {
		Mobile.setText(findTestObject('Provider/Provider360/Insurance/insuranceAutoSearchTextField_'+os), insuranceName, 60);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyAutoSuggestionOption(name, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/autoSuggestedOption_android', ['value': name]), defaultTime, onFailure);
	}

	@Keyword
	def verifyAutoSearchField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/insuranceAutoSearchField_android'), 30);
	}

	@Keyword
	def verifyAddInsurancePopupCLoseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/addInsurancePopupCloseBtn_android'), 30);
	}
	@Keyword
	def tapOnMinusIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/autoSuggestedOptionMinusIcon_'+os), 30);
	}

	@Keyword
	def verifyMinusIconPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/autoSuggestedOptionMinusIcon_'+os), 30);
	}


	@Keyword
	def tapClose() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/CloseOptn_android'), 30);
	}

	@Keyword
	def verifyAcceptedInsuranceSheetVisible(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/acceptedInsuranceSheet_'+os), 30);
	}

	@Keyword
	def tapOnOtherInsurancePlusIcon(partialText) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/otherInsurancePlusIcon_android', ['name': partialText]), 50)
	}

	@Keyword
	def tapOnSaveInsuranceBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/saveInsurancesBtn_'+os), 50)
	}
	@Keyword
	def verifySaveInsuranceBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/saveInsurancesBtn_'+os), defaultTime,onFailure)
	}

	@Keyword
	def enterTextInSearchField(text) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Insurance/searchField_'+os) , text, 60)
	}

	@Keyword
	def searchAndAddOtherInsurance(partialText) {
		//tapOnAddOtherInsuranceBtn();
		verifyAcceptedInsuranceSheetVisible();
		enterTextInSearchField(partialText);
		tapOnOtherInsurancePlusIcon(partialText);
	}

	@Keyword
	def searchAndAddAcceptedInsurance(name) {
		tapOnAddAcceptedInsuranceBtn();
		tapOnAutoSearchField();
		enterTextInAutoSearch(name)
		verifyAutoSuggestionOption(name)
		tapOnPlusIcon(name)
	}

	@Keyword
	def verifyInsuranceNameInSavedAcceptanceSheet(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/selectedInsurance_android', ['value': text]), 60, onFailure)
	}

	@Keyword
	def tapOtherInsurance() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/otherInsurance_'+os), defaultTime)
	}

	@Keyword
	def removeOtherInsurance(name) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/otherInsuranceMinusIcon_android', ['name': name]), defaultTime)
	}

	@Keyword
	def verifyOtherInsurancePresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/otherInsurance_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyWellcareInsurancePresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/wellcareInsurance_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyOtherInsuranceNotPresent() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Insurance/otherInsurance_'+os), defaultTime)
	}

	@Keyword
	def verifySavedAcceptedInsuranceTextNotPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Provider360/Insurance/savedAcceptanceInsuranceTitle_'+os), defaultTime, onFailure)
	}

	@Keyword
	def verifySavedAcceptedInsuranceTextPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/Insurance/savedAcceptanceInsuranceTitle_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAddOtherInsuranceBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/addOtherInsuranceBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAddOtherInsuranceBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/addOtherInsuranceBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyAddAcceptedInsuranceOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/addAcceptedInsuranceBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnAddAcceptedInsuranceBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/addAcceptedInsuranceBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnPlusIcon(name) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/autoSuggestedOptionPlusIcon_'+os, ['name': name]), 30);
	}
	@Keyword
	def getTextOfOneInsurance() {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Insurance/getTxtOfOneInsurance_android'), defaultTime)
	}

	@Keyword
	def verifyInsurancePageText(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		String text = "You don't have any accepted health insurance listed. Add your accepted insurance to let concierge patients their payment options.";
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Insurance/insurancePageText_andriod'), text, onFailure);
	}

	@Keyword
	def verifyAcceptedInsurancePopup(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/acceptedInsuranceSheet_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyAcceptedInsurancePageTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/acceptedInsuranceTitle_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifySearchFieldTextInAcceptedInsurancePage(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		String text = 'Which insurances do you accept?';
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Insurance/searchFieldTextInAcceptedInsurance_andriod'), text, onFailure)
	}

	@Keyword
	def tapOnInsurancePlusBtn(val) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/selecteInsurance(random)_andriod',['val': val]), defaultTime)
	}

	@Keyword
	def verifyInsuranceAddedOrNot(val, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Insurance/selecteInsurance(random)_andriod',['val': val]), defaultTime, onFailure)
	}

	@Keyword
	tapOnInsuranceMinusBtn(val){
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/deselectInsurance(random)_andriod', ['val': val]), defaultTime)
	}

	@Keyword
	def verifyInsuranceRemoved(val, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/selecteInsurance(random)_andriod',['val': val]), defaultTime, onFailure)
	}

	@Keyword
	def verifyInsuranceAdded(val, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/deselectInsurance(random)_andriod', ['val': val]), defaultTime, onFailure)
	}

	@Keyword
	def verifyInsuranceNotAdded(val, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Insurance/deselectInsurance(random)_andriod', ['val': val]), defaultTime, onFailure)
	}

	@Keyword
	def verifyAddedInsuranceInInsurancePage(name, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/addedInsuranceInInsurancePage_andriod', ['name': name]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnaddedCaretIconInInsurancePage(name) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/addedInsuranceInInsurancePage_andriod', ['name': name]), defaultTime)
	}

	@Keyword
	def verifyAddedInsuranceMinusBtn(name, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/addedInsuranceMinusButton_andriod', ['name': name]), defaultTime, onFailure)
	}

	@Keyword
	def getInsuranceText(index) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Insurance/insuranceInAcceptedInsurancePage_andriod', ['index': index]), defaultTime)
	}

	@Keyword
	def getInsuranceTextInInsurancePage(name) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Insurance/addedInsuranceTextInInsurancepage_andriod', ['name': name]), defaultTime)
	}
	@Keyword
	def verifyInsuranceOptionsElementTxt(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.takeScreenshot();
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/verifyElementTxt_android', ['text': text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyInsuranceOptionsElementNotExist(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.takeScreenshot();
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Insurance/verifyElementTxtNotExist_android', ['text': text]), defaultTime, onFailure);
	}

	@Keyword
	def addInsurancesInBuildMyProfileScreen(name) {
		tapOnInsuranceOption()
		searchAndAddAcceptedInsurance(name)
		tapClose()
		verifySavedAcceptedInsuranceTextPresent()
		tapOnSaveInsuranceBtn()
	}

	@Keyword
	def removeAllInsurances(maxIteratons = 10) {
		int i = 0
		def isExist = Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/chevronRightIcon_android', ['index': 1]), 10, FailureHandling.OPTIONAL)
		while(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/chevronRightIcon_android', ['index': 1]), 10, FailureHandling.OPTIONAL)  && (i < maxIteratons)) {
			Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/Insurance/chevronRightIcon_android', ['index': 1]), 10)
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/chevronRightIcon_android', ['index': 1]), 10)
			while(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Insurance/minusIcon_android', ['index': 1]), 10, FailureHandling.OPTIONAL)  && (i < 5)) {
				Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Insurance/minusIcon_android', ['index': 1]), 10)
				Mobile.delay(2)
			}
		}
	}
}
