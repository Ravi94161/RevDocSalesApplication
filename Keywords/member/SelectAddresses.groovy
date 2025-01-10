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
import mobile.Generic
import mobile.MobileActions

public class SelectAddresses {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	def onFailure=FailureHandling.CONTINUE_ON_FAILURE;
	SearchForCare search = new SearchForCare();
	Generic gen = new Generic();
	MobileActions mob = new MobileActions()


	@Keyword
	def setTxtInSearchLocationsField(txt) {
		try {
			Mobile.setText(findTestObject('Object Repository/Member/SelectAddresses/searchLocationsField_android'), txt, defaultTime);
			Mobile.hideKeyboard(FailureHandling.OPTIONAL);
		}
		catch(Exception e) {
			Mobile.setText(findTestObject('Object Repository/Member/Member360/ElectronicHealthRecord/Demographics/addressField_android'), txt, defaultTime)
			Mobile.hideKeyboard(FailureHandling.OPTIONAL);
		}
	}
	@Keyword
	def setTxtInSearchForAnAddressField(txt) {
		Mobile.delay(5)
		Mobile.setText(findTestObject('Object Repository/Member/SelectAddresses/searchForAnAddress_andriod'), txt, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnAddressOf(txt, index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/SelectAddresses/selectAddress_android',["txt":txt, "index": index]), defaultTime);
	}
	@Keyword
	def verifySearchLocationsField(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SelectAddresses/searchLocationsField_android'), defaultTime, onFailure);
	}
	@Keyword
	def tapFirstSearchResult() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/firstSearchResults_android'), 15)
	}
	@Keyword
	def tapFirstSearchResultStar() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/firstSearchResultStar_android'), 15)
	}
	@Keyword
	def verifyFirstSearchResult(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/firstSearchResults_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySecondSearchResult(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/secondSearchResults_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySecondSearchResultNotExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/secondSearchResults_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifyFirstSearchResultAddress(address) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/verifySearchAddressFirstResult_android',['address':address]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnLocationDpn(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/locationDpn_android'), defaultTime, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/locationDpn_android'), defaultTime, onFailure);
		Mobile.hideKeyboard();
	}

	@Keyword
	def verifyLocationSearchOption(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/locationDpn_android'), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSearchField(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBar_android'), defaultTime, onFailure);
		Mobile.tap(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBar_android'), defaultTime, onFailure);
	}
	@Keyword
	def verifySearchField(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBar_android'), defaultTime, onFailure);
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchBar_android'), defaultTime, onFailure);
	}
	@Keyword
	def typInProviderOrProcedureSearhField(txt) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/SearchForCare/providerSearchField_android'),defaultTime,onFailure);
		Mobile.setText(findTestObject('Object Repository/Member/SearchForCare/providerSearchField_android'), txt, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnSearchResult(text, index = 1) {
		if(text == "General Procedure") {
			index = 1
		}
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/searchResult_android', ['text':text, 'index':index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSearchResultOption(text, index = 1) {
		if(text == "General Procedure") {
			index = 2
		}
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/searchResultOption_android', ['text':text, 'index':index]), defaultTime, onFailure);
	}

	@Keyword
	def tapOnSearchResultProcedure(text, index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/searchResult_android', ['text':text, 'index':index]), defaultTime, onFailure);
	}

	@Keyword
	def procedureEditBtn(procedurename, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/procedureEditBtn_andriod', ["procedurename": procedurename]), defaultTime, onFailure)
	}
	@Keyword
	def verifySearchResult(text, index = 1) {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Member/Member360/MemberAppointments/searchResult_android', ['text':text, 'index':index]), defaultTime)
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/searchResult_android', ['text':text, 'index':index]), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyRevprivateBadgeNotExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Search/revPrivatebadge_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchResultNotExist(text, index = 1) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/searchResult_android', ['text':text, 'index':index]), defaultTime, FailureHandling.CONTINUE_ON_FAILURE);
	}

	@Keyword
	def tapOnSearchIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/searchIcon_android'), defaultTime);
	}

	@Keyword
	def tapOnSearchInput() {
		search.tapOnCrossIconOnProfile();
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/searchIcon_android'), defaultTime)
	}

	@Keyword
	def tapOnSearchNewIcon(onFailure =FailureHandling.OPTIONAL, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/searchIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def searchAddressAndProviderOrProcedure(address, providerOrProcedure, providerOrProcedureSearchResult) {
		setAddress(address)
		tapOnSearchIcon();
		Mobile.hideKeyboard();
		typInProviderOrProcedureSearhField(providerOrProcedure);
		Mobile.hideKeyboard();
		verifySearchResult(providerOrProcedureSearchResult)
		tapOnSearchResult(providerOrProcedureSearchResult)
	}

	@Keyword
	def searchAddressAndProviderOrProcedureViewAll(address, providerOrProcedure, providerOrProcedureSearchResult) {
		searchAddressAndProviderOrProcedure(address, providerOrProcedure, providerOrProcedureSearchResult)
		search.tapOnViewAllBtn();
		Mobile.delay(10)
	}

	@Keyword
	def searchAddressProviderProcedure(address, provider, providerNameSearchResult, procedure) {
		setAddress(address)
		tapOnSearchIcon();
		Mobile.hideKeyboard();
		typInProviderOrProcedureSearhField(provider);
		Mobile.hideKeyboard();
		tapOnSearchResult(providerNameSearchResult)
		Mobile.delay(3)
		tapOnSearchNewIcon();
		Mobile.hideKeyboard();
		typInProviderOrProcedureSearhField(procedure);
		Mobile.hideKeyboard();
		tapOnSearchResult(procedure)
	}
	@Keyword
	def searchAddressProviderProcedureViewAll(address, provider, providerNameSearchResult, procedure) {
		searchAddressProviderProcedure(address, provider, providerNameSearchResult, procedure)
		search.tapOnViewAllBtn();
		Mobile.delay(10)
	}
	@Keyword
	def searchProviderProcedureViewAll(provider, providerNameSearchResult, procedure) {
		tapOnSearchField();
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
		typInProviderOrProcedureSearhField(provider);
		tapOnSearchResult(providerNameSearchResult)
		tapOnSearchNewIcon();
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
		typInProviderOrProcedureSearhField(procedure);
		tapOnSearchResult(procedure)
		search.tapOnViewAllBtn();
		Mobile.delay(10)
	}

	@Keyword
	def searchProviderViewAll(provider, providerNameSearchResult) {
		tapOnSearchField();
		Mobile.hideKeyboard();
		typInProviderOrProcedureSearhField(provider);
		tapOnSearchResult(providerNameSearchResult)
		Mobile.delay(10)
		search.tapOnViewAllBtn();
		Mobile.delay(10)
	}

	@Keyword
	def categorySearchAddressAndProviderOrProcedureViewAll(address, providerOrProcedure, providerOrProcedureSearchResult) {
		setAddress(address)
		tapOnSearchIcon()
		Mobile.hideKeyboard();
		tapOnSearchNewIcon();
		Mobile.hideKeyboard();
		typInProviderOrProcedureSearhField(providerOrProcedure);
		tapOnSearchResult(providerOrProcedureSearchResult)
		search.tapOnViewAllBtn();
		Mobile.delay(10)
	}

	@Keyword
	def searchAddressAndProcedure(address, procedure) {
		setAddress(address)
		tapOnSearchIcon()
		typInProviderOrProcedureSearhField(procedure);
		tapOnSearchResult(procedure)
		Mobile.delay(10)
	}

	@Keyword
	def searchAddressProviderOrProcedureVerifyNotExist(address, providerOrProcedure, providerOrProcedureSearchResult) {
		setAddress(address)
		tapOnSearchIcon();
		typInProviderOrProcedureSearhField(providerOrProcedure);
		verifySearchResultNotExist(providerOrProcedureSearchResult)
	}

	@Keyword
	def searchProviderOrProcedureInSearchScreen(providerOrProcedure, providerOrProcedureSearchResult) {
		tapOnSearchNewIcon();
		typInProviderOrProcedureSearhField(providerOrProcedure);
		tapOnSearchResult(providerOrProcedureSearchResult)
		search.tapOnViewAllBtn();
	}

	@Keyword
	def setTxtInSearchLocationsFieldForLatest(txt) {
		Mobile.setText(findTestObject('Object Repository/Member/SelectAddresses/searchLocationFieldLatest_android'), txt, defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}
	@Keyword
	def tapOnProviderSearch() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/providerSearchField_android'), defaultTime);
		Mobile.hideKeyboard(FailureHandling.OPTIONAL);
	}

	@Keyword
	def verifyNoResultsFound(text) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/noResultsFound'), defaultTime);
	}

	@Keyword
	def tapOnHomeIcon() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/homeIcon_android'), defaultTime, FailureHandling.OPTIONAL);
	}

	@Keyword
	def setAddress(address) {
		tapOnHomeIcon()
		tapOnLocationDpn()
		setTxtInSearchLocationsField(address);
		tapFirstSearchResult();
		Mobile.delay(5)
	}

	@Keyword
	def searchAndSelectAddress(address) {
		setTxtInSearchLocationsField(address);
		tapFirstSearchResult();
		Mobile.delay(5)
	}

	@Keyword
	def tapOnAnySavedLocation(index) {
		Mobile.tap(findTestObject('Object Repository/Member/SelectAddresses/SelectAnySavedLocation_android', ['index':index]), defaultTime);
	}

	@Keyword
	def verifySerachLocationsFiledNotExist(onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/SelectAddresses/searchLocationsField_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchAddressResultByIndex(index,address) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/verifySearchAddressResultByIndex_android', ['index':index, 'address':address]), defaultTime,onFailure);
	}

	@Keyword
	def verifyStarForSearchHistoryAddress(index,address,star) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/verifyStarForSearchHistoryAddress_android', ['index':index, 'address':address, 'star':star]), defaultTime,onFailure);
	}

	@Keyword
	def verifyStarForSearchResultsAddress(address,star) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/verifyStarForSearchResultsAddress_android', ['address':address, 'star':star]), defaultTime,onFailure);
	}

	@Keyword
	def verifyStarForSavedLocationsAddress(address,star) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/verifyStarForSearchResultsAddress_android', ['address':address, 'star':star]), defaultTime,onFailure);
	}

	@Keyword
	def verifySavedLocationsSearchAddress(address) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/verifySavedLocationsSearchAddress_android', ['address':address]), defaultTime,onFailure);
	}
	@Keyword
	def tapOnBookAGeneralAppoinmentOpt() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/bookAGeneralAppoinment_andriod'), defaultTime)
	}

	@Keyword
	def verifyExploreBtnRevPrivate() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SelectAddresses/exploreBtnRevPrivate_android'), defaultTime)
	}

	@Keyword
	def tapOnExploreBtnRevPrivate() {
		Mobile.tap(findTestObject('Object Repository/Member/SelectAddresses/exploreBtnRevPrivate_android'), defaultTime)
	}
	@Keyword
	def tapOnProviderInfoBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/providerInfoBtn_andriod'), defaultTime)
	}
	@Keyword
	def tapOnProviderProfileXBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/Insurance/xBtn_andriod'), defaultTime)
	}
	@Keyword
	def verifyProcedureInfoBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/MemberAppointments/procedureInfoOption_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnProcedureInfoBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/procedureInfoOption_android'), defaultTime, onFailure)
	}
	@Keyword
	def tapOnCloseBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Member360/MemberAppointments/ProviderProfile/closeBtn_android'), defaultTime)
	}
	@Keyword
	def verifySearchProviderCard(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/providerSearchCard_andriod'), defaultTime, onFailure)
	}

	@Keyword
	def verifySearchNewIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/searchIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyShareIcon(onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/shareIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnProfileBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/profileBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def verifyNotifyMeBtnExists() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/notifyMeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnNotifyBtnOnProgram(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/notifyBtnOnProgram_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnNotifyMeBtn(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/SearchForCare/notifyMeBtn_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnProcedureInfoIcon(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/procedureInfoIcon_android'), defaultTime, onFailure)
	}

	@Keyword
	def tapOnFavoriteIconInProcedureInfo(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/favoriteIconInProcedurePage_android'), defaultTime, onFailure)
	}

	@Keyword
	def VerifyFavoriteIconInProcedureInfo(onFailure =FailureHandling.CONTINUE_ON_FAILURE) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchLocation/favoriteIconInProcedurePage_android'), defaultTime, onFailure)
	}
}
