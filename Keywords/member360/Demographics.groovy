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
import member.MyAddresses
import member.SelectAddresses
import mobile.Generic
import mobile.MobileActions
import provider360.HomeShippingAddress
import memberSignUp.SignUp

public class Demographics {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	MedicalNotes medicalnotes=new MedicalNotes();
	HomePage homepage=new HomePage();
	HomeShippingAddress address=new HomeShippingAddress();
	Generic gen=new Generic();
	SignUp sign=new SignUp();
	SelectAddresses selectAdd = new SelectAddresses();
	MobileActions ma = new MobileActions();


	@Keyword
	def fillDetailsInDemoGraphicsScreen(fullAddress, relation, relName, phno,language, race, MaritalStatus, email = "abc@gmail.com") {
		sign.tapOnMaleInIIdentifyAsSectionInEHR();
		fillAddressInEHRDemographics(fullAddress);
		sign.setTextInEmailAddressField(email)
		gen.swipeUp();
		fillEmergencyContactsInEHRDemographics(relation, relName, phno);
		fillAdditionalInformationInEHRDemographics(language, race, MaritalStatus);
		tapOnUploadBtn();
		tapOnChooseFromLibraryBtn();
		tapOnSelectPic();
		gen.swipeUp();
		Mobile.delay(40)
		waitForReUploadBtnVisible();
		Mobile.delay(10);
		tapOnNextBtn();
	}
	@Keyword
	def navigateToEHRDemographics() {
		medicalnotes.tapOnElectronicHealthRecordOption();
	}
	@Keyword
	def fillAddressInEHRDemographics(address, onFailure = FailureHandling.OPTIONAL) {
		Mobile.scrollToText("Name of Address (eg: Home, Work) *", onFailure)
		typeInNameOfAddressInput("Work");
		tapOnAddressField();
		selectAdd.setTxtInSearchForAnAddressField(address);
		Mobile.delay(5)
		selectAdd.tapFirstSearchResult();
	}
	@Keyword
	def fillEmergencyContactsInEHRDemographics(relation, relName, phno, onFailure = FailureHandling.OPTIONAL) {
		Mobile.scrollToText("Emergency Contact", onFailure);
		gen.swipeUpLittle();
		tapOnRelationInputBtn();
		tapOnSelectRelationOption(relation);
		Mobile.delay(5)
		typeInEmergencyContactNameInput(relName);
		typeInEmergencyContactPhoneNumberInput(phno);
	}
	@Keyword
	def fillAdditionalInformationInEHRDemographics(language, race, MaritalStatus, onFailure = FailureHandling.OPTIONAL) {
		Mobile.scrollToText("Additional Information *", onFailure);
		//gen.swipeUpLittle();
		//tapOnPreferredLanguagesInputBtn();
		//tapOnSelectRelationOption(language);
		//tapOnPreferredLangSaveBtn();
		tapOnRaceInputBtn();
		tapOnSelectRelationOption(race);
		//tapOnMaritalStatusInputBtn();
		//tapOnSelectRelationOption(MaritalStatus);
		gen.swipeUpLittle();
		//tapOnPreferredLanguagesInputBtn();
		//tapOnSelectRelationOption(language);
		//tapOnPreferredLangSaveBtn();
		tapOnRaceInputBtn();
		tapOnSelectRelationOption(race);
		//tapOnMaritalStatusInputBtn();
		//tapOnSelectRelationOption(MaritalStatus);
	}
	@Keyword
	def tapOnDemographicsBtn() {
		tapOnExpandAllBtn();
		//		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/demographicsBtn_'+os), defaultTime);
	}

	@Keyword
	def tapOnExpandAllBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/expandAllBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnDemographicsAfterExpand() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/demographicsOptnAftrExpnd_andriod'), defaultTime);
	}
	@Keyword
	def tapOnEditBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/editBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnchevronDownBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/chevronDown_android'), defaultTime);
	}
	@Keyword
	def clearTheFirstName() {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/firstNameInput_'+os), defaultTime);
	}

	@Keyword
	def getFirstName() {
		Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/firstNameInput_android'), defaultTime);
	}

	@Keyword
	def verifyFirstNameAndLastNameFields() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/firstNameInput_android'), defaultTime)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/lastNameInput_android'), defaultTime);
	}

	@Keyword
	def typeInFirstNameInput(name) {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/firstNameInputEdit_android'), defaultTime);
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/firstNameInputEdit_android'), name, defaultTime);
	}
	@Keyword
	def typeInFirstNameInputEdit(name) {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/firstNameInputEdit_'+os), defaultTime);
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/firstNameInputEdit_'+os), name, defaultTime);
	}
	@Keyword
	def clearTextFirstNameInputEdit() {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/firstNameInputEdit_'+os), defaultTime);
	}
	@Keyword
	def clearTheMiddleName() {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/middleNameInput_'+os), defaultTime);
	}

	@Keyword
	def verifyMiddleNameInputField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime){
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/middleNameInput_'+os), defaultTime, onFailure);
	}

	@Keyword
	def typeInMiddleNameInput(name) {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/middleNameInput_'+os), defaultTime);
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/middleNameInput_'+os), name, defaultTime);
	}
	@Keyword
	def clearTextMiddleNameInput() {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/middleNameInput_'+os), defaultTime);
	}
	@Keyword
	def clearTheLastName() {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/lastNameInput_'+os), defaultTime);
	}
	@Keyword
	def typeInLastNameInput(name) {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/lastNameInput_android'), defaultTime);
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/lastNameInput_'+os), name, defaultTime);
	}
	@Keyword
	def clearTextLastNameInput() {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/lastNameInput_'+os), defaultTime);
	}
	@Keyword
	def tapOnDobInputBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/dobInputBtn_'+os), defaultTime);
	}
	@Keyword
	def selectYearSeekbar() {
		Mobile.setSliderValue(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/selectYearSeekbar_'+os), 20, defaultTime);
	}
	@Keyword
	def tapOnConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/confirmBtn_'+os), defaultTime);
	}
	@Keyword
	def getTxtDob() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/getTxtDob_'+os), defaultTime);
	}

	@Keyword
	def selectSex(index= 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Registration/Demographics/selectSexInRegistration_andriod', ["index": index]), defaultTime)
	}

	@Keyword
	def setTextInEmailAddressField(email) {
		Mobile.scrollToText("Email Address")
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emailAddressField_android'), email, defaultTime);
	}

	@Keyword
	def tapOnCountryInputBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/countryInputBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSelectCountryOption(text, index = 2) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/selectCountryOption_android', ['country': text, 'index':index]), defaultTime);
	}
	@Keyword
	def tapOnFemaleBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/femaleBtn_android', ['index': index]), defaultTime);
	}
	@Keyword
	def tapOnMaleBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/maleBtn_'+os, ['index': index]), defaultTime);
	}
	@Keyword
	def typeInNameOfAddressInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/nameOfAddressInput_android'), name, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def tapOnAddressField(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/addressField_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyAddressField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/addressField_android'), defaultTime, onFailure)
	}
	@Keyword
	def typeInAddress1Input(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/address1Input_'+os), name, defaultTime);
	}
	@Keyword
	def typeInAddress2Input(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/address2Input_android'), name, defaultTime);
	}

	@Keyword
	def verifyAddress2Placeholder(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/address2Input_android', ['text':text]), defaultTime, onFailure);
	}
	@Keyword
	def typeInCityInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/cityInput_'+os), name, defaultTime);
	}
	@Keyword
	def tapOnSelectStateInputBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/selectStateInputBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnSelectStateOption(state) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/selectStateOption_'+os, ['state': state]), defaultTime);
	}
	@Keyword
	def typeInZipInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/zipInput_'+os), name, defaultTime);
	}

	@Keyword
	def tapOnAddFamilyMemberBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/addFamilyMember_android'), defaultTime);
	}
	@Keyword
	def tapOnRelationInputBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/relationInputBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSelectRelationOption(option, index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/selectRelationOption_android', ['option': option, 'index': index]), defaultTime);
	}
	@Keyword
	def tapOnSelectOption(option) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/selectOption_'+os, ['option': option]), defaultTime);
	}
	@Keyword
	def typeInEmergencyContactNameInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/emergencyContactNameInput_android'), name, defaultTime);
	}
	@Keyword
	def typeInEmergencyContactPhoneNumberInput(name) {
		Mobile.delay(5);
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/emergencyContactPhoneNumberInput_android'), name, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def clearEmergencyContactPhoneNumberInput(onFailure = FailureHandling.OPTIONAL) {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/emergencyContactPhoneNumberInput_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnPreferredLanguagesInputBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/preferredLanguagesInputBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnPreferredLangSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/preferredLangSaveBtn_'+os), defaultTime);
	}
	@Keyword
	def getTextPreferredLang() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/getTextPreferredLang_'+os), defaultTime);
	}
	@Keyword
	def tapOnRaceInputBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/raceInputBtn_'+os), defaultTime);
	}
	@Keyword
	def getTextRace() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/getTextRace_'+os), defaultTime);
	}
	@Keyword
	def getMemberIdValue() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/MemberIdValue_android'), defaultTime);
	}
	@Keyword
	def verifyMemberIdIsTenDigits(String number, int expectedDigits) {
		if (number == null || !number.matches("\\d{10}")) {
			throw new Exception('Number does not have 10 digits!')
		}
	}
	@Keyword
	def tapOnMaritalStatusInputBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/maritalStatusInputBtn_'+os, ['index':index]), defaultTime);
	}
	@Keyword
	def getTextMaritalStatus() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/getTextMaritalStatus_'+os), defaultTime);
	}
	@Keyword
	def tapOnReuploadBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def testObject = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/reuploadBtn_'+os)
		ma.scrollUntilElementIsVisible(testObject, 5)
		Mobile.tap(testObject, defaultTime, onFailure);
	}
	@Keyword
	def verifyUploadBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def testObject = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/uploadBtn_'+os)
		ma.scrollUntilElementIsVisible(testObject, 5)
		Mobile.verifyElementExist(testObject, defaultTime, onFailure);
	}
	@Keyword
	def verifyElementText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/verifyElementText_android',["text":text]), defaultTime, onFailure);
	}
	@Keyword
	def verifyCloseOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/closeOption_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifychooseFromLibraryOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/chooseFromLibraryOpt_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyBrowseFileOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/browseFilesOpt_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyTakeNewPhotoOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/takeNewPhotoOpt_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyReuploadBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Reupload", onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/reUploadBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/uploadBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnReUploadBtn() {
		Mobile.scrollToText("Reupload", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/reUploadBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnChooseFromLibraryBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/chooseFromLibraryBtn_'+os), defaultTime);
	}
	@Keyword
	def tapOnPhotoOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/photoOption_android'), defaultTime);
	}
	@Keyword
	def tapOnSelectPic(index = 2) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/selectPic_'+os, ['index':index]), defaultTime);
	}
	@Keyword
	def tapOnSaveBtn() {

		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/saveBtn_android'), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/saveBtn_android'), defaultTime);
			Mobile.delay(20);
		}
	}
	@Keyword
	def tapOnSaveAndCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/saveAndCloseBtn_'+os), defaultTime);
	}
	@Keyword
	def verifySaveAndCloseBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/saveAndCloseBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnNextBtn() {
		Mobile.delay(15);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/nextBtn_'+os), defaultTime, FailureHandling.OPTIONAL);
	}
	@Keyword
	def verifyNextBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/nextBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/backBtn_'+os), defaultTime);
	}
	@Keyword
	def verifyBackBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/backBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def verifyDemographicsDetailsText(field, text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/verifyDemographicsDetailsText_'+os, ['field': field, 'text': text]), defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyDemographicsFieldData(field, text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/verifyDetails_'+os, ['field': field, 'text': text]), defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyDetailsContainsText(field, text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/verifyDetailsContainsText_'+os, ['field': field, 'text': text]), defaultTime,FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyDOBDetailsInDemographics(date) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/dobverification_android',['date': date]), defaultTime)
	}
	@Keyword
	def verifyPhoto() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/verifyPhoto_android'), defaultTime);
	}
	@Keyword
	def tapOnCloseBtn() {
		//		try {
		Mobile.delay(10);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/closeBtn_'+os), defaultTime);
		//		} catch(Exception e) {
		//			println("Button not found")
		//		}
	}
	@Keyword
	def verifyExistWithoutSavingText(failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/existWithoutSavingTxt_andriod'), defaultTime, failure)
	}
	@Keyword
	def verifyExistingPageDescription() {
		String text = "If you leave this screen without saving all of your information will be lost. Please complete all required fields and save.";
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/existingPopupPageDescription_andriod'), text);
	}
	@Keyword
	def verifyExitWithoutSaveBtn(failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/exitWithoutSaveBtn_andriod'), defaultTime, failure)
	}
	@Keyword
	def tapOnExitWithoutSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/exitWithoutSaveBtn_andriod'), defaultTime);
	}
	@Keyword
	def verifyCancelBtnInExitWithoutSavePage(failure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/cancelBtnExistWithoutSavePage_andriod'), defaultTime, failure)
	}
	@Keyword
	def taponExitWithoutSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/exitWithoutSaveBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyExitWithoutSavePopupPageNotPresent(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/closeOption_'+os), defaultTime, onFailure);
	}
	@Keyword
	def tapOnCancel() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/cancelBtnExistWithoutSavePage_andriod'), defaultTime);
	}
	@Keyword
	def tapOnAddAdditionalEmergencyContactBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/addAdditionalEmergencyContactBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyAddAdditionalEmergencyContactBtnInEmergencyContactPage(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/addAdditionalEmergencyContactBtn_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def verifyRelationFieldInEmergencyContactPage(onFailure =FailureHandling.CONTINUE_ON_FAILURE, index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/relationFieldInEmergencyContactPage_andriod',['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def verifyEmergencyContactNameFieldInEmergencyContactPage(onFailure =FailureHandling.CONTINUE_ON_FAILURE, index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emergencyContactNameFieldInEmergencyContactPg_andriod', ['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def verifyEmergencyContactPhnNumFieldInEmergencyContactPage(onFailure =FailureHandling.CONTINUE_ON_FAILURE, index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emergencyContactPhnNumInEmrgncyContctPg_andriod', ['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def verifySaveBtnInEmergencyContactPage(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/saveBtn_'+os), defaultTime, onFailure);
	}
	@Keyword
	def deleteEmergencyContactBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/deleteEmergencyContactBtn_andriod', ['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def enterEmergencyContactNameInEmergencyContactPage(index, text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emergencyContactNameFieldInEmergencyContactPg_andriod', ['index': index]), text, defaultTime )
	}
	@Keyword
	def enterEmergencyContactPhnNumInEmergencyContactPage(index, text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emergencyContactPhnNumInEmrgncyContctPg_andriod', ['index': index]), text, defaultTime);
	}
	@Keyword
	def verifyRelationFieldValue(index, value) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/relationFieldValue_andriod', ['index' : index]), value)
	}
	@Keyword
	def verifyEmergencyContactName(index, value) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emergencyContactNameFieldInEmergencyContactPg_andriod', ['index': index]), value);
	}
	@Keyword
	def verifyEmergencyContactPhnNum(index, value) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emergencyContactPhnNumInEmrgncyContctPg_andriod', ['index': index]), value);
	}
	@Keyword
	def tapdeleteEmergencyContactBtn(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/deleteEmergencyContactBtn_andriod', ['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnConfirmEmrgncyCnctDeltBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/confirmEmergencyCntctDltBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifydeleteEmergencyContactBtnNotExist(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/deleteEmergencyContactBtn_andriod', ['index': index]), defaultTime, onFailure)
	}
	@Keyword
	def verifyRelationFieldValueNotExist(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/relationFieldValue_andriod', ['index' : index]), defaultTime, onFailure)
	}
	@Keyword
	def verifyEmergencyContactNameNotExist(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emergencyContactNameFieldInEmergencyContactPg_andriod', ['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyEmergencyContactPhnNumNotExist(index, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/emergencyContactPhnNumInEmrgncyContctPg_andriod', ['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def getEmergencyContactDetailsInDempgraphicsPage() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/emergencyContactdetails_andriod'), 0);
	}
	@Keyword
	def verifyStringMatching(text, text1) {
		String regexPattern = ".*" + text1 + ".*";

		// Use verifyMatch with the dynamically constructed regular expression pattern
		Mobile.verifyMatch(text, regexPattern, true, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def verifyDemographicsUILabelsForExistingAccount(value, onFailure =FailureHandling.CONTINUE_ON_FAILURE ) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/demographicsUIlabels_andriod', ['value': value]), defaultTime, onFailure);
	}
	@Keyword
	def verifyEditBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/editBtn_'+os), defaultTime, onFailure)
	}
	@Keyword
	def verifyGovernmentIssuedIdInExistingUser(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/governmentIssuedIdPht_andriod'), defaultTime, onFailure)
	}
	@Keyword
	def waitForReUploadBtnVisible(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/reUploadBtn_android'), defaultTime, onFailure);
		Mobile.delay(10)
	}
	@Keyword
	def getScreenTitle() {
		return Mobile.getText(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/screenTitle_android'), defaultTime);
	}
	@Keyword
	def verifyValidationMsg(value, text, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/validationmsg_andriod', ['value': value]), text, onFailure)
	}
	@Keyword
	def verifyAddressValidationMsg(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/searchAddressErrorMsg_android'), text, onFailure)
	}
	@Keyword
	def verifyErrorMsg(value, text, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/requiredErrorMsg_andriod', ['value': value]), text, onFailure)
	}
	@Keyword
	def verifyValidationErrorMsg(value, text, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/errorMsg_andriod', ['value': value]), text, onFailure)
	}
	@Keyword
	def verifyIdentifyRequiredMsg(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/identifyAsRequiredMsg_andriod'), text, onFailure)
	}
	@Keyword
	def tapOnDateOfBirthField() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/dateOfBirthField_andriod'), defaultTime)
	}
	@Keyword
	def tapOnConfirmBtnOfDateOfBirth() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/confirmBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnAnyPicFromLib() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/SelectAnyPicFromLib_android'), defaultTime);
	}
	@Keyword
	def verifySelectedPicExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/EditDetailsPage/SelectAnyPicFromLib_android'), defaultTime);
	}
	@Keyword
	def fillAddressInEHRDemographicsForLatest(address, onFailure = FailureHandling.OPTIONAL) {
		Mobile.scrollToText("Name of Address (eg: Home, Work) *", onFailure)
		typeInNameOfAddressInput("Work");
		tapOnAddressField();
		selectAdd.setTxtInSearchLocationsFieldForLatest(address);
		selectAdd.tapFirstSearchResult();
	}
	@Keyword
	def typeInSearchAddress(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/MyAddress/searchAddressInput_android'),text, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def fillMyAddressInProfile(address, onFailure = FailureHandling.OPTIONAL) {
		Mobile.scrollToText("Address *", onFailure)
		tapOnAddressField();
		typeInSearchAddress(address);
		selectAdd.tapFirstSearchResult();
		Mobile.delay(5);
		Mobile.scrollToText("Name of Address (eg: Home, Work) *", onFailure)
		typeInNameOfAddressInput("Work");
	}
	//verifying the ui of Additional info screen
	@Keyword
	def verifyDateOfBirthField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/dateOfBirthField_andriod'), defaultTime)
	}
	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Login/continueBtn_android'), defaultTime)
	}

	@Keyword
	def verifyContinueBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Login/continueBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnDateBirth() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/dateOfBirth_andriod'), defaultTime)
	}

	@Keyword
	def verifyDateBirthField() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/dateOfBirth_andriod'), defaultTime)
	}

}
