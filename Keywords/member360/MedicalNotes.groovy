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

public class MedicalNotes {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnElectronicHealthRecordOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/electronicHealthRecordOption_android'), defaultTime);
	}

	@Keyword
	def verifyElectronicHealthRecordOption() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/electronicHealthRecordOption_android'), defaultTime);
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def verifyDemographicsOption() {
		try {
			return Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/demographics_android'), defaultTime);
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def tapOnprofileIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/profileIcon_android'), defaultTime);
		Mobile.delay(5);
	}

	@Keyword
	def tapOnMedicalNotesOption() {
		//tapOnExpandAllBtn()
		Mobile.scrollToText("Medical Notes", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/medicalNotesOption_'+os), defaultTime);
//		Mobile.scrollToText('Upload Note', FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	@Keyword
	def tapOnExpandAllBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnAlreadyAddedMedicalNotes(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/notesAddedByProvider_android',['index':index]), defaultTime);
	}

	@Keyword
	def verifyAlreadyAddedMedicalNotesPresent(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/notesAddedByProvider_android',['index':index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnUploadNoteBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/uploadNoteBtn_android'), defaultTime);
	}

	@Keyword
	def verifyUploadNoteBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/uploadNoteBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/uploadBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyUploadBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/uploadBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnChooseFromLibrary() {
		Mobile.delay(5)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/chooseFromLibrary_android'), defaultTime);
	}

	@Keyword
	def tapOnSelectPic() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/MedicalNotes/selectPic_android'), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/selectPic_'+os), defaultTime);
	}

	@Keyword
	def typeInNameOfProviderInput(name,index) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/MedicalNotes/nameOfProviderInput_'+os,['index':index]), name, defaultTime);
	}

	@Keyword
	def typeInNameOfLabInput(name,index) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/Lab Results/nameOfLabInput_android',['index':index]), name, defaultTime);
	}

	@Keyword
	def enterNameInProviderTxtBx(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/MedicalNotes/ProviderNameTxtBx_android'), name, defaultTime);
	}

	@Keyword
	def tapOnProviderSpecialtyDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/providerSpecialtyDrpdwn_'+os), defaultTime);
	}

	@Keyword
	def tapOnCardiologistOption(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/cardiologistOption_android', ["index": index]), defaultTime);
	}
	
	@Keyword
	def tapOnAnySpecialtyOption(specialty, index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/anySpecialtyOption_android', ["specialty":specialty, "index": index]), defaultTime);
	}

	@Keyword
	def tapOnMonthDrpdwn(index=1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/monthDrpdwn_android',['index':index]), defaultTime);
	}

	@Keyword
	def tapOnMarchOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/marchOption_android'), defaultTime);
	}

	@Keyword
	def tapOnAugustOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/AugustOption_android'), defaultTime);
	}

	@Keyword
	def tapOnYearDrpdwn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/yearDrpdwn_'+os,['index':index]), defaultTime);
	}

	@Keyword
	def tapOnYear(year) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/selectYear_'+os, ['year': year]), defaultTime);
	}

	@Keyword
	def tapOnDescriptionInput(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/MedicalNotes/descriptionInput_'+os), text, defaultTime);
	}

	@Keyword
	def tapOnAddAdditionalUpload() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalUpload_'+os), defaultTime);
	}

	@Keyword
	def verifyUploadedNotes(value, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/MedicalNotes/nameOfUploadedMedicalNote_android', ['value': value]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnUploadedNotes(value, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/nameOfUploadedMedicalNote_android', ['value': value]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/saveBtn_'+os), defaultTime);
	}

	@Keyword
	def verifySaveBtnAbsence(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.delay(5)
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Member360/MedicalNotes/saveBtn_'+os), defaultTime, onFailure)
	}

	@Keyword
	def tapOnViewMoreBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.delay(10)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/viewMoreBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchFieldAndEnterTxt(providerName) {
		Mobile.delay(5)
		Mobile.setText(findTestObject('Object Repository/Member/Member360/MedicalNotes/searchMedicalNotesField_android'), providerName, defaultTime,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def clearTxtInSearchField() {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/MedicalNotes/searchMedicalNotesField_android'), defaultTime)
	}

	@Keyword
	def tapOnLabResults() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/labResults_android'), defaultTime);
	}

	@Keyword
	def tapOnViewMoreUploadBtn(index = 2, onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/viewMoreUploadBtn_'+os,['index':index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnChoosePdfOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/choosePDF_'+os), defaultTime);
	}

	@Keyword
	def verifySaveBtnPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/saveBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyViewMoreBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/viewMoreBtn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifySortAndFilterBtnPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/sortAndFilter_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyViewMoreUploadBtnPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Lab Results/uploadInViewMore_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyNoItemsFoundTextPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/NoItems_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyChoosePdfOptnPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/choosePDF_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyTakeNewPhotoOptnPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/takeNewPhoto_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnTakeNewPhotoOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/takeNewPhoto_'+os), defaultTime);
	}
	@Keyword
	def tapOnCameraShutterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/cameraShutterBtn_android'), defaultTime);
		Mobile.delay(10);
	}
	@Keyword
	def tapOnAllowWhileUsingTheAppOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/AllowWhileUsingTheApp_android'), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def verifyChooseFromLibraryOptnPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/chooseFromLibrary_'+os), defaultTime, onFailure);
	}

	@Keyword
	def tapOnTodayAddedMedicalNote(date) {
		Mobile.scrollToText(date, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/todayMedicalNote_android',['date': date]), defaultTime)
	}

	@Keyword
	def verifyFieldNamesOnAddedMedicalNote(name, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/dynamicMedicalNotesFieldName_android', ['name': name]), defaultTime, onFailure)
	}

	@Keyword
	def verifyFieldValues(fieldName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/dynamicFieldValues_android',['fieldName': fieldName]), defaultTime, onFailure)
	}

	@Keyword
	def verifyNoImagesTxt(fieldName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/noImagesText_android',['fieldName': fieldName]), defaultTime, onFailure)
	}
	@Keyword
	def verifyAndTapOnViewMoreBtn(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("View More", FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/viewMoreBtn_android', ['index': index]), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/viewMoreBtn_android', ['index': index]), defaultTime);
	}

	@Keyword
	def verifySortAndFilterBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/sortAndFilterBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSortAndFilterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/sortAndFilterBtn_android'), defaultTime);
	}
	@Keyword
	def verifyMedicalNotesSearchField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/searchMedicalNotes_android'), defaultTime, onFailure);
	}
	@Keyword
	def setTextInMedicalNotesSearchField(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/searchMedicalNotes_android'), text, defaultTime)
	}
	@Keyword
	def verifySearchResult(text,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime ) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/searchMedicalNotes_android',["text":text]), defaultTime, onFailure)
	}
	@Keyword
	def getMedicalNoteProviderNameTxt() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/getMedicalNoteProviderNametxt_android'), defaultTime);
	}

	@Keyword
	def getMedicalNoteProviderNameTxtAfterSearch(index = 2) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/getProviderNameAfterSearch_android',["index":index]), defaultTime);
	}

	@Keyword
	def verifyAndTapOnClearBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/clearBtn_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/clearBtn_android'), defaultTime);
	}
	@Keyword
	def verifyApplyBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/applyBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnApplyBtn() {

		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/applyBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnCloseOnSearchBar() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/closeOnSearchBar_android'), defaultTime);
	}
	@Keyword
	def tapOnRevDocProviderNotesOption(TorF = false) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/revDocProviderNotesOption_android', ["TorF":TorF]), defaultTime);
	}
	@Keyword
	def tapOnSpecialityAtoZOption(TorF = false) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/specialityAtoZOption_android', ["TorF":TorF]), defaultTime);
	}
	@Keyword
	def verifysortAndFilterCount(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/sortAndFilterCount_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySelectedNoteType(noteType, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/selectedNoteType_android', ["noteType":noteType]), defaultTime, onFailure);
	}
	@Keyword
	def verifyDeSelectedNoteType(noteType, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/deSelectedNoteType_android', ["noteType":noteType]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSortAndFilter(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/sortAndFilter_android'), defaultTime)
	}
	@Keyword
	def verifyUpdatedDate(currentDate, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/updatedTextAndDate_android',['date':currentDate]), defaultTime, onFailure);
	}

	@Keyword
	def verifyNameOfProviderInput(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/nameOfProviderInput_'+os,['index':index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyProviderSpecialtyDrpdwn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/providerSpecialtyDrpdwn_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyYearDrpdwn(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/yearDrpdwn_'+os,['index':index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyMonthDrpdwn(index=1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/monthDrpdwn_'+os,['index':index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyDescriptionInput(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/descriptionInput_'+os), defaultTime, onFailure);
	}

	@Keyword
	def verifyAddAdditionalUploadBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/addAdditionalUploadBtn'), defaultTime, onFailure);
	}

	@Keyword
	def verifyHeaderTitle(headerName, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/HeaderOrTitle',['title':headerName]), defaultTime, onFailure);
	}

	@Keyword
	def verifyViewMoreUploadBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/uploadBtnInMedicalNotes_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyClearBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/clearBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyOptionsInSortAndFilter(optionName, TorF = false, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/ViewMore/optionsInSortAndFilter', ["TorF":TorF, 'optionsName': optionName]), defaultTime, onFailure);
	}

	@Keyword
	def verifyCloseButton(title, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/closeButtons', ["sheetTitle":title]), defaultTime, onFailure);
	}

	@Keyword
	def tapCloseButton(title, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/closeButtons', ["sheetTitle":title]), defaultTime);
	}

	@Keyword
	def verifyNoteFields(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/noteFields',['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyCloseButtonExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/closeButton_android'), defaultTime, onFailure);
	}
	@Keyword
	def getMedicalNoteMemberNameTxt() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/getMedicalNoteMemberNametxt_android'), defaultTime);
	}
	@Keyword
	def getProviderNameInMedicalNoteTxt() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/getProviderNameInMedicalNotetxt_android'), defaultTime);
	}
	@Keyword
	def getSpecialityInMedicalNoteTxt() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/getSpecialityInMedicalNotes'), defaultTime);
	}
	@Keyword
	def getApproximateMonthAndYear() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/getApproximateMonthAndYear_android'), defaultTime);
	}
	@Keyword
	def getShortDescription() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/getShortDescription_android'), defaultTime);
	}
	@Keyword
	def tapOnUploadedImageInNote(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/uploadedImageNote_android'), defaultTime)
	}
	@Keyword
	def verifyImageDisplayed(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/uploadedImageNote_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyCloseButtonOnImagePreview(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/closeButtonOnPreview_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyImagePreviewHeader(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/imagePreviewtxt_android'), defaultTime, onFailure);
	}
	def verifyUpoadedFileIsPdf(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/closeButtonInButtom_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnUploadedPdfNote(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/uploadedPdfNote_android'), defaultTime)
	}
	@Keyword
	def verifyTopCloseButtonOnHeader(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/topCloseButtonForPdf_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyCloseButtonInButtom(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/closeButtonInButtom_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyPdfNameHeader(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/pdfMedicalNoteName_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyMemberDetailsExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/memberAddressInNote_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyFileIsImage(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		try {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/imagePreview_andoid'), defaultTime, onFailure)
			return true
		}
		catch(Exception e) {
			return false
		}
	}
	@Keyword
	def verifyFileIsPdf(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		try {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/MedicalNotes/Note/uploadedPdfNote_android'), defaultTime, onFailure);
			return true
		}
		catch(Exception e) {
			return false
		}
	}
	@Keyword
	def tapOnAddedMedicalNote(text, index) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/addedMedicalNote_android',['text': text, 'index': index]), defaultTime);
	}
	@Keyword
	def tapOnMedicalNotes() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/medicalNotesOption_'+os), defaultTime);
	}
	@Keyword
	def tapOnViewPrescriptionSummry(medicationName) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/viewPrescriptionSummary_android',['medicationName': medicationName]), defaultTime);
	}
	@Keyword
	def getCardText(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Provider/HomePage/OpenTasks/Medical Notes/verifyCardNameText_android', ['index' : index]), defaultTime)
	}
}
