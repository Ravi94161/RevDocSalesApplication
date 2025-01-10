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
import mobile.Generic

public class FamilyHistory {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();
	ElectronicHealthRecord ehr = new ElectronicHealthRecord();

	@Keyword
	def tapOnFamilyHistoryOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
		Mobile.scrollToText("Family History", FailureHandling.OPTIONAL)
		//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/familyHistoryOption_'+os), defaultTime);
	}

	@Keyword
	def tapOnEditBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/editBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnFamilyHistoryOptionAfterExpand() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/familyHistoryBtnAftrExpnd_andriod'), defaultTime);
	}

	@Keyword
	def verifyEditBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/editBtn_'+os), defaultTime);
	}

	@Keyword
	def verifyOptionText(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/verifyOptionText_'+os,['index':index]), defaultTime);
	}
	@Keyword
	def tapOnLivingBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/livingBtn_android'), defaultTime);
	}
	@Keyword
	def verifyLivingBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/livingBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnAddACancerTypeOrAddAdditionalCancerTypeBtn() {
		Mobile.scrollToText("Cancer", FailureHandling.OPTIONAL);
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/addAcancerTypeBtn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)) {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/addAcancerTypeBtn_android'), defaultTime);
		}
		else {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/addAdditionalCancerType_android'), defaultTime)
		}
	}
	@Keyword
	def setTxtInCancerTypeTxtBx(text, index) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/cancerTypeTxtBx_android',["index":index]), text, defaultTime);
	}
	@Keyword
	def clearTxtInCancerTypeTxtBx(index, onFailure = FailureHandling.OPTIONAL) {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/cancerTypeTxtBx_android',["index":index]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCurrentRdBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/currentRdBtn_android', ['index':index]), defaultTime);
	}
	@Keyword
	def tapOnPastRdBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/pastRdBtn_android', ['index':index]), defaultTime);
	}
	@Keyword
	def tapOnRelationDpDn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/relationDpDn_android'), defaultTime);
	}
	@Keyword
	def tapOnRelationType(relation) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/relationType_android', ["relation":relation]), defaultTime);
	}
	@Keyword
	def verifyElementTxt(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/verifyElementTxt_android',["text":text]), defaultTime, onFailure)
	}
	@Keyword
	def verifyElementTxtNotExist(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/verifyElementTxt_android',["text":text]), defaultTime, onFailure)
	}
	@Keyword
	def getRelationText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/getRelationTxt_android'), defaultTime);
	}
	@Keyword
	def tapOnAdditionalRelativeOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/addAdditionalRelative_android'), defaultTime);
	}
	@Keyword
	def verifyAdditionalRelativeOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/addAdditionalRelative_android'), defaultTime, onFailure);
	}
	@Keyword
	def ScrollToBottomOfFamilyHistoryScreen(onFailure =FailureHandling.OPTIONAL, defaultTime = 10) {
		int count = 0;
		while(Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/addAdditionalRelative_android'), defaultTime, onFailure)) {
			if(count<=5) {
				gen.swipeUp();
				count +=1;
			}
			else {
				break;
			}
		}
	}
	@Keyword
	def tapOnDeleteFamilyMember(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/deleteFamilyMember_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Medical History/deleteBtnConfirm_android'), defaultTime)
	}
	@Keyword
	def tapOnAddBtnForFamilyHistory(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Family History", FailureHandling.OPTIONAL)
		gen.swipeUpLittle();
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/addBtnForFamilyHistory_android'), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/addBtnForFamilyHistory_android'), defaultTime)
	}
	@Keyword
	def tapOnAddAFamilyMemberOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/addaFamilyMemberOpt_android'), defaultTime);
	}
	@Keyword
	def fillDetailsInFamilyHistoryScreen(relation) {
		ehr.dem.tapOnRelationInputBtn();
		ehr.dem.tapOnSelectRelationOption(relation);
		tapOnLivingBtn();
		ehr.verifyAndTapOnNoBtn();
	}
	@Keyword
	def verifyRelationDropDown(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/relationDropDownBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnRelationDropDown() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/relationDropDownBtn_andriod'), defaultTime)
	}
	@Keyword
	def tapOnRelation(relation) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/selectTheYear_andriod',["year": relation]), defaultTime)
	}

	@Keyword
	def verifyDeceasedBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/deceasedBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnDeceasedBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/deceasedBtn_andriod'), defaultTime)
	}
	@Keyword
	def tapOnYearOfDeathDrpDwn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/yearOfDeathDrpDwnBtn_andriod', ["index": index]), defaultTime)
	}
	@Keyword
	def verifyYearOfDeath(text, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/yearOfDeathDrpDwnBtn_andriod', ["index": index]), text)
	}
	@Keyword
	def tapOnYear(year) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/selectTheYear_andriod',["year": year]), defaultTime)
	}
	@Keyword
	def tapOnYesBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/yesBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyYesBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/yesBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyNoBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/noBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyDeleteFamilyMemberBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/deleteFamilyMember_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifySaveAndCloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/saveAndCloseBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def getHealthConditionText() {
		gen.swipeUpShort()
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/getHealthCondition_android'), defaultTime);
	}

	@Keyword
	def selectFamilyMember(familyMember) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/selectFamilyMember_android',["familyMember": familyMember]), defaultTime)
	}
	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Family History/saveBtn_android'), defaultTime)
	}
}
