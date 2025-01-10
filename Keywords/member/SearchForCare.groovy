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
import mobile.MobileActions
import mobile.Generic

public class SearchForCare {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	Generic gen = new Generic()
	MobileActions mob = new MobileActions()

	@Keyword
	def tapOnFilterIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/filterIcon_android'), defaultTime);
	}

	@Keyword
	def verifyFilterIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/filterIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyFilterCount(count = 1, filterCount =true, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(filterCount == true) {
			return Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/filterCount_android', ["count": count]), defaultTime, onFailure)
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/SearchForCare/filterCount_android', ["count": count]), 10, onFailure)
		}
	}
	@Keyword
	def tapOnAllDeliveryMethodsSrlDn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/allDeliveryMethodsSrlDn_android'), defaultTime);
	}
	@Keyword
	def tapOnAllDeliveryMethodsRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/allDeliveryMethodRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnHouseCallRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/houseCallRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnCheckOutNowBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/checkOutNowBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnFacilityVisitRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/facilityVisitRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnHouseCallSlot() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/houseCallSlot_android'), defaultTime);
	}
	@Keyword
	def tapOnTelemedicalCallTimeSlot(index) {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/telimedicineTimeSlot_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnFacilityVisitSlot() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/facilityVisitSlot_android'), defaultTime);
	}
	@Keyword
	def tapOnYesBookBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/yesBookBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/SaveBtn_android'), defaultTime);
	}
	@Keyword
	def setTxtInProviderSearhField(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/SearchForCare/providerSearchField_android'), txt, defaultTime);
	}

	@Keyword
	def setTxtInProcedureSearhField(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/SearchForCare/providerSearchField_android'), txt, defaultTime);
	}

	@Keyword
	def tapOnViewAllBtn(index = 1) {
		//tapOnCrossIconOnProfile();
		Mobile.delay(5);
		//		gen.swipeUpShort()
		//		if(Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android',["index": index]), 6, FailureHandling.OPTIONAL)) {
		//			gen.swipeUpLittle()
		//		}
		TestObject testObject = findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android',["index": 1])
		if(Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android',["index": index]), 6, FailureHandling.OPTIONAL)) {
			mob.scrollUntilElementIsVisible(testObject)
		}
		//		Mobile.scrollToText("View Availabilities", FailureHandling.OPTIONAL);
		//		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android',["index": index]), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android',["index": index]), defaultTime);
	}
	@Keyword
	def verifyViewAllBtn(index = 1, onFailure = FailureHandling.OPTIONAL, defaultTime = 10) {
		//		Mobile.scrollToText("View Availabilities", FailureHandling.OPTIONAL);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android',["index": index]), defaultTime);
	}

	@Keyword
	def tapOnSlotsNextDay(index = 2) {
		tapOnCrossIconOnProfile();
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/SearchForCare/slotsNextDay_android',['index':index]), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/slotsNextDay_android',['index':index]), defaultTime);
	}


	@Keyword
	def getCostOfHouseCallTimeSlotText() {
		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/costOfHousecallSlot_android'), defaultTime);
	}
	@Keyword
	def getCostOfTelemedicineTimeSlotText(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/costOfTeleMedicineSlot_android'), defaultTime, onFailure);
	}
	@Keyword
	def getTimeOfTelemedicineTimeSlotText(index) {

		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/timeOfTelemedicineSlot_android',["index":index]), defaultTime);
	}

	@Keyword
	def verifyTelemedicineTimeSlotText(index, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/timeOfTelemedicineSlot_android',["index":index]), defaultTime, onFailure);
	}

	@Keyword
	def verifyNotExistTimeOfTelemedicineTimeSlotText(time) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/SearchForCare/verifyTeleTimeSlot_android',["time":time]), defaultTime,onFailure);
	}
	@Keyword
	def tapOnResetFiltersBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/resetFiltersBtn_android',['index':index]), defaultTime);
	}
	@Keyword
	def verifyResetFiltersBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime, index = 1) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/resetFiltersBtn_android',['index':index]), defaultTime, onFailure);
	}
	@Keyword
	def verifyAndTapOnLocationDropDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/locationDropDn_android'), defaultTime);
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/locationDropDn_android'), defaultTime);
	}

	@Keyword
	def tapOnAnyDayDropDown() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/anyDayDrpDown_anroid'), defaultTime);
	}
	@Keyword
	def tapOnAnyTimeDropDown() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/anyTimeDrpDown_anroid'), defaultTime);
	}
	@Keyword
	def tapOnSearchBackBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/searchBackBtn_android'), defaultTime);
	}
	@Keyword
	def verifyProfileRelatedTxt(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		return Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/profileRelatedTxt_android'), 15, onFailure);
	}
	@Keyword
	def tapOnCrossIconBesideTxt() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/crossIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnCrossIconOnProfile() {
		if(verifyProfileRelatedTxt()) {
			Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/crossIcon_android'), defaultTime,FailureHandling.OPTIONAL);
		}
	}
	@Keyword
	def tapOnViewAllBtnByIndex(index = 1) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android', ["index": index]), defaultTime, onFailure)
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android', ["index": index]), defaultTime);
	}
	@Keyword
	def verifyAllAvailabilitiesTitle(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/allAvailabilitiesTitle_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifyFavouriteOutline(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Favourites/favouriteOutline_android'), defaultTime)
	}

	@Keyword
	def verifyShareIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/shareIcon1_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyProcedureInfoIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/procedureInfoBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnProcedureInfoIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/procedureInfoBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifySearchBackBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/searchBackBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnAnyProgramOnHorizontalScroll() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/progamOnHorizontalscroll_android'), defaultTime);
	}
	@Keyword
	def verifyListOfFiltersText() {
		def listofFiltersText = ["Delivery Methods", "Date", "Time", "Specialties", "Language", "Gender", "Facility Radius"];
		listofFiltersText.each { filterText ->
			new	MobileActions().verifyElementPresentByText(filterText);
		}
	}

	@Keyword
	def verifyFilterCheckMark(filter,checkMark = true, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(checkMark == true) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/filterCheckMark_android', ["filter":filter]), defaultTime, onFailure);
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/SearchForCare/filterCheckMark_android', ["filter":filter]), 10, onFailure);
		}
	}

	@Keyword
	def tapOnProgrameAvailableViewAllBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/programeAvailableViewAllBtn_andriod'), defaultTime)
	}
	
	@Keyword
	def verifyThePromoPriceByPromoName(promoName, value) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/promoPriceByPromoName_andriod',["promoName": promoName, "value": value]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	
	@Keyword
	def verifyPromoTag(promoName) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/verifyPromoTagBypromoName_andriod', ["promoName": promoName]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	
	@Keyword
	def verifyTheDiscountByPromoName(promoName, value) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/verifyDiscountBypromoName_andriod',["promoName": promoName, "value": value]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
}
