package provider

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
import mobile.Generic
import provider360.OrderSupplies

import internal.GlobalVariable

public class CreateProgram {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	MobileActions ma = new MobileActions()
	Generic gen = new Generic()
	OrderSupplies sup = new OrderSupplies()

	@Keyword
	def tapOnSetUpBtnBasedOnLabelTxt(label) {
		TestObject testObject = findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/setUpBtnBasedOnLabelTxt_android', ['label': label])
		ma.scrollUntilElementIsVisible(testObject)
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/setUpBtnBasedOnLabelTxt_android', ['label': label]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	//------------------Fill Program Details-----------------
	@Keyword
	def enterProgramName(name) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/enterProgNameField_android'), name, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def tapOnPhotoUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/ProfessionalLicense/uploadBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnchooseFromLibrary() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/chooseFromLibrary_android'), defaultTime)
	}

	@Keyword
	def tapOnselectPic() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/selectPic_android'), defaultTime);
		Mobile.delay(30);
	}

	@Keyword
	def uploadImage() {
		tapOnPhotoUploadBtn()
		tapOnchooseFromLibrary()
		tapOnselectPic()
	}

	@Keyword
	def enterTxtInProgIncludeField(txt) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/programDescriptionField_android'), txt, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def enterTxtInProgDescriptionField(txt) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/programDescription2_android'), txt, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def enterTxtInDurationField(index = 1, num) {
		Mobile.clearText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/inputNumberField_android', ['index': index]), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/inputNumberField_android', ['index': index]), num.toString(), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def tapOnCancellationMonthDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/cancellationMonthsDrpDwn_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnSaveAndContinueBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveAndContinueBtn_android'), defaultTime, onFailure)
	}
	
	@Keyword
	def tapOnSearchField(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/addressSearchBar_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/addressSearchBar_android'), defaultTime, onFailure);
	}
	
	@Keyword
	def tapOnSelectStateDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/selectStateDrpDown_android'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	
	@Keyword
	def tapOnSelectMI() {
		Mobile.scrollToText("MI")
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/stateMI_android'), defaultTime)
	}

	//---------------Program Appointments Page-----------------------
	@Keyword
	def enterAppointmentName(index, name) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/ProgramAppointmentsPage/apptNamefield_android',  ['index': index]), name, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def enterApptDescription(txt) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/ProgramAppointmentsPage/apptDescriptionField_android'), txt, defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL)
	}

	@Keyword
	def tapOnDoneBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/PRM/doneBtn_android'), defaultTime)
	}

	@Keyword
	def enterTxtInSearchproceduresField(proc) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/ProgramAppointmentsPage/searchProceduresField_android'), proc, defaultTime)
	}

	@Keyword
	def addProcedure(cat, proc) {
		ma.tapOnElementByText("Add Procedure");
		Mobile.scrollToText(cat)
		ma.tapOnElementByText(cat);
		Mobile.scrollToText(proc)
		ma.tapOnElementByText(proc);
	}

	@Keyword
	def addAnAppointment(apptName, type, desc, del, index=0) {
		enterAppointmentName(index, apptName)
		enterApptDescription(desc)
		if(type == "Assessment") {
			ma.tapOnElementByText("Assessment Appointment");
		}
		Mobile.scrollToText("Select Delivery Method")
		ma.tapOnElementByText("Select Delivery Method");
		ma.tapOnElementByText(del);
		tapOnDoneBtn()
	}

	@Keyword
	def enterDeliveryMethodPricingDetails(dm,price) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/Program Pricing/houseCallPricingTxtBox_android', ['dm': dm]), price.toString(), defaultTime)
	}

	@Keyword
	def verifyPriceDetails(label, price, index) {
		Mobile.scrollToText(label, FailureHandling.OPTIONAL)
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/Program Pricing/priceUsingLabel_android', ['label': label, 'index': index]), price)
	}

	@Keyword
	def enterIngredientInflationAmt(percent) {
		Mobile.scrollToText("Ingredient Inflation Amount")
		Mobile.clearText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/Program Pricing/ingredientInflationAmt_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/Program Pricing/ingredientInflationAmt_android'), percent.toString(), defaultTime)
	}

	@Keyword
	def enterProgramMarkUpPercentage(percent) {
		Mobile.scrollToText("What percent do you want to mark up")
		Mobile.clearText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/Program Pricing/progMarkupPercentage_android'), defaultTime)
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/Program Pricing/progMarkupPercentage_android'), percent.toString(), defaultTime)
	}

	@Keyword
	def tapOnGoLiveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/goLiveBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnOkayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/okayBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnLivePrograms() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/liveProgramOpt_android'), defaultTime)
	}
	
	@Keyword
	def tapOnMyStaff() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/myStaff_android'), defaultTime)
	}

	@Keyword
	def deselectCheckMembership(membershipType) {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/membershipCheckBx_android', ['membershipType': membershipType]), defaultTime)
	}

	@Keyword
	def fillProgramDetails(label, progName, desc) {
		tapOnSetUpBtnBasedOnLabelTxt(label)
		enterProgramName(progName)
		uploadImage()
		enterTxtInProgIncludeField(desc)
		gen.swipeUp()
		enterTxtInProgDescriptionField(desc)
		sup.tapOnSaveBtn()
	}
	
	@Keyword
	def fillProgramDurationDetails(label, index, duration) {
		tapOnSetUpBtnBasedOnLabelTxt(label)
		gen.verifyElementTextPresent("Duration Months");
		enterTxtInDurationField(index, duration)
		sup.tapOnSaveBtn()
	}
	
	@Keyword
	def setProgramCategory(label, categoryName) {
		tapOnSetUpBtnBasedOnLabelTxt(label)
		gen.verifyElementTextPresent("What category will this program appear under?");
		ma.tapOnElementByText(categoryName);
		sup.tapOnSaveBtn()
		gen.verifyElementTextPresent(categoryName);
	}
	
	@Keyword
	def enterPatientDetails(label, patientsCount = 0) {
		tapOnSetUpBtnBasedOnLabelTxt(label)
		if(patientsCount!=0) {
			setNumberOfMembers(patientsCount = 2);
		}
		sup.tapOnSaveBtn()
		gen.verifyElementTextPresent("REV1, REV+, REVPRIVATE")
	}
	
	@Keyword
	def selectRegion(label, stateOption) {
		tapOnSetUpBtnBasedOnLabelTxt("Region")
		ma.tapOnElementByText(stateOption);
		sup.tapOnSaveBtn()
	}
	
	@Keyword
	def selectPayToOption(label) {
		tapOnSetUpBtnBasedOnLabelTxt(label)
		ma.tapOnElementByText('Savings account');
		sup.tapOnSaveBtn()
	}
	
	@Keyword
	def selectProgramStructure(label, type) {
		tapOnSetUpBtnBasedOnLabelTxt(label)
		ma.tapOnElementByText(type);
		sup.tapOnSaveBtn()
	}
	
	@Keyword
	def setCancellationFee(label, cancelFee, cancelMonths,index2, assessment = null, assessFee = null, index1 = null) {
		tapOnSetUpBtnBasedOnLabelTxt(label)
		if(assessment != null) {
			gen.verifyElementTextPresent("Do you require an assessment appointment?");
			ma.tapOnElementByText(assessment);
			enterTxtInDurationField(index1, assessFee)
		}
		gen.verifyElementTextPresent("Cancellation Fee");
		enterTxtInDurationField(index2, cancelFee)
		tapOnCancellationMonthDrpdwn()
		ma.tapOnElementByText(cancelMonths);
		sup.tapOnSaveBtn()
	}
	
	@Keyword
	def enterPhoneNumber(num) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/phoneNumberField_android'), num, defaultTime)
	}
	
	@Keyword
	def tapOnSearchBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/searchBtn_android'), defaultTime)
	}
	
	//--------------End Fill program Details
	
	@Keyword
	def verifyEditProgramBtn(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/More/MyPrograms/editProgram_android', ['index': index]), defaultTime)
	}
	
	@Keyword
	def verifyEditProgramBtnNotExist(index = 1) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/More/MyPrograms/editProgram_android', ['index': index]), defaultTime)
	}
	
	@Keyword
	def tapOnDraftProgramsBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/More/MyPrograms/draftPrograms_android'), defaultTime)
	}

	@Keyword
	def tapOnEditProgrameBtn(programName) {
		Mobile.tap(findTestObject('Object Repository/Provider/More/editProgramBtnByName_andriod', ["programName": programName]), defaultTime)
	}
	
	@Keyword
	def setNumberOfMembers(membersCount = 1) {
		def membersCountObj = findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/Patient Details/selectNumOfMembers_android');
		Mobile.clearText(membersCountObj, defaultTime);
		Mobile.setText(membersCountObj, membersCount.toString(), defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	
	@Keyword
	def enterDeliveryMethodQuantityDetails(dm,price) {
		Mobile.setText(findTestObject('Object Repository/Provider/More/MyPrograms/CreateProgramPage/Program Pricing/deliveryMethodQuantity_android', ['dm': dm]), price.toString(), defaultTime)
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def setDeliveryMethodQuantityAndPrice(deliveryMethodName, quantity, price) {
		enterDeliveryMethodQuantityDetails(deliveryMethodName, quantity);
		enterDeliveryMethodPricingDetails(deliveryMethodName, price)
	}
}
