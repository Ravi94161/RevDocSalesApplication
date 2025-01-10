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
import member.HomePage
import mobile.Generic
import provider360.HomeShippingAddress

public class LabResults {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen=new Generic();

	@Keyword
	def tapOnLabResultsOpt() {
//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
		Mobile.scrollToText("Lab Results", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResultsOptn_android'), defaultTime);
	}

	@Keyword
	def tapOnViewMoreBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/viewMoreBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifySearchField(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/searchField_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def enterTextInSearchField(text) {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/searchField_andriod'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/searchField_andriod'), text, defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def getCardText(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		index = index-1
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/verifycardText_andriod', ['index' : index]), defaultTime)
	}

	@Keyword
	def tapOnFilterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/filterBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnFilterOption(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/selectTheFilterOpt_andriod', ['index': index]), defaultTime)
	}

	@Keyword
	def tapOnApplybtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/applyBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnClearBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/clearBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyFilterCount(value, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/afterFilterCount_andriod'), value)
	}

	@Keyword
	def verifyFilterBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/filterBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyFilterCountNotPresent(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/afterFilterCount_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyOptionSelectedOrNot(option, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/verifySelectedFilterOpt_andriod', ['value' : option]), defaultTime, onFailure)
	}

	@Keyword
	def verifyDeselectedOrNot(option, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/verifyUnselectedOpt_andriod', ['value' : option]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/uploadBtn_andriod'), defaultTime)
	}

	@Keyword
	def uploadBtnInUploadLabPage() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/uploadBtnInUploadLabPage_andriod'), defaultTime)
	}

	@Keyword
	def tapOnChooseFromLibraryOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/chooseFromLibraryOpt_andriod'), defaultTime)
	}

	@Keyword
	def tapOnTakeNewPhotoOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/takeNewPhotoOpt_andriod'), defaultTime)
	}

	@Keyword
	def tapOnChoosePdfOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/choosePdfOpt_andriod'), defaultTime)
	}

	@Keyword
	def tapOnImg() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/selectImg_andriod'), defaultTime)
	}

	@Keyword
	def verifyUplodedImg(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/verifyImgLayout_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnReuploadBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/reuploadBtn_andriod'), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/reuploadBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnOkayBtnWhenCameraOpen() {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/okBtnCameraOpen_andriod'), defaultTime)
		}
		catch(Exception e) {
		}
	}

	@Keyword
	def tapOnTakePhotoBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/takePhotoBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnDoneBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/DoneBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnPdfFile() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/selectPdf_andriod'), defaultTime)
	}

	@Keyword
	def verifyUploadedPdf(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/verifyUploadedPdf_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnWhileUsingTheApp() {
		try {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/whileusingTheAppOp_andriod'), defaultTime)
		}
		catch(Exception e) {
		}
	}

	@Keyword
	def tapOnMoreOptionBTnInChooseFilePage() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/moreOptionBtnInFileChoosePage_andriod'), defaultTime)
	}

	@Keyword
	def tapOnDownloadOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/downloadOpt_andriod'), defaultTime)
	}

	@Keyword
	def tapOnSearchedResult(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/searchedResult_andriod', ['value': text]), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/searchedResult_andriod', ['value': text]), defaultTime)
	}

	@Keyword
	def verifyLabResultPage(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/labResultPageTitle_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCloseBtn(index= 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/closeBtn_andriod',['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyLabResultName(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/labResultName_andriod'), text)
	}

	@Keyword
	def verifyLabelValuesPresentOrNot(value, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/labelValues_andriod', ['value': value]), defaultTime, onFailure)
	}

	@Keyword
	def verifyPdfNameLabel(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/pdfNameNdSize_andriod',['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyPdfSizeLabel(index = 2, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/pdfNameNdSize_andriod',['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyFileNameAfterClickingTheFile(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/fileNameAfterClickingTheFile_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyThePdfFileContentAfterClickingTheFile(onFailure = FailureHandling.OPTIONAL) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/pdfFileContntAfterClickingTheFile_andriod'), defaultTime, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/pdfFileContntAfterClickingTheFile_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyCloseBottomBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/closeBtnBottom_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCloseBottomBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/closeBtnBottom_andriod'), defaultTime)
	}

	@Keyword
	def tapOnFile(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/pdfNameNdSize_andriod',['index': index]), defaultTime)
	}

	@Keyword
	def tapOnCloseBtn(index= 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/closeBtn_andriod',['index': index]), defaultTime)
	}

	@Keyword
	def tapOnViewResultBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/viewResultBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyBarPriorityValue(priority, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/barPriorityName_andriod',['priority':priority]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def verifyBarProgressIsPresentOrNot(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/barProgress_andriod', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyNameOfLabInputBx(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Lab Results/nameOfLabInput_android'), defaultTime)
	}
	
	@Keyword
	def enterTheNameOfLabInputBx(Text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.sendKeys(findTestObject('Object Repository/Member/Member360/Lab Results/nameOfLabInput_android'), Text)
	}

	@Keyword
	def verifyMonthDrpDwn(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/MedicalNotes/monthDrpdwn_android', ["index": index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyYearDrpDwn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/MedicalNotes/yearDrpdwn_'+os), defaultTime);
	}

	@Keyword
	def tapOnMonthDrpDwn(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/monthDrpdwn_android', ["index": index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnYearDrpDwn(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/yearDrpdwn_'+os), defaultTime);
	}
	
	@Keyword
	def verifyAddAddtionalUpload(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Lab Results/addAdditionalUploadBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnFirstLabResult(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Lab Results/firstLabResult_android', ["index" : index]), defaultTime)
	}

	@Keyword
	def verifyLabResults(index = 1, onFailure =FailureHandling.OPTIONAL) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Lab Results/firstLabResult_android', ["index" : index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyLabRecordImage(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Lab Results/labRecordImage_android'), defaultTime)
	}

	@Keyword
	def verifyLabName(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Lab Results/labName_android'), defaultTime)
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/Lab Results/labName_android'), defaultTime)
	}

	@Keyword
	def verifySearchFieldOnViewMorePage(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Lab Results/searchLabResults_android'), defaultTime)
	}

	@Keyword
	def verifyUIOfSortAndFilterPage(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/Lab Results/sortByTxt_android', ['txt': txt]), defaultTime)
	}

	@Keyword
	def tapOnUploadBtnInUploadLabPage() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/uploadBtn_'+os), defaultTime);
	}
	//verify Lab results added by member or patient
	@Keyword
	def verifyLabResultsAddedByMember(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Lab Results/labResultsAddedByMember_android',['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnAnyLabResultsAddedByMember(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Lab Results/labResultsAddedByMember_android',['index': index]), defaultTime)
	}

	@Keyword
	def getLabNameAddedByMember(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/Lab Results/getLabNameAddedByMember_android',['index': index]), defaultTime)
	}

	@Keyword
	def getLabDateAddedByMember(index) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/Lab Results/getLabDateAddedByMember_android',['index': index]), defaultTime)
	}

	@Keyword
	def verifyLabNameElementExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/verifyLabNameElement_android',['index': index]), defaultTime)
	}

	@Keyword
	def verfyLabDateAddedElementExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/verifyLabDateElement_android',['index': index]), defaultTime)
	}

	@Keyword
	def verfyLabImageExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/verifyLabImage_android',['index': index]), defaultTime)
	}

	@Keyword
	def verfyPhotoPreviewImage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/LabResults/verifyPhotoPreviewImage_android'), defaultTime)
	}
}
