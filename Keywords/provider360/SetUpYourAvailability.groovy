package provider360

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Rectangle
import org.openqa.selenium.WebElement

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import mobile.Generic
import providerRegistration.ContactInformation
import providerRegistration.Demographics
import mobile.MobileActions


public class SetUpYourAvailability {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	ContactInformation contact=new ContactInformation();
	Demographics demo = new Demographics();
	Generic gen = new Generic();
	MobileActions mob = new MobileActions();
	SetUpProviderProfile prof = new SetUpProviderProfile()
	Procedures proc = new Procedures()

	@Keyword
	def verifyAvailabilitySummaryTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/availailitySummaryTitle_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySundayBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/selectSunday_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyMondayBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/selectMonday_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyTuesdayBtn(dayPrefix = "Tu") {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/selectTuesday_android', ["dayPrefix":dayPrefix]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSpecificDayBtn(dayPrefix = "Tu") {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/selectTuesday_android', ["dayPrefix":dayPrefix]), defaultTime, onFailure);
	}
	@Keyword
	def verifyWednesdayBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/selectWednesday_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyThursdayBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/selectThursday_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyFridayBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/selectFriday_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySaturdayBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/selectSaturday_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyEditSundaysBtn(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/editSundaysBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyEditMondaysBtn(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/editMondaysBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySaveAvailabilityBtn(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/saveAvailabilityBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyEditAllWeekdaysTitle(Weekdays){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/EditAllWeekdaysTitle_android',["Weekdays":Weekdays]), defaultTime, onFailure);
	}
	@Keyword
	def verifyToggleBtn(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/toggleBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnToggleBtn(){
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/toggleBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyStartTimeOption(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/startTime_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyEndTimeOption(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/endTime_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyVanCallCheckBox(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/vanCallCheckBox_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyTeleMedicineCheckBox(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/telemedicineCheckBox_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyHoseCallCheckBox(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/houseCallCheckBox_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyFacilityCheckBox(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/facilityCheckBox_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyDeleteThisTimeRangeOption(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/deleteThisTimeRange_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyAddAdditionalTimeRangeOption(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/addAdditionalTimeRangeOption_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySaveChangesBtn(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/saveChangesBtn_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyCloseBtn(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/closeBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/closeBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyDeliveryOption(deliveryMethod){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/deliveryOption_android',["delivery":deliveryMethod]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnDeliveryOption(deliveryMethod){
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/deliveryOption_android',["delivery":deliveryMethod]), defaultTime);
	}
	@Keyword
	def verifyPayToOption(deliveryMethod){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/payToOption_android',["delivery":deliveryMethod]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnPayToOptionForDeliveryMethod(deliveryMethod) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/payToOption_android',["delivery":deliveryMethod]), defaultTime);
	}
	@Keyword
	def verifyBankNameCheckBoxExist(account) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/bankingAccountSelected_android', ['account': account]), defaultTime)
	}
	@Keyword
	def verifySpecificProcedureOption(deliveryMethod){
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/specificProcedureOption_android',["delivery":deliveryMethod]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSetUpYourSheduleTemplateOption() {
		Mobile.scrollToText("Set Up Your Schedule Template", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/setUpYourSheduleTemplate_android'), defaultTime)
	}

	@Keyword
	def verifySetUpYourSheduleTemplateOption(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText("Set Up Your Schedule Template", FailureHandling.OPTIONAL);
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/setUpYourSheduleTemplate_android'), defaultTime, FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/setUpYourSheduleTemplate_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSaveAndContinueBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveAndContinueBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSelectMonday() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/selectMonday_'+os), defaultTime)
	}

	@Keyword
	def tapOnEditMondaysBtn(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/editMondaysBtn_'+os), defaultTime, onFailure)
	}

	@Keyword
	def getProcedureCountOnAvailabilitySummaryScreen(DM) {
		Mobile.getText(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Set Up Your Availabilty/procedureCount_android', ['DM':DM]), defaultTime)
	}

	@Keyword
	def tapOnEditWeekdaysBtn(day, onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/editWeekdayBtn_android', ['weekday': day]), defaultTime, onFailure)
	}

	@Keyword
	def verifyCheckBoxFilledExist(DM) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Build My Revdoc Profile/Set Up Your Availabilty/EditWeekdaysPage/deliveryMethodCheckBox_android', ['DM': DM]), defaultTime, FailureHandling.OPTIONAL)) {
			return true
		}
		else {
			return false
		}
	}

	@Keyword
	def tapOnVanCallDeliveryMethodCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/vanCallDeliveryMethodCheckBox_android'), defaultTime)
	}

	@Keyword
	def tapOnProceduresOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/proceduresOption_android'), defaultTime)
	}

	@Keyword
	def tapOnCholecystectomyProcedureCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/cholecystectomyProcedureCheckBox_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveProceduresBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveProceduresBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveBtnEditMonday() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveBtnEditMonday_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveAvailabilityBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveAvailabilityBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnDateFieldOnAvailabilityRepititionPopup() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/DateFieldOnAvailabilityRepititionPopup_android'), defaultTime)
	}
	@Keyword
	def tapOnSaveChangesBtn() {
		Mobile.delay(15, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveChangesBtn_android'), defaultTime)
	}

	@Keyword
	def verifyScheduledAppointmentWarningMsg(onFailure =FailureHandling.OPTIONAL) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/scheduledUpdatedMsg_android'), defaultTime, onFailure)
	}

	@Keyword
	def waitForSetUpYourAvailabilityOptionPresent() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/setUpYourSheduleTemplate_android'), defaultTime)
	}

	@Keyword
	def tapOnAddDayAndTimeBtn(onFailure =FailureHandling.OPTIONAL) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/addDayAndTimeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyAddDayAndTimeBtnPresent(onFailure =FailureHandling.OPTIONAL) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/addDayAndTimeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def waitForAddDayAndTimeBtnPresent(onFailure =FailureHandling.OPTIONAL) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/addDayAndTimeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def waitForCloseBtnNotPresent() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/closeBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectSunday() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectSunday_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectWeekday(day) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectWeekday_android', ['day': day]), defaultTime)
	}

	@Keyword
	def tapOnSelectWednesday() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectWednesday_android'), defaultTime)
	}

	@Keyword
	def tapOnStartTimeInput() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/startTimeInput_android'), defaultTime)
	}

	@Keyword
	def tapOnEndTimeInput() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/endTimeInput_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectHour() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectHour_android'), defaultTime)
	}

	@Keyword
	def tapOnConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/confirmBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveBtn(onFailure = FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnDeleteIcon(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/deleteIcon_android', ['index': index]), defaultTime)
	}

	@Keyword
	def tapOnDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/deleteBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnNoKeepBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/noKeepBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnEditIcon(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/editIcon_android', ['index': index]), defaultTime)
	}

	@Keyword
	def verifyDeleteIconExist(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/deleteIcon_android', ['index': index]), defaultTime)
	}

	@Keyword
	def verifyEditIconExist(index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/editIcon_android', ['index': index]), defaultTime)
	}

	@Keyword
	def tapOnPayToOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/payToOption_android'), defaultTime)
	}

	@Keyword
	def tapOnSavingsCheckBox() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/SavingsCheckBox_android'), defaultTime)
	}

	@Keyword
	def verifySavingCheckBoxExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/SavingsCheckBox_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveBtnPayTo() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveBtnPayTo_android'), defaultTime)
	}

	@Keyword
	def tapOnDontWantToWorkOnMondayToggle() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/dontWantToWorkOnMondayToggle_android'), defaultTime)
	}

	@Keyword
	def verifyMondayNotAvailableMsg() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/removeMondayAvailabilityTxt_android'), defaultTime)
	}

	@Keyword
	def verifyTuesdayNotAvailableMsg() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/removeTuesdayAvailabilityTxt_android'), defaultTime)
	}

	@Keyword
	def verifyNothingScheduledMsg() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/nothingScheduled_android'), defaultTime)
	}

	@Keyword
	def tapOnDeliveryOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/deliveryOption_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectAnAddressDropdown() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectAnAddressDropdown_android'), defaultTime)
	}

	@Keyword
	def tapOnAddress(address) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectAddress_andriod', ["address": address]), defaultTime)
	}

	@Keyword
	def verifyAddressWithDeliveryMethod(delivery, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/verifyAddresswithDeliveryMethod_andriod',["delivery": delivery]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSelectWorkAddress() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectWorkAddress_android'), defaultTime)
	}

	@Keyword
	def tapOnSaveDeliveryBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/saveDeliveryBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnSelectHomeAddress() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectHomeAddress_android'), defaultTime)
	}

	@Keyword
	def tapOnAddAdditionalTimeRangeOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/addAdditionalTimeRangeOption_android'), defaultTime)
	}

	@Keyword
	def tapOnStartTime() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/startTime_android'), defaultTime)
	}

	@Keyword
	def tapOnEndTime() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/endTime_android'), defaultTime)
	}

	@Keyword
	def tapOnSetUpYourScheduleTemplateBtn() {
		Mobile.scrollToText("Set Up Your Schedule Template")
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/setUpYourScheduleTemplateBtn_'+os), defaultTime)
	}

	@Keyword
	def tapOnAnyProcedureTypeOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AllProceduresView/anyProcedureTypeOption_'+os), defaultTime)
	}

	@Keyword
	def getTextProcedureType(index) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AllProceduresView/getTextProcedureType_'+os,['index':index]), defaultTime)
	}

	@Keyword
	def tapOnProcedureType(index) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AllProceduresView/getTextProcedureType_'+os,['index':index]), defaultTime)
	}

	@Keyword
	def getTextProcedureName(procedure) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AllProceduresView/getTextProcedureName_'+os,['procedureType':procedure]), defaultTime)
	}

	@Keyword
	def tapOnProcedureMoreInfoOpt() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AllProceduresView/procedureProfileBtn_android'), defaultTime)
	}

	@Keyword
	def verifyProcedureName(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/ProcedureProfile/verifyProcedureName_'+os,['name':name]), defaultTime, onFailure)
	}

	@Keyword
	def verifyProcedureTimeOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/ProcedureProfile/verifyProcedureTimeOption_'+os), defaultTime, onFailure)
	}

	@Keyword
	def verifyCategoryOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/ProcedureProfile/verifyCategoryOption_'+os), defaultTime, onFailure)
	}

	@Keyword
	def verifyEligibilityOption(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/ProcedureProfile/verifyEligibilityOption_'+os,['text':text]), defaultTime, onFailure)
	}

	@Keyword
	def verifyAboutOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/ProcedureProfile/verifyAboutOption_'+os), defaultTime, onFailure)
	}

	@Keyword
	def verifyProcedureOptions(option, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.scrollToText(option, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/ProcedureProfile/verifyProcedureOptions_'+os,['option':option]), defaultTime, onFailure)
	}
	@Keyword
	def addNewAddressInDeliveryMethod(address, addressName) {
		contact.tapOnSearchField()
		contact.tapOnInputSearchField(address)
		contact.tapOnFirstSearchResult()
		contact.typeInNameOfAddressInputBx(addressName);
	}

	@Keyword
	def scrollAndTapOnFirstSearchAddressResult(testObject, address, addressName) {
		mob.scrollUntilElementIsVisible(testObject)
		contact.tapOnFirstAddressSearchResult(GlobalVariable.searchAddress2, "Home");
	}


	@Keyword
	def tapOnContinueBtn(defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/Delivery/continueBtn_android'), defaultTime);
	}

	@Keyword
	def tapOnSelectAnAddressField() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/Delivery/selectAnAddressField_android'), defaultTime);
	}
	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/backBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnAddAnAddressOption() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/Delivery/addAnAddressOpt_android'), defaultTime);
	}
	@Keyword
	def tapOnSetUpYourAvailability() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/setUpYourAvailability_andriod'), defaultTime)
	}

	@Keyword
	def verifySetUpYourAvailability() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/setUpYourAvailability_andriod'), defaultTime)
	}

	@Keyword
	def selectHours(num) {
		int numberOfTimes = num;
		for (int i = 0; i < numberOfTimes; i++) {
			Mobile.setSliderValue(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectHour_android'), 10, defaultTime);
		}
	}
	@Keyword
	def selectMinutes(num) {
		int numberOfTimes = num
		for (int i = 0; i < numberOfTimes; i++) {
			Mobile.setSliderValue(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/selectMinutes_android'), 10, defaultTime);
		}
	}
	@Keyword
	def enterAddressDetails(address, addressName) {
		//contact.verifyHomeAddressTitle()
		contact.tapOnSearchField()
		contact.tapOnInputSearchField(address)
		contact.tapOnFirstSearchResult()
		contact.typeInNameOfAddressInputBx(addressName);
	}

	@Keyword
	def verifyUIValidationOfContactScreen(address, addressName) {
		contact.tapOnSearchField()
		contact.tapOnInputSearchField(address)
		contact.tapOnFirstSearchResult()
		contact.typeInNameOfAddressInputBx(addressName);
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
	def selectHour(targetValue) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/SelectTime/amOrpm_android'), defaultTime, FailureHandling.OPTIONAL)) {
			if(targetValue>12) {
				targetValue = targetValue - 12;
				selectAMorPM("PM")
			}else{
				selectAMorPM("AM")
			}
		}
		TestObject hours = findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/SelectTime/hour_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth/2).toInteger()
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = startx
		def endy =  starty + 100

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/hour']", "content-desc").split(",")[0].trim().toInteger()
		def value =  getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/hour']", "content-desc").split(",")[0].trim().toInteger()
		println("value3": value)
		int i= 1;

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/hour']", "content-desc").split(",")[0].trim().toInteger() != targetValue.toInteger() && i <= 23) {

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
	def selectMinute(targetValue) {
		TestObject hours = findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/SelectTime/minutes_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth/2).toInteger()
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = startx
		def endy =  starty + 100

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/minutes']", "content-desc").split(",")[0].trim().toInteger()

		int i= 1;

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/minutes']", "content-desc").split(",")[0].trim().toInteger() != targetValue.toInteger() && i <= 5) {

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
	def selectTime(hour, minute) {
		selectHour(hour)
		selectMinute(minute)
	}

	@Keyword
	def selectMonth(targetValue) {
		TestObject hours = findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/SelectDate/month_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth/2).toInteger()
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = startx
		def endy =  starty - 50

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/month']", "content-desc").split(",")[0].trim().toLowerCase()
		int i= 1;

		while (currentValue != targetValue.toLowerCase() && i <= 12) {
			Mobile.swipe(startx, starty, endx, starty - 50, FailureHandling.OPTIONAL);
			Mobile.delay(1) // Wait for 1 second for UI to update
			currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/month']", "content-desc").split(",")[0].trim().toLowerCase()
			i = i + 1;
		}
	}

	@Keyword
	def selectDay(targetValue) {
		TestObject hours = findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/SelectDate/day_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth/2).toInteger()
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = startx
		def endy =  starty + 100

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/date']", "content-desc").split(",")[0].trim().toInteger();
		int i= 1;

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/date']", "content-desc").split(",")[0].trim().toInteger() != targetValue.toInteger() && i <= 31) {

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
	def selectYear(targetValue) {
		TestObject hours = findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/SelectDate/year_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth/2).toInteger()
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = startx
		def endy =  starty + 100

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/year']", "content-desc").split(",")[0].trim().toInteger();
		int i= 1;

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/year']", "content-desc").split(",")[0].trim().toInteger() != targetValue.toInteger() && i <= 15) {

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
	def selectAMorPM(String targetValue) {
		TestObject ampmSeekBar = findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/SelectTime/amOrpm_android')
		def eHeight = Mobile.getElementHeight(ampmSeekBar, defaultTime)
		def eWidth = Mobile.getElementWidth(ampmSeekBar, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(ampmSeekBar, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(ampmSeekBar, defaultTime)

		def startx  = eLeftPos + (eWidth / 2).toInteger()
		def starty = (eTopPos + (eHeight / 2)).toInteger()
		def endx = startx
		def endy

		if (targetValue.trim() == "AM") {
			endy = starty + 100
		} else if (targetValue.trim() == "PM") {
			endy = starty - 100
		} else {
			println "Invalid target value. Please specify 'AM' or 'PM'."
			return
		}

		int i = 1

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.revdoc_provider:id/ampm']", "content-desc").split(",")[0].trim() != targetValue && i <= 5) {
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL)

			i++
		}

		if (i > 5) {
			println "Failed to select $targetValue within 5 attempts."
		} else {
			println "Successfully selected $targetValue."
		}
	}

	@Keyword
	def selectDate(month, day, year) {
		selectMonth(month);
		selectDay(day);
		selectYear(year);
	}

	@Keyword
	def tapAddAnAdditionalDayAndTimeRange() {
		Mobile.tap(findTestObject('Object Repository/Provider/Registration/SetUpYourAvailabilty/addAnAdditionalDayAndTimeRange_android'), defaultTime);
	}

	@Keyword
	def getTimeRangeOnAvailabilitySummaryScreen(day) {
		Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/timeRangeField_android', ['day':day]), defaultTime)
	}

	@Keyword
	def setYourAvailabiltyOnBuildMyProfileScreen() {
		tapOnSetUpYourAvailability()
		tapOnAddDayAndTimeBtn()
		tapOnSelectWeekday('Su')
		tapOnSelectWeekday('M')
		tapOnSelectWeekday('Tu')
		tapOnSelectWeekday('W')
		tapOnSelectWeekday('Th')
		tapOnSelectWeekday('F')
		tapOnSelectWeekday('Sa')
		tapOnStartTimeInput()
		selectTime(1, 30)
		tapOnConfirmBtn()
		tapOnEndTimeInput()
		selectTime(23, 30)
		tapOnConfirmBtn()
		tapOnSaveBtn()
		tapOnSaveAndContinueBtn()
		tapOnSaveAvailabilityBtn()
		tapOnDateFieldOnAvailabilityRepititionPopup()
		selectDate('May', '20', '2028')
		tapOnConfirmBtn()
		tapOnSaveChangesBtn()
	}

	@Keyword
	def addTimeRange(startHour, startMin, endHour, endMin) {
		tapOnStartTimeInput()
		selectTime(startHour, startMin)
		tapOnConfirmBtn()
		tapOnEndTimeInput()
		selectTime(endHour, endMin)
		tapOnConfirmBtn()
	}

	@Keyword
	def navigateToeditWeekdaysInSetUpYourAvailability(d, day) {
		proc.tapOnProfileIcon()
		prof.tapOnSetUpProviderProfile()
		tapOnSetUpYourSheduleTemplateOption()
		tapOnSelectWeekday(d)
		def timeRange = getTimeRangeOnAvailabilitySummaryScreen(day)
		prof.tapOnEditWeekday(day)
		return timeRange
	}

	@Keyword
	def savingAvailabilityAndVerifyMsg(msg1, msg2) {
		tapOnSaveAvailabilityBtn()
		tapOnSaveChangesBtn()
		verifyText(msg1);
		verifyText(msg2);
	}

	@Keyword
	def setDistance(value) {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/distanceMilesInputBx_android'), defaultTime);
		Mobile.hideKeyboard();
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/distanceMilesInputBx_android'), value.toString(), defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def getDistance() {
		Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/distanceMilesInputBx_android'), defaultTime);
	}

	@Keyword
	def setRate(value, index = 2) {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/rateAmountInputBx_android', ['index': index]), defaultTime);
		Mobile.hideKeyboard();
		Mobile.delay(0.5)
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/rateAmountInputBx_android', ['index': index]), value.toString(), defaultTime);
		Mobile.hideKeyboard();
	}

	@Keyword
	def getRate(index = 2) {
		Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/rateAmountInputBx_android', ['index': index]), defaultTime);
	}

	@Keyword
	def tapOnDeleteThisTimeRange() {
		gen.swipeUp()
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/deleteThisTimeRange_android'), defaultTime);
	}

	@Keyword
	def tapOnYesDeleteBtn() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/yesDeleteBtn_android'), defaultTime);
	}

	@Keyword
	def verifyNothingScheduledTextElementNotExist() {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/nothingScheduledText_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyNothingScheduledTextElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/nothingScheduledText_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def verifyText(text, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/verifyText_android',['text':text]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnContinueBtnOnAvailability() {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/continueBtn_android'), defaultTime);
	}

	@Keyword
	def verifyContinueBtnOnAvailability() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/continueBtn_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def scrollUntilAddAdditionalTimeRangeOptionVisible() {
		while(Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/addAdditionalTimeRangeOption_android'), 10, FailureHandling.OPTIONAL)) {
			gen.swipeUpLittle();
		}
	}

	@Keyword
	def tapOnDeliveryMethodCheckBox(delivery) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/deliveryMethodCheckBox_android',['delivery':delivery]), defaultTime);
	}

	@Keyword
	def tapOnDeliveryMethodOption(delivery) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/deliveryMethodOption_android',['delivery':delivery]), defaultTime);
	}

	@Keyword
	def typeInRateInput(text) {
		Mobile.clearText(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/rateInput_android'), defaultTime);
		Mobile.setText(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/rateInput_android'), text, defaultTime);
	}

	@Keyword
	def tapOnProcedureOption(delivery) {
		Mobile.scrollToText(delivery, FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/procedureOption_android',['delivery':delivery]), defaultTime);
	}

	@Keyword
	def tapOnProcedureTypeCheckBox(procedure, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/EditAllWeekdays/procedureTypeOption_android',['procedure':procedure]), defaultTime, onFailure);
	}

	@Keyword
	def verifyPrice(time,delivery,price) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/verifyPrice_android',['time':time,'delivery':delivery,'price':price]), defaultTime);
	}

	@Keyword
	def tapOnViewProceduresBtn(time,delivery) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/viewProceduresBtn_android',['time':time,'delivery':delivery]), defaultTime);
	}

	@Keyword
	def verifyProcedureNotExist(procedure) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/verifyProcedure_android',['procedure':procedure]), defaultTime);
	}

	@Keyword
	def getDeliveryAddressUnderEditWeekdays(delvieryName) {
		Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/deliveryAddressBelowEditWeekDays_android', ['deliveryMethod': delvieryName] ), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def tapOnAccountInPayTo(account) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/accountPayTo_android',['account': account]), defaultTime);
	}
	@Keyword
	def verifyProcedurePrice(procedure, price, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/verifyProcedurePrice_andriod',["procedure": procedure, "price": price]), defaultTime, onFailure)
	}

	@Keyword
	def verifyProcedurePriceNotExistCondition(procedure, price) {
		return Mobile.verifyElementNotExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/verifyProcedurePrice_andriod',["procedure": procedure, "price": price]), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyProcedureProceVisibilityStatus(procedure, price, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AvailabilitySummary/verifyProcedurePrice_andriod',["procedure": procedure, "price": price]), 30, FailureHandling.OPTIONAL)) {
			return true
		}
		else {
			return false
		}
	}
	//------------------------------------------Availability Summary Screen------------------------------------------------------
	@Keyword
	def verifyDeliveryMethodDistance(deliveryMethod, distance, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Provider360/SetUpYourAvailability/Availability Summary/deliveryMethodDistance_android',["deliveryMethod":deliveryMethod, "distance":distance]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSpecificViewProceduresOption(deliveryMethod) {
		Mobile.tap(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AllProceduresView/viewProceduresOptByDelivery_android', ["deliveryMethod":deliveryMethod]), defaultTime);
	}
	@Keyword
	def getTextOfSpecificViewProceduresOption(deliveryMethod) {
		return Mobile.getText(findTestObject('Object Repository/Provider/Provider360/SetUpYourScheduleTemplate/AllProceduresView/viewProceduresOptByDelivery_android', ["deliveryMethod":deliveryMethod]), defaultTime);
	}

	@Keyword
	def navigateAvailabilityScreenToHomeScreen(closeBtnTimes = 2, backBtnTimes = 3) {
		for(int i=1;i<=closeBtnTimes;i++) {
			tapOnCloseBtn();
			Mobile.delay(5);
		}
		for(int i=1;i<=backBtnTimes;i++) {
			tapOnBackBtn();
			Mobile.delay(5);
		}
	}

	@Keyword
	def setYourAvailabilityToDontWorkOnAllDaysAndVerifyNothingScheduled(day, dayFullName) {
		tapOnSelectWeekday(day);
		tapOnEditWeekdaysBtn(dayFullName);
		tapOnDontWantToWorkOnMondayToggle();
		tapOnSaveChangesBtn();
		verifyNothingScheduledMsg();
	}
	//------------------------------------------End - Availability Summary Screen------------------------------------------------------

}
