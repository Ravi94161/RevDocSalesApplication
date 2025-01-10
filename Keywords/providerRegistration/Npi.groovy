package providerRegistration

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import mobile.Generic

public class Npi {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Demographics demo = new Demographics();
	Generic gen = new Generic();

	@Keyword
	def enterNpiNumber(npi) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/NPIForm/npiNumberTextField_android'), npi, defaultTime);
	}

	@Keyword
	def clearNpiNumber() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/NPIForm/npiNumberTextField_android'), defaultTime);
	}

	@Keyword
	def enterConfirmNpiNumber(npi) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/NPIForm/confirmNpiNumberTextField_android'), npi, defaultTime);
	}

	@Keyword
	def clearConfirmNpiNumber() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/NPIForm/confirmNpiNumberTextField_android'), defaultTime);
	}

	@Keyword
	def enterLastName(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/NPIForm/lastNameTextField_android'), name, defaultTime);
	}

	@Keyword
	def clickOnSubmitBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/NPIForm/submitNpi_android'), defaultTime);
	}

	@Keyword
	def verifyNpiNumInDemographicsPage(npi) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/NPIForm/npiNumInDemoPage_android'), npi);
	}

	@Keyword
	def verifyLastNameInDemographicsPage(name) {
		Mobile.scrollToText(name, FailureHandling.OPTIONAL)
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/NPIForm/lastNameTextField_android'), name);
	}

	@Keyword
	def verifyNpiNumInNpiPage(npi) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/NPIForm/npiNumberTextField_android'), npi);
	}

	@Keyword
	def verifyConfirmNpiNumber(npi) {
		
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/NPIForm/confirmNpiNumberTextField_android'), npi);
	}

	@Keyword
	def verifyLastNameInNpiPage(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/NPIForm/lastNameTextField_android'), name);
	}

	//UI Verifications

	@Keyword
	def verifyNpiHeadingContent1() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/npiHeadingContent1_android'), defaultTime);
	}

	@Keyword
	def verifyNpiHeadingContent2() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/npiHeadingContent2_android'), defaultTime);
	}

	@Keyword
	def verifyNpiNumberPlaceholder() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/npiNumberPlaceholder_android'), defaultTime);
	}

	@Keyword
	def verifyConfirmNpiNumberPlaceholder() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/confirmNpiNumberPlaceholder_android'), defaultTime);
	}

	@Keyword
	def verifyLastNamePlaceholder() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/lastNamePlaceholder_android'), defaultTime);
	}

	@Keyword
	def verifySubmitNpiBtnText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/submitNpiBtnText_android'), defaultTime);
	}

	@Keyword
	def verifyRequiredMsgNpiNumber() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/requiredMsgNpiNumber_android'), defaultTime);
	}

	@Keyword
	def verifyRequiredMsgConfirmNpiNumber() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/requiredMsgConfirmNpiNumber_android'), defaultTime);
	}

	@Keyword
	def verifyRequiredMsgLastName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/requiredMsgLastName_android'), defaultTime);
	}

	@Keyword
	def verifyErrorMsgNpiNumberMismatch() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/errorMsgNpiNumberMismatch_android'), defaultTime);
	}

	@Keyword
	def verifyErrorMsgNpiNumberLessthan10() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/NPIForm/errorMsgNpiNumberLessthan10_android'), defaultTime);
	}


	@Keyword
	def fillDetailsInNpiPage(npi,cnfnpi,name) {
		enterNpiNumber(npi);
		enterConfirmNpiNumber(cnfnpi);
		enterLastName(name);
		Mobile.hideKeyboard();
		clickOnSubmitBtn();
	}

	@Keyword
	def verifyNpiDetailsInDemographicsPage(npi, name) {
		verifyNpiNumInDemographicsPage(npi);
		verifyLastNameInDemographicsPage(name);
	}

	@Keyword
	def verifyNpiDetailsInNpiPage(npi, name) {
		Mobile.pressBack();
		demo.verifyExitWithoutSavingPopup()
		demo.verifyCancelBtn()
		demo.taponExitWithoutSavingBtn()
		verifyNpiNumInNpiPage(npi);
		verifyConfirmNpiNumber(npi);
		verifyLastNameInNpiPage(name);
		clickOnSubmitBtn();
	}
	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/getReadyForRegistration/continueBtn_android'), defaultTime)
	}
}
