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

public class SearchResults {
	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	Generic gen = new Generic();
	MobileActions mob = new MobileActions()

	@Keyword
	def verifyViewAllBtnForProvider(providerName) {
		Mobile.delay(2);
		Mobile.scrollToText(providerName);
		if(!Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/viewAllBtnforProvider_android', ['name': providerName]), 5, FailureHandling.OPTIONAL)) {
			gen.swipeUpLittle();
		}
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/viewAllBtnforProvider_android', ['name': providerName]), defaultTime);
	}

	@Keyword
	def tapViewAllBtnForProvider(providerName) {
		//verifyViewAllBtnForProvider(providerName);
		//def index = 1
		//println("getApptCountOnSlot": getApptCountOnSlot(providerName, index))
		//if( getApptCountOnSlot(providerName, index).toInteger() > 10) {
		//	println("inside if")
		Mobile.scrollToText("View Availabilities", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/viewAllBtnforProvider_android', ['name': providerName]), defaultTime);
		//} else {
		//println("inside else")
		//tapApptCountOnSlot(providerName, index + 1)
		//}
	}

	@Keyword
	def tapOnViewAllBtnByIndex(index) {
		TestObject testObject = findTestObject('Object Repository/Member/SearchForCare/viewAllBtn_android',["index": index])
		mob.scrollUntilElementIsVisible(testObject)
		//		Mobile.scrollToText("View Availabilities", FailureHandling.OPTIONAL)
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/viewAllBtnByIndex_android',['index':index]), defaultTime);
	}

	@Keyword
	def verifySearchFieldText(name, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/searchFieldText_android',  ['name': name]), defaultTime, onFailure)
	}

	@Keyword
	def getApptCountOnSlot(providerName, index = 1, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime ) {
		return Mobile.getText(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/availabilitySlotCount_android', ['name': providerName, 'index': index]),defaultTime, onFailure)
	}

	@Keyword
	def tapApptCountOnSlot(providerName, index = 1, onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime ) {
		return Mobile.tap(findTestObject('Object Repository/Member/HomePage/Search/SearchResults/availabilitySlotCount_android', ['name': providerName, 'index': index]),defaultTime, onFailure)
	}

	@Keyword
	def tapOnSearchResult(onFailure = FailureHandling.STOP_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.tap(findTestObject('Object Repository/Provider/HomePage/OpenTasks/EHR/avatar_android'), defaultTime, onFailure);
	}

	@Keyword
	def verifySearchResults() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Member360/SearchFunctionality/searchResultCard_android'), defaultTime)
	}

	@Keyword
	def tapOnSearchBackBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/Search/searchBack_android'), defaultTime)
	}
	//---------------------programs available----------------------------------------
	@Keyword
	def getAvailableProgramName(index = 1) {
		return Mobile.getText(findTestObject('Object Repository/Member/SearchForCare/ProgramsAvailable/getProgramName_android', ["index":index]), defaultTime);
	}

	@Keyword
	def verifyProgramsViewAllBtn(isExist = true, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/ProgramsAvailable/programsViewAllBtn_android'), defaultTime, onFailure)
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/SearchForCare/ProgramsAvailable/programsViewAllBtn_android'), defaultTime, onFailure)
		}

	}

	@Keyword
	def verifyListOfPrograms(isExist = true, onFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		if(isExist) {
			Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/ProgramsAvailable/listOfPrograms_android'), defaultTime, onFailure)
		}else {
			Mobile.verifyElementNotExist(findTestObject('Object Repository/Member/SearchForCare/ProgramsAvailable/listOfPrograms_android'), defaultTime, onFailure)
		}

	}
	//---------------------end - programs available----------------------------------------
}
