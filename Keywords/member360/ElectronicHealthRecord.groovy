package member360

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
import com.kms.katalon.core.testobject.ObjectRepository
import mobile.Generic
import member360.Demographics
import member.HomePage

public class ElectronicHealthRecord {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure = FailureHandling.CONTINUE_ON_FAILURE
	Generic gen = new Generic();
	Demographics dem=new Demographics();
	MedicalNotes medicalnotes=new MedicalNotes();
	Medications medications = new Medications();
	HomePage homepage=new HomePage();
	SurgicalHistory  surgicalhistory= new SurgicalHistory();

	@Keyword
	def fillInPharmacyScreen(index) {
		tapOnAddPreferredPharmacyBtn();
		Mobile.delay(8)
		tapOnSelectPharmacyByIndex(index);
		medications.tapOnSavePharmacyBtn();
		Mobile.delay(5)
		dem.tapOnNextBtn();
	}

	@Keyword
	def navigateToEHRSurgicalHistory() {
		homepage.WaitForProfileIconPresent();
		homepage.verifyProfileIcon();
		homepage.tapOnProfileIcon();
		Mobile.delay(15);
		tapOnElectronicHealthRecord();
		surgicalhistory.tapOnSurgicalHistoryOpt();
	}

	@Keyword
	def navigateToEHRFamilyHistory() {
		homepage.WaitForProfileIconPresent();
		homepage.verifyProfileIcon();
		homepage.tapOnProfileIcon();
		Mobile.delay(15);
		tapOnElectronicHealthRecord();
		tapOnFamilyHistoryOption();
	}

	@Keyword
	def tapOnpreferredPharmacyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/preferredPharmacyOption_android'), defaultTime);
	}

	@Keyword
	def tapOnAddPreferredPharmacyBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/addPreferredPharmacyBtn_'+os), defaultTime);
		Mobile.delay(8)
	}

	@Keyword
	def verifyUseCurrentLocationTxtExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/useCurrentLocation_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnUseCurrentLocationOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/useCurrentLocation_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyEnterCityOrZipCodeTxtExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/enterCityOrZipCode_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnEnterCityOrZipCodeOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/enterCityOrZipCode_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSearchResultAddress(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/searchResultAddress_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyCityOrZipCodeTxtFieldExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/cityOrZipCodeTxtFiled_android'), defaultTime, onFailure);
	}

	@Keyword
	def enterCity(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/cityOrZipCodeTxtFiled_android'), text, defaultTime, onFailure);
	}

	@Keyword
	def enterZipCode(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/cityOrZipCodeTxtFiled_android'), text, defaultTime, onFailure);
	}

	@Keyword
	def verifyElementByIndexExist(txt, index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/verifyElementByIndex_android',["txt":txt, "index":index]), defaultTime,onFailure);
	}

	@Keyword
	def tapOnSelectPharmacyByIndex(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/selectPharmacyByIndex_'+os,['index':index]), defaultTime);
	}

	@Keyword
	def getPharmacyDetails(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/getPharmacyName_android',["index":index]), defaultTime);
	}

	@Keyword
	def tapOnEditOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/editOption_android'), defaultTime);
	}

	@Keyword
	def tapOnsaveToPrefferedPharmacyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalPharmacyOpt_android'), defaultTime);
	}

	@Keyword
	def checkPrimaryPharmacyCheckBx(checkBox, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/primaryPharmacyCheckBx_'+os,['checkBox':checkBox]), defaultTime);
	}

	@Keyword
	def verifyPrimaryPharmacyCheckBxElementExist(checkBox, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Preferred Pharmacy/primaryPharmacyCheckBx_'+os,['checkBox':checkBox]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAddAdditionalPharmacyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalPharmacyOpt_android'), defaultTime);
	}
	@Keyword
	def verifyAdvaceSearchBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/advanceSearchBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifySearchPlaceHolder(txt, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/searchPlaceHolder_android',["txt":txt]), defaultTime, onFailure);
	}
	@Keyword
	def verifyBottomSheetTitle(title, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/preferredPharmacyTitle_android'), title, onFailure)
	}
	@Keyword
	def verifySearchOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/searchOption_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifySearchResultsTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/searchResultTitle_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyBottomSheetClose(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/bottomSheetClose_android', ['index' : index]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnBottomSheetClose(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/bottomSheetClose_android', ['index' : index]), defaultTime)
	}
	@Keyword
	def tapOnFamilyHistoryOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/familyHistoryOption_android'), defaultTime);
	}
	@Keyword
	def verifyAdditionalRelativeOpt() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalRelativeOpt_android'), defaultTime);
	}

	@Keyword
	def tapOnAddAdditionalRelativeOpt() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalRelativeOpt_android'), defaultTime);
	}

	@Keyword
	def scrollUntilAddAdditionalBtnFound() {
		for (int i = 0; i < 15; i++) {
			if (Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalRelativeOpt_android'), 10, FailureHandling.OPTIONAL)) {
				// Element found, exit loop
				break
			}

			// Perform scroll action
			gen.swipeUp();
		}
	}
	@Keyword
	def tapOnRelationDropDown() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/relationDropDown_android'), defaultTime);
	}
	@Keyword
	def tapOnBrotherOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/brotherOption_android'), defaultTime);
	}
	@Keyword
	def verifyAreTheyLivingTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/areTheyLivingTxt_android'), defaultTime);
	}
	@Keyword
	def verifyRequiredText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/requiredTxt_android'), defaultTime);
	}
	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/saveBtn_android'), defaultTime);
		Mobile.delay(15);
	}
	@Keyword
	def tapOnAddPlusOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addPlusOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnAddAdditionalRelativeBtn(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalRelativeOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnAddFamilyMemberOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addFamilyMemberOpt_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapOnDeceasesBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/deseasedBtn_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/deseasedBtn_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapOnLivingBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/livingBtn_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/livingBtn_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapOnNoBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/noBtn_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/noBtn_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapOnYesBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/yesBtn_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/yesBtn_android'), defaultTime);
	}
	@Keyword
	def verifyDoesYourFamilyText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/doesYourTxt_android'), defaultTime);
	}
	@Keyword
	def verifyHealthConditionText() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/healthConditionTxt_android'), defaultTime);
	}
	@Keyword
	def verifyDeleteFamilyMemberOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/deleteFamilyMemberOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnDeleteFamilyMemberOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/deleteFamilyMemberOpt_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapOnAsthamaBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Asthma",FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/asthamaBtn_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/asthamaBtn_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapOnPastRadioBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/pastRadioBtn_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/pastRadioBtn_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapOnCurrentRadioBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/currentRadioBtn_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/currentRadioBtn_android'), defaultTime);
	}
	@Keyword
	def verifyYourEHRTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/yourEHRtitle_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnInsurance() {
		tapOnExpandAllBtn()
		Mobile.scrollToText("Insurance", FailureHandling.OPTIONAL)
		gen.swipeUpLittle()
		//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insuranceOption_android'), defaultTime);
	}

	@Keyword
	def tapOnInsuranceTab() {
		Mobile.scrollToText("Insurance", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insuranceOption_android'), defaultTime);
	}

	@Keyword
	def verifyInsuranceOptionExist(isElementExist = true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Insurance", FailureHandling.OPTIONAL);
		if(isElementExist == true) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insuranceOption_android'), defaultTime, onFailure);
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insuranceOption_android'), defaultTime, onFailure);
		}
	}

	@Keyword
	def tapOnEditBtn() {
		Mobile.scrollToText("Edit", FailureHandling.CONTINUE_ON_FAILURE);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/editInsuranceBtn_android'), defaultTime);
	}

	@Keyword
	def verifyBottomSheetPageTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Settings/bottomSheetPageTitle_android'), title, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyInsuranceTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/InsuranceTitle_android'), title, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnSearchBar() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/searchBar_android'), defaultTime);
	}
	@Keyword
	def tapOnAnyInsuranceOption(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/selectAnyInsurance_android',["index":index]), defaultTime);
	}

	@Keyword
	def getInsuranceText(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/getInsuranceText_android',["index":index]), defaultTime);
	}

	@Keyword
	def verifyBottomSheetCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/bottomSheetClose_android'), defaultTime);
	}

	@Keyword
	def verifyAndTapOnSearchField() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/finalSearchField_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/finalSearchField_android'), defaultTime);
	}

	@Keyword
	def enterInsuranceName(insurance) {
		Mobile.setText(findTestObject("Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/finalSearchField_android"), insurance, defaultTime)
	}

	@Keyword
	def enterAdditionalCancerType(name) {
		Mobile.setText(findTestObject("Object Repository/Member/Member360/ElectronicHealthRecord/additionalCancerTypeInputBox_android"),name, defaultTime)
	}

	@Keyword
	def tapOnCurrentBtnForAdditonalCancerType() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/currentRadioBtnForAdditionalCancer_android'), defaultTime)
	}

	@Keyword
	def tapOnCloseBtnInSearchField(index = 2) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/closeBtnInSearchField_android',["index": index]), defaultTime)
	}

	@Keyword
	def verifyAbsenceOfEnteredText(value) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/textInSearchField_android',['value': value]), defaultTime)
	}

	@Keyword
	def selectFirstSuggstedInsurance(insurance) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/firstSelectedInsurance_android',["insurance": insurance]), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/firstSelectedInsurance_android',["insurance": insurance]), defaultTime)
	}

	@Keyword
	def verifyUpdatedInsurance(insurance) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/updatedInsuranceName_android', ['insurance':insurance]), defaultTime)
	}

	@Keyword
	def verifyElementPresent(Options) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/'+ Options), defaultTime,onFailure);
	}
	@Keyword
	def verifyEHRUpdatedDate() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/ehrUpdateDate_android'), defaultTime)
	}

	@Keyword
	def verifyShareElementPresent(Options) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/'+ Options), defaultTime,FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnCloseCrossBtnOne() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/closeCrossBtnOne_android'), defaultTime);
	}
	@Keyword
	def tapOnFirstInsuranceOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/firstInsurance_android'), defaultTime);
	}
	@Keyword
	def tapOnFrontOfCard() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/frontOfCard_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyFrontOfCard(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/frontOfCard_android'), defaultTime);
	}
	@Keyword
	def tapOnBackOfCard() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/addBackOfCard_android'), defaultTime);
	}

	@Keyword
	def verifyBackOfCard(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/addBackOfCard_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnExpandAllBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
	}
	@Keyword
	def verifyExpandAllBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
	}
	@Keyword
	def verifyCloseBtnInEHR() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/closeOpt_android'), defaultTime)
	}
	@Keyword
	def tapOnCloseBtnInEHR() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/closeOpt_android'), defaultTime)
	}
	@Keyword
	def verifyElementNotPresent(Options, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = 10) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/'+ Options), defaultTime,onFailure);
	}

	@Keyword
	def tapOnDocumentsTab() {
		Mobile.scrollToText("Documents", FailureHandling.OPTIONAL)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Documents/documentOption_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Documents/documentOption_android'), defaultTime);
	}

	@Keyword
	def verifyUploadBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Documents/uploadBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Documents/uploadBtn_android'), defaultTime);
	}

	@Keyword
	def verifyMonthAndYearExist(documentName, monthYear) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Documents/monthAndYear_android', ['documentName': documentName, 'monthYear': monthYear]), defaultTime);
	}

	@Keyword
	def tapOnCloseBtnInDocuments(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Documents/closeBtn_android', ['index': index]), defaultTime);
	}

	@Keyword
	def verifyDocumentNameTxtField() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Documents/documentNameTxtField_android'), defaultTime);
	}

	@Keyword
	def enterDocumentName(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/Documents/documentNameTxtField_android'), text, defaultTime);
	}

	@Keyword
	def tapOnDemographicsBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/demographicsOptnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnPreferredPhrmcyBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/preferredPhrmcyBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnMedicalHistoryBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/medicalHistoryBtnAftrExpnd_andriod'), defaultTime)
	}

	@Keyword
	def tapOnMedicalHistoryBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalHistoryOptn_android'), defaultTime)
	}

	@Keyword
	def tapOnSurgicalHistoryBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/surgicalHistoryBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnMedicationBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/medicationBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnAllergiesBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/allergiesBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnSocialHistoryBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/socialHistoryBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnFamilyHistoryBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/familyHistoryBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnLabResultBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/labResultBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnMedicalNotes() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/medicalNotesOption_android'), defaultTime)
	}
	@Keyword
	def tapOnMedicalNotesBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/medicalNotesBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnInsuranceBtnAftrExpnd() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/insuranceBtnAftrExpnd_andriod'), defaultTime)
	}
	@Keyword
	def tapOnShareBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/shareBtn_android'), defaultTime)
	}
	@Keyword
	def verifyShareBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/shareBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnAddAddtionalCancerTypeBtn() {
		Mobile.scrollToText("Cancer", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalCancerType_android'), defaultTime)
	}

	@Keyword
	def tapOnAddAcancerTypeBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAcancerType_android'), defaultTime)
	}

	@Keyword
	def verifyAddAcancerTypeBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAcancerType_android'), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyCancerTypeText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/verifyCancerTypeText_'+os,['text':text]), defaultTime,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnDeleteBtnForAddtionalCancerType() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/deleteBtnForAdditionalCancer_android'), defaultTime)
	}

	@Keyword
	def tapOnDeleteBtnConfirm() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/deleteBtnConfirm_android'), defaultTime)
	}

	@Keyword
	def tapOnElectronicHealthRecord() {
		Mobile.delay(3);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/electronicHealthRecordBtn_android'), defaultTime)
	}

	@Keyword
	def verifyBackOfCardInMedications(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/backBtnOnCard_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyNotTakingAnyMedicationsInMedications(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/notTakingMedicationEmptyRdBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnCheckBoxNotTakingAnyMedicationsInMedications() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/notTakingMedicationEmptyRdBtn_android'), defaultTime)
	}

	@Keyword
	def get(index) {
		return Mobile.getAttribute(findTestObject('Object Repository/Provider/Provider360/MemberPanel/getProcedureType',['index': index]), 'text', defaultTime)
	}

	@Keyword
	def tapOnDateBirth() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/dateOfBirth_andriod'), defaultTime)
	}

	@Keyword
	def verifyDateBirthField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/dateOfBirth_andriod'), defaultTime)
	}

	@Keyword
	def tapOnNextBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/nextBtn_'+os), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def tapOnHealthRecordTab() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/electronicHealthRecordOption_android'), defaultTime);
	}

	@Keyword
	def navigateToEHRDemographicsTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Demographics", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/demographicsBtn_'+os), defaultTime);
	}


	@Keyword
	def navigateToEHRMedicationsTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Medications", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medications/medicationsTab_android'), defaultTime);
	}

	@Keyword
	def navigateToEHRFamilyHistoryTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Family History", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/familyHistoryOption_'+os), defaultTime);
	}

	@Keyword
	def navigateToEHRAllergiesTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Allergies", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/allergiesTab_android'), defaultTime);
	}

	@Keyword
	def navigateToEHRMedicalHistoryTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Personal Medical History", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/medicalHistoryTab_android'), defaultTime)
	}

	@Keyword
	def navigateToEHRSocialHistoryTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Social History", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Social History/socialHistoryOption_'+os), defaultTime);
	}

	@Keyword
	def navigateToEHRInsuranceTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Insurance", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insuranceOption_android'), defaultTime);
	}

	@Keyword
	def navigateToEHRMedicalNotesTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Medical Notes", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/medicalNotesOption_'+os), defaultTime);
	}

	@Keyword
	def navigateToEHRSurgicalHistoryTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Surgical History", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/SurgicalHistory/surgicalHistoryOpt_andriod'), defaultTime)
	}

	@Keyword
	def navigateToEHRLabResultsTab() {
		tapOnHealthRecordTab();
		//tapOnExpandAllBtn(); //If UI changes in EHR, uncomment this line and comment below tap action statement.
		Mobile.scrollToText("Lab Results", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResultsOptn_android'), defaultTime);
	}
}
