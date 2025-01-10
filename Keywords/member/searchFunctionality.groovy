package member

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.util.internal.PathUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement

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
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import groovy.json.JsonSlurper
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.Rectangle
import org.openqa.selenium.WebElement
import groovy.time.TimeCategory

import internal.GlobalVariable
import mobile.Generic

public class searchFunctionality {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	Generic gen = new Generic();

	@Keyword
	def tapOnSearchField(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBar_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBar_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchAddressFieldPage(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBar_android'), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchAddressPagLabel_android', ['txt': txt]), defaultTime)
	}


	@Keyword
	def verifySearchFieldElementExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/search_field_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchForCareTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchForCareTitle_android'), defaultTime)
	}

	@Keyword
	def verifyDeliveryMethodsDrpdwn(index = 2) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/deliveryMethodsDrpDwn_android',['index':index]), defaultTime)
	}

	@Keyword
	def verifyCardsOnSearchpage(cardType) {
		Mobile.verifyElementVisible(findTestObject('Member/Member360/SearchFunctionality/searchFieldOnSearchResultsPage_android', ['value': cardType]), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/editBtnsOnCardsOnSearchpage_android', ['value': cardType]), defaultTime)
	}

	@Keyword
	def tapOnAddressDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/addressDrpDwn_android'), defaultTime)
	}

	@Keyword
	def verifyBottomSheetTitle(title, onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/bottomSheetTitle_android'), title, onFailure)
	}

	@Keyword
	def tapOnAddress(address) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchAddress_android', ['address': address]), defaultTime)
	}

	@Keyword
	def verifyClearBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/clearBtn_android'), defaultTime)
	}

	@Keyword
	def verifySearchBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBtn_android'), defaultTime)
	}

	@Keyword
	def enterInputInSearchField(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchInputField_android'), txt, defaultTime)
	}

	@Keyword
	def tapOnClearBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/clearBtn_android'), defaultTime)
	}

	@Keyword
	def verifyBronchoscopyProcedureNotVisible(procedure, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/bronchoscopyProcedure_android', ['value': procedure]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnAutoSearchedResult(procedure) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/SearchFunctionality/bronchoscopyProcedure_android', ['value': procedure]), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/bronchoscopyProcedure_android', ['value': procedure]), defaultTime)
	}

	@Keyword
	def verifyAutoSearchedResult(txt) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/SearchFunctionality/autoSearchedOption_android', ['value': txt]), defaultTime)
	}

	@Keyword
	def tapOnDateOnSearchCard(date) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/dateOnSearchCard_android', ['value': date]), defaultTime)
	}

	@Keyword
	def verifyCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/closeBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/closeBtn_android'), defaultTime)
	}

	@Keyword
	def verifyLabelsOnSearchpage(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/labelsOnSearchPage_android', ['value': txt]), defaultTime, onFailure)
	}

	@Keyword
	def verifyAbsenceOfLabelsOnSearchpage(txt, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/labelsOnSearchPage_android', ['value': txt]), defaultTime, onFailure)
	}

	@Keyword
	def verifyCardiologistlabel() {
		for (int i = 1 ; i<=3 ; i++) {
			Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/specialityInSearchCards_android', ['index': i]), defaultTime)
		}
	}

	@Keyword
	def tapOnAppoinmentsTimeSlot(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/appoinmentsTimeSlot_android', ['index': index]), defaultTime);
	}
	@Keyword
	def verifyAppoinmentsTimeSlotVisible(time, index = 1, onFailure = FailureHandling.STOP_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/appoinmentsTimeSlot_android', ['index': index]), defaultTime);
		Mobile.verifyElementText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/appoinmentsTimeSlot_android', ['index': index]), time, onFailure);
	}

	@Keyword
	def tapOnSearchFielsOnResultsScreen() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/serachBarOnResultsScreen_android'), defaultTime)
	}

	@Keyword
	def verifySupervisorNameInSearchResults(name, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/supervisorNameInSearchResults_android', ['value': name]), defaultTime, onFailure)
	}
	@Keyword
	def tapOnSearchBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnLocationLabel(text = 'Location') {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/labelsOnSearchPage_android',["value":text]), defaultTime);
	}
	@Keyword
	def tapOnDateLabel() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/labelsOnSearchPage_android',["value":"Date"]), defaultTime);
	}
	@Keyword
	def tapOnTimeLabel() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/labelsOnSearchPage_android',["value":"Time"]), defaultTime);
	}
	@Keyword
	def clearMilesTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/milesTxtBx_android'), defaultTime);
	}
	@Keyword
	def typeInMilesTxtBx(miles) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/milesTxtBx_android'),miles,defaultTime);
	}
	@Keyword
	def tapOnLocationRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/locationRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/saveBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnselectedDateCare(DateCare) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectDateOfCare_android',["value":DateCare]), defaultTime);
	}
	@Keyword
	def tapOnselectedTimeOfCare(TimeCare) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectDateOfCare_android',["value":TimeCare]), defaultTime);
	}
	@Keyword
	def tapOnParticularDate(Date) {
		def index = 2
		if(Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectSpecificDate_android',["date":Date,'index':index]), defaultTime, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectSpecificDate_android',["date":Date,'index':index]), defaultTime);
		}
		else {
			index = 1
			Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectSpecificDate_android',["date":Date,'index':index]), defaultTime);
		}
	}
	@Keyword
	def tapOnStartDate() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/startDate_android'), defaultTime);
	}
	@Keyword
	def tapOnEndDate() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/endDateField_android'), defaultTime);
	}
	@Keyword
	def tapOnConformBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/conformBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSpecificTimeScrollBar() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/specificTimeScrollBar_android'), defaultTime);
	}
	@Keyword
	def tapOnTimerange(timerange) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/betweenTimeOption_android',["value":timerange]), defaultTime);
	}
	@Keyword
	def getAddressFromLocatioCard(cardType) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/locationAddress_android', ["value": cardType]), defaultTime);
	}

	@Keyword
	def getDateAndTimeFromSearchPage(cardType) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/timeAndDateFieldsOnSearchPage_android', ["value": cardType]), defaultTime);
	}

	@Keyword
	def verifyFilteredSearch(txt) {
		Mobile.getText(findTestObject('Member/Member360/SearchFunctionality/searchFieldOnSearchResultsPage_android', ['value': txt]), defaultTime);
	}

	@Keyword
	def verifyProcedureProviderExist(name) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/procedureProvider_android', ["value": name]), defaultTime)
	}
	@Keyword
	def verifyProcedureProviderNotExist(name) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/procedureProvider_android', ["value": name]), defaultTime)
	}

	@Keyword
	def tapOnViewAllBtn(name) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/procedureProviderViewAllBtn_android', ["value": name]), defaultTime)
	}

	@Keyword
	def verifyCalendarVisible(name, month, onFailure= FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/calendar_android', ["value": name]), defaultTime, onFailure)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/currentMonth_android', ["month": month]), defaultTime, onFailure)
	}

	@Keyword
	def tapOnCloseBtnInSearchBar() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/closeBtnInSearchBar_android'), defaultTime)
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/backBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnProviderCalendarBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/providerCalendarBackBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnAddedDataInSearchBar(txt) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/autoSearchedOption_android', ['value': txt]), defaultTime)
	}

	@Keyword
	def tapOnButtonsheetClose() {
		Mobile.tap(findTestObject('Member/Member360/SearchFunctionality/bottomSheetClose_android'), defaultTime);
	}

	@Keyword
	def verifyDeliveryMethods(methodName) {
		// this method verifies slots under delivery method need to change its name
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/deliveryMethods_android',["value":methodName]), defaultTime);
	}
	@Keyword
	def tapOnDeliveryMethodsDrpdwn(index = 2) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/deliveryMethodsDrpDwn_android',['index':index]), defaultTime);
	}
	@Keyword
	def verifysearchLocationInputField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchLocationInputField_android'), defaultTime);
	}
	@Keyword
	def verifyselectedDateOfCare(DateCare) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectDateOfCare_android',["value":DateCare]), defaultTime);
	}
	@Keyword
	def verifyselectedTimeOfCare(TimeCare) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectDateOfCare_android',["value":TimeCare]), defaultTime);
	}
	@Keyword
	def verifyTodayOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/todayOption_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}
	@Keyword
	def verifySpecificDateOnAppointment(date) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectDateOfCare_android',["value":date]), defaultTime);
	}
	@Keyword
	def verifyStartDateField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/startDate_android'), defaultTime);
	}
	@Keyword
	def verifyEndDateField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/endDateField_android'), defaultTime);
	}
	@Keyword
	def tapOnLanguageScrlDn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/languageScrlDn_android'), defaultTime);
	}
	@Keyword
	def tapOnEnglishRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/englishRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnfirstProviderOnSearchReasult() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/firstProviderInSearchResult_android'), defaultTime);
	}
	@Keyword
	def verifyEnglishTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/englishText_android'), defaultTime);
	}
	@Keyword
	def typeInSpecialitiesTxtBx(specialities) {
		Mobile.setText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/specialitiesTxtBx_android'), specialities, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def tapOnSpecialitiesDrpDn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/specialityDrpdn_android'), defaultTime);
	}
	@Keyword
	def tapOnDermatologistOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/dermatologistOption_android'), defaultTime);
	}
	@Keyword
	def verifyDermatologistProvider() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/dermatologistProvider_android'), defaultTime);
	}
	@Keyword
	def tapOnResetFilterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/resetFilterBtn_android'), defaultTime);
	}

	@Keyword
	def verifyResetFilterCount(count) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/resetFilterCount_android'), defaultTime);
	}

	@Keyword
	def verifyResetFilterCountNotPresent() {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/resetFilterCount_android'), defaultTime);
	}

	@Keyword
	def verifyfirstProviderOnSearchReasult() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/firstProviderInSearchResult_android'), defaultTime);
	}

	@Keyword
	def verifySpecialityFilter(speciality) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/specialityFilter_android', ['speciality': speciality]), defaultTime);
	}

	@Keyword
	def getFirstProviderName(index = 1) {
		gen.swipeUpLittle()
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/getProviderFullName_android'), defaultTime);
	}

	@Keyword
	def tapOnSearchResultspageSearchBar(txt) {
		Mobile.tap(findTestObject('Member/Member360/SearchFunctionality/searchFieldOnSearchResultsPage_android', ['value': txt]), defaultTime);
	}
	@Keyword
	def tapOnAllDeliveryMethodsRdBtn(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/allDeliveryMethodsRdBtn_android', ['index':index]), defaultTime);
	}
	@Keyword
	def tapOnFacilityVisitRdBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/facilityVisitRdBtn_android'), defaultTime);
	}
	@Keyword
	def verifyFacilityVisitBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/facilityVisitRdBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnfyFacilityVisitBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/facilityVisitRdBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnLuxeMobileClinicRdBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/luxeMobileClinicRdBtn_android'), defaultTime);
	}

	@Keyword
	def verifyDeliveryMethodsDpdnText(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/facilityVisitPlusOneDpDn_android', ['text': text]), defaultTime);
	}

	def verifyFacilityVisitPlusOneMoreBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/facilityVisitPlusOneDpDn_android'), defaultTime);
	}
	@Keyword
	def tapOnFacilityVisitPlusOneMoreBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/facilityVisitPlusOneDpDn_android'), defaultTime);
	}
	@Keyword
	def tapOnAllDeliveryMethodsOption(index = 2) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/deliveryMethodsDrpDwn_android',['index':index]), defaultTime);
	}
	@Keyword
	def verifyBeforeOptionDropDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/beforeDropDown_android'), defaultTime);
	}
	@Keyword
	def verifyAfterOptionDropDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/afterOptionDropDn_android'), defaultTime);
	}
	@Keyword
	def verifyStartTimeDropDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/startTimeField_android'), defaultTime);
	}
	@Keyword
	def tapOnStartTimeField() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/startTimeField_android'), defaultTime);
	}
	@Keyword
	def tapOnEndTimeField() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/Any Time Filter/endTimeField_android'), defaultTime);
	}
	@Keyword
	def verifyAtOptionDropDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/atOptionDropDn_android'), defaultTime);
	}
	@Keyword
	def setDateSliderValue() {
		Mobile.setSliderValue(findTestObject('Object Repository/Member/Member360/SearchFunctionality/dateSeekBar_android'), 75, 10)
	}
	@Keyword
	def verifyTimerange(timerange) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/betweenTimeOption_android',["value":timerange]), defaultTime);
	}

	@Keyword
	def tapOnAtOptionDropDown() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/atOptionDropDn_android'), defaultTime);
	}
	@Keyword
	def verifyProviderAppointments(method, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/facilityVisitAppointments_android',["value":method]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnAutoSearchedResultByName(procedure) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/supervisorNameInSearchResults_android', ['value': procedure]), defaultTime)
	}
	@Keyword
	def tapOnOneSpeciality(specialityName) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectOneSpeciality_android',["value":specialityName]), defaultTime);
	}
	@Keyword
	def verifyNotExistViewAllBtn(name) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/procedureProviderViewAllBtn_android', ["value": name]), defaultTime)
	}
	@Keyword
	def tapOnProviderNameSearchCard(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/firstSearchCard_android', ['index': index]), defaultTime);
	}
	@Keyword
	def verifyProviderNameSearchCard(index = 1, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/firstSearchCard_android', ['index': index]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnSecondProviderName() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/secondProviderName_android'), defaultTime);
	}
	@Keyword
	def tapOnThirdProviderName() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/thirdProviderName_android'), defaultTime);
	}
	@Keyword
	def verifyStateNameTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/floridaTxt_android'), defaultTime);
	}
	@Keyword
	def tapOnGenderScrlDnBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/genderScrlDnBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnMaleRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/maleRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnFemaleRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/femaleRadioBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAllAvailabilitiesTitle() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/allAvailabilitiesTitle_android'), defaultTime);
	}

	@Keyword
	def verifyDateOnApptScreen(date) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/dateOnApptScreen_android', ['value': date]), defaultTime);
	}
	@Keyword
	def tapOnProviderViewAllBtn(num) {
		Mobile.scrollToText("View Availabilities", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/providerViewAll_android',["value":num]), defaultTime);
	}

	@Keyword
	def roundOffToNearestQuarter(time) {
		Calendar calendar = Calendar.getInstance()
		calendar.time = time
		int minutes = calendar.get(Calendar.MINUTE)
		int hour = calendar.get(Calendar.HOUR_OF_DAY)

		if (minutes >= 0 && minutes < 15) {
			calendar.set(Calendar.MINUTE, 15)
		} else if (minutes >= 15 && minutes < 30) {
			calendar.set(Calendar.MINUTE, 30)
		} else if (minutes >= 30 && minutes < 45) {
			calendar.set(Calendar.MINUTE, 45)
		} else if (minutes >= 45) {
			if (hour < 23) {
				calendar.add(Calendar.HOUR_OF_DAY, 1)
				calendar.set(Calendar.MINUTE, 0)
			} else {
				calendar.set(Calendar.HOUR_OF_DAY, 0)
				calendar.set(Calendar.MINUTE, 0)
			}
		}

		return calendar.time
	}

	@Keyword
	def verifyFirstAvailableSlot(time, deliveryMethod) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/firstAvailableSlot_android', ['time': time, 'deliveryMethod': deliveryMethod]), defaultTime)
	}

	@Keyword
	def verifyFirstAvailableSlotCondition(time, deliveryMethod) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/firstAvailableSlot_android', ['time': time, 'deliveryMethod': deliveryMethod]), defaultTime, FailureHandling.OPTIONAL)
	}

	@Keyword
	def verifyDeliveryMethodVisible(deliveryMethod) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/deliveryMethodOnProviderAvailabiltiesPage_android', ['value': deliveryMethod]), defaultTime)
	}

	@Keyword
	def tapOnProviderNameSearchField() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchFieldOnSearchResultsPage_android'),defaultTime,onFailure);
	}

	@Keyword
	def VerifyDeliveryMethodAndSlots(deliveryMethod) {
		verifyDeliveryMethodVisible(deliveryMethod)
		verifyDeliveryMethods(deliveryMethod)
	}

	@Keyword
	def getProviderLocation() {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/providerLocation_android'), defaultTime)
	}


	@Keyword
	def selectPaymentMethod(cash, insurance) {
		def responseAddresses = WS.sendRequest(findTestObject('Object Repository/API/deliveryMethod',  ["cash": cash, "insurance": insurance]))
		WS.verifyResponseStatusCode(responseAddresses, 200)
	}

	@Keyword
	def postProviderLoginAndSetToken() {
		def tokenResponse = WS.sendRequest(findTestObject('Object Repository/API/POST Login Auth'))
		WS.verifyResponseStatusCode(tokenResponse, 200)

		GlobalVariable.providerToken =     tokenResponse.getHeaderField("St-Access-Token");

		String responseBody = tokenResponse.getResponseBodyContent()
		JsonSlurper parser = new JsonSlurper()
		def jsonResponseBody = parser.parseText(responseBody)
		GlobalVariable.providerId = jsonResponseBody.user.id

		println "providerToken: " +  GlobalVariable.providerToken

		println "providerId: " + GlobalVariable.providerId
	}

	@Keyword
	def verifyHorizontalScrollbar() {
		Mobile.waitForElementPresent(findTestObject("Object Repository/Member/Member360/SearchFunctionality/horizontalScrollView_android"), defaultTime)
	}

	@Keyword
	def verifyMemberServicesTitle() {
		return Mobile.waitForElementPresent(findTestObject("Object Repository/Member/HomePage/memberServicesTitle_android"), defaultTime)
	}

	@Keyword
	def tapOnHouseCallAppoinmentsTimeSlot(deliveryMethod) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/SearchFunctionality/houseCallAppoinmentsTimeSlot_android', ['deliveryMethod': deliveryMethod]), defaultTime, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/houseCallAppoinmentsTimeSlot_android', ['deliveryMethod': deliveryMethod]), defaultTime);
	}

	@Keyword
	def tapOnSelectApptSlotByIndex(deliveryMethod,index) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectApptSlotByIndex_android', ['deliveryMethod': deliveryMethod,'index':index]), defaultTime);
	}

	@Keyword
	def getApptSlotTime(deliveryMethod) {
		return Mobile.getText(findTestObject('Object Repository/Member/Member360/SearchFunctionality/houseCallAppoinmentsTimeSlot_android', ['deliveryMethod': deliveryMethod]), defaultTime)
	}

	@Keyword
	def chooseRevOneMemberOption() {
		Mobile.delay(2)
		gen.swipeUp()
		try {
			Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/revOneMemberOptn_android'), defaultTime);
		} catch(Exception e) {
			println("Btn not found")
		}
	}

	@Keyword
	def chooseRevPlusMemberOption() {
		Mobile.delay(2)
		gen.swipeUp()
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/revDocPlusMemberOptn_android'), defaultTime);
	}

	@Keyword
	def tapRevPlusMemberBadge() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/revPlusMemberOptn_android'), defaultTime);
	}

	@Keyword
	def tapOnYesBookOptn(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/yesBookOptn_android'), defaultTime);
	}

	@Keyword
	def tapOnCheckOutNowOptn(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/checkOutNow_android'), defaultTime);
	}

	@Keyword
	def tapOnProceedToCheckOut(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/proccedToCheckOut_android'), defaultTime);
	}

	@Keyword
	def tapOnSaveForLater(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/SaveForLater_android'), defaultTime);
	}

	@Keyword
	def tapOnSaveForLaterOnRevPlus(){
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/saveForLaterOnRevPlus_android'), defaultTime);
	}

	@Keyword
	def tapOnTodayOption() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/todayOption_android'), defaultTime);
	}

	@Keyword
	def verifyAppoinmentDetails(txt) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/appoinmentDetails_android', ['value': txt]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnRemoveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/RemoveBtn_android'), defaultTime);
	}

	@Keyword
	def verifyRemoveBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/RemoveBtn_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyRemoveBtnOfRevPlus(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/removeRevPlus_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnMoveToCartBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/moveToCart_android'), defaultTime);
	}

	@Keyword
	def verifyMoveToCartBtn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/moveToCart_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyMoveToCartBtnOfRevPlus(onFailure = FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/moveToCartRevPlus_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifyTextPresent(txt) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/Member360/SearchFunctionality/text_android', ['value': txt]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def tapOnSearchInput() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchInput_android'), defaultTime);
	}

	@Keyword
	def scrollFiltersHorizontallyFromRightToLeft(index = 1) {
		TestObject vscroll = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/horizontalScrollView_android', ['index': index])
		def eHeight = Mobile.getElementHeight(vscroll, 10)
		def eWidth = Mobile.getElementWidth(vscroll, 10)
		def eLeftPos = Mobile.getElementLeftPosition(vscroll, 10)
		def eTopPos = Mobile.getElementTopPosition(vscroll, 10)

		def startx  = eWidth - 100
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = eLeftPos + 300
		//		def endx = eLeftPos + 50
		def endy =  starty

		Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
	}

	@Keyword
	def scrollFiltersHorizontallyFromLeftToRight(index = 1) {
		TestObject vscroll = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/horizontalScrollView_android', ['index': index])
		def eHeight = Mobile.getElementHeight(vscroll, 10)
		def eWidth = Mobile.getElementWidth(vscroll, 10)
		def eLeftPos = Mobile.getElementLeftPosition(vscroll, 10)
		def eTopPos = Mobile.getElementTopPosition(vscroll, 10)

		def startx  = eLeftPos + 100
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = eWidth - 300
		def endy =  starty

		Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyProviderType(providerType, index = 1) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/providerType_android'), providerType, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	def scrollToAnyGenderFilter() {
		int i = 0;
		while(!Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/genderScrlDnBtn_android'), 10, FailureHandling.OPTIONAL) && i <= 5) {
			i = i+1;
			scrollFiltersHorizontallyFromRightToLeft();
		}
	}

	@Keyword
	def scrollToLanguageFilter() {
		int i = 0;
		while(!Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/languageScrlDn_android'), 10, FailureHandling.OPTIONAL) && i <= 5) {
			i = i+1;
			scrollFiltersHorizontallyFromRightToLeft();
		}
	}
	@Keyword
	def scrollToAnyDayFilter() {
		int i = 0;
		while(!Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/anyDayDrpDown_anroid'), 10, FailureHandling.OPTIONAL) && i <= 5) {
			i = i+1;
			scrollFiltersHorizontallyFromRightToLeft();
		}
	}
	@Keyword
	def scrollToAnyTimeFilter() {
		int i = 0;
		while(!Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/anyTimeDropDnBtn_android'), 10, FailureHandling.OPTIONAL) && i <= 5) {
			i = i+1;
			scrollFiltersHorizontallyFromRightToLeft();
		}
	}
	@Keyword
	def horizontalScrollToText(Text, iterations = 2) {
		int i = 0;
		while(!Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': Text]), 10, FailureHandling.OPTIONAL) && i < iterations) {
			i = i+1;
			scrollFiltersHorizontallyFromRightToLeft();
		}
		i = 0;
		while(!Mobile.verifyElementExist(findTestObject('Object Repository/Provider/Registration/elementText_android', ['Text': Text]), 10, FailureHandling.OPTIONAL) && i < iterations) {
			i = i+1;
			scrollFiltersHorizontallyFromLeftToRight();
		}
	}
	
	@Keyword
	def tapOnAnyTimeDropDn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/anyTimeDropDnBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSpecificTimeBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/specificTimeBtn_android'), defaultTime);
	}
	@Keyword
	def tapOncarrotDownBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/carrotDownOnTimeOfCarePopup_android'), defaultTime);
	}
	@Keyword
	def tapOnspecificTimeRange(specificTimeRange) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/specificTimeRange_android',["text":specificTimeRange]), defaultTime);
	}
	@Keyword
	def verifyAndTapOnSpecificDateBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/specificDateBtn_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/specificDateBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnNextDateFromCalendar() {
		Date currentDate = new Date()
		Calendar calendar = Calendar.getInstance()
		calendar.time = currentDate
		calendar.add(Calendar.DAY_OF_MONTH, 1)
		Date nextDate = calendar.time
		SimpleDateFormat dateFormat = new SimpleDateFormat("d")
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/d");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("E, MMM d");
		String formattedDayOfMonth = dateFormat.format(nextDate)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dayOnCalendar_android',["day":formattedDayOfMonth]), defaultTime);
		return [dateFormat2.format(nextDate), dateFormat3.format(nextDate)]
	}
	@Keyword
	def verifyTextOnAnyDayDropDn(monthDay, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dateTxtOnAnyDayDpdn_android',["monthDay":monthDay]), defaultTime, onFailure);
	}
	@Keyword
	def verifySlotDateOnCard(slotDate, index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/seachCardSlotDate_android',["slotDate":slotDate, "index":index]), defaultTime, onFailure);
	}
	@Keyword
	def selectDateOnSearchCard(cardIndex, dateIndex) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/selectDateOnSearchCard_android',  ['cardIndex': cardIndex, 'dateIndex': dateIndex]), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def verifyAddressOnProviderCard(state, index, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.delay(15);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/providerCardAddress_android',["state":state, "index":index]), defaultTime, onFailure);
	}
	@Keyword
	def tapOnLocationDropDn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/locationDropDn_android'), defaultTime);
	}
	@Keyword
	def verifyAndTapOnDateRangeBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dateRangeBtn_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dateRangeBtn_android'), defaultTime);
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
		TestObject hours = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/hourSeekBar_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth/2).toInteger()
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = startx
		def endy =  starty + 100

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/hour']", "content-desc").split(",")[0].trim().toInteger()
		def value =  getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/hour']", "content-desc").split(",")[0].trim().toInteger()
		println("value3": value)
		int i= 1;

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/hour']", "content-desc").split(",")[0].trim().toInteger() != targetValue.toInteger() && i <= 23) {

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
		TestObject hours = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/Any Time Filter/minutesSeekBar_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth/2).toInteger()
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = startx
		def endy =  starty + 100

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/minutes']", "content-desc").split(",")[0].trim().toInteger()

		int i= 1;

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/minutes']", "content-desc").split(",")[0].trim().toInteger() != targetValue.toInteger() && i <= 5) {

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
	def tapOnConfirmBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/Any Time Filter/confirmBtn_andorid'), defaultTime, FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	def getStartTimeTxt() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/Any Time Filter/getStartTimeTxt_android'), defaultTime);
	}
	@Keyword
	def getEndTimeTxt() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/Any Time Filter/getEndTimeText_android'), defaultTime);
	}
	@Keyword
	def verifyTextOnAnyTimeBtn(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/Any Time Filter/textOnAnyTimeBtn_android',["text":text]), defaultTime, onFailure);
	}

	@Keyword
	def selectMonth(targetValue) {
		TestObject hours = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/Any Date Filter/month_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth / 2).toInteger()
		def starty = (eTopPos + (eHeight / 2)).toInteger()
		def endx = startx
		def endy = starty - 100 // Changed to swipe up

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/month']", "content-desc").split(",")[0].trim().toLowerCase()
		int i = 1

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/month']", "content-desc").split(",")[0].trim().toLowerCase() != targetValue.toLowerCase() && i <= 12) {
			Mobile.swipe(startx, starty, endx, endy, FailureHandling.OPTIONAL)
			i = i + 1
		}
	}

	@Keyword
	def selectDay(targetValue) {
		TestObject hours = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/Any Date Filter/day_android')
		def eHeight = Mobile.getElementHeight(hours, defaultTime)
		def eWidth = Mobile.getElementWidth(hours, defaultTime)
		def eLeftPos = Mobile.getElementLeftPosition(hours, defaultTime)
		def eTopPos = Mobile.getElementTopPosition(hours, defaultTime)

		def startx  = eLeftPos + (eWidth/2).toInteger()
		def starty = (eTopPos + (eHeight/2)).toInteger();
		def endx = startx
		def endy =  starty + 100

		def currentValue = getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/date']", "content-desc").split(",")[0].trim().toInteger();
		int i= 1;

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/date']", "content-desc").split(",")[0].trim().toInteger() != targetValue.toInteger() && i <= 31) {

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
		TestObject hours = findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/Any Date Filter/year_android')
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

		while (getAttributeValue("//android.widget.SeekBar[@resource-id='com.revdoc.member:id/year']", "content-desc").split(",")[0].trim().toInteger() != targetValue.toInteger() && i <= 30) {

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
	def selectDate(month, day, year) {
		selectMonth(month);
		selectDay(day);
		selectYear(year);
	}
	// Function to convert time string to Date object
	Date parseTime(String time) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a")
		return format.parse(time)
	}
	// Function to check if a slot starts from 12:00 PM or later
	boolean isSlotValid(String startTime, startTimeTxt) {
		Date slotStartTime = parseTime(startTime)
		Date twelvePM = parseTime(startTimeTxt)
		return slotStartTime.after(twelvePM) || slotStartTime.equals(twelvePM)
	}
	//Function to check if a slot before 12pm
	boolean isBeforeSlotValid(String startTime, startTimeTxt) {
		Date slotStartTime = parseTime(startTime)
		Date twelvePM = parseTime(startTimeTxt)
		return slotStartTime.before(twelvePM)
	}
	boolean isBetweenSlotValid(String startTime, String startTimeTxt, String endTimeTxt) {
		Date slotStartTime = parseTime(startTime)
		Date startTimeRange = parseTime(startTimeTxt)
		Date endTimeRange = parseTime(endTimeTxt)
		return (slotStartTime.after(startTimeRange) || slotStartTime.equals(startTimeRange)) && slotStartTime.before(endTimeRange)
	}
	@Keyword
	def verifySlotsAfterSpecificTime(startTimeTxt, time1, time2, time3, time4) {
		// Example slot timings
		def slotTimings = [time1, time2, time3, time4]
		// Iterate through slot timings and check validity
		for (String slotTime : slotTimings) {
			if (!isSlotValid(slotTime, startTimeTxt)) {
				KeywordUtil.markFailed("Slot timing ${slotTime} is before ${startTimeTxt}")
				break
			}
		}
	}
	@Keyword
	def verifySlotsBeforeSpecificTime(startTimeTxt, time1, time2, time3, time4) {
		// Example slot timings
		def BeforeSlotTimings = [time1, time2, time3, time4]
		// Iterate through slot timings and check validity
		for (String slotTime : BeforeSlotTimings) {
			if (!isBeforeSlotValid(slotTime, startTimeTxt)) {
				KeywordUtil.markFailed("Slot timing ${slotTime} is After ${startTimeTxt}")
				break
			}
		}
	}
	@Keyword
	def verifySlotsBetweenSpecificTime(startTimeTxt, endTimeTxt, time1, time2, time3, time4) {
		def slotTimings = [time1, time2, time3, time4]
		for (String slotTime : slotTimings) {
			if (!isBetweenSlotValid(slotTime, startTimeTxt, endTimeTxt)) {
				println "Slot timing ${slotTime} is invalid. It does not fall between ${startTimeTxt} and ${endTimeTxt}."
			} else {
				println "Slot timing ${slotTime} is valid."
			}
		}
	}

	@Keyword
	def tapOnLocationIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/locationIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnAnyDayDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/anyDayDrpdwn_android'), defaultTime);
	}
	@Keyword
	def tapOnDateFromCalendar(date) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dayOnCalendar_android',["day":date]), defaultTime);
	}

	@Keyword
	def tapOnFacilityRadiusBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/facilityRadiusBtn_andriod'), defaultTime)
	}

	@Keyword
	def tapOnDateInCalendar(int date) {
		int position
		if(date <= 20) {
			position = 1
		}
		else {
			position = MobileDriverFactory.getDriver().findElementsByXPath("//android.widget.TextView[@text='${date}']").size()
		}
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dateInCalendar',["day":date, "index": position]), defaultTime);
	}

	@Keyword
	def getFutureDateFromRealCalendar(int inputDate,int daysToAdd) {

		//import java.text.SimpleDateFormat
		// java.util.Calendar
		// Input date  // Day of the month

		// Create a SimpleDateFormat object for input and output date format
		SimpleDateFormat sdf = new SimpleDateFormat("d")

		// Get the current date
		Calendar calendar = Calendar.getInstance()

		// Set the day of the month for the current date
		calendar.set(Calendar.DAY_OF_MONTH, inputDate)

		// Add 7 days to the input date
		calendar.add(Calendar.DAY_OF_MONTH, 7)

		// Get the output date
		Date outputDate = calendar.getTime()

		// Format the output date
		String outputDateStr = sdf.format(outputDate)

		println("--------Output date after 7 days: " + outputDateStr)
		return Integer.parseInt(outputDateStr)
	}

	@Keyword
	def verifyParticularDatePresent(Date) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectSpecificDate_android',["date":Date]), defaultTime)
	}

	@Keyword
	def verifyParticularDateNotPresent(Date) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/selectSpecificDate_android',["date":Date]), defaultTime)
	}

	@Keyword
	def tapOnPencilIconInSearch() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/pencilIconInSearch'), defaultTime);
	}

	@Keyword
	def tapOnSearchBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBack'), defaultTime)
	}

	@Keyword
	def tapOnCloseIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/tapOnCloseIcon_android'), defaultTime)
	}
	@Keyword
	def verifyCloseIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/tapOnCloseIcon_android'), defaultTime, onFailure);
	}

	@Keyword
	def selectASpecificSpeciality(specialityName = "Cardiologist") {
		tapOnSpecialitiesDrpDn();
		typeInSpecialitiesTxtBx(specialityName);
		tapOnOneSpeciality(specialityName);
	}

}
