package member360

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable
import mobile.Generic

public class Allergies {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen=new Generic();
	@Keyword
	def tapOnAllergiesTab() {
		tapOnExpandAllBtn();
		Mobile.scrollToText("Allergies", FailureHandling.OPTIONAL)
//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/allergiesTab_android'), defaultTime);
	}
	
	@Keyword
	def tapOnExpandAllBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
	}
	
	@Keyword
	def tapOnAllergiesTabAfterExpand() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/allergiesBtnAftrExpnd_andriod'), defaultTime);
	}
	@Keyword
	def verifyUpdatedDateTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/updatedDate_android'), defaultTime);
	}
	@Keyword
	def verifyEditOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/editOption_android'), defaultTime);
	}
	@Keyword
	def verifyNotesOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/notesOption_android'), defaultTime);
	}
	@Keyword
	def verifyCloseOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/closeOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnNotesOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/notesOption_android'), defaultTime);
	}
	@Keyword
	def tapOnNoKnownAllergiesEmptyRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/emptyNoKnownAllergiesRadioBtn_android'), defaultTime);
	}
	@Keyword
	def setTextInAllergiesTxtBx(text, index = 1) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/allergyTxtBx_android', ['index': index]), text, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def clearTextInAllergiesTxtBx(index = 1) {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/allergyTxtBx_android', ['index': index]), defaultTime);
	}
	@Keyword
	def tapOnReactionDropDn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/reactionDropDn_android'), defaultTime);
	}
	@Keyword
	def tapOnDrugReaction() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/Reaction/Drug_android'), defaultTime);
	}
	@Keyword
	def verifySpecificDrugReaction(reaction, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/specificReaction_android',["reaction":reaction]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSpecificDrugReaction(reaction, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/specificReaction_android',["reaction":reaction]), defaultTime, onFailure);
	}
	@Keyword
	def setTextAddANoteTextBox(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/AddaNoteTxtBx_android'), text, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def clearTextAddANoteTextBox() {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/AddaNoteTxtBx_android'), defaultTime);
	}
	@Keyword
	def VerifyBackBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Settings/backBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Settings/backBtn_android'), defaultTime)
	}
	@Keyword
	def VerifyScreenTitle(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/verifyText_'+os, ['txt': text]), defaultTime, onFailure)
	}
	@Keyword
	def VerifyCheckBox(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/CheckBoxBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/CheckBoxBtn_android'), defaultTime)
	}
	@Keyword
	def VerifyCheckedCheckBox(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/CheckedCheckBox_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnVerifiedCheckedCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/CheckedCheckBox_android'), defaultTime)
	}
	@Keyword
	def VerifyRequiredText(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/RequiredText_android',['index' : index]), defaultTime)
	}
	@Keyword
	def tapOnCloseOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/CloseBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnAdditionalAllergyOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/AddAdditionalAllergyOption_android'), defaultTime);
	}
	@Keyword
	def tapOnDeleteAllergyOption(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/DeleteAllergyBtn_android',['index' : index]), defaultTime)
	}
	@Keyword
	def VerifyDeleteAllergyOption(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/VerifyDeleteAllergyTitle_android',['index' : index]), defaultTime)
	}
	@Keyword
	def tapOnDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/DeleteBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/CancelBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSaveAndCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/SaveAndCloseBtn_android'), defaultTime)
	}
	@Keyword
	def verifyElementText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SignUp/verifyText_'+os, ['txt': text]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnAddAdditionalAllergiesOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/AddAdditionalAllergy_'+os), defaultTime);
	}
	@Keyword
	def verifyAllergyTextBxPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/additionalAllergyTxtBox_android'), defaultTime);
	}
	@Keyword
	def verifyReactionDropDownPresent() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/additionalReactionTxtBx_android'), defaultTime);
	}
	@Keyword
	def verifyAdditionalNotesField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/additionalNotes_android'), defaultTime)
	}
	@Keyword
	def verifyAdditionalDeleteOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/additionalDeleteOption_android'), defaultTime)
	}
	@Keyword
	def tapOnAdditonalDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/additionalDeleteOption_android'), defaultTime)
	}
	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/saveBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnAllergiesOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/AllergiesOptn_'+os), defaultTime);
	}
	@Keyword
	def tapOnEditOptn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/EditOptn_'+os), defaultTime);
	}
	@Keyword
	def tapOnAddBtnForAllergies(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Add", FailureHandling.OPTIONAL)
		gen.swipeUpLittle();
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/AddBtnForAllergies_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/AddBtnForAllergies_android'), defaultTime);
	}
	@Keyword
	def fillDetailsInAllergiesScreen(Allergytype, text) {
		setTextInAllergiesTxtBx(Allergytype);
		tapOnReactionDropDn();
		tapOnDrugReaction();
		setTextAddANoteTextBox(text);
	}
	@Keyword
	def tapOnCloseButton(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/MemberServices/Memberships/RevPrivate Provider Search/closeButton_android'), defaultTime, onFailure);
	}
	@Keyword
	def getReactionNameText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/Reaction/getReactionNameText_android'), defaultTime);
	}
	@Keyword
	def verifyProviderNamesInNotes(notes,onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/provideDetailsOne_android',['notes':notes]), defaultTime,onFailure);
	}
	@Keyword
	def setTextInAllergiesTxtBxWithIndex(text, index) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/allergyTxtBxWithIndex_android',['index':index]), text, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def tapOnReactionDropDnWithIndex(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/reactionDropDnWithIndex_android',['index':index]), defaultTime);
	}
	@Keyword
	def tapOnDrugReactionWithIndex(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/Reaction/DrugWithIndex_android',['index':index]), defaultTime);
	}
	@Keyword
	def setTextAddANoteTextBoxWithIndex(text, index) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/AddaNoteTxtBxWithIndex_android',['index':index]), text, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def VerifyDeleteAllergyOptionNotPresent(index) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/VerifyDeleteAllergyTitle_android',['index' : index]), defaultTime)
	}
}
