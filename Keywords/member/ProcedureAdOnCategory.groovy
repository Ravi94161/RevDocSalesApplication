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

public class ProcedureAdOnCategory {

	String os = GlobalVariable.osName;
	int defaultTime = GlobalVariable.defaultTime;
	@Keyword
	def tapOnProcedureAdOnOptn(category) {
		Mobile.scrollToText(category, FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/ProcedureAdOnOptn_android',['category':category]), defaultTime)
	}
	@Keyword
	def verifyDelievryMethodsExist(text, OnFailure = FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/Cart/Checkout/elementText_android', ['text': text]), defaultTime, OnFailure)
	}
	@Keyword
	def verifyPaymentOptnsExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/PaymentOptns_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyProcedureNameElementExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/procedureName_android'), defaultTime);
	}
	@Keyword
	def verifyInfoIconExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/infoIcon_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnInfoIcon(index = 1) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/infoIcon_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyMoreInfoBtnExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/moreInfoBtn_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnMoreInfoBtnExist(index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/moreInfoBtn_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnSummaryBtnExist() {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/summaryBtn_android'), defaultTime);
	}
	@Keyword
	def verifyBookAptBtn(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/BookAptBtn_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnBookAptBtn(index) {
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/BookAptBtn_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifySearchFieldInProcedure() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Search/SearchFunctionality/searchBar_android'), defaultTime);
	}
	@Keyword
	def verifySearchBackBtn() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/SearchForCare/searchBackBtn_android'), defaultTime);
	}
	@Keyword
	def verifyTimeDurationExist() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/timeInProcedure_android'), defaultTime);
	}
	@Keyword
	def verifyProcedureDiscription(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/ProcedureDiscriptn_android',["index":index]), defaultTime);
	}
	@Keyword
	def verifyPriceElementExist(index) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/PriceInProcedure_android',["index":index]), defaultTime);
	}
	@Keyword
	def tapOnProcedureCostAndOtherDetailsOpt() {
		Mobile.scrollToText("Procedure Cost and Other Details", FailureHandling.OPTIONAL);
		Mobile.tap(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/procedureCostOption_android'), defaultTime);
	}
	@Keyword
	def verifyRevOneFollowingText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/revOneFollowingText_android',["text":text]), defaultTime);
	}
	@Keyword
	def verifyRevPlusFollowingText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/revPlusFollowingText_android',["text":text]), defaultTime);
	}
	@Keyword
	def verifyRevPrivateFollowingText(text, onFailure =FailureHandling.CONTINUE_ON_FAILURE, defaultTime = defaultTime) {
		Mobile.verifyElementExist(findTestObject('Object Repository/Member/HomePage/Procedure Ad-On Category/revPrivateFollowingText_android',["text":text]), defaultTime);
	}

	// -------------------- Start Add Procedure or add-on ---------------
	@Keyword
	def tapOnProcedureCbx(procedureName) {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/Open/AddProcedureOrAddOn/procedureCbx_android', ["procedureName": procedureName]), defaultTime)
	}

	@Keyword
	def tapOnProcedToCheckoutBtn() {
		Mobile.tap(findTestObject('Object Repository/Member/myCarePage_android/Open/AddProcedureOrAddOn/proceedToCheckoutBtn_android'), defaultTime)
	}

	// -------------------- End Add Procedure or add-on ---------------
}
