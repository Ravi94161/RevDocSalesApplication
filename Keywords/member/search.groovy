package member

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
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


import internal.GlobalVariable

public class Search {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;

	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;

	def failureHandle = FailureHandling.CONTINUE_ON_FAILURE

	// Home search
	@Keyword
	def tapOnHomeSearchField() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/search_field_android'), defaultTime);
	}

	@Keyword
	def tapOnSearchOptionInProviderList() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/searchOptionInProviderList_'+os), defaultTime);
	}

	@Keyword
	def verifySearchFieldElementExist() {

		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/search_field_android'), defaultTime, onFailure);

		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/search_field_android'), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);

	}

	// Select Address bottom screen
	@Keyword
	def veriySelectAddressTitle() {

		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/selectAddressTitle_android'), 'Select Address', onFailure);

		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/selectAddressTitle_android'), 'Select Address',failureHandle);

	}

	@Keyword
	def tapOnSearchLocationsField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/searchLocationField_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchLocationsFieldElementExist() {

		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/searchLocationField_android'), defaultTime, onFailure);

		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/searchLocationField_android'), defaultTime,failureHandle);

	}

	@Keyword
	def enterInputInSearchLocationField(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/searchLocationField_android'), txt, defaultTime)
	}

	@Keyword
	def tapSearchResult(txt) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/searchResults_android', ['txt': txt]), defaultTime)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/searchResults_android', ['txt': txt]), defaultTime)
	}

	@Keyword
	def tapFirstSearchResult() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/firstSearchResults_android'), 15)
	}

	// Search Results
	@Keyword
	def verifySearchForCareTitle() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/searchForCareTitle_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnSearchField() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/search_field_android'), defaultTime);
	}

	@Keyword
	def tapOnSeachPencilIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/searchPencilIcon_android'), defaultTime);
	}

	@Keyword
	def enterInputInSearchField(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Search/searchInputField_android'), txt, defaultTime)
	}

	@Keyword
	def tapInputInSearchField() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/searchInputField_android'), defaultTime)
	}

	@Keyword
	def verifyDeliveryMethodsDrpdwn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/deliveryMethodsDrpDwn_android'), defaultTime, onFailure)
	}


	@Keyword
	def verifyCardsOnSearchpage(cardType) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/cardsOnSearchpage_android', ['value': cardType]), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/editBtnsOnCardsOnSearchpage_android', ['value': cardType]), defaultTime)
	}

	@Keyword
	def tapOnCardsOnSearchpage(cardType) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/cardsOnSearchpage_android', ['value': cardType]), defaultTime)
	}

	@Keyword
	def verifyBottomSheetTitle(title) {
		Mobile.verifyElementText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/bottomSheetTitle_android'), "Location")
	}

	@Keyword
	def tapOnAddress(address) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/searchAddress_android', ['address': address]), defaultTime)
	}

	@Keyword
	def verifyClearBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/clearBtn_android'), defaultTime)
	}

	@Keyword
	def verifySearchBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/searchBtn_android'), defaultTime)
	}

	@Keyword
	def enterInputInSearchField1(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/searchInputField_android'), txt, defaultTime)
	}

	@Keyword
	def tapOnClearBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/clearBtn_android'), defaultTime)
	}

	@Keyword
	def verifyBronchoscopyProcedureNotVisible(procedure) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/bronchoscopyProcedure_android', ['value': procedure]), defaultTime)
	}

	@Keyword
	def tapOnAutoSearchedResult(procedure) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/autoSearchedOption_android', ['value': procedure]), defaultTime,  FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/autoSearchedOption_android', ['value': procedure]), defaultTime)
	}

	@Keyword
	def verifyAutoSearchedResult(txt) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/autoSearchedOption_android', ['value': txt]), defaultTime)
	}

	@Keyword
	def tapOnDateOnSearchCard(date) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dateOnSearchCard_android', ['value': date]), defaultTime)
	}

	@Keyword
	def verifyCloseBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/closeBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/closeBtn_android'), defaultTime)
	}

	@Keyword
	def verifyLabelsOnSearchpage(txt) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/labelsOnSearchPage_android', ['value': txt]), defaultTime)
	}

	@Keyword
	def verifyAbsenceOfLabelsOnSearchpage(txt) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/labelsOnSearchPage_android', ['value': txt]), defaultTime)
	}

	@Keyword
	def verifyCardiologistlabel() {
		for (int i = 1 ; i<=3 ; i++) {
			Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/specialityInSearchCards_android', ['index': i]), defaultTime)
		}
	}

	@Keyword
	def tapOnSearchFielsOnResultsScreen() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/serachBarOnResultsScreen_android'), defaultTime)
	}

	@Keyword
	def verifySupervisorNameInSearchResults(name) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/supervisorNameInSearchResults_android', ['value': name]), defaultTime)
	}
	@Keyword
	def tapOnSearchBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/searchBtn_android'), defaultTime)
	}
	@Keyword
	def tapOnLocationLabel() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/labelsOnSearchPage_android',["value":'Location']), defaultTime);
	}
	@Keyword
	def tapOnDateLabel() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/labelsOnSearchPage_android',["value":"Date"]), defaultTime);
	}
	@Keyword
	def tapOnTimeLabel() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/labelsOnSearchPage_android',["value":"Time"]), defaultTime);
	}
	@Keyword
	def clearMilesTxtBx() {
		Mobile.clearText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/milesTxtBx_android'), defaultTime);
	}
	@Keyword
	def typeInMilesTxtBx(miles) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/milesTxtBx_android'),miles,defaultTime);
	}
	@Keyword
	def tapOnLocationRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/locationRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSaveBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/saveBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnselectedDateCare(DateCare) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/selectDateOfCare_android',["value":DateCare]), defaultTime);
	}
	@Keyword
	def tapOnselectedTimeOfCare(TimeCare) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/selectDateOfCare_android',["value":TimeCare]), defaultTime);
	}
	@Keyword
	def tapOnParticularDate(Date) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/selectSpecificDate_android',["date":Date]), defaultTime);
	}
	@Keyword
	def tapOnStartDate() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/startDate_android'), defaultTime);
	}
	@Keyword
	def tapOnEndDate() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/startDate_android'), defaultTime);
	}
	@Keyword
	def tapOnConformBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/conformBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnSpecificTimeScrollBar() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/specificTimeScrollBar_android'), defaultTime);
	}
	@Keyword
	def tapOnTimerange(timerange) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/betweenTimeOption_android',["value":timerange]), defaultTime);
	}
	@Keyword
	def getAddressFromLocatioCard(cardType) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/locationAddress_android', ["value": cardType]), defaultTime);
	}

	@Keyword
	def getDateAndTimeFromSearchPage(cardType) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/timeAndDateFieldsOnSearchPage_android', ["value": cardType]), defaultTime);
	}

	@Keyword
	def verifyFilteredSearch(txt) {
		Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/cardsOnSearchpage_android', ['value': txt]), defaultTime);
	}

	@Keyword
	def verifyProcedureProviderExist(name) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/procedureProvider_android', ["value": name]), defaultTime)
	}
	@Keyword
	def verifyProcedureProviderNotExist(name) {
		Mobile.verifyElementNotVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/procedureProvider_android', ["value": name]), defaultTime)
	}

	@Keyword
	def tapOnViewAllBtn(name) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/procedureProviderViewAllBtn_android', ["value": name]), defaultTime)
	}

	@Keyword
	def verifyCalendarVisible(name, month) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/calendar_android', ["value": name]), defaultTime)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/currentMonth_android', ["month": month]), defaultTime)
	}

	@Keyword
	def tapOnCloseBtnInSearchBar() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/closeBtnInSearchBar_android'), defaultTime)
	}

	@Keyword
	def tapOnBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/backBtn_android'), defaultTime)
	}

	@Keyword
	def tapOnProviderCalendarBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/providerCalendarBackBtn'), defaultTime)
	}

	@Keyword
	def tapOnAddedDataInSearchBar(txt) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/autoSearchedOption_android', ['value': txt]), defaultTime)
	}

	@Keyword
	def tapOnButtonsheetClose() {
		Mobile.tap(findTestObject('Member/HomePage/Search/SearchFunctionality/bottomSheetClose_android'), defaultTime);
	}

	@Keyword
	def verifyDeliveryMethods(methodName) {
		// this method verifies slots under delivery method need to change its name
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/deliveryMethods_android',["value":methodName]), defaultTime);
	}
	@Keyword
	def tapOnDeliveryMethodsDrpdwn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/deliveryMethodsDrpDwn_android'), defaultTime);
	}
	@Keyword
	def verifysearchLocationInputField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/searchLocationInputField_android'), defaultTime);
	}
	@Keyword
	def verifyselectedDateOfCare(DateCare) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/selectDateOfCare_android',["value":DateCare]), defaultTime);
	}
	@Keyword
	def verifyselectedTimeOfCare(TimeCare) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/selectDateOfCare_android',["value":TimeCare]), defaultTime);
	}
	@Keyword
	def verifyTodayOption() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/todayOption_android'), defaultTime);
	}
	@Keyword
	def verifySpecificDateOnAppointment(date) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/selectDateOfCare_android',["value":date]), defaultTime);
	}
	@Keyword
	def verifyStartDateField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/startDate_android'), defaultTime);
	}
	@Keyword
	def verifyEndDateField() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/endDateField_android'), defaultTime);
	}
	@Keyword
	def tapOnLanguageScrlDn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/languageScrlDn_android'), defaultTime);
	}
	@Keyword
	def tapOnEnglishRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/englishRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnfirstProviderOnSearchReasult() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/firstProviderInSearchResult_android'), defaultTime);
	}
	@Keyword
	def verifyEnglishTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/englishText_android'), defaultTime);
	}
	@Keyword
	def typeInSpecialitiesTxtBx(specialities) {
		Mobile.setText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/specialitiesTxtBx_android'), specialities, defaultTime);
		Mobile.hideKeyboard();
	}
	@Keyword
	def tapOnSpecialitiesDrpDn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/specialityDrpdn_android'), defaultTime);
	}
	@Keyword
	def tapOnDermatologistOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dermatologistOption_android'), defaultTime);
	}
	@Keyword
	def verifyDermatologistProvider() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dermatologistProvider_android'), defaultTime);
	}
	@Keyword
	def tapOnResetFilterBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/resetFilterBtn_android'), defaultTime);
	}
	@Keyword
	def verifyfirstProviderOnSearchReasult() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/firstProviderInSearchResult_android'), defaultTime);
	}

	@Keyword
	def verifySpecialityFilter(speciality) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/specialityFilter_android', ['speciality': speciality]), defaultTime);
	}

	@Keyword
	def getFirstProviderName() {
		return Mobile.getText(findTestObject('Member/HomePage/Search/SearchFunctionality/firstProviderName_android'), defaultTime);
	}

	@Keyword
	def tapOnSearchResultspageSearchBar(txt) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/cardsOnSearchpage_android', ['value': txt]), defaultTime);
	}
	@Keyword
	def tapOnAllDeliveryMethodsRdBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/allDeliveryMethodsRdBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnFacilityVisitRdBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/facilityVisitRdBtn_android'), defaultTime);
	}
	@Keyword
	def verifyFacilityVisitBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/facilityVisitRdBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnfyFacilityVisitBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/facilityVisitRdBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnVanCallRdBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/vanCallRdBtn_android'), defaultTime);
	}
	@Keyword
	def verifyFacilityVisitPlusOneMoreBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/facilityVisitPlusOneDpDn_android'), defaultTime);
	}
	@Keyword
	def tapOnFacilityVisitPlusOneMoreBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/facilityVisitPlusOneDpDn_android'), defaultTime);
	}
	@Keyword
	def tapOnAllDeliveryMethodsOption() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/deliveryMethodsDrpDwn_android'), defaultTime);
	}
	@Keyword
	def verifyBeforeOptionDropDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/beforeDropDown_android'), defaultTime);
	}
	@Keyword
	def verifyAfterOptionDropDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/afterOptionDropDn_android'), defaultTime);
	}
	@Keyword
	def verifyStartTimeDropDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/startTimeField_android'), defaultTime);
	}
	@Keyword
	def verifyAtOptionDropDown() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/atOptionDropDn_android'), defaultTime);
	}
	@Keyword
	def setDateSliderValue() {
		Mobile.setSliderValue(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dateSeekBar_android'), 75, 10)
	}
	@Keyword
	def verifyTimerange(timerange) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/betweenTimeOption_android',["value":timerange]), defaultTime);
	}

	@Keyword
	def tapOnAtOptionDropDown() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/atOptionDropDn_android'), defaultTime);
	}
	@Keyword
	def verifyProviderAppointments(method) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/facilityVisitAppointments_android',["value":method]), defaultTime);
	}
	@Keyword
	def tapOnAutoSearchedResultByName(procedure) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/supervisorNameInSearchResults_android', ['value': procedure]), defaultTime)
	}
	@Keyword
	def tapOnOneSpeciality(specialityName) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/selectOneSpeciality_android',["value":specialityName]), defaultTime);
	}
	@Keyword
	def verifyNotExistViewAllBtn(name) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/procedureProviderViewAllBtn_android', ["value": name]), defaultTime)
	}
	@Keyword
	def tapOnProviderName(text, index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/firstProviderName_android', ["text":text, 'index': index]), defaultTime);
	}
	
	@Keyword
	def tapOnProviderProfile() {
		Mobile.tap(findTestObject('Object Repository/Member/Member Provider Profile/providerProfile_android'), defaultTime);
	}
	
	@Keyword
	def tapOnSecondProviderName() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/secondProviderName_android'), defaultTime);
	}
	@Keyword
	def tapOnThirdProviderName() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/thirdProviderName_android'), defaultTime);
	}
	@Keyword
	def verifyFloridaTxt() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/floridaTxt_android'), defaultTime);
	}
	@Keyword
	def tapOnGenderScrlDnBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/genderScrlDnBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnMaleRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/maleRadioBtn_android'), defaultTime);
	}
	@Keyword
	def tapOnFemaleRadioBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/femaleRadioBtn_android'), defaultTime);
	}

	@Keyword
	def verifyAllAvailabilitiesTitle() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/allAvailabilitiesTitle_android'), defaultTime);
	}

	@Keyword
	def verifyDateOnApptScreen(date) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/dateOnApptScreen_android', ['value': date]), defaultTime);
	}
	@Keyword
	def tapOnProviderViewAllBtn(num) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/providerViewAll_android',["value":num]), defaultTime);
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
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/firstAvailableSlot_android', ['time': time, 'deliveryMethod': deliveryMethod]), defaultTime)
	}

	@Keyword
	def verifyDeliveryMethodVisible(deliveryMethod) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/deliveryMethodOnProviderAvailabiltiesPage_android', ['value': deliveryMethod]), defaultTime)
	}

	@Keyword
	def searchProviderByName(txt, name) {
		tapOnSearchResultspageSearchBar(txt)
		tapOnClearBtn()
		tapOnSearchField()
		enterInputInSearchField(name)
	}

	@Keyword
	def VerifyDeliveryMethodAndSlots(deliveryMethod) {
		verifyDeliveryMethodVisible(deliveryMethod)
		verifyDeliveryMethods(deliveryMethod)
	}

	@Keyword
	def getProviderLocation() {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/providerLocation_android'), defaultTime)
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
	def verifyHorizontalScrollbar(index = 1,onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.delay(5)
		Mobile.waitForElementPresent(findTestObject("Object Repository/Member/HomePage/Search/SearchFunctionality/horizontalScrollView_android", ["index":index]), defaultTime, onFailure)
	}

	@Keyword
	def verifyMemberServicesTitle() {
		return Mobile.waitForElementPresent(findTestObject("Object Repository/Member/HomePage/memberServicesTitle_android"), defaultTime)
	}

	@Keyword
	def searchLocation(searchAddress = GlobalVariable.searchAddress) {
		verifySearchFieldElementExist();
		tapOnHomeSearchField();
		veriySelectAddressTitle();

		// Search for the location
		verifySearchLocationsFieldElementExist();
		tapOnSearchLocationsField();
		enterInputInSearchLocationField(searchAddress);
		Mobile.hideKeyboard();
		tapFirstSearchResult();
	}
	
	@Keyword
	def selectAddress(searchAddress = GlobalVariable.searchAddress1) {
		tapOnHomeSearchField();
		tapOnSearchLocationsField();
		enterInputInSearchLocationField(searchAddress);
		Mobile.hideKeyboard();
		tapFirstSearchResult();
	}
}
