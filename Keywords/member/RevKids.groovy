package member

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
import member360.Demographics
import memberSignUp.SignUp
import mobile.Generic
import mobile.MobileActions
import mobile.Utility

public class RevKids {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def Demographics dem= new Demographics();
	def SignUp sgn = new SignUp();
	def Generic gen = new Generic();
	def MobileActions ma = new MobileActions();
	def Utility ul = new Utility();
	
	@Keyword
	def verifyAddProfilePlusIconExists(isExist = true, defaultTime = defaultTime) {
		def failureMsg = "Add Profile Plus Icon notExist"
		if(isExist) {
			ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/addProfilePlusIcon_android'), failureMsg, defaultTime);
		} else {
			failureMsg = "Add Profile Plus Icon Exist"
			ul.verifyElementNotPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/addProfilePlusIcon_android'), failureMsg, defaultTime);
		}
	}

	@Keyword
	def tapOnAddProfilePlusIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/addProfilePlusIcon_android'), defaultTime);
	}

	@Keyword
	def verifyAddADependentBtn(defaultTime = defaultTime) {
		def failureMsg = "Add A Dependent Btn not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/addADependentBtn_android'), failureMsg, defaultTime);
	}
	@Keyword
	def tapOnAddADependentBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/addADependentBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAddCatsAndDogBtn(defaultTime = defaultTime) {
		def failureMsg = "Add Cats And Dog Btn not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/addCatsAndDogBtn_android'), failureMsg, defaultTime);
	}
	@Keyword
	def tapOnAddCatsAndBogBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/addCatsAndDogBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAddDependentsPlusIcon(defaultTime = defaultTime) {
		def failureMsg = "Add Dependents Plus Icon not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/addDependentsPlusIcon_android'), failureMsg, defaultTime);
	}
	@Keyword
	def tapOnAddDependentsPlusIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/addDependentsPlusIcon_android'), defaultTime);
	}

	@Keyword
	def verifyAddPhotoPlusIcon(defaultTime = defaultTime) {
		def failureMsg = "Add Dependents Plus Icon not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/addPhotoPlusIcon_android'), failureMsg, defaultTime);
	}
	@Keyword
	def tapOnAddPhotoPlusIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/addPhotoPlusIcon_android'), defaultTime);
	}

	@Keyword
	def UploadAPhoto() {
		tapOnAddPhotoPlusIcon()
		dem.tapOnChooseFromLibraryBtn();
		dem.tapOnSelectPic();
		Mobile.delay(10);
	}

	@Keyword
	def verifyContinueBtn(defaultTime = defaultTime) {
		def failureMsg = "continue btn not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/continueBtn_android'), failureMsg, defaultTime);
	}

	@Keyword
	def tapOnContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/continueBtn_android'), defaultTime);
	}

	@Keyword
	def verifyIcertifyCheckBox() {
		def failureMsg = "IcertifyCheckBox not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/iCertifyCheckBox_android'), failureMsg, defaultTime);
	}

	@Keyword
	def tapOnIcertifyCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/iCertifyCheckBox_android'), defaultTime);
	}

	@Keyword
	def verifyIAttestCheckBox(defaultTime = defaultTime) {
		def failureMsg = "IAttestCheckBox not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/iAttestCheckBox_android'), failureMsg, defaultTime);
	}

	@Keyword
	def tapOnIAttestCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/iAttestCheckBox_android'), defaultTime);
	}

	@Keyword
	def verifyNewCheckedProfile(index = 1, defaultTime = defaultTime) {
		def failureMsg = "NewCheckedProfile not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/newCheckedProfile_android', ["index":index]), failureMsg, defaultTime);
	}
	@Keyword
	def tapOnNewCheckedProfile(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/newCheckedProfile_android', ["index":index]), defaultTime);
	}

	@Keyword
	def verifyCheckOutBtn(defaultTime = defaultTime) {
		def failureMsg = "CheckOutBtn not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/checkoutBtn_android'), failureMsg, defaultTime);
	}

	@Keyword
	def tapOnCheckOutBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/checkoutBtn_android'), defaultTime);
	}

	@Keyword
	def verifyMemberNameOnProfileDropDn(firstName, defaultTime = defaultTime) {
		def failureMsg = "MemberNameOnProfileDropDn not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/memberProfileName_android', ['firstName':firstName]), failureMsg, defaultTime);
	}

	@Keyword
	def fillDependentsDetails(firstName = "Kidtest", middleName ="k", lastname ='user', tapOnContinue = true) {
		typeInDependentsFirstName(firstName)
		typeInDependentsMiddleName(middleName)
		typeInDependentsLastName(lastname)
		tapOnDependentsDOBField()
		sgn.swipeDownTwoYears(2)
		sgn.tapOnConfirmDobBtn()
		def selectedDOB = getSelectedDOB()
		gen.swipeUp();
		sgn.tapOnMaleBtn()
		tapOnMaleBtnInIdentifyAsSection();
		tapOnIcertifyCheckBox();
		tapOnIAttestCheckBox();
		if(tapOnContinue) {
			tapOnContinueBtn();
		}
		return selectedDOB;
	}

	@Keyword
	def verifyDependentsFirstMiddleAndLastNameFields(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		def isExist = true
		isExist = Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/dependentsFirstName_android'), defaultTime, onFailure);
		isExist = Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/dependentsMiddleName_android'), defaultTime, onFailure);
		isExist = Mobile.verifyElementExist(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/dependentsLastName_android'), defaultTime, onFailure);
		if(!isExist) {
			Mobile.takeScreenshot(FailureHandling.OPTIONAL)
		}
	}

	@Keyword
	def typeInDependentsFirstName(firstName = "Kidtest") {
		def firstNameObj = findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/dependentsFirstName_android');
		Mobile.clearText(firstNameObj, defaultTime);
		Mobile.setText(firstNameObj, firstName, defaultTime);
	}

	@Keyword
	def typeInDependentsMiddleName(middleName ="k") {
		def firstNameObj = findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/dependentsMiddleName_android');
		Mobile.clearText(firstNameObj, defaultTime);
		Mobile.setText(firstNameObj, middleName, defaultTime);
	}

	@Keyword
	def typeInDependentsLastName(lastName ="User") {
		def firstNameObj = findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/dependentsLastName_android');
		Mobile.clearText(firstNameObj, defaultTime);
		Mobile.setText(firstNameObj, lastName, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyDependentsDOBField(defaultTime = defaultTime) {
		def failureMsg = "DependentsDOBField not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/dependentsDateOfBirth_android'), failureMsg, defaultTime);
	}

	@Keyword
	def tapOnDependentsDOBField() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/dependentsDateOfBirth_android'), defaultTime);
	}

	@Keyword
	def tapOnMaleBtnInIdentifyAsSection() {
		Mobile.tap(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/identifyAsMaleBtn_android'), defaultTime);
	}

	@Keyword
	def verifyInputRequiredFieldsMsg(fieldName, message, index = 1, defaultTime = defaultTime) {
		def failureMsg = "InputRequiredFieldsMsg not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/inputFieldsRequiredMsg_android', ["fieldName":fieldName, "msg":message, "index":index]), failureMsg, defaultTime);
	}
	@Keyword
	def verifycheckBoxFillRequiredMsg(contentDesc, message, index = 1, defaultTime = defaultTime) {
		def failureMsg = "checkBoxFillRequiredMsg not found"
		ul.verifyElementPresentAndContinueOnFailure(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/checkboxFillRequiredMsg_android', ["contentDesc":contentDesc, "msg":message, "index":index]), failureMsg, defaultTime);
	}

	@Keyword
	def getSelectedDOB() {
		return Mobile.getText(findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/getDOB_android'), defaultTime)
	}

	@Keyword
	def verifyAddedKidDetailsOnEditCard(name, DOB, gender, index = 1, defaultTime = defaultTime) {
		def pencilGreyObj = findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/pencilGrey_android', ['index':index]);
		def AvatarObj = findTestObject('Object Repository/Member/RevKids And RevPets/RevKids/profileAvatar_android', ['index':index+1])
		def failureMsg1 = "pencilGrey not found"
		def failureMsg2 = "profile Avatar not found"
		ul.verifyElementPresentAndContinueOnFailure(pencilGreyObj, failureMsg1, defaultTime);
		ul.verifyElementPresentAndContinueOnFailure(AvatarObj, failureMsg2, defaultTime);
		ma.verifyElementPresentByText(name);
		ma.verifyElementPresentByText(DOB);
		ma.verifyElementPresentByText(gender);
	}
}
