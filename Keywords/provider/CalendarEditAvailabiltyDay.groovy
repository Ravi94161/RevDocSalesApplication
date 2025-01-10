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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import internal.GlobalVariable

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement

public class CalendarEditAvailabiltyDay {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	@Keyword
	def tapOnAvailabilityToggle() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/availabilityToggle_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveChangesBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/saveChangesBtn_android'), defaultTime)
		Mobile.delay(20);
	}

	@Keyword
	def verifyUnavailabiltyMsg(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementText(findTestObject('Object Repository/Provider/Calendar/EditDatePage/unavailabiltyMsg_android'), "We will remove the day's availability from your schedule. You can edit your unavailabilities in your profile.", onFailure)
	}

	@Keyword
	def verifyScheduleUpdatedMsg(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/EditDatePage/scheduleUpdatedMsg_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnoContinueBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/continueBtn_android'), defaultTime)
	}

	@Keyword
	def verifyNoAvailabilityMsg() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/EditDatePage/noAvailabilityMsg_android'), defaultTime)
	}

	@Keyword
	def verifyAbsenceOfNoAvailabilityMsg() {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Calendar/EditDatePage/noAvailabilityMsg_android'), defaultTime)
	}

	@Keyword
	def tapOnCloseBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/closeBtn_android', ['index':index]), defaultTime)
	}

	@Keyword
	def tapOnFirstPopupCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/firstPopupCloseBtn_android'), defaultTime)
	}

	@Keyword
	def verifyAddAdditionalTimeRangeBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/EditDatePage/addAdditionalTimeRangeBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnAddAdditionalTimeRangeBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/addAdditionalTimeRangeBtn_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnEditPencilBtnOnCalendar() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/editPencilBtnOnCalendar_android'), defaultTime);
	}
	@Keyword
	def verifyEditPencilBtnOnCalendar(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/editPencilBtnOnCalendar_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnEditDayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/editDayBtn_android'), defaultTime);
	}
	@Keyword
	def verifyEditDayBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/editDayBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def checkDeliveryMethod(deliveryMethodName) {

		if(! Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/checkedDeliveryMethod',['deliveryMethodName': deliveryMethodName]), 10, FailureHandling.OPTIONAL) ) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/selectDeliveryMethod',['deliveryMethodName': deliveryMethodName]), defaultTime)
		}
		verifyDeliveryMethodChecked(deliveryMethodName)
	}

	@Keyword
	def verifyDeliveryMethodChecked(deliveryMethodName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/checkedDeliveryMethod',['deliveryMethodName': deliveryMethodName]), defaultTime)
	}

	@Keyword
	def unCheckDeliveryMethod(deliveryMethodName) {

		if(! Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/unCheckedDeliveryMethod',['deliveryMethodName': deliveryMethodName]), 10, FailureHandling.OPTIONAL) ) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/selectDeliveryMethod',['deliveryMethodName': deliveryMethodName]), defaultTime)
		}
		verifyDeliveryMethodUnChecked(deliveryMethodName)
	}

	@Keyword
	def verifyDeliveryMethodUnChecked(deliveryMethodName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/unCheckedDeliveryMethod',['deliveryMethodName': deliveryMethodName]), defaultTime)
	}

	@Keyword
	def selectDeliveryMethodOption(deliveryMethodOption, index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/deliveryMethodOptions',['deliveryMethodOption': deliveryMethodOption, 'index': index]), defaultTime)
	}

	@Keyword
	def checkProcedure(procedureName) {

		if(! Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/checkedProcedureOptions',['procedureName': procedureName]), 10, FailureHandling.OPTIONAL) ) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/selectProcedureOptionsCheckbox',['procedureName': procedureName]), defaultTime)
		}
		verifyProcedureChecked(procedureName)
	}

	@Keyword
	def verifyProcedureChecked(procedureName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/checkedProcedureOptions',['procedureName': procedureName]), defaultTime)
	}

	@Keyword
	def unCheckProcedure(procedureName) {

		if(! Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/unCheckedProcedureOptions',['procedureName': procedureName]), 10, FailureHandling.OPTIONAL) ) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/selectProcedureOptionsCheckbox',['procedureName': procedureName]), defaultTime)
			if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/checkedProcedureOptions',['procedureName': procedureName]), 10, FailureHandling.OPTIONAL) ) {
				Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/selectProcedureOptionsCheckbox',['procedureName': procedureName]), defaultTime)
			}
		}
		verifyProcedureUnChecked(procedureName)
	}

	@Keyword
	def verifyProcedureUnChecked(procedureName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/unCheckedProcedureOptions',['procedureName': procedureName]), defaultTime)
	}

	@Keyword
	def tapOnSaveButton() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/saveBtn_android'), defaultTime)
	}

	@Keyword
	def verifyAndturnOnDeliveryMethod(dm) {
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/EditDatePage/deliveryMethodStatus_android', ['dm': dm]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/deliveryMethodStatus_android', ['dm': dm]), defaultTime)
			Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Calendar/EditDatePage/deliveryMethodStatus_android', ['dm': dm]), defaultTime)
		}
	}

	@Keyword
	def numOfDmSelected() {
		int count = MobileDriverFactory.getDriver().findElementsByXPath('//android.widget.TextView[@resource-id="deliverymethod"]').size()
		return count
	}
	@Keyword
	def tapOnEditAllWeekDayBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/editAllWeekDaysBtn_android'), defaultTime);
	}
	@Keyword
	def verifyEditAllWeekDayBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/editAllWeekDaysBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapOnDeliveryAddressFieldOnEditDatePage(dm) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/deliveryAddressFieldEditDayPage_android', ['DM':dm]), defaultTime)
	}

	@Keyword
	def tapOnSelectAddressField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/selectAddressField_android'), defaultTime)
	}

	@Keyword
	def selectAnotherAddress(address) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/selectAnotherAddress_android',['address': address]), defaultTime)
	}

	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/saveBtn_android'), defaultTime)
	}

	@Keyword
	def changeDeliveryAddressIEditDay(dm, address) {
		tapOnDeliveryAddressFieldOnEditDatePage(dm)
		tapOnSelectAddressField()
		selectAnotherAddress(address)
		tapOnSaveBtn()
	}
	@Keyword
	def verifyAndturnOffDeliveryMethod(deliveryMethod, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Calendar/EditDatePage/checkBoxFilledDeliveryMethod_android', ['deliveryMethod': deliveryMethod]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/checkBoxFilledDeliveryMethod_android', ['deliveryMethod': deliveryMethod]), defaultTime)
			Mobile.verifyElementNotVisible(findTestObject('Object Repository/Provider/Calendar/EditDatePage/checkBoxFilledDeliveryMethod_android', ['deliveryMethod': deliveryMethod]), 15, onFailure);
		}
	}
	@Keyword
	def tapOnProcedureType(procedure) {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/procedureType_android', ["procedure":procedure]), defaultTime);
	}
	@Keyword
	def setACustomRate(rate) {
		Mobile.clearText(findTestObject('Object Repository/Provider/Calendar/EditDatePage/customRateTxtBx_android'), defaultTime);
		Mobile.setText(findTestObject('Object Repository/Provider/Calendar/EditDatePage/customRateTxtBx_android'), rate, defaultTime);
	}
	@Keyword
	def tapOnCustomRateToggleBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/addCustomRateToggleBtn_android'), defaultTime);
	}

	@Keyword
	def enableUnAvailabilityToggle() {
		//provider will be unavailable for that day
		if(! Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/weWillRemoveDaysAvailabilityText'), 10, FailureHandling.OPTIONAL) ) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/availabilityToggle_android'), defaultTime)
		}
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/weWillRemoveDaysAvailabilityText'), defaultTime)
	}

	@Keyword
	def disableUnAvailabilityToggle() {
		//provider will available for that day
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/weWillRemoveDaysAvailabilityText'), 10, FailureHandling.OPTIONAL) ) {
			Mobile.tap(findTestObject('Object Repository/Provider/Calendar/EditDatePage/availabilityToggle_android'), defaultTime)
		}
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/startTime_android'), 10, FailureHandling.OPTIONAL) ) {
			Mobile.scrollToText("House Call")
		}
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Calendar/EditDatePage/addAdditionalTimeRangeBtn_android'), defaultTime)
	}
}
