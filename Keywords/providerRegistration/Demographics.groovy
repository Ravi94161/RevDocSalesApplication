package providerRegistration

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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.Dimension
import mobile.MobileActions

import internal.GlobalVariable

public class Demographics {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	MobileActions ma = new MobileActions()

	@Keyword
	def tapOnProviderTypeDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/providerTypeDropdown_android'), defaultTime)
	}

	@Keyword
	def selectProviderType(type) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/providerType_'+os, ['providerType': type]), defaultTime)
	}

	@Keyword
	def verifySpecialityDrpdwn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/Demographics/specialityDrpdwn_android'), defaultTime)
	}

	@Keyword
	def verifySpecialityDrpdwnsAbsence() {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Registration/Demographics/specialityDrpdwn_android'), defaultTime)
	}

	@Keyword
	def tapOnSpecialityDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/specialityDrpdwn_android'), defaultTime)
	}

	@Keyword
	def getNameOnSpecialityDpn() {
		Mobile.getText(findTestObject('Object Repository/Provider/Provider360/Demographics/selectedNameOnSpecialityDpn_android'), defaultTime)
	}

	@Keyword
	def verifyBottomSheetTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Demographics/bottomSheetTitle_'+os), title)
	}

	@Keyword
	def tapOnNursePractitionerOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/nursePractitionerOption_android'), defaultTime)
	}

	@Keyword
	def typeInYearsFromInputBx(yearsfrom) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Demographics/yearsFromInputBx_android'), yearsfrom, defaultTime)
	}
	@Keyword
	def clearYearsFromInputBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/Demographics/yearsFromInputBx_android'), defaultTime)
	}
	@Keyword
	def typeInYearsToInputBx(yearsto) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Demographics/yearsToInputBx_android'), yearsto, defaultTime)
		Mobile.hideKeyboard();
	}
	@Keyword
	def clearYearsToInputBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/Demographics/yearsToInputBx_android'), defaultTime)
		Mobile.hideKeyboard();
	}

	@Keyword
	def typeInFirstNameInputBx(firstname) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Demographics/firstNameInputBx_android'), firstname, defaultTime)
		Mobile.hideKeyboard();
	}
	@Keyword
	def clearFirstNameInputBx() {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/Demographics/firstNameInputBx_android'), defaultTime)
		Mobile.hideKeyboard();
	}

	@Keyword
	def typeInMiInputBx(mi) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Demographics/miInputBx_android'), mi, defaultTime)
	}

	@Keyword
	def tapOnDateOfBirth() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Demographics/dateOfBirth_android'), 60)
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/dateOfBirth_android'), 60)
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width * 2 / 3  // Change to 2/3rd from the left
		int endX = startX
		int startY = device_Height * 0.70  // Change to 70% from the top
		int endY = device_Height * 0.80  // Change to 80% from the top (or adjust as needed)

		// Swipe down the year field
		Mobile.swipe(startX, startY, endX, endY) //swiping 3 years down for every swipe
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def tapOnConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/confirmBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/uploadBtn_android'), defaultTime)
		verifyTextPresent("Browse Files")
		verifyTextPresent("Take new photo")
		verifyTextPresent("Choose from library")
	}
	@Keyword
	def verifyUploadBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/Demographics/uploadBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnchooseFromLibrary() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/chooseFromLibrary_android'), defaultTime)
	}

	@Keyword
	def tapOnBrowseFiles() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Demographics/browseFiles_android'), defaultTime);
	}

	@Keyword
	def tapOnselectPic() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/selectPic_android'), defaultTime);
		Mobile.delay(30);
	}
	
	@Keyword
	def tapOnGovIdCameraShutterBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Demographics/horizontalCameraShutterBtn_android'), defaultTime)
	}

	@Keyword
	def typeInSocialSecurityNumberInputBx(ssn) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Demographics/socialSecurityNumberInputBx_android'), ssn, defaultTime)
	}

	@Keyword
	def typeInFaxNumberInputBx(fax) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Demographics/faxNumberInputBx_android'), fax, defaultTime)
	}

	@Keyword
	def tapOnNextBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/nextBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/backBtn_android'), defaultTime)
	}

	@Keyword
	def verifyYearsFromInputBxElementText(year) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Demographics/yearsFromInputBx_android'),year)
	}

	@Keyword
	def verifyYearsToInputBxElementText(year) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Demographics/yearsToInputBx_android'), year)
	}

	@Keyword
	def verifyFirstNameInputBxElementText(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Demographics/firstNameInputBx_android'), name)
	}

	@Keyword
	def verifyMiInputBxElementText(mi) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Demographics/miInputBx_android'), mi)
	}

	@Keyword
	def verifyFaxNumberInputBxElementText(fax) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Demographics/faxNumberInputBx_android'), fax)
	}

	@Keyword
	def verifySocialSecurityNumberInputBxElementText(ssn) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Demographics/socialSecurityNumberInputBx_android'), ssn)
	}

	@Keyword
	def verifyExitWithoutSavingPopup() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/Demographics/exitWithoutRegTitle_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/Demographics/closeBtn_android'), defaultTime)
	}

	@Keyword
	def verifyCancelBtn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/Demographics/cancelBtn_android'), defaultTime)
	}

	@Keyword
	def taponExitWithoutSavingBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/exitWithoutSavingBtn_android'), defaultTime)
	}

	@Keyword
	def verifyCountryDrpdwn() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Registration/Demographics/countryDrpDwn_android'), defaultTime)
	}

	@Keyword
	def tapCountryDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/countryDrpDwn_android'), defaultTime)
		verifyTextPresent("Canada")
		verifyTextPresent("United States")
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/bottomSheetClose_android'), defaultTime)
	}

	@Keyword
	def swipeUp() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.70  // Change to 70% from the top
		int endY = device_Height * 0.30  // Change to 30% from the top

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(10)
	}

	@Keyword
	def swipeUpLittle() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.50  // Set to 50% from the top
		int endY = device_Height * 0.25  // Set to a lower percentage to cover 50% of the screen

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
		Mobile.delay(10)
	}


	@Keyword
	def swipeUpTopofScreen() {
		int device_Height = Mobile.getDeviceHeight()

		int device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.65  // Set to 35% from the top
		int endY = device_Height * 0.30  // Adjust the value based on the desired swipe distance

		// Swipe up
		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def swipeRightOnSignature() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int startY = device_Height * 0.20  // Set to 20% from the top
		int endY = startY
		int startX = device_Width * 0.80  // Adjust the value based on the desired swipe distance (80% from the left)
		int endX = device_Width * 0.20  // Adjust the value based on the desired swipe distance (20% from the left)

		// Swipe horizontally
		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	def swipeDown() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()

		int dstartX = device_Width / 2
		int dendX = dstartX
		int dstartY = device_Height * 0.30  // Change to 30% from the top
		int dendY = device_Height * 0.70  // Change to 70% from the top

		// Swipe down
		Mobile.swipe(dstartX, dstartY, dendX, dendY)
	}

	@Keyword
	def fillingDetailsInDemographicPage(fromYears, toYears, firstName, MiInput, FaxNum, socialSecNum, providerType ='DMD') {
		tapOnProviderTypeDropdown();

		//select MD/DO and check if we are getting other speciality dropdown
		ma.tapOnElementByText(providerType)
		verifyTextPresent(providerType);
		typeInYearsFromInputBx(fromYears);
		typeInYearsToInputBx(toYears);
		Mobile.hideKeyboard();
		typeInFirstNameInputBx(firstName);
		Mobile.hideKeyboard();
		typeInMiInputBx(MiInput);
		Mobile.hideKeyboard();
		//swipeUp();
		Mobile.scrollToText('Social Security Number *', FailureHandling.STOP_ON_FAILURE);
		tapOnDateOfBirth();
		Mobile.hideKeyboard();
		tapOnConfirmBtn();
		tapOnUploadBtn();
		tapOnchooseFromLibrary();
		tapOnselectPic();
		Mobile.delay(30)
		//swipeUp();Social Security Number *
		Mobile.scrollToText('Fax Number', FailureHandling.STOP_ON_FAILURE)
		typeInFaxNumberInputBx(FaxNum);
		Mobile.hideKeyboard();
		Mobile.scrollToText('Social Security Number *', FailureHandling.STOP_ON_FAILURE);
		typeInSocialSecurityNumberInputBx(socialSecNum);
		Mobile.hideKeyboard();
		tapOnNextBtn();
		tapOnBackBtn();
	}

	@Keyword
	def verifyingFilledDetailsInDemographicsPage(fromYears, toYears, firstName, MiInput, FaxNum, socialSecNum) {
		verifyYearsFromInputBxElementText(fromYears);
		verifyYearsToInputBxElementText(toYears);
		verifyFirstNameInputBxElementText(firstName);
		verifyMiInputBxElementText(MiInput);
		//swipeUp();
		Mobile.scrollToText('Social Security Number *', FailureHandling.STOP_ON_FAILURE);
		verifyFaxNumberInputBxElementText(FaxNum);
		verifyCountryDrpdwn();
		verifySocialSecurityNumberInputBxElementText(socialSecNum);
		tapOnNextBtn();
	}
	@Keyword
	def tapOnMDorDOoption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/MDorDOoption_'+os), defaultTime);
	}
	@Keyword
	def tapOnDemographisBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/Provider Demographics/demographicsOption_android'), defaultTime);
	}
	@Keyword
	def verifyCheckedSpeciality(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Demographics/checkedSpeciality_Android',["text":text]), defaultTime, onFailure)
	}

	@Keyword
	def verifySpecialityNotSelected(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Registration/Demographics/checkedSpeciality_Android',["text":text]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSpecialityType(text) {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/specialityType_android',["text":text]), defaultTime);
	}
	@Keyword
	def clearTxtInLastNameField(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/Demographics/lastNameField_android'), defaultTime, onFailure);
	}
	@Keyword
	def setTxtInLastNameField(text, onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.setText(findTestObject('Object Repository/Provider/Registration/Demographics/lastNameField_android'), text, defaultTime, onFailure);
	}
	@Keyword
	def tapOnReUploadBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/reuploadBtn_android'), defaultTime);
	}
	@Keyword
	def verifyTextPresent(text) {
		//text= ["This is required for the background check", "Step 1 of 9 - Demographics", "Social security number must be 9 digits in length", "Required"]
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Demographics/verifyAnyTextInPage',["text":text]), defaultTime)
	}
	@Keyword
	def onlyFillDetailsInDemographicPage(fromYears, toYears, firstName, miInput, faxNum, socialSecNum) {
		tapOnProviderTypeDropdown();

		//select MD/DO and check if we are getting other speciality dropdown
		ma.tapOnElementByText("MD")
		typeInYearsFromInputBx(fromYears);
		typeInYearsToInputBx(toYears);
		Mobile.hideKeyboard();
		typeInFirstNameInputBx(firstName);
		Mobile.hideKeyboard();
		typeInMiInputBx(miInput);
		Mobile.hideKeyboard();
		//swipeUp();
		Mobile.scrollToText('Social Security Number *', FailureHandling.STOP_ON_FAILURE);
		tapOnDateOfBirth();
		Mobile.hideKeyboard();
		tapOnConfirmBtn();
		tapOnUploadBtn();
		tapOnchooseFromLibrary();
		tapOnselectPic();
		Mobile.delay(20)
		//swipeUp();Social Security Number *
		Mobile.scrollToText('Fax Number', FailureHandling.STOP_ON_FAILURE)
		typeInFaxNumberInputBx(faxNum);
		Mobile.hideKeyboard();
		Mobile.scrollToText('Social Security Number *', FailureHandling.STOP_ON_FAILURE);
		typeInSocialSecurityNumberInputBx(socialSecNum);
		Mobile.hideKeyboard();
	}
	@Keyword
	def verifyReUploadBtnExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE,defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Demographics/reuploadBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def taponCancelBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/cancelBtn_android'), defaultTime)
	}
	@Keyword
	def verifyLastNameInputBxElementText(name) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Registration/Demographics/lastNameField_android'), name)
	}
	@Keyword
	def verifySaveBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Demographics/saveBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def verifyImageExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE,defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Demographics/verifyImage_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyImage(defaultTime=60, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Registration/Demographics/image_andriod'), defaultTime, onFailure)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/Demographics/image_andriod'), defaultTime, onFailure);
	}
	@Keyword
	def clearTxtInMIField(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/Demographics/miInputBx_android'), defaultTime, onFailure);
	}
	@Keyword
	def clearTxtInFaxNumberField(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.clearText(findTestObject('Object Repository/Provider/Registration/Demographics/faxNumberInputBx_android'), defaultTime, onFailure);
	}
	@Keyword
	def taponSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/Demographics/saveBtn_android'), defaultTime);
	}
}
