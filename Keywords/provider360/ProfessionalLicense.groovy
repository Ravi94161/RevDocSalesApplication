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
import provider360.Procedures
import provider360.ProfessionalLicense
import providerRegistration.License
import provider360.SetUpYourAvailability
import providerRegistration.Education
import provider360.Banking

import internal.GlobalVariable

public class ProfessionalLicense {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Procedures proce = new Procedures();
	License myLicense = new License();
	Banking bankingBtn = new Banking();

	@Keyword
	def verifyProffesionalLicenseOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/professionalLicenseOption_android'), defaultTime);
	}

	@Keyword
	def tapOnProffesionalLicenseOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/professionalLicenseOption_android'), defaultTime);
	}

	@Keyword
	def verifyViewIcon() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/viewIcon_android'), defaultTime);
	}

	@Keyword
	def verifyLicenseStateExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/licenseStateName_android'), defaultTime);
	}

	@Keyword
	def verifyLicenseNumberExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/licenseNumber_android'), defaultTime);
	}

	@Keyword
	def verifyLicenseExpDateExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/licenseExpirationDate_android'), defaultTime);
	}

	@Keyword
	def verifyLicenseTypeExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/licenseType_android'), defaultTime);
	}

	@Keyword
	def verifyPastLicenseStateExist() {
		//Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/pastLicenseState_android'), defaultTime);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/pastLicenseState_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyPastLicenseNumExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/pastLicenseNum_android'), defaultTime);
	}

	@Keyword
	def verifyPastLicenseExpDateExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/pastLicenseExpDate_android'), defaultTime);
	}

	@Keyword
	def verifyPastLicenseTypeExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/pastLicenseType_android'), defaultTime);
	}

	@Keyword
	def verifyUploadedImage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/preViewOfImage_android'), defaultTime);
	}

	@Keyword
	def verifyAddAdditionalLicensesOption() {
		Mobile.scrollToText("Add additional professional license", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/addAdditionalLicense_android'), defaultTime);
	}

	@Keyword
	def tapOnAddAdditionalLicensesOption() {
		Mobile.scrollToText("Add additional professional license", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/addAdditionalLicense_android'), defaultTime);
	}
	@Keyword
	def tapOnUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/uploadBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyPopUpTitle(text, index=1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/popUpTitle_andriod', ["index": index]), text)
	}
	@Keyword
	def verifyChooseFromLibraryOpt(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/chooseFromLibrary_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyTakeNewPhotoOpt(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/takeNewPhoto_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyBrowserFileOpt(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/browserFile_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyCloseBtn(index=1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/closeBtn_andriod', ["index": index]), defaultTime, onFailure)
	}
	@Keyword
	def verifyPlaceholderText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/placeHolderText_andriod', ["text" : text]), defaultTime, onFailure)
	}
	@Keyword
	def verifyDropDwnWithPlaceholderText(value, text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/dropDwnWithPlaceholder_andriod', ["value": value, "text" : text]), defaultTime, onFailure)
	}
	@Keyword
	def verifyUploadBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/uploadBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifySaveBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/saveBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnSaveBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/saveBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyProviderLicenseText(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/providerLicenseNumber_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnDEALicenseOpt() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/deaLicense_andriod'), defaultTime)
	}

	@Keyword
	def verifyLicenseDetailsForSupervior(value, name) {
		Mobile.verifyElementText(findTestObject('Provider/Provider360/SupervisionNP/medicalLicenseDetails_android', ['value': value]), name)
	}

	@Keyword
	def addLicense(date) {
		proce.verifyProfileIcon();
		proce.tapOnProfileIcon();
		proce.tapOnProviderProfileOption();

		//Adding additional license
		tapOnProffesionalLicenseOption()
		tapOnAddAdditionalLicensesOption()
		myLicense.tapOnSelectStateDropdown();
		myLicense.tapOnselcetStateFl();
		myLicense.typeInProviderLicenseNumberInputBx("12345677");
		Mobile.hideKeyboard();
		myLicense.tapOnLicenseExpirationDate();
		myLicense.avail.selectMonth(date);
		myLicense.tapOnConfirmBtn();
		myLicense.tapOnLicenseTypeDropdown();
		myLicense.tapOnSelectAALicense();
		myLicense.edu.tapOnUploadBtn();
		myLicense.edu.tapOnChooseFromLibrary();
		myLicense.edu.tapOnSelectPic();
		Mobile.delay(30)
		verifySaveBtn()
		tapOnSaveBtn()
		bankingBtn.tapOnBankingBackBtn();
		Mobile.delay(5);
		bankingBtn.tapOnBankingBackBtn();
		Mobile.delay(10);
		bankingBtn.tapOnBankingBackBtn();
	}
}
