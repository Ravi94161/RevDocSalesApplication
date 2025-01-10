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
import mobile.Generic
import providerRegistration.Demographics

public class Education {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Demographics demo = new Demographics();
	Generic gen = new Generic();

	@Keyword
	def tapOnEducationOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Education/educationOption_android'), defaultTime);
	}
	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Education/saveBtn_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnAddCertificatesAndAdd(certificateName) {
		def index = 1;
		def count = 0;
		if(verifyAddCerticicates()) {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Education/addCertifications_android'), defaultTime);
			gen.swipeUp();
			setTextInCertificationName(certificateName, index = 1);
			demo.tapOnUploadBtn();
			demo.tapOnchooseFromLibrary();
			demo.tapOnselectPic();
			gen.swipeUp();
			//tapOnSaveBtn()
		}
		else {
			while(!(verifyAddAdditionalCertifications(FailureHandling.OPTIONAL, defaultTime = 10)) && count<=10) {
				gen.swipeUp();
				gen.swipeUp();
			}
			tapOnAddAdditionalCertifications()
			setTextInCertificationName(certificateName, index = 1);
			demo.tapOnUploadBtn();
			demo.tapOnchooseFromLibrary();
			demo.tapOnselectPic();
			gen.swipeUp();
			tapOnSaveBtn();
		}
	}
	@Keyword
	def verifyAddCerticicates(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.scrollToText("Add Certifications", onFailure);
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Education/addCertifications_android'), defaultTime, onFailure)
	}
	@Keyword
	def setTextInCertificationName(text, index = 1) {
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/Education/certificationName_android',["index":index]),text, defaultTime)
	}
	@Keyword
	def verifyAddAdditionalCertifications(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Education/addAdditionalCertifications_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnAddAdditionalCertifications() {
		Mobile.scrollToText("Add Additional Certifications", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Education/addAdditionalCertifications_android'), defaultTime);
	}
	@Keyword
	def tapOnDeleteCertification() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Education/deleteCertification_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Education/deleteBtn_android'), defaultTime);
	}
	@Keyword
	def verifyCertificationName(name, index=1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Education/certificationName_android',["index":index]), name, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def verifyPageTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Education/pageTitle_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyBackBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Education/backBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyText(graduate, value, text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Education/universityText_andriod',["text" : graduate, "value": value]), text)
	}
	@Keyword
	def verifyPlaceholderText(graduate, value, text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Education/placeholderText_andriod', ["text" : graduate, "value": value]), text)
	}
	@Keyword
	def verifyReuploadbtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Education/reuploadBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyPriFilledData(graduate, value, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Education/priFilledData_andriod', ["text" : graduate, "value": value]), defaultTime, onFailure);
	}
	@Keyword
	def verifyData(graduate, value, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Education/verifyData_andriod', ["text" : graduate, "value": value]), defaultTime, onFailure)
	}
	@Keyword
	def verifyEducationDetailsOfSupervisor(value, name) {
		Mobile.verifyElementText(findTestObject('Provider/Provider360/SupervisionNP/medicalLicenseDetails_android', ['value': value]), name)
	}

	@Keyword
	def verifyGraduationUniversityName(id, name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Education/verifyEducationDtails_android', ['id': id]), name)
	}

	@Keyword
	def verifyGraduationStateAndYear(title, name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Provider360/Education/verifyEducationStateAndYearDetails_android', ['title':title]), name)
	}
}
