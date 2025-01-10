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

public class Procedures {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	providerRegistration.Procedures proc = new providerRegistration.Procedures();
	MobileActions ma = new MobileActions()
	

	@Keyword
	def tapOnProfileIcon() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/profileIcon_android'), defaultTime)
	}
	@Keyword
	def verifyProfileIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/profileIcon_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnProviderProfileOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/providerProfileOption_android'), defaultTime)
	}

	@Keyword
	def tapOnProceduresOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/proceduresOption_android'), defaultTime)
	}

	@Keyword
	def tapOnPrimaryCareProcedure() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedure_android'), defaultTime)
	}

	@Keyword
	def tapOnGeneralCareProcedure() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/generalCareProcedure_android'), defaultTime)
	}

	@Keyword
	def tapOnMigraineProcedure() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/migraineProcedure_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveProceduresBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/saveProceduresBtn_android'), defaultTime)
	}

	@Keyword
	def verifySaveProceduresBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/saveProceduresBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnGeneralProcedureViewMorebtn() {
		TestObject testObject = findTestObject('Object Repository/Provider/Provider360/Procedures/generalProcedureViewMore_andriod')
		ma.scrollUntilElementIsVisible(testObject)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/generalProcedureViewMore_andriod'), defaultTime)
	}

	@Keyword
	def verifyTheProcedureProfileTitle(failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureProfileTitle_android'), defaultTime, failure)
	}

	@Keyword
	def verifyCloseBtn(failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/closeBtn_android'), defaultTime, failure)
	}

	@Keyword
	def verifyTheAboutText(failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/aboutText_andriod'), defaultTime, failure)
	}

	@Keyword
	def verifyVideoFrameLayout(failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/videoFrameLayout_andriod'), defaultTime, failure)
	}

	@Keyword
	def tapProcedureDetails() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureDetails_andriod'), defaultTime)
	}

	@Keyword
	def verifyProcedureDeliveryMethods(failure = FailureHandling.CONTINUE_ON_FAILURE, num) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureDeliveryMethods_andriod',['num': num]), defaultTime, failure)
	}

	@Keyword
	def VerifyProcedureProviders(failure = FailureHandling.CONTINUE_ON_FAILURE, num) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureProviders_andriod', ['num': num]), defaultTime, failure);
	}

	@Keyword
	def verifycategory(failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/category_andriod'), defaultTime, failure);
	}

	@Keyword
	def checkTheLungsProceduresCheckBox(name= 'Lungs') {
		try {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/checkBoxesOfProceduresBeforeCheck_andriod',['name': name]), defaultTime, FailureHandling.OPTIONAL);
		}
		catch(Exception e) {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/lungsProcedureCheckbox_android'), defaultTime)
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/lungsProcedureCheckbox_android'), defaultTime)
		}
	}
	@Keyword
	def checkThePrimaryCareProceduresCheckBox(name = "Primary Care") {
		try{
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/checkBoxesOfProceduresBeforeCheck_andriod',['name': name]), defaultTime, FailureHandling.OPTIONAL);
		}
		catch(Exception e) {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedureCheckbox_android'), defaultTime);
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedureCheckbox_android'), defaultTime)
		}
	}

	@Keyword
	def verifyProcedureCheckBoxChecked(name) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/Procedures/checkBoxesOfProceduresBeforeCheck_andriod',['name': name]), defaultTime)
	}

	//	@Keyword
	//	def verifyPrimaryCareProcedureCheckBoxChecked() {
	//		Mobile.verifyElementChecked(findTestObject('Object Repository/Provider/Provider360/Procedures/primaryCareProcedureCheckbox_android'), defaultTime)
	//	}

	@Keyword
	def tapOnSaveProcedureBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/saveProceduresBtn_android'), defaultTime);
	}

	@Keyword
	def verifyTheProcedureName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureName_andriod'), defaultTime)
	}

	@Keyword
	def verifyProcedureTime() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureTime_andriod'), defaultTime)
	}

	@Keyword
	def verifyHsaFsaHra() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/hsa_Fsa_Hra_andriod'), defaultTime)
	}

	@Keyword
	def verifyPostCareInstructionsOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/postCareInstructionsInProfile_android'), defaultTime);
	}

	@Keyword
	def verifyManufacturerDocumentationOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/manufacturerDocumentationinProfile_andriod'), defaultTime)
	}

	@Keyword
	def tapOnManufacturerDocumentationOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/manufacturerDocumentationinProfile_andriod'), defaultTime)
	}


	@Keyword
	def verifyTheProcedureStepsOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/procedureStepsInProfile_android'), defaultTime)
	}

	@Keyword
	def tapOnDownloadBtnInManufacturerDocumentOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/downloadBtnInManufacturerDocmnt_andriod'), defaultTime)
	}

	@Keyword
	def verifyTheDownloadedFile() {
		try {
			Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/downloadedDocument_andriod'), defaultTime)
		}
		catch(Exception e) {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/downloadFileAgainPopCancelBtn_android'), defaultTime);
			Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/Procedures/downloadedDocument_andriod'), defaultTime)
		}
	}

	@Keyword
	def tapOnThreeDotsInChromePage() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/threeDotsInChromePage_andriod'), defaultTime);
	}

	@Keyword
	def tapOnDownloadOptionInChrome() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/downloadBtnInChrome_andriod'), defaultTime);
	}

	@Keyword
	def verifydownloadFileAgainPopCancel() {
		Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Procedures/downloadFileAgainPopCancelBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnCancelBtnOnChrome(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/cancelBtnOnChrome_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCrossIconOnChrome(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/crossIconOnChrome_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCategoryCbxChecked(categoryType, onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementChecked(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/HouseCallProcedure/procedureCategoryEmptyCheckBx_android', ['categoryType': categoryType]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnEmptyCategoryCbx(categoryType, onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		if (!Mobile.verifyElementChecked(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/HouseCallProcedure/procedureCategoryEmptyCheckBx_android', ['categoryType': categoryType]), defaultTime, onFailure)) {
			Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Procedures/Procedure Profile/HouseCallProcedure/procedureCategoryEmptyCheckBx_android', ['categoryType': categoryType]), defaultTime, onFailure)
		}
	}

	@Keyword
	def navigateHomeScreenToProviderProcedures() {
		tapOnProfileIcon();
		tapOnProviderProfileOption();
		proc.tapOnProceduresOption();
	}
}
