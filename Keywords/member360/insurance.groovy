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
import org.openqa.selenium.Rectangle
import org.openqa.selenium.WebElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

import io.appium.java_client.AppiumDriver

import internal.GlobalVariable
import member.MemberAppointments
import member.SelectAddresses
import mobile.Generic
import member.Checkout

public class insurance {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	ElectronicHealthRecord Ehr = new ElectronicHealthRecord();
	MemberAppointments memApt = new MemberAppointments();
	SelectAddresses address = new SelectAddresses();
	Generic gen = new Generic()
	Checkout ch = new Checkout()

	@Keyword
	def tapOnCloseOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/closeOpt_android'), defaultTime);
	}
	@Keyword
	def verifyCloseOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/closeOpt_android'), defaultTime);
	}
	@Keyword
	def verifyChooseFromLibrary() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MedicalNotes/chooseFromLibrary_android'), defaultTime);
	}
	@Keyword
	def verifyUploadPhotoTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/uploadPhotoTitle_android'), defaultTime);
	}
	@Keyword
	def verifyTakeNewPhotoOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/takeNewPhotoOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnChooseFromLibrary() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/chooseFromLibrary_android'), defaultTime);
	}

	@Keyword
	def tapOnSelectPic() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MedicalNotes/selectPic_android'), defaultTime);
	}
	@Keyword
	def fillDetailsInInsuranceScreen() {
		Ehr.tapOnFrontOfCard();
		tapOnChooseFromLibrary();
		Mobile.delay(3)
		tapOnSelectPic();
		Ehr.tapOnBackOfCard();
		tapOnChooseFromLibrary();
		Mobile.delay(3)
		tapOnSelectPic();
		//		Ehr.gen.swipeUp();
		//		Ehr.dem.waitForReUploadBtnVisible();
		//		memApt.tapOnDoneBtn();
		//		Ehr.verifyYourEHRTitle();
	}
	@Keyword
	def verifyEditBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/editOption_android'), defaultTime);
	}
	@Keyword
	def VerifyScreenTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/NotesPage/screenTitle_android'), defaultTime);
	}
	@Keyword
	def VerifyFrontOfInsurance() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/EhrReviewButton/Insurance/frontOfInsurance_android'), defaultTime);
	}
	@Keyword
	def VerifyBackOfInsurance() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/EhrReviewButton/Insurance/backOfInsurance_android'), defaultTime);
	}
	@Keyword
	def VerifyInsuranceName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/HomePage/EhrReviewButton/Insurance/insuranceName_android'), defaultTime);
	}
	@Keyword
	def verifyFrontDropBox() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/frontOfCard_android'), defaultTime);
	}
	@Keyword
	def VerifyBackDropBox() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/addBackOfCard_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def tapOnFrontOfCard() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/frontOfCard_android'), defaultTime);
	}
	@Keyword
	def tapOnEditFrontOfCard() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/editFrontOfCard_android'), defaultTime);
	}
	@Keyword
	def tapOnEditBackOfCard() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/editBackOfCard_android'), defaultTime);
	}
	@Keyword
	def tapOnBackOfCard() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/addBackOfCard_android'), defaultTime);
	}
	@Keyword
	def VerifySearchBar() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/searchBar_android'), defaultTime);
	}
	@Keyword
	def tapOnSearchBar() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/searchBar_android'), defaultTime);
	}
	@Keyword
	def typeInSearchField(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/finalSearchField_android'), text, defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def verifyFirstSearchResult(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/firstSearchResult_android', ['text':text]), defaultTime);
	}
	@Keyword
	def tapOnAnyInsurance(index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/selectAnyInsurance_android', ['index':index]), defaultTime);
	}
	@Keyword
	def verifySaveBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/saveBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Allergies/saveBtn_android'), defaultTime);
	}

	@Keyword
	def verifyInsuranceName() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/InsuranceAfterSelection_android'), defaultTime);
	}
	@Keyword
	def verifyPageTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/uploadPhotoTitle_android'), title)
	}

	@Keyword
	def verifyBackButton(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Insurance/backBtn_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifySubTitles(subtitle, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Insurance/subTitles_andriod', ['subtitle': subtitle]), defaultTime, onFailure)
	}

	@Keyword
	def verifyImage(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.delay(2)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Insurance/image_andriod', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnImage(index = 1, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.delay(2)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Insurance/image_andriod', ['index': index]), defaultTime, onFailure)
	}

	@Keyword
	def zoomTheElement(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Insurance/image_andriod', ['index': index]), defaultTime)
		Mobile.pinchToZoomInAtPosition(200, 300, 20)
		Mobile.getElementWidth
	}

	@Keyword
	def verifySearchField(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Insurance/searchField_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSearchField() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Insurance/searchField_andriod'), defaultTime)
	}

	@Keyword
	def enterTextInsearchField(text) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/Insurance/searchFieldText_andriod'), text, defaultTime)
	}

	@Keyword
	def verifySearchFieldText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Insurance/searchFieldText_andriod', ['insurance':text]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnXBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Insurance/xBtn_andriod'), defaultTime)
	}

	@Keyword
	def verifyListOfInsurance(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/Insurance/listOfInsurance_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def selectAnyOneInsurance(insurance) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/firstSelectedInsurance_android',['insurance': insurance]), defaultTime)
	}

	@Keyword
	def getselectedInsuranceName(insurance) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/firstSelectedInsurance_android',['insurance': insurance]), defaultTime)
	}

	@Keyword
	def verifySelectedInsurance(text) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/Insurance/selectedInsurance_andriod'), text)
	}

	@Keyword
	def verifyInsuranceNotSelected(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/Insurance/selectedInsurance_andriod'), defaultTime, onFailure)
	}

	//Get Insurance Name method
	@Keyword
	def getInsuranceNameText() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insuranceName_android'), defaultTime)
	}

	//New UI - Insurance flow keywords

	@Keyword
	def tapOnInsuranceCheckbox() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/insuranceCheckbox_android'), defaultTime)
	}

	@Keyword
	def tapOnInsuranceNameInput() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/insuranceNameInput_android'), defaultTime)
	}

	@Keyword
	def typeInInsuranceNameInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/insuranceNameInput_android'), name, defaultTime)
	}

	@Keyword
	def tapOnFirstSearchResult(text, index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/firstSearchResult_android', ['text':text, 'index':index]), defaultTime)
	}

	@Keyword
	def tapOnInsurancePlanInput() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/insurancePlanInput_android'), defaultTime)
	}

	@Keyword
	def typeInInsurancePlanInput(name) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/insurancePlanInput_android'), name, defaultTime)
	}

	@Keyword
	def typeInPolicyNumberInput(number) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/policyNumberInput_android'), number, defaultTime)
	}

	@Keyword
	def typeInGroupNumberInput(number) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/groupNumberInput_android'), number, defaultTime)
	}

	@Keyword
	def tapOnEnterInsuranceAddressOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/enterInsuranceAddressOption_android'), defaultTime)
	}

	@Keyword
	def typeInInsurancePhoneInput(number) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/insurancePhoneInput_android'), number, defaultTime)
	}

	@Keyword
	def tapOnEffectiveDateOption(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/effectiveDate_android', ['index':index]), defaultTime)
	}

	@Keyword
	def tapOnTermDateOption(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/termDate_android', ['index':index]), defaultTime)
	}

	@Keyword
	def tapOnConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/confirmBtn_android'), defaultTime)
	}

	@Keyword
	def getAttributeValue(xpath, attribute) {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		WebElement ele = driver.findElementByXPath(xpath);
		String value = ele.getAttribute(attribute);
		println("value2": value)
		return value
	}

	@Keyword
	def selectYear(targetValue) {
		TestObject hours = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/selectYear_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth/2).toInteger()
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = startx
		def endy =  starty + 100

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/year']", "content-desc").split(",")[0].trim().toInteger();
		int i= 1;

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/year']", "content-desc").split(",")[0].trim().toInteger() != targetValue.toInteger() && i <= 15) {

			// Compare the target value with the current value
			if (targetValue.toInteger() < currentValue.toInteger()) {
				Mobile.swipe(startx, starty, endx, starty + 100, FailureHandling.OPTIONAL);
			} else if (targetValue.toInteger() > currentValue.toInteger()) {
				Mobile.swipe(startx, starty, endx, starty - 100, FailureHandling.OPTIONAL);
			} else {
				println("No need to scroll, already at the target value")
			}

			i = i + 1;

		}
	}


	@Keyword
	def fillInsuranceDetailsInEHR(insuranceName, insurancePlan, policyNumber, groupNumber, insurancePhone, fullAddress = GlobalVariable.searchAddress) {
		tapOnInsuranceNameInput();
		typeInInsuranceNameInput(insuranceName)
		tapOnFirstSearchResult(insuranceName)
		tapOnInsurancePlanInput()
		typeInInsurancePlanInput(insurancePlan)
		tapOnFirstSearchResult(insurancePlan)
		fillDetailsInInsuranceScreen()
		Mobile.delay(10)
		typeInPolicyNumberInput(policyNumber)
		typeInGroupNumberInput(groupNumber)
		gen.swipeUpShortLoop(3)
		fillInsuranceAddressForNewUser(fullAddress)
//		tapOnEnterInsuranceAddressOption()
//		address.searchAndSelectAddress(GlobalVariable.searchAddress)
		gen.swipeUp()
		typeInInsurancePhoneInput(insurancePhone)
		tapOnEffectiveStartDateOption(1)
		selectYear('2024')
		tapOnConfirmBtn()
		tapOnEffectiveDatesOption(1)
		selectYear('2026')
		tapOnConfirmBtn()
		//		tapOnSaveBtn();
	}
	@Keyword
	def tapOnEffectiveDatesOption(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/Insurance/effectiveDates_android', ['index':index]), defaultTime)
	}

	@Keyword
	def fillDetailsInInsuranceScreenForExistingAct() {
		tapOnEditFrontOfCard();
		tapOnChooseFromLibrary();
		Mobile.delay(3)
		tapOnSelectPic();
		tapOnEditBackOfCard();
		tapOnChooseFromLibrary();
		Mobile.delay(3)
		tapOnSelectPic();
	}
	@Keyword
	def fillInsuranceDetailsInEHRForExistingAct(insuranceName, insurancePlan, policyNumber, groupNumber, insurancePhone, fullAddress = GlobalVariable.searchAddress) {
		tapOnInsuranceNameInput();
		typeInInsuranceNameInput(insuranceName)
		tapOnFirstSearchResult(insuranceName)
		tapOnInsurancePlanInput()
		typeInInsurancePlanInput(insurancePlan)
		tapOnFirstSearchResult(insurancePlan)
		fillDetailsInInsuranceScreenForExistingAct()
		Mobile.delay(10)
		typeInPolicyNumberInput(policyNumber)
		typeInGroupNumberInput(groupNumber)
		gen.swipeUp()
		//ch.tapOnSearchAddress()
		//address.searchAndSelectAddress(GlobalVariable.searchAddress)

		fillInsuranceAddress(fullAddress)
		gen.swipeUp()
		typeInInsurancePhoneInput(insurancePhone)
		tapOnEffectiveStartDateOption(1)
		selectYear('2024')
		tapOnConfirmBtn()
		tapOnEffectiveDatesOption(1)
		selectYear('2026')
		tapOnConfirmBtn()
		//		tapOnSaveBtn();
	}
	@Keyword
	def tapOnEffectiveStartDateOption(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/selectStartDate_android', ['index':index]), defaultTime)
	}

	@Keyword
	def fillInsuranceAddress(fullAddress) {
		def splittedAddress = splitAddress(fullAddress)
		def addressLine1 = splittedAddress.addressLine1
		def city = splittedAddress.city
		def state = splittedAddress.state
		def zipCode = splittedAddress.zipCode

		def addressLine1Object = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/addressLine1_android');
		def cityObj = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insuranceCity_android');
		def zipCodeObj = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insurancePostalCode_android');
		def stateDropDnObj = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/InsuranceStateDropDn_android');
		def stateCodeObj = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insuranceStateText_android', ['text':state]);

		Mobile.clearText(addressLine1Object, defaultTime, FailureHandling.OPTIONAL)
		Mobile.setText(addressLine1Object, addressLine1, defaultTime, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.clearText(cityObj, defaultTime, FailureHandling.OPTIONAL)
		Mobile.setText(cityObj, city, defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
		if(ch.mbActions.verifyElementNotPresentByText(state, FailureHandling.OPTIONAL)) {
			Mobile.tap(stateDropDnObj, defaultTime)
			Mobile.delay(10);
			Mobile.scrollToText(state, FailureHandling.OPTIONAL)
			Mobile.tap(stateCodeObj, defaultTime)
		}

		Mobile.clearText(zipCodeObj, defaultTime, FailureHandling.OPTIONAL)
		Mobile.setText(zipCodeObj, zipCode, defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	@Keyword
	def fillInsuranceAddressForNewUser(fullAddress) {
		def splittedAddress = splitAddress(fullAddress)
		def addressLine1 = splittedAddress.addressLine1
		def city = splittedAddress.city
		def state = splittedAddress.state
		def zipCode = splittedAddress.zipCode

		def addressLine1Object = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/newUser/addressLine1_android');
		def cityObj = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/newUser/city_android');
		def zipCodeObj = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/newUser/postalcode_android');
		def stateDropDnObj = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/InsuranceStateDropDn_android');
		def stateCodeObj = findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Insurance/insuranceStateText_android', ['text':state]);

		Mobile.clearText(addressLine1Object, defaultTime, FailureHandling.OPTIONAL)
		Mobile.setText(addressLine1Object, addressLine1, defaultTime, FailureHandling.CONTINUE_ON_FAILURE)

		Mobile.clearText(cityObj, defaultTime, FailureHandling.OPTIONAL)
		Mobile.setText(cityObj, city, defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
		if(ch.mbActions.verifyElementNotPresentByText(state, FailureHandling.OPTIONAL)) {
			Mobile.tap(stateDropDnObj, defaultTime)
			Mobile.delay(10);
			Mobile.scrollToText(state, FailureHandling.OPTIONAL)
			Mobile.tap(stateCodeObj, defaultTime)
		}
		gen.swipeUpLittle()
		Mobile.clearText(zipCodeObj, defaultTime, FailureHandling.OPTIONAL)
		Mobile.setText(zipCodeObj, zipCode, defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def splitAddress(fullAddress = GlobalVariable.searchAddress) {
		def addressPattern = /^(.+?),\s*(.+?),\s*([A-Z]{2})\s*(\d{5})$/
		def matcher = fullAddress =~ addressPattern

		if (matcher.matches()) {
			return [
				addressLine1: matcher[0][1],
				city        : matcher[0][2],
				state       : matcher[0][3],
				zipCode     : matcher[0][4]
			]
		}
	}
}
